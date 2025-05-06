package com.thomas.products.alg;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V>  {
    private static final long serialVersionUID = 1L;
    protected int maxElements;

    public LRUCache(int maxSize) {
        super(maxSize, 0.75F, true);
        this.maxElements = maxSize;
    }

    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > this.maxElements;
    }


    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1)); //1
        cache.put(3,3); //2淘汰，剩13
        System.out.println(cache.get(2)); // null 未找到
        cache.put(4,4); //1淘汰，剩34
        System.out.println(cache.get(1)); // null 未找到
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
