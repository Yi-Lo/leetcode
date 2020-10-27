package solution.easy;

/**
 * @author Yi-Lo
 * 2020/10/22 15:38
 * @version 1.0
 * @topics Array、Two Pointers
 * @urllink https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class P88_Merge_Sorted_Array {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int m_last = m > 0 ? m - 1 : 0;
        int n_last = n > 0 ? n - 1 : 0;
        int nums_last = nums1.length - 1;
        while (m_last >= 0 && n_last >= 0 && n > 0) {
            if (nums1[m_last] >= nums2[n_last]) {
                nums1[nums_last] = nums1[m_last];
                m_last--;
            } else {
                nums1[nums_last] = nums2[n_last];
                n_last--;
            }
            nums_last--;
        }
        while (n_last >= 0 && n > 0) {
            nums1[n_last] = nums2[n_last];
            n_last--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int num : nums1) {
            System.out.println(num);
        }
    }
}
