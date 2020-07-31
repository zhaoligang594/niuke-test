package com.breakpoint.leetcode;

import com.breakpoint.annotation.Important;

/**
 * 16. 最接近的三数之和
 * middle
 * https://leetcode-cn.com/problems/3sum-closest/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/15
 */
@Important
public class Solution16 {
    /*
        给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 

        示例：

        输入：nums = [-1,2,1,-4], target = 1
        输出：2
        解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
         

        提示：

        3 <= nums.length <= 10^3
        -10^3 <= nums[i] <= 10^3
        -10^4 <= target <= 10^4

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/3sum-closest
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int i = new Solution16().threeSumClosest(nums, 1);
        System.out.println(i);
    }


    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        qSort(nums, 0, n - 1);
        int ans = Integer.MAX_VALUE, min_gap = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            int pa = nums[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int temp_sum = pa + nums[j] + nums[k];

                if (temp_sum > target) {
                    k--;
                } else if (temp_sum < target) {
                    j++;
                } else {
                    return target;
                }
                if (Math.abs(temp_sum - target) < min_gap) {
                    ans = temp_sum;
                    min_gap = Math.abs(temp_sum - target);
                }
            }
        }
        return ans;
    }


    private void qSort(int[] nums, int l, int r) {
        if (l < r) {
            int partition = getPartition(nums, l, r);
            qSort(nums, l, partition - 1);
            qSort(nums, partition + 1, r);
        }
    }

    private int getPartition(int[] nums, int l, int r) {
        int temp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= temp) r--;
            if (l < r) nums[l] = nums[r];
            while (l < r && nums[l] <= temp) l++;
            if (l < r) nums[r] = nums[l];
        }
        nums[l] = temp;
        return l;
    }


}
