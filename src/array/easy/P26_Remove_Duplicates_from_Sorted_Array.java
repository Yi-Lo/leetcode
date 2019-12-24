package array.easy;

/**
 * @author Yi-Lo
 * 2019/12/24 23:11
 * @version 1.0
 */
public class P26_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        int tail = 1;
        for (int num : nums) {
            if (num > max) {
                max = num;
                nums[tail] = max;
                tail++;
            }
        }
        return tail;
    }

}
