package com.breakpoint.zw;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = 0;
        for (int l = 0; l < m; l++) {
            for (int r = 0; r < m; r++) {
                if (l != 0 || r != 0) {
                    max = Math.max(max, getMax(nums, l, r));
                }
            }
        }
        System.out.println(max);
    }

    static int getMax(int[] A, int L, int M) {
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
