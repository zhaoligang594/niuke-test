package com.breakpoint.leetcode;

import java.util.Arrays;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/01
 */
public class Solution66 {
    /*

            给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

            最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

            你可以假设除了整数 0 之外，这个整数不会以零开头。

            示例 1:

            输入: [1,2,3]
            输出: [1,2,4]
            解释: 输入数组表示数字 123。
            示例 2:

            输入: [4,3,2,1]
            输出: [4,3,2,2]
            解释: 输入数组表示数字 4321。
            通过次数169,660提交次数380,894

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/plus-one
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9, 9};
        int[] ints = new Solution66().plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }

    public int[] plusOne(int[] digits) {
        // 进位
        int next = 1, tag = -1;
        for (int i = digits.length - 1; i >= 0; i--) {
            tag = 0;
            int temp = digits[i] + next;
            digits[i] = temp % 10;
            next = temp / 10;
            if (next == 0) {
                break;
            }
        }
        if (next == 0 || tag == -1) {
            return digits;
        }
        int[] returnArr = new int[digits.length + 1];
        returnArr[0] = next;
        for (int i = 1; i < returnArr.length; i++) {
            returnArr[i] = digits[i - 1];
        }
        return returnArr;
    }

}
