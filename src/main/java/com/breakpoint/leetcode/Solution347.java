package com.breakpoint.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 *
 * @author breakpoint/赵先生
 * 2020/09/07
 */
public class Solution347 {

    /*
        给定一个非空的整数数组，返回其中出现频率前 k 高的元素。


        示例 1:

        输入: nums = [1,1,1,2,2,3], k = 2
        输出: [1,2]
        示例 2:

        输入: nums = [1], k = 1
        输出: [1]
         

        提示：

        你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
        你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
        题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
        你可以按任意顺序返回答案。
        通过次数81,991提交次数134,558

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/top-k-frequent-elements
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {3, 0, 1, 0};
        int[] ints = new Solution347().topKFrequent(nums, 1);
        System.out.println(ints);
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        Map<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>(((o1, o2) -> {
            return o2.nums - o1.nums;
        }));

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Node node = map.get(nums[i]);
                node.nums++;
                maxHeap.remove(node);
                maxHeap.offer(node);
            } else {
                map.put(nums[i], new Node(nums[i], 1));
                maxHeap.offer(map.get(nums[i]));
            }
        }
        while (k > 0) {
            res[k - 1] = maxHeap.poll().key;
            k--;
        }
        return res;
    }

    static class Node {
        public int key;
        public int nums;

        public Node(int key, int nums) {
            this.key = key;
            this.nums = nums;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return key == node.key;
        }

        @Override
        public int hashCode() {

            return Objects.hash(key, nums);
        }
    }
}
