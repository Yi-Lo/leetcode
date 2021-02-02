package design;

import java.util.*;

/**
 * @author Yi-Lo
 * 2021/2/2 11:11
 * @version 1.0
 */
public class RandomizedSet {

    public Random rand;

    public List<Integer> list;

    public Map<Integer, Integer> dict;

    public RandomizedSet() {
        rand = new Random();
        dict = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (dict.containsKey(val)) return false;
        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if (!dict.containsKey(val)) return false;
        int lastElement = list.get(list.size() - 1);
        int index = dict.get(val);
        list.set(index, lastElement);
        dict.put(lastElement, index);
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
