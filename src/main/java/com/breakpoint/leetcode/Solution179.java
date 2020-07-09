package com.breakpoint.leetcode;

import java.util.*;

/**
 * 179. 最大数
 * middle
 * https://leetcode-cn.com/problems/largest-number/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/09
 */
public class Solution179 {

    /*
        给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

        示例 1:

        输入: [10,2]
        输出: 210
        示例 2:

        输入: [3,30,34,5,9]
        输出: 9534330
        说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/largest-number
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


     */

    public static void main(String[] args) {

        int[] nums = {0,0};
        String s = new Solution179().largestNumber(nums);
        System.out.println(s);

    }

    public String largestNumber(int[] nums) {
        if (nums == null || 0 == nums.length) {
            return "0";
        }
        List<String> temp = new ArrayList<String>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(String.valueOf(nums[i]));
        }

        /*
            算法的关键位置就是 增加自己的比较器来进行比较计算

         */
        Collections.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str1.compareTo(str2);
            }
        });

        if (temp.get(nums.length - 1).equals("0")) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        for (int i = nums.length - 1; i >= 0; i--) {
            sb.append(temp.get(i));
        }
        return sb.toString();
    }
}
