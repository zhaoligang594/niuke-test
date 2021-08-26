package com.breakpoint.leetcode2;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/22
 */
public class Solution771 {

    public int numJewelsInStones(String jewels, String stones) {
        int[] stone = new int['z' - 'A' + 1];
        for (char ch : jewels.toCharArray()) {
            stone[ch - 'A'] = 1;
        }
        int ans = 0;
        for (char ch : stones.toCharArray()) {
            if (stone[ch - 'A'] == 1) ans++;
        }
        return ans;
    }
}
