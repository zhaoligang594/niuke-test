package leetcode2025;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/14
 */
public class Solution34 {

    // 34. 在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int leftIndex = getLeftIndex(nums, target);
        if (leftIndex == nums.length || nums[leftIndex] != target) return ans;
        int rightIndex = getRightIndex(nums, target);
        return new int[]{leftIndex, rightIndex - 1};
    }


    private int getLeftIndex(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private int getRightIndex(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
