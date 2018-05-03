package com.thomas.products.lucene;
/**
 * 自定义收集器
 * @author cn.mingyuan@foxmail.com 
 * 
 */

import org.apache.lucene.document.Document;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
/**
 * 自定义Collector结果收集器
 * @author Lanxiaowei
 *
 */
class GroupCollector implements Collector, LeafCollector {
    /**评分计算器*/
    private Scorer scorer;
    /**段文件的编号*/
    private int docBase;

    private String fieldName;
    private SortedDocValues sortedDocValues;

    private List<ScoreDoc> scoreDocs = new ArrayList<ScoreDoc>();

    public LeafCollector getLeafCollector(LeafReaderContext context)
            throws IOException {
        this.sortedDocValues = context.reader().getSortedDocValues(fieldName);
        return this;
    }

    @Override
    public boolean needsScores() {
        return false;
    }

    public void setScorer(Scorer scorer) throws IOException {
        this.scorer = scorer;
    }

    public void collect(int doc) throws IOException {
        // scoreDoc:docId和评分
//        BytesRef bytesRef = sortedDocValues.get(doc);
//        System.out.println(bytesRef);
        this.scoreDocs.add(new ScoreDoc(this.docBase + doc, this.scorer.score()));
    }

    public GroupCollector(String fieldName) {
        super();
        this.fieldName = fieldName;
    }

    public int getDocBase() {
        return docBase;
    }

    public void setDocBase(int docBase) {
        this.docBase = docBase;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public SortedDocValues getSortedDocValues() {
        return sortedDocValues;
    }

    public void setSortedDocValues(SortedDocValues sortedDocValues) {
        this.sortedDocValues = sortedDocValues;
    }

    public List<ScoreDoc> getScoreDocs() {
        return scoreDocs;
    }

    public void setScoreDocs(List<ScoreDoc> scoreDocs) {
        this.scoreDocs = scoreDocs;
    }

    public Scorer getScorer() {
        return scorer;
    }
}


/**
 * 自定义Collector测试
 * @author Lanxiaowei
 *
 */
public class GroupCollectorTest {
    public static void main(String[] args) throws IOException {
        String indexDir = "/opt/data/lucene_test/index/es_copy";
        Directory directory = FSDirectory.open(Paths.get(indexDir));
        IndexReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
        TermQuery termQuery = new TermQuery(new Term("name", "yangyang"));
        GroupCollector collector = new GroupCollector("name");
        searcher.search(termQuery, null, collector);
        List<ScoreDoc> docs = collector.getScoreDocs();
        for (ScoreDoc scoreDoc : docs) {
            int docID = scoreDoc.doc;
            Document document = searcher.doc(docID);
            String title = document.get("name");
            float score = scoreDoc.score;
            System.out.println(docID + ":" + title + "  " + score);
        }

        reader.close();
        directory.close();
    }
}  