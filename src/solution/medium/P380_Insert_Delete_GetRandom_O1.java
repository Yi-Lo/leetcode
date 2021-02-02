package solution.medium;

import design.RandomizedSet;

/**
 * @author Yi-Lo
 * 2021/2/2 10:05
 * @version 1.0
 * @topics Design、Array、Hash Table
 * @urllink https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 */
public class P380_Insert_Delete_GetRandom_O1 {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}
