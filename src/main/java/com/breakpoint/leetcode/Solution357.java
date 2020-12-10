package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 357. 计算各个位数不同的数字个数
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 *
 * @author breakpoint/赵先生
 * 2020/09/02
 */
public class Solution357 {

    /*
        给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。

        示例:

        输入: 2
        输出: 91
        解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
        通过次数12,307提交次数23,982

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int i = new Solution357().countNumbersWithUniqueDigits(4);
        System.out.println(i);
    }

    int res = 0;

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        countNumbersWithUniqueDigits(nums, 0, n);
        return res + 1;
    }

    //Deque<Integer> deque = new ArrayDeque<>();
    // 标识 是否访问过
    int[] tag = new int[10];

    public void countNumbersWithUniqueDigits(int[] nums, int start, int n) {
        if (n == 0) return;
        for (int i = 0; i < nums.length; i++) {
            // 判断剪枝
            if (start != i && tag[i] == 0) {
                tag[i] = 1;
                //deque.addLast(nums[i]);
                //System.out.println(deque);
                res++;
                countNumbersWithUniqueDigits(nums, i, n - 1);
                //deque.pollLast();
                tag[i] = 0;
            }
        }
    }

    /*=============================================  其他人写的动态规划算法  ===========================================*/

    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        int min = Math.min(10, n);
        int ans = 10;
        for (int i = 1; i < min; i++) {
            dp[i + 1] = dp[i] * (10 - i);
            ans += dp[i + 1];
        }
        return ans;
    }

//    作者：jiayibing
//    链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits/solution/zhi-xing-yong-shi-0-ms-zai-suo-you-java-ti-jia-433/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
