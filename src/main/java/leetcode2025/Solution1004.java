package leetcode2025;

/**
 * https://leetcode.cn/problems/max-consecutive-ones-iii/
 *
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/04
 */
public class Solution1004 {

    public static void main(String[] args) {
        int i = new Solution1004().longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
    }

    public int longestOnes(int[] nums, int k) {
        int ret = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            while (right < nums.length && nums[right] == 1) right++;
            while (right < nums.length && nums[right] == 0 && k > 0) {
                right++;
                k--;
            }
            ret = Math.max(ret, right - left);
            while (right < nums.length && nums[right] == 0 && k == 0) {
                while (nums[left] == 1) left++;
                if (nums[left] == 0) {
                    left++;
                    k++;
                }
            }
        }
        return ret;
    }
}
