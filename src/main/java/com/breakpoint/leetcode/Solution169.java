package com.breakpoint.leetcode;

/**
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/10
 * @see Solution229  类似的操作
 */
public class Solution169 {

    /*

        给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

        你可以假设数组是非空的，并且给定的数组总是存在多数元素。



        示例 1:

        输入: [3,2,3]
        输出: 3
        示例 2:

        输入: [2,2,1,1,1,2,2]
        输出: 2
        通过次数184,632提交次数289,480
     */


    public static void main(String[] args) {
        int[] nums = {-1, 1, 1, 1, 2, 1};
        int i = new Solution169().majorityElement(nums);
        System.out.println(i);
    }

    // 摩尔投票法
    public int majorityElement(int[] nums) {

        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }


//    public int majorityElement(int[] nums) {
//
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int maxVal = -1, maxCount = -1;
//        Node[] nodes = new Node[nums.length / 2 + 1];
//        for (int i = 0; i < nums.length; i++) {
//            int index = nums[i] % nodes.length;
//            if (index < 0) {
//                index = -index;
//            }
//            Node n = nodes[index];
//            if (null == n) {
//                nodes[index] = new Node(nums[i], 1);
//                n = nodes[index];
//            } else {
//                boolean isFound = false;
//                while (null != n) {
//                    if (nums[i] == n.key) {
//                        n.val++;
//                        isFound = true;
//                        break;
//                    }
//                    n = n.next;
//                }
//
//                // not fond
//                if (!isFound) {
//                    n = nodes[index];
//                    nodes[index] = new Node(nums[i], 1);
//                    nodes[index].next = n;
//                    n = nodes[index];
//                }
//            }
//            if (n.val > maxCount) {
//                maxCount = n.val;
//                maxVal = nums[i];
//            }
//        }
//        return maxVal;
//    }
//
//
//    private static class Node {
//        int key;
//        int val;
//        Node next;
//
//        public Node(int key, int val) {
//            this.key = key;
//            this.val = val;
//        }
//    }
}
