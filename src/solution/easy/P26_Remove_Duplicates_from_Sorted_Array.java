package solution.easy;

/**
 * @author Yi-Lo
 * 2020/10/21 16:10
 * @version 1.0
 * @topics Array、Two Pointers
 * @urllink https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class P26_Remove_Duplicates_from_Sorted_Array {

    public static int removeDuplicates_s1(int[] nums) {
        int len = 1;
        int min = nums[0];
        int max = nums[nums.length - 1];
        if (min == max) {
            return 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= min) {
                len++;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > min) {
                        min = nums[j];
                        nums[j] = nums[i];
                        nums[i] = min;
                        if (min == max) {
                            return len;
                        }
                        break;
                    }
                }
            }
        }
        return len;
    }

    public static int removeDuplicates_s2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeDuplicates_s3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int tail = 1;
        for (int num : nums) {
            if (num > max) {
                max = num;
                nums[tail] = num;
                tail++;
            }
        }
        return tail;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates_s2(new int[]{1}));
        System.out.println(removeDuplicates_s2(new int[]{1, 1}));
        System.out.println(removeDuplicates_s2(new int[]{1, 2}));
        System.out.println(removeDuplicates_s2(new int[]{1, 2, 3}));
        System.out.println(removeDuplicates_s2(new int[]{1, 1, 1}));
        System.out.println(removeDuplicates_s2(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates_s2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

}
