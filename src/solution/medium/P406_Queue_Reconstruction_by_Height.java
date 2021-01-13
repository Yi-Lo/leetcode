package solution.medium;

import helper.ArrayHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/1/13 13:13
 * @version 1.0
 * @topics Greedy
 * @urllink https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 */
public class P406_Queue_Reconstruction_by_Height {

    public static int[][] reconstructQueue_s1(int[][] people) {
        sort(people);
        swap(people);
        return people;
    }

    public static void sort(int[][] people) {
        for (int i = 1; i < people.length; i++) {
            int val = sum(people, i);
            int[] height = people[i];
            int j = i - 1;
            while (j >= 0) {
                if (sum(people, j) > val) {
                    people[j + 1] = people[j];
                } else {
                    break;
                }
                j--;
            }
            people[j + 1] = height;
        }
    }

    public static void swap(int[][] people) {
        int length = people.length;
        for (int i = 1; i < length; i++) {
            int height = people[i][0];
            int count = people[i][1];
            if (count(people, i, height) > count) {
                int[] temp = people[i - 1];
                people[i - 1] = people[i];
                people[i] = temp;
            }
            if (count(people, i, height) < count) {
                int[] temp = people[i + 1];
                people[i + 1] = people[i];
                people[i] = temp;
            }
        }
    }

    public static int sum(int[][] people, int i) {
        return people[i][0] + people[i][1];
    }

    public static int count(int[][] people, int i, int val) {
        int count = 0;
        for (int j = 0; j < i; j++) {
            if (people[j][0] >= val) {
                count++;
            }
        }
        return count;
    }

    public static int[][] reconstructQueue_s2(int[][] people) {
        Arrays.sort(people, (people1, people2) -> {
            if (people1[0] != people2[0]) {
                return people2[0] - people1[0];
            } else {
                return people1[1] - people2[1];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = {{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
        ArrayHelper.println(reconstructQueue_s1(people));
        ArrayHelper.println(reconstructQueue_s2(people));
    }
}
