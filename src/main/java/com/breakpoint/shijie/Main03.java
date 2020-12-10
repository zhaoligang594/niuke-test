package com.breakpoint.shijie;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author breakpoint/赵先生
 * 2020/09/09
 */
public class Main03 {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] numsStr = str.split(",");
//        int[] nums = new int[numsStr.length];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = Integer.valueOf(numsStr[i]);
//        }
//        if (nums.length == 1) {
//            System.out.println(nums[0]);
//            return;
//        } else if (nums.length == 2) {
//            System.out.println(Math.max(nums[0], nums[1]));
//        } else {
//            int[] dp = new int[nums.length];
//            dp[0] = nums[0];
//            dp[1] = nums[1];
//            int max = Integer.MIN_VALUE;
//            for (int i = 2; i < nums.length; i += 2) {
//                dp[i] = Math.max(dp[i - 2] + nums[i], nums[i]);
//                max = Math.max(max, dp[i]);
//            }
//            for (int i = 3; i < nums.length; i += 2) {
//                dp[i] = Math.max(dp[i - 2] + nums[i], nums[i]);
//                max = Math.max(max, dp[i]);
//            }
//            System.out.println(max);
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] numsStr = str.split(",");
        A[] nums = new A[numsStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new A(Integer.valueOf(numsStr[i]), i);
        }
        if (nums.length == 1) {
            System.out.println(nums[0].val);
            return;
        } else if (nums.length == 2) {
            System.out.println(Math.max(nums[0].val, nums[1].val));
        } else {
            Arrays.sort(nums, ((o1, o2) -> {
                return o2.val - o1.val;
            }));
            int max = 0;
            A pre = null;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    max += nums[i].val;
                    pre = nums[i];
                } else {
                    if (pre.index != nums[i].index + 1 || pre.index != nums[i].index + 1) {
                        max += nums[i].val;
                        pre = nums[i];
                    }
                }
            }
            System.out.println(max);
        }
    }

    static class A {
        public int val;
        public int index;

        public A(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
