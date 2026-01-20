package leetcode2025;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author breakpoint
 * @email: zlgtop@163.com
 * create date: 2025/05/01
 */
public class Solution209 {

    // 采用滑动窗口执行
    public static void main(String[] args) {
        int[] num = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
        int i = new Solution209().minSubArrayLen(213, num);
        System.out.println(i);
    }

    public int minSubArrayLen(int target, int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        int ret = 0;
        while (!pq.isEmpty() && target > 0) {
            target -= pq.poll();
            ret++;
        }
        if (target > 0) {
            return 0;
        }
        return ret;
    }
}
