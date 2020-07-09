package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/02
 */
public class Solution448 {


    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = new Solution448().findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        final int len = nums.length;
        int target = 1 + len;

        for (int i = 0; i < len; i++) {
            Integer k = target - nums[i];
            if(list.contains(k)){
                list.remove(k);
            }
        }


        for (int i = 1; i <= len; i++) {
            list.add(i);
        }
        for (int i = 0; i < len; i++) {
            list.remove((Object) nums[i]);
        }
        return list;
    }


}
