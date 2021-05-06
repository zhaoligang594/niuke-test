package com.breakpoint.interviewer;

import com.breakpoint.annotation.Success;

/**
 * 类似接雨水差不多的
 *
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-04-02
 */
@Success
public class Test1721 {
    public static void main(String[] args) {

    }

    // 接雨水
    public int trap(int[] height) {
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i > 0) {
                maxL[i] = Math.max(height[i], maxL[i - 1]);
            } else {
                maxL[i] = height[i];
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (i < height.length - 1) {
                maxR[i] = Math.max(height[i], maxR[i + 1]);
            } else {
                maxR[i] = height[i];
            }
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(maxL[i], maxR[i]) - height[i];
        }
        return res;
    }

}
