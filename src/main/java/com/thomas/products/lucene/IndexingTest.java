package com.thomas.products.lucene;

import junit.framework.TestCase;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.MMapDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class IndexingTest extends TestCase {

	// 準備數據
	protected String[] ids = { "1", "2" };
	protected String[] unindexed = { "Netherlands", "Italy" };
	protected String[] unstored = { "Amsterdam has lots of bridges",
			"Venice has lots of cancals" };
	protected String[] text = { "Amsterda", "Venice" };
	private String indexPath = "/opt/data/lucene_test/index/es_copy";
//	private String indexPath = "/opt/isaiah/node/data/debug_isaiah/nodes/0/indices/twitter/0/index";
	private Directory directory;

	@Override
	public void setUp() throws IOException {

//		directory = new RAMDirectory();
//		directory = MMapDirectory.open(Paths.get(indexPath));
		directory = FSDirectory.open(Paths.get(indexPath));
	}


    private IndexWriter getIndexWriter() throws IOException {
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        iwc.setWriteLockTimeout(5000);
		return new IndexWriter(directory, iwc);
	}

	public int getHitsCount(String key,String value) throws IOException {

        IndexReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);

        Query query = new TermQuery(new Term(key, value));
        TopDocs topDocs = null;
        int count =10;
        for (int i = 0; i < count; i++) {
            long start = System.currentTimeMillis();
            topDocs = searcher.search(query, 10);
            System.out.println("cost " + (System.currentTimeMillis()-start));
        }

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		return scoreDocs.length;
	}

    @Test
    public void testWriteDoc() throws IOException{
        IndexWriter indexWriter = getIndexWriter();

        for (int i = 0; i < ids.length; i++) {
            Document document = new Document();
            document.add(new Field("id", ids[i], Field.Store.YES, Field.Index.NO));
//            document.add(new StringField("id", ids[i], Field.Store.YES));
            Field country = new Field("country", unindexed[i], Field.Store.YES, Field.Index.NOT_ANALYZED_NO_NORMS);
//            country.fieldType().setIndexOptions(IndexOptions.NONE);
            document.add(country);
            document.add(new StringField("contents", unstored[i], Field.Store.NO));
//            document.add(new StringField("name", text[i], Field.Store.YES));
            document.add(new StoredField("name", text[i])  );
            indexWriter.addDocument(document);
        }
        indexWriter.close();

        IndexReader reader = DirectoryReader.open(directory);
        System.out.println(reader.numDocs());
        System.out.println(getHitsCount("id","1"));
        reader.close();
    }

    @Test
    public void testIndexWriter() throws IOException {
        IndexWriter indexWriter = getIndexWriter();
        System.err.println(((MMapDirectory)directory).getDirectory().toString());
        System.err.println(indexWriter.numDocs());
        System.err.println(indexWriter.getCommitData());
//        indexWriter.close();
        IndexWriter indexWriter1 = getIndexWriter();
//        indexWriter1.close();
    }

    @Test
    public void testIndexReader() throws IOException {
        IndexReader reader = DirectoryReader.open(directory);
        System.out.println(reader.numDocs());
        System.out.println(getHitsCount("_type","user"));
        System.out.println(getHitsCount("_type","mytype"));
        System.out.println(getHitsCount("name","yangyang32"));
        System.out.println(getHitsCount("_uid","mytype#1"));
        reader.close();
    }

    @Test
    public void testEsGetByTypes() throws IOException {
        IndexReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);

        BooleanQuery bool = new BooleanQuery();
        bool.add(new TermQuery(new Term("_type", "user")), BooleanClause.Occur.SHOULD);
        Query filter = new ConstantScoreQuery(bool);

        BooleanQuery bq = new BooleanQuery();
        if (filter != null) {
            bq.add(filter, BooleanClause.Occur.MUST);
        }
        Query searchFilter = new QueryWrapperFilter(bq);
        Query q = new ConstantScoreQuery(searchFilter);

        TopDocs topDocs = searcher.search(q, 10);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        System.out.println(scoreDocs.length);
    }

    @Test
    public void testGetDoc() throws IOException {
        IndexReader reader = DirectoryReader.open(directory);
        System.out.println(reader.numDocs());
        IndexSearcher searcher = new IndexSearcher(reader);
        for (int i = 0; i < 5; i++) {
            Document doc = searcher.doc(i);
            System.out.println(i + " "+ doc.get("name"));
        }


//        reader = DirectoryReader.openIfChanged((DirectoryReader)reader);
//        System.out.println(reader.numDocs());
//        int hitsCount2 = getHitsCount();
//        System.out.println(hitsCount2);
        reader.close();
    }
}
