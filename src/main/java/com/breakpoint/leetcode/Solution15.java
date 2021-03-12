package com.breakpoint.leetcode;

import com.breakpoint.annotation.Important;
import com.breakpoint.annotation.Success;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/10
 */
@Important
@Success
public class Solution15 {

    /*
        给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

        注意：答案中不可以包含重复的三元组。 

        示例：

        给定数组 nums = [-1, 0, 1, 2, -1, -4]，

        满足要求的三元组集合为：
        [
          [-1, 0, 1],
          [-1, -1, 2]
        ]
        通过次数273,081提交次数958,351

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/3sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution15().threeSum(nums);
        System.out.println(lists);
    }

    // 使用 双指针的 方式 求解这个问题
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 剪枝的操作
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                // 满足的情况
                if (nums[i] + nums[l] + nums[r] == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while (l < nums.length && nums[l] == nums[l - 1]) l++;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    // -- 与 剪枝
                    r--;
                    while (r >= 0 && r < nums.length - 1 && nums[r] == nums[r + 1]) r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                    // ++ 与剪枝
                    while (l < nums.length && nums[l] == nums[l - 1]) l++;
                }
            }// end while
        }
        return res;
    }
}