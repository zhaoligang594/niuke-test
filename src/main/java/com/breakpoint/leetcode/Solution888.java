package com.breakpoint.leetcode;

import java.util.HashMap;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-02-01
 */
public class Solution888 {

    public static void main(String[] args) {

    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        HashMap<Integer, Integer> mapA = new HashMap<>();
        for (int numA : A) {
            sumA += numA;
            mapA.put(numA, numA);
        }
        for (int numB : B) {
            sumB += numB;
        }
        int target = (sumA - sumB) / 2;
        // y-x= (sumA-SumB)/2=target
        // y= target+x
        for (int numB : B) {
            if (mapA.containsKey(target + numB)) {
                return new int[]{target + numB, numB};
            }
        }
        return null;
    }


}
