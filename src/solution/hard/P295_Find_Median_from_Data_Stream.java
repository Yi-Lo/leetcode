package solution.hard;

import design.MedianFinder;

/**
 * @author Yi-Lo
 * 2021/1/31 11:06
 * @version 1.0
 * @topics Heap、Design
 * @urllink https://leetcode-cn.com/problems/find-median-from-data-stream/
 */
public class P295_Find_Median_from_Data_Stream {

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }
}
