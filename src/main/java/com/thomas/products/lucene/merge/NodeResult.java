package com.thomas.products.lucene.merge;

/**
 * Created by yangyang32 on 16/9/20.
 */
public class NodeResult {
    private String nodeId;
    private ShardTopDocs[] nodeTopDocses;

    public NodeResult(String nodeId, ShardTopDocs[] nodeTopDocses) {
        this.nodeId = nodeId;
        this.nodeTopDocses = nodeTopDocses;
    }

    public String getNodeId() {
        return nodeId;
    }

    public ShardTopDocs[] getNodeTopDocses() {
        return nodeTopDocses;
    }
}
