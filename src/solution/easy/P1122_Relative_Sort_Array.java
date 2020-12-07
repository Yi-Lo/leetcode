package solution.easy;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Yi-Lo
 * 2020/12/7 18:17
 * @version 1.0
 * @topics Sort、Array
 * @urllink https://leetcode-cn.com/problems/relative-sort-array/
 */
public class P1122_Relative_Sort_Array {

    public static int[] relativeSortArray_s1(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr1.length; i++) {
            Integer count = map.get(arr1[i]);
            if (count == null) count = 0;
            map.put(arr1[i], count + 1);
        }
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < map.get(arr2[i]); j++) {
                res[index++] = arr2[i];
            }
            map.remove(arr2[i]);
        }
        for (int k : map.keySet()) {
            for (int j = 0; j < map.get(k); j++) {
                res[index++] = k;
            }
        }
        return res;
    }

    public static int[] relativeSortArray_s2(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];
        int idx = 0;
        for (int n : arr1) arr[n]++;
        for (int n : arr2) {
            while (arr[n]-- > 0) {
                arr1[idx++] = n;
            }
        }
        for (int n = 0; n < arr.length; n++) {
            while (arr[n]-- > 0) {
                arr1[idx++] = n;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        relativeSortArray_s1(arr1, arr2);
        relativeSortArray_s2(arr1, arr2);
    }
}
