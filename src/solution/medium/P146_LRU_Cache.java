package solution.medium;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Yi-Lo
 * 2020/12/7 18:13
 * @version 1.0
 * @topics Design
 * @urllink https://leetcode-cn.com/problems/lru-cache/
 */
public class P146_LRU_Cache {

    private int capacity;

    LinkedHashMap<Integer, Integer> cache;

    public P146_LRU_Cache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
