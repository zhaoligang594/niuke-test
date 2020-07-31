package com.breakpoint.leetcode;

/**
 * 面试题 08.03. 魔术索引
 * simple
 * https://leetcode-cn.com/problems/magic-index-lcci/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/31
 */
public class Test0731 {

    /*
            魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。

            示例1:

             输入：nums = [0, 2, 3, 4, 5]
             输出：0
             说明: 0下标的元素为0
            示例2:

             输入：nums = [1, 1, 1]
             输出：1
            说明:

            nums长度在[1, 1000000]之间
            此题为原书中的 Follow-up，即数组中可能包含重复元素的版本

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/magic-index-lcci
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 5};
        int magicIndex = new Test0731().findMagicIndex(nums);
        System.out.println(magicIndex);
    }


    public int findMagicIndex(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }

        return -1;
    }
}
