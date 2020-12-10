package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. 递增子序列
 * https://leetcode-cn.com/problems/increasing-subsequences/
 * middle
 *
 * @author breakpoint/zlg
 * 2020/08/25
 */
public class Solution491 {

    /*
        给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

        示例:

        输入: [4, 6, 7, 7]
        输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
        说明:

        给定数组的长度不会超过15。
        数组中的整数范围是 [-100,100]。
        给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
        通过次数9,815提交次数19,608

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/increasing-subsequences
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> subsequences = new Solution491().findSubsequences(nums);
        System.out.println(subsequences);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (null == nums || nums.length == 0 || nums.length == 1) {
            return lists;
        }
        Set<List<Integer>> listSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[i]);
            list.add(i);
            listSet.add(list);
        }
        while (listSet.size() > 0) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : listSet) {
                int start = list.remove(list.size() - 1);
                for (int i = start + 1; i < nums.length; i++) {
                    if (list.get(list.size() - 1) <= nums[i]) {
                        List<Integer> tempList = new ArrayList<>(list);
                        tempList.add(nums[i]);
                        tempList.add(i);
                        temp.add(tempList);
                    }
                }
                //list.add(start);
            }

            listSet.clear();
            listSet.addAll(temp);
            for (List<Integer> list : listSet) {
                Integer remove = list.remove(list.size() - 1);
                if (list.size() > 1) {
                    lists.add(new ArrayList<>(list));
                }
                list.add(remove);
            }
            temp.clear();
        }
        listSet = new HashSet<>(lists);
        lists = new ArrayList<>(listSet);
        return lists;
    }
}
