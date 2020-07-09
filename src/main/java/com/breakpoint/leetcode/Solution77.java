package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/01
 */
@Deprecated
public class Solution77 {


    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution77().combine(4, 2);
        System.out.println(combine);
    }

    // calculate
    public List<List<Integer>> combine(int n, int k) {

        if (n < k) {
            // 没有数据返回
            return Collections.emptyList();
        }

        List<List<Integer>> lists = new ArrayList<>();


        int start_index = n - k + 1;

        int skip_count = 0;

        while (start_index > 0) {

            skip_count++;
            start_index--;
        }
        return lists;
    }

}
