package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/12
 */
public class Solution46 {

    /*
            给定一个 没有重复 数字的序列，返回其所有可能的全排列。

            示例:

            输入: [1,2,3]
            输出:
            [
              [1,2,3],
              [1,3,2],
              [2,1,3],
              [2,3,1],
              [3,1,2],
              [3,2,1]
            ]
            通过次数151,167提交次数197,895

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/permutations
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = new Solution46().permute(nums);
        System.out.println(permute);
    }

    List<List<Integer>> res = new LinkedList<>();
    boolean[] tag;

    public List<List<Integer>> permute(int[] nums) {
        tag = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        backTrack(nums, list);
        return res;
    }

    private void backTrack(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            if (tag[i]) continue;
            tag[i] = true;
            list.add(num);
            backTrack(nums, list);
            list.remove(num);
            tag[i] = false;
        }
    }
}
