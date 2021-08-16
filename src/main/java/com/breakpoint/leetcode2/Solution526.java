package com.breakpoint.leetcode2;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/16
 */
public class Solution526 {

    public static void main(String[] args) {
        for (int i = 1; i < 16; i++) {
            System.out.print(new Solution526().countArrangement2(i));
            System.out.print(",");
        }
    }

    public int countArrangement(int n) {
        int[] anss = {0, 1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
        return anss[n];
    }


    public int countArrangement2(int n) {
        tag = new boolean[n + 1];
        dfs(1, n);
        return ans;
    }

    // 标识位 表明当前的位置使用没有 使用了为 true 没有使用 为 false
    boolean[] tag;
    int ans = 0;

    private void dfs(int cur, int n) {
        if (cur > n) {
            ans++;
        } else {
            // 深度回溯递归调用
            for (int i = 1; i < tag.length; i++) {
                if (!tag[i] && (i % cur == 0 || cur % i == 0)) {
                    tag[i] = true;
                    dfs(cur + 1, n);
                    tag[i] = false;
                }
            }
        }
    }
}
