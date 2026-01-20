package leetcode2025;

/**
 * @author breakpoint
 * @email: zlgtop@163.com
 * create date: 2025/05/01
 */
public class Solution45 {

    public int jump(int[] nums) {
        int res = 0, end = 0, maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            maxIdx = Math.max(maxIdx, i + nums[i]);
            if (i == end) {
                res++;
                end = maxIdx;
            }
        }
        return res;
    }
}
