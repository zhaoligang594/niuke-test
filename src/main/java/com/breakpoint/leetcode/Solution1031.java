package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-09
 */
//https://leetcode-cn.com/problems/maximum-sum-of-two-non-overlapping-subarrays/solution/c-python3-hua-dong-chuang-kou-tan-xin-la-5a5g/
@Success
public class Solution1031 {

    public static void main(String[] args) {

    }

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        int maxL = preSum[L];
        int maxM = preSum[M];
        int res = preSum[L + M];
        for (int k = L + M + 1; k < n + 1; k++) {
            //  #L,M|r(r含)
            maxL = Math.max(maxL, preSum[k - M] - preSum[k - M - L]);

            int curM = preSum[k] - preSum[k - M];

            int res_LM = maxL + curM;

            // #M,L|r(r含)

            int curL = preSum[k] - preSum[k - L];

            maxM = Math.max(maxM, preSum[k - L] - preSum[k - L - M]);

            int res_ML = maxM + curL;

            res = Math.max(res, Math.max(res_LM, res_ML));
        }
        return res;
    }
}
