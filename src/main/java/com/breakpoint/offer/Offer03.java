package com.breakpoint.offer;

import com.breakpoint.annotation.Success;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * simple
 * <p>
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/15
 */
@Success
public class Offer03 {
    /*
        找出数组中重复的数字。


        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

        示例 1：

        输入：
        [2, 3, 1, 0, 2, 5, 3]
        输出：2 或 3
         

        限制：

        2 <= n <= 100000

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int i = new Offer03().findRepeatNumber(nums);
        System.out.println(i);

    }

    /**
     * 找到重复数
     *
     * @param nums 输入的参数
     * @return 返回的对象
     */
    public int findRepeatNumber(int[] nums) {
        // 设定一个标记的数组 来表示 当前是否已经查看过了 实际上也是一个 hash
        int[] tags = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (tags[nums[i]] < 0) { // 说明已经访问过了
                return nums[i];
            } else {
                tags[nums[i]] = -1;// 没有访问过 那么就标记为 -1
            }
        }
        return -1;
    }


}
