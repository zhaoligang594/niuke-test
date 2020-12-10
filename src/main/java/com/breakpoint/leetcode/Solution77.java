package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/01
 */
@Success
public class Solution77 {

    /*
        给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

        示例:

        输入: n = 4, k = 2
        输出:
        [
          [2,4],
          [3,4],
          [2,3],
          [1,2],
          [1,3],
          [1,4],
        ]
        通过次数72,658提交次数97,429


        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/combinations
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution77().combine(4, 2);
        System.out.println(combine);
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>());
        }else {
            combine(n, k, 1, new ArrayDeque<>());
        }
        return res;
    }

    public void combine(int n, int k, int start, Deque<Integer> deque) {
        if (k == 0) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (k >= 1) {
                deque.addLast(i);
                combine(n, k - 1, i + 1, deque);
                deque.pollLast();
            }
        }
    }

}
