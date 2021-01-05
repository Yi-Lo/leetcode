package solution.medium;

import helper.ArrayHelper;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Yi-Lo
 * 2021/1/5 14:33
 * @version 1.0
 * @topics Heap、Hash Table
 * @urllink https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class P347_Top_K_Frequent_Elements {

    static class Element {
        public int val;
        public int count = 0;

        public Element(int val) {
            this.val = val;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Element> table = new HashMap<>();
        PriorityQueue<Element> queue = new PriorityQueue<>(Comparator.comparingInt(x -> -x.count));
        for (int num : nums) {
            Element element = table.get(num);
            if (element == null) {
                element = new Element(num);
                table.put(num, element);
            }
            element.count++;
        }
        queue.addAll(table.values());
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = queue.poll().val;
        }
        return topK;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] topK = topKFrequent(nums, 2);
        ArrayHelper.println(topK);
    }
}
