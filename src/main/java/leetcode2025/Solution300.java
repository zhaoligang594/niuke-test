package leetcode2025;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author 赵立刚
 * @email: zlgtop@163.com
 * create at: 2025/05/02
 */
public class Solution300 {

    public static void main(String[] args) {
        Solution300 sol = new Solution300();
        int i = sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
