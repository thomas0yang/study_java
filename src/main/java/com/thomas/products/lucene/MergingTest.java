package com.thomas.products.lucene;

import junit.framework.TestCase;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class MergingTest extends TestCase {

	protected String[] ids = { "1", "2" };
	protected String[] unindexed = { "Netherlands", "Italy" };
	protected String[] unstored = { "Amsterdam has lots of bridges",
			"Venice has lots of cancals" };
	protected String[] text = { "Amsterda", "Venice" };
	private String indexPathOriginal = "/opt/data/lucene_test/index/merge/original";
//	private String indexPathTarget = "/opt/data/lucene_test/index/merge/target";
//	private String indexPathOriginal = "/opt/data/lucene_test/index/es_copy";
	private String indexPathTarget = "/opt/isaiah/node/data/debug_isaiah/nodes/0/indices/twitter/0/index";
	private Directory directoryOriginal;
	private Directory directoryTarget;

	@Override
	public void setUp() throws IOException {

//		directory = new RAMDirectory();
        directoryOriginal = FSDirectory.open(Paths.get(indexPathOriginal));
        directoryTarget = FSDirectory.open(Paths.get(indexPathTarget));
	}

    private void writeData(Directory directory) throws IOException {
        IndexWriter indexWriter = getIndexWriter(directory);
        for (int i = 0; i < ids.length; i++) {
            Document document = new Document();
            document.add(new StringField("id", ids[i], Field.Store.YES));
            document.add(new StringField("country", unindexed[i], Field.Store.NO));
            document.add(new StringField("contents", unstored[i], Field.Store.NO));
            document.add(new StringField("name", text[i], Field.Store.YES));
            indexWriter.addDocument(document);
        }
        indexWriter.close();
    }

    private IndexWriter getIndexWriter(Directory directory) throws IOException {
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
		return new IndexWriter(directory, iwc);
	}

    @Test
    public void testIndexReader() throws IOException {
//        writeData(directoryOriginal);
//        writeData(directoryTarget);
//        IndexWriter indexWriter = getIndexWriter(directoryTarget);
//        IndexReader reader = DirectoryReader.open(indexWriter, true);
//        System.out.println(reader.numDocs());
        System.out.println(getHitsCount("name","yangyang1"));

//        indexWriter.addIndexes(directoryOriginal);
//        indexWriter.commit();

//        System.out.println("=========after============");
//        DirectoryReader directoryReader = DirectoryReader.openIfChanged((DirectoryReader) reader);
//        reader = directoryReader == null ? reader : directoryReader;
//        System.out.println(reader.numDocs());
//        System.out.println(getHitsCount("name","yangyang32"));
//        reader.close();

    }

    @Test
    public void testQuery() throws IOException {
        System.out.println(getHitsCount("name","yangyang1"));
    }



    public int getHitsCount(String key, String value) throws IOException {
        IndexReader reader = DirectoryReader.open(directoryTarget);
        IndexSearcher searcher = new IndexSearcher(reader);

        Query query = new TermQuery(new Term(key, value));

        TopDocs topDocs = searcher.search(query, 10);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        return scoreDocs.length;
    }
}
