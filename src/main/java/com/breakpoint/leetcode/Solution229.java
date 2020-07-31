package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/majority-element-ii/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/10
 */
public class Solution229 {

    /*
        给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

        说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
        示例 1:

        输入: [3,2,3]
        输出: [3]
        示例 2:

        输入: [1,1,1,3,3,2,2,2]
        输出: [1,2]

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/majority-element-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 5, 6};
        List<Integer> list = new Solution229().majorityElement(nums);
        System.out.println(list);
    }

    // 摩尔投票法查找候选人

    /**
     * @param nums
     * @return
     * @see com.breakpoint.leetcode.Solution169
     */
    public List<Integer> majorityElement(int[] nums) {

        if (null == nums || nums.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }
        int candidateA = nums[0], candidateACount = 1, start = 1, candidateB, candidateBCount = 0;

        while (start < nums.length && nums[start] == candidateA) {
            start++;
            candidateACount++;
        }

        if (start < nums.length) {
            candidateB = nums[start];
            candidateBCount = 1;

            start++;

            for (; start < nums.length; start++) {

                if (nums[start] == candidateA) {
                    candidateACount++;
                    continue;
                } else if (nums[start] == candidateB) {
                    candidateBCount++;
                    continue;
                }

                if (candidateACount == 0) {
                    candidateA = nums[start];
                    candidateACount++;
                    continue;
                }

                if (candidateBCount == 0) {
                    candidateB = nums[start];
                    candidateBCount++;
                    continue;
                }

                candidateACount--;
                candidateBCount--;
            }

            candidateACount = 0;
            candidateBCount = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == candidateA) {
                    candidateACount++;
                }
                if (nums[i] == candidateB && candidateA != candidateB) {
                    candidateBCount++;
                }
            }


            if (candidateACount * 3 > nums.length) {
                list.add(candidateA);
            }

            if (candidateBCount * 3 > nums.length) {
                list.add(candidateB);
            }

        } else {
            list.add(candidateA);
        }

        return list;

    }
}
