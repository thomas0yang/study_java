package com.thomas.products.lucene.merge;

/**
 * 
 * The target that the search request was executed on.
 * @author renshaobin
 * @date 2015年11月4日
 * @since jdk1.8.05 or after
 */
public class SearchShardTarget {

    private String nodeId;
    private String index;
    private int shardId;

    public SearchShardTarget(String nodeId, String index, int shardId) {
        this.nodeId = nodeId;
        this.index = index;
        this.shardId = shardId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getIndex() {
        return index;
    }

    public int getShardId() {
        return shardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchShardTarget that = (SearchShardTarget) o;

        if (shardId != that.shardId) return false;
        if (index != null ? !index.equals(that.index) : that.index != null) return false;
        if (nodeId != null ? !nodeId.equals(that.nodeId) : that.nodeId != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "SearchShardTarget{" +
                "index='" + index + '\'' +
                ", shardId=" + shardId +
                ", nodeId=" + nodeId +
                '}';
    }
}
