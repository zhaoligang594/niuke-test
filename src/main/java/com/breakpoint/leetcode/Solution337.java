package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 377. 组合总和 Ⅳ
 *
 * @author breakpoint/赵先生
 * 2020/09/03
 */
public class Solution337 {
    /*
        给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。

        示例:

        nums = [1, 2, 3]
        target = 4

        所有可能的组合为：
        (1, 1, 1, 1)
        (1, 1, 2)
        (1, 2, 1)
        (1, 3)
        (2, 1, 1)
        (2, 2)
        (3, 1)

        请注意，顺序不同的序列被视作不同的组合。

        因此输出为 7。
        进阶：
        如果给定的数组中含有负数会怎么样？
        问题会产生什么变化？
        我们需要在题目中添加什么限制来允许负数的出现？

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/combination-sum-iv
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        int i = new Solution337().combinationSum4(nums, 35);
        System.out.println(i);
    }

    int res = 0;

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (Integer num : nums) {
                if (i >= num) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    public int combinationSum42(int[] nums, int target) {
        return dfs(nums, target, new int[target + 1]);
    }

    /*================================  超出时间限制  ==================================================*/

    public int dfs(int[] nums, int target, int[] count) {
        if (count[target] > 0) return count[target];
        if (target == 0) return 1;
//        for (int i = 0; i < nums.length; i++) {
//            count[target] += count[target - nums[i]];
//        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                int dfs = dfs(nums, target - nums[i], count);
                count[target - nums[i]] = dfs;
                res += dfs;
            } else {
                break;
            }
        }
        return res;
    }
}
