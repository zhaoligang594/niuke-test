package com.breakpoint.daily;

public class Solution1295 {

    public int findNumbers(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            String s = String.valueOf(num);
            if (s.length() % 2 == 0 && (s.charAt(s.length() - 1) - '0') % 2 == 0) {
                ret++;
            }
        }
        return ret;
    }
}
