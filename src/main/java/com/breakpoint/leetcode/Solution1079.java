package com.breakpoint.leetcode;

import java.util.Arrays;

/**
 * @author breakpoint/赵先生
 * 2020/10/02
 */
public class Solution1079 {
    public static void main(String[] args) {
        int aab = new Solution1079().numTilePossibilities("AAB");
        System.out.println(aab);
    }

    int res = 0; // 返回值
    boolean[] tag; // 标记

    public int numTilePossibilities(String tiles) {
        if (null == tiles || "".equals(tiles)) return 0;
        tag = new boolean[tiles.length()];
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        dfs(chars);
        return res;
    }

    public void dfs(char[] tiles) {
        for (int i = 0; i < tiles.length; i++) {
            if (!tag[i]) {
                // 剪枝，当i>0
                // tiles[i] == tiles[i - 1] 说明树在同一层的时候，元素相同
                // !tag[i - 1] 表明前面的元素已经使用过了，那么，就不用这个树的分支了。
                if (i > 0 && tiles[i] == tiles[i - 1] && !tag[i - 1]) continue;
                tag[i] = true;
                res++;
                dfs(tiles);
                tag[i] = false;
            }
        }
    }
}
