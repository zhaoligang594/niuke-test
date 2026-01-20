package leetcode2025;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/06
 */
public class Solution238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        long temp = 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            temp *= nums[i];
        }
        return res;
    }
}
