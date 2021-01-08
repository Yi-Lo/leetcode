package solution.medium;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Yi-Lo
 * 2021/1/8 12:24
 * @version 1.0
 * @topics Array、Two Pointers、Binary Search
 * @urllink https://leetcode-cn.com/problems/find-the-duplicate-number/
 */
public class P287_Find_the_Duplicate_Number {

    public static int findDuplicate_s1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int findDuplicate_s2(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1;
    }

    public static int findDuplicate_s3(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1, cnt = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) cnt++;
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static int findDuplicate_s4(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate_s1(nums));
        System.out.println(findDuplicate_s2(nums));
        System.out.println(findDuplicate_s3(nums));
        System.out.println(findDuplicate_s4(nums));
    }
}