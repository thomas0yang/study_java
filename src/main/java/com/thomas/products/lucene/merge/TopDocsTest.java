package com.thomas.products.lucene.merge;

import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import java.io.IOException;
import java.util.*;

/**
 * Created by yangyang32 on 16/9/20.
 */
public class TopDocsTest {

    public static void main(String[] args) throws IOException {
        simpletest2();
    }

    private static void simpletest() {
        ScoreDoc[] scoreDocs = {new ScoreDoc(0, 1), new ScoreDoc(1, 2)};
        TopDocs topDocs1 = new TopDocs(2, scoreDocs, 2);

        ScoreDoc[] scoreDocs2 = {new ScoreDoc(10, 1), new ScoreDoc(11, 2)};
        TopDocs topDocs2 = new TopDocs(2, scoreDocs2, 2);

        TopDocs[] topDocs = {topDocs1, topDocs2};

        try {
            TopDocs merge = TopDocs.merge(0, 10, topDocs);
            List<ScoreDoc> list = Arrays.asList(merge.scoreDocs);
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void simpletest2() throws IOException {

        //准备数据
        ScoreDoc[] scoreDocs = {new ScoreDoc(0, 1), new ScoreDoc(1, 2)};
        TopDocs topDocs1 = new TopDocs(2, scoreDocs, 2);

        ScoreDoc[] scoreDocs2 = {new ScoreDoc(3, 1), new ScoreDoc(4, 2)};
        TopDocs topDocs2 = new TopDocs(2, scoreDocs2, 2);


        ShardTopDocs[] shardTopDocs = {
                new ShardTopDocs(new SearchShardTarget("node1","index1", 100), topDocs1),
                new ShardTopDocs(new SearchShardTarget("node1","index11", 101), topDocs2)
        };
        NodeResult node1 = new NodeResult(shardTopDocs[0].getShardTarget().getNodeId() , shardTopDocs);


        ScoreDoc[] scoreDocs3 = {new ScoreDoc(10, 1), new ScoreDoc(11, 2)};
        TopDocs topDocs3 = new TopDocs(2, scoreDocs3, 2);
        ShardTopDocs[] shardTopDocs2 = {
                new ShardTopDocs(new SearchShardTarget("node2","index2", 1000), topDocs3)
        };
        NodeResult node2 = new NodeResult(shardTopDocs2[0].getShardTarget().getNodeId() , shardTopDocs2);
        List<NodeResult> list = Arrays.asList(node1, node2);


        //维护排序后的ScoreDoc[]中的每个ScoreDoc中的shardindex和SearchShardTarget的映射关系
        int shardIndex = 0;
        Map<Integer, SearchShardTarget> nodeIndexShardMap = new HashMap<>();
        List<TopDocs> topDocList = new ArrayList<>();
        for (NodeResult nodeResult : list) {
            ShardTopDocs[] nodeTopDocses = nodeResult.getNodeTopDocses();
            for (int i = 0; i < nodeTopDocses.length; i++) {
                topDocList.add(nodeTopDocses[i].getTopDocs()); //待排序的topdocs列表
                SearchShardTarget shardTarget = nodeIndexShardMap.get(shardIndex);
                if(shardTarget == null) {
                    nodeIndexShardMap.put(shardIndex, nodeTopDocses[i].getShardTarget());
                }
                shardIndex++;
            }
        }

        TopDocs[] topDocs = (TopDocs[])topDocList.toArray(new TopDocs[topDocList.size()]);
        TopDocs merge = TopDocs.merge(0, 5, topDocs); //node内部排序,保证一个node提取n个

        List<ScoreDocTarget> resultList = new ArrayList<>();
        for (ScoreDoc scoreDoc : merge.scoreDocs) {
            SearchShardTarget searchShardTarget = nodeIndexShardMap.get(scoreDoc.shardIndex);
            resultList.add(new ScoreDocTarget(scoreDoc, searchShardTarget));
        }

        for (ScoreDocTarget scoreDocTarget : resultList) {
            System.out.println(scoreDocTarget);
        }


//        Map<String, LinkedHashMap<SearchShardTarget, List<ScoreDoc>>> resultMap = new LinkedHashMap<>();
//        for (ScoreDoc scoreDoc : merge.scoreDocs) {
//            SearchShardTarget searchShardTarget = nodeIndexShardMap.get(scoreDoc.shardIndex);
//            LinkedHashMap<SearchShardTarget, List<ScoreDoc>> targetListMap = resultMap.get(searchShardTarget.getNodeId());
//            if (targetListMap == null){
//                targetListMap = new LinkedHashMap<>();
//                resultMap.put(searchShardTarget.getNodeId(), targetListMap);
//            }
//            List<ScoreDoc> scoreDocList = targetListMap.get(searchShardTarget);
//            if (scoreDocList == null){
//                scoreDocList = new ArrayList<>();
//                targetListMap.put(searchShardTarget, scoreDocList);
//            }
//            scoreDocList.add(scoreDoc);
//        }
//
//        //打印数据
//        for (Map.Entry<String, LinkedHashMap<SearchShardTarget, List<ScoreDoc>>> entry : resultMap.entrySet()) {
//            String node = entry.getKey();
//            LinkedHashMap<SearchShardTarget, List<ScoreDoc>> value = entry.getValue();
//            for (Map.Entry<SearchShardTarget, List<ScoreDoc>> entry2 : value.entrySet()) {
//                SearchShardTarget shardtarget = entry2.getKey();
//                List<ScoreDoc> scoreDocList = entry2.getValue();
//                for (ScoreDoc scoreDoc : scoreDocList) {
//                    System.out.println(node+"\t"+shardtarget + "\t" + scoreDoc);
//                }
//            }
//        }
    }
}


 class ScoreDocTarget{
     ScoreDoc scoreDoc;
     SearchShardTarget target;

     public ScoreDocTarget(ScoreDoc scoreDoc, SearchShardTarget target) {
         this.scoreDoc = scoreDoc;
         this.target = target;
     }

     public ScoreDoc getScoreDoc() {
         return scoreDoc;
     }

     public SearchShardTarget getTarget() {
         return target;
     }

     @Override
     public String toString() {
         return "ScoreDocTarget{" +
                 "scoreDoc=" + scoreDoc +
                 ", target=" + target +
                 '}';
     }
 }