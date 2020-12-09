package solution.hard;

/**
 * @author Yi-Lo
 * 2020/12/9 18:03
 * @version 1.0
 * @topics Sort、Binary Indexed Tree、Segment Tree、Binary Search、Divide and Conquer
 * @urllink https://leetcode-cn.com/problems/reverse-pairs/
 */
public class P493_Reverse_Pairs {

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int mergeSort(int[] nums, int left, int right) {
        if (right <= left) return 0;
        int mid = left + ((right - left) >> 1);
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int i = 0, l = left, m = mid + 1, r = mid + 1;
        int[] cache = new int[right - left + 1];
        while (l <= mid) {
            while (r <= right && nums[l] > 2L * nums[r]) r++;
            while (m <= right && nums[l] >= nums[m]) cache[i++] = nums[m++];
            count += r - (mid + 1);
            cache[i++] = nums[l++];
        }
        while (m <= right) cache[i++] = nums[m++];
        System.arraycopy(cache, 0, nums, left, cache.length);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 5, 1};
        System.out.println(reversePairs(nums));
    }
}
