package com.thomas.products.lucene.merge;


import org.apache.lucene.search.TopDocs;

/**
 * Created by yangyang32 on 16/9/20.
 * 每个shard中返回的topdocs
 */
public class ShardTopDocs{
    private SearchShardTarget shardTarget;
    private TopDocs topDocs;

    public ShardTopDocs(SearchShardTarget shardTarget, TopDocs topDocs) {
        this.shardTarget = shardTarget;
        this.topDocs = topDocs;
    }

    public SearchShardTarget getShardTarget() {
        return shardTarget;
    }

    public TopDocs getTopDocs() {
        return topDocs;
    }

}
