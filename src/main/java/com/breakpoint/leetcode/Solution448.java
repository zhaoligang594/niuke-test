package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        Set<Integer> set = new TreeSet<>();
        for (Integer val : nums) {
            set.add(val);
        }
        List<Integer> res = new ArrayList<>();
        for (Integer i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) res.add(i);
        }
        return res;
    }


}
