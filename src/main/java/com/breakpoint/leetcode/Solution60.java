package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. 第k个排列
 *
 * @author breakpoint/赵先生
 * 2020/09/05
 */
public class Solution60 {
    /*
        给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

        按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

        "123"
        "132"
        "213"
        "231"
        "312"
        "321"
        给定 n 和 k，返回第 k 个排列。

        说明：

        给定 n 的范围是 [1, 9]。
        给定 k 的范围是[1,  n!]。
        示例 1:

        输入: n = 3, k = 3
        输出: "213"
        示例 2:

        输入: n = 4, k = 9
        输出: "2314"

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/permutation-sequence
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        String permutation = new Solution60().getPermutation(4, 9);
        System.out.println(permutation);
    }

    List<String> res = new ArrayList<>();
    boolean[] tag;
    boolean isSeeked = false;
    StringBuilder sb = new StringBuilder();

    public String getPermutation(int n, int k) {
        if (k <= 0) return null;
        int[] startAndCount = getStartAndCount(n, k);
        tag = new boolean[n + 1];
        dfs(n, startAndCount[1], n, startAndCount[0]);
        return res.get(startAndCount[1]-1);
    }


    private int[] getStartAndCount(int n, int k) {
        int sub = 1;
        for (int i = 1; i < n; i++) {
            sub *= i;
        }
        if (sub * n < k) return null;
        int start = k % (sub + 1) == 0 ? k / (sub) : k / (sub + 1) + 1;
        int count = k - sub * (start - 1);
        return new int[]{start, count};
    }

    public void dfs(int n, int k, int count, int start) {
        for (int i = start; i <= n; i++) {
            if (!tag[i] && !isSeeked) {
                tag[i] = true;
                sb.append(i);
                if (count == 1) {
                    res.add(sb.toString());
                    //System.out.println(sb.toString());
                    if (res.size() == k) {
                        isSeeked = true;
                        //return;
                    }
                } else if (count > 1) {
                    dfs(n, k, count - 1, 1);
                }
                sb.delete(sb.length() - 1, sb.length());
                tag[i] = false;
            }
        }
    }


}
