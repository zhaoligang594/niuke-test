package com.breakpoint.leetcode;

import java.util.*;

/**
 * @author breakpoint/赵先生
 * 2020/09/02
 */
public class Solution90 {

    /*
            在解决公共的前缀的时候，可以使用树结构来判断是否可以去掉重复的操作
     */

    /*
        给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

        说明：解集不能包含重复的子集。

        示例:

        输入: [1,2,2]
        输出:
        [
          [2],
          [1],
          [1,2,2],
          [2,2],
          [1,2],
          []
        ]
        通过次数46,773提交次数77,015

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/subsets-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        //int[] nums = {4, 4, 4, 1, 4};
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new Solution90().subsetsWithDup(nums);
        System.out.println(lists);
    }

    List<List<Integer>> res = new ArrayList<>();
    /*  ==================================================================== */

    // 去重复的集合 但是操作比较慢
    //Set<String> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, deque);
        res.add(new ArrayList<>());
        return res;
    }

    public void subsetsWithDup(int[] nums, int start, Deque<Integer> deque) {
        for (int i = start; i < nums.length; i++) {
            // 核心的思想 去掉同一层的数据
            if (i > start && nums[i] == nums[i - 1]) continue;
            deque.addLast(nums[i]);
            // 这也是去重复的操作
            //if (set.add(deque.toString())) {
            res.add(new ArrayList<>(deque));
            subsetsWithDup(nums, i + 1, deque);
            //}
            deque.pollLast();
        }
    }
}
