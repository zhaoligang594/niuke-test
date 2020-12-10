package com.breakpoint.shijie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/09/27
 */
public class Solution02 {

    public static void main(String[] args) {
        Integer[] nums = {3, 5, 11, 12};
        Integer[] prime = new Solution02().find_prime(nums);
        System.out.println(Arrays.toString(prime));
    }

    public Integer[] find_prime(Integer[] nums) {
        List<Integer> res = new ArrayList<>();
        if (null != nums && nums.length > 0) {
            for (Integer num : nums) {
                boolean isPrim = true;
                for (int i = 2; i < num; i++) {
                    if (num % i == 0) {
                        isPrim = false;
                        break;
                    }
                }
                if (isPrim) {
                    res.add(num);
                }
            }
        }
        return res.toArray(new Integer[0]);
    }
}
