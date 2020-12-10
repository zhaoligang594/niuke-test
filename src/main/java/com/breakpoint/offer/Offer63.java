package com.breakpoint.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author breakpoint/赵先生
 * 2020/12/03
 */
public class Offer63 {

    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length > 0) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.addLast(-1);
            for (int i = 0; i < prices.length; i++) {
                if (stack.peekLast() > -1 && prices[stack.peekLast()] < prices[i]) {
                    res = Math.max(res, prices[i] - prices[stack.peekLast()]);
                } else {
                    stack.addLast(i);
                }
            }
            for (int i = prices.length - 1; i > stack.peekLast(); i--) {
                res = Math.max(res, prices[i] - prices[stack.peekLast()]);
            }
        }
        return res;
    }
}
