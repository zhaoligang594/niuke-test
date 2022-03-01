package com.breakpoint.daily;

/**
 * @author : breakpoint
 * create date : 2022/02/20
 * 欢迎关注公众号 《代码废柴》
 */
public class Solution717 {


    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if (bits[n - 1] != 0) return false;

        //  [1, 1, 1, 0]
        int i = 0;
        for (; i < n; i++) {
            if (bits[i] == 1) {
                i++;
                continue;
            }
            if (bits[i] == 0) {
                // 在最后一个位置时候
                if (i == n - 1) return true;
            }
        }
        return false;
    }

}
