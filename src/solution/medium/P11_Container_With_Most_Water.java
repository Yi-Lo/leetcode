package solution.medium;

/**
 * @author Yi-Lo
 * 2020/10/27 19:28
 * @version 1.0
 * @topics Array、Two Pointers
 * @urllink https://leetcode-cn.com/problems/container-with-most-water/
 */
public class P11_Container_With_Most_Water {

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
