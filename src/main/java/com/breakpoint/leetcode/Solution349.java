package com.breakpoint.leetcode;

import java.util.*;

/**
 * @author breakpoint/赵先生
 * 2020/11/02
 */
public class Solution349 {

    //[9,3,7]
    //[6,4,1,0,0,4,4,8,7]
    public static void main(String[] args) {

        Set<Integer> set=new HashSet<>();

        System.out.println(set.remove(0));



        int[] nums1 = {9, 3, 7};
        int[] nums2 = {6, 4, 1, 0, 0, 4, 4, 8, 7};
        int[] intersection = new Solution349().intersection(nums1, nums2);

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        for (; i < nums1.length || j < nums2.length; ) {
            if (i >= nums1.length || j >= nums2.length) break;
            if (i > 0 && nums1[i] == nums1[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && nums2[j] == nums2[j - 1]) {
                j++;
                continue;
            }
            while (j < nums2.length && nums1[i] > nums2[j]) {
                j++;
            }
            if (j >= nums2.length) break;
            while (i < nums1.length && nums1[i] < nums2[j]) {
                i++;
            }
            if (i >= nums1.length) break;
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
