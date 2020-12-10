package com.breakpoint.leetcode;

import com.breakpoint.utils.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * @author breakpoint/赵先生
 * 2020/09/06
 */
public class Solution120 {

    /*
        给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

        相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

         

        例如，给定三角形：

        [
             [2],
            [3,4],
           [6,5,7],
          [4,1,8,3]
        ]
        自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/triangle
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        List<List<Integer>> list2 = ListUtils.getList2("[" +
                "[-1]," +
                "[2,3]," +
                "[1,-1,-3]]");
        int i = new Solution120().minimumTotal(triangle);
        System.out.println(i);

    }


    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return 0;
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] dp = new int[row][col];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j <= i; j++) {
                if (i > 0) {
                    int preSize = triangle.get(i - 1).size();
                    // int minVal =
                    int minVal = j - 1 >= 0 ? j >= preSize ? dp[i - 1][j - 1] : Math.min(dp[i - 1][j], dp[i - 1][j - 1]) : dp[i - 1][j];
//                    int minVal;
//                    if (j - 1 >= 0) {
//                        minVal = j >= preSize ? dp[i - 1][j - 1] : Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
//                    } else {
//                        minVal = dp[i - 1][j];
//                    }
                    dp[i][j] = minVal + triangle.get(i).get(j);
                } else {
                    dp[i][j] = triangle.get(i).get(j);
                }
                if (i == row - 1) {
                    res = Math.min(res, dp[i][j]);
                }
            }
        }


        return res;
    }





    /*  =====================  下面是运行超时的   =============================== */

    int res = Integer.MAX_VALUE;

    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null) return 0;
        dfs(triangle, 0, 0, 0);
        return res;
    }

    private void dfs(List<List<Integer>> triangle, int i, int start, int curSum) {
        if (i >= triangle.size()) {
            //System.out.println(curSum);
            res = Math.min(res, curSum);
            return;
        }
        List<Integer> list = triangle.get(i);
        for (int k = start; k < start + 2 && k < list.size(); k++) {
            dfs(triangle, i + 1, k, curSum + list.get(k));
        }
    }


}
