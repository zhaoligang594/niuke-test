package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1124. 表现良好的最长时间段
 *
 * @author breakpoint/赵先生
 * 2020/09/06
 */
public class Solution1124 {
    /*
            给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。

            我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。

            所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。

            请你返回「表现良好时间段」的最大长度。

            示例 1：

            输入：hours = [9,9,6,0,6,6,9]
            输出：3
            解释：最长的表现良好时间段是 [9,9,6]。
             

            提示：

            1 <= hours.length <= 10000
            0 <= hours[i] <= 16

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/longest-well-performing-interval
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] hours = {6, 9, 9};
        int i = new Solution1124().longestWPI(hours);
        System.out.println(i);
    }

    public int longestWPI(int[] hours) {
        int[] score = new int[hours.length];
        for (int i = 0; i < score.length; i++) score[i] = hours[i] > 8 ? 1 : -1;
        int[] preSum = new int[score.length + 1];
        for (int i = 1; i < preSum.length; i++) preSum[i] = preSum[i - 1] + score[i - 1];
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 1; i < preSum.length; i++) {
            if (preSum[stack.peekLast()] > preSum[i]) stack.addLast(i);
        }
        // 返回值就是最大的宽度，小于这个 就是 无所谓了
        for (int i = preSum.length - 1; i >= res; i--) {
            while (!stack.isEmpty() && preSum[stack.peekLast()] < preSum[i]) {
                res = Math.max(res, i - stack.peekLast());
                stack.pollLast();
            }
        }

        return res;
    }
}
