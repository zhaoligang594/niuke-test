package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

/**
 * https://leetcode-cn.com/problems/decode-xored-array/
 *
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-05-06
 */
@Success
public class Solution1720 {

    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }
        return res;
    }
}
