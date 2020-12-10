package com.breakpoint.leetcode;

import java.util.*;

/**
 * 47. 全排列 II
 *
 * @author breakpoint/zlg
 * 2020/08/28
 */
public class Solution47 {
    /*
        给定一个可包含重复数字的序列，返回所有不重复的全排列。

        示例:

        输入: [1,1,2]
        输出:
        [
          [1,1,2],
          [1,2,1],
          [2,1,1]
        ]
        通过次数83,375提交次数139,623

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/permutations-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2};
        List<List<Integer>> permute = new Solution47().permuteUnique(nums);
        System.out.println(permute);
    }

    List<List<Integer>> res = new ArrayList<>();
    int[] tag;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        tag = new int[nums.length];
        Deque<Integer> list = new LinkedList<Integer>();
        backTrack(nums, list);
        return res;
    }

    // 循环迭代的操作
    private void backTrack(int[] nums, Deque<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            if (tag[i] == 1) continue;
            tag[i] = 1;
            list.addLast(num);
            if (set.add(list.toString())) {
                System.out.println(list.toString());
                backTrack(nums, list);
            }
            list.removeLast();
            tag[i] = 0;
        }

    }
}
