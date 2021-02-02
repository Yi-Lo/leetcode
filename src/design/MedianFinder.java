package design;

import java.util.PriorityQueue;

/**
 * @author Yi-Lo
 * 2021/1/31 11:08
 * @version 1.0
 */
public class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() == maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? (double) maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) * 0.5;
    }
}
