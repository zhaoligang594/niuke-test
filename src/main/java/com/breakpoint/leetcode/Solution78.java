package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 78. 子集
 * middle
 * https://leetcode-cn.com/problems/subsets/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/08/03
 */
public class Solution78 {

    /*
        给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

        说明：解集不能包含重复的子集。

        示例:

        输入: nums = [1,2,3]
        输出:
        [
          [3],
          [1],
          [2],
          [1,2,3],
          [1,3],
          [2,3],
          [1,2],
          []
        ]


        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/subsets
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = new Solution78().subsets(nums);
        System.out.println(subsets);
        int n = 4;
        // 找到所有的子网掩码
        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);
            System.out.println(bitmask);
        }
    }


    // 没求解一个 都会进行生成新的集合满足我们的结果要求
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        res.add(item);

        if (nums == null || nums.length == 0) {
            return res;
        }
        List<List<Integer>> temp = null;
        for (int num : nums) {
            temp = new ArrayList<>();
            for (List<Integer> list : res) {
                item = new ArrayList<>(list);
                item.add(num);
                temp.add(item);
            }
            res.addAll(temp);
            temp = null;
        }
        return res;
    }
}
