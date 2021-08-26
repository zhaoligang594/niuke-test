package com.breakpoint.daily;

import java.util.Arrays;

/**
 * 881. 救生艇
 * https://leetcode-cn.com/problems/boats-to-save-people/
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/26
 */
public class Solution881 {

    // 采用贪心的算法来求解
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1, ans = 0;
        while (l < r) {
            if (people[l] + people[r] < limit) {
                l++;
            }
            r--;
            ans++;
        }
        return ans;
    }
}
