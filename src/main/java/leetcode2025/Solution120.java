package leetcode2025;

import java.util.List;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/05
 */
public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return 0;
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[] dp = new int[col];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j <= i; j++) {
                if (i > 0) {
                    int preSize = triangle.get(i - 1).size();
                    // int minVal =
                    int minVal = j - 1 >= 0 ? j >= preSize ? dp[j - 1] : Math.min(dp[j], dp[j - 1]) : dp[j];
                    dp[j] = minVal + triangle.get(i).get(j);
                } else {
                    dp[j] = triangle.get(i).get(j);
                }
                if (i == row - 1) {
                    res = Math.min(res, dp[j]);
                }
            }
        }
        return res;
    }

}
