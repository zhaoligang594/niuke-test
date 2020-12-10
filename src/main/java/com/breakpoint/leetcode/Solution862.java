package com.breakpoint.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author breakpoint/赵先生
 * 2020/12/09
 */
public class Solution862 {

    //[84,-37,32,40,95]
    //167
    public static void main(String[] args) {
        int[] A = {84,-37,32,40,95};
        int i = new Solution862().shortestSubarray(A, 167);
    }

    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }
}
