package leetcode2025;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-01-29
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int count = 1, ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ret) {
                count++;
            } else {
                count--;
            }
            if (count <= 0) {
                ret = nums[i];
                count = 1;
            }
        }
        return ret;
    }
}
