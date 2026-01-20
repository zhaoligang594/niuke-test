package leetcode2025;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-01-29
 */
public class Solution53 {

    public static void main(String[] args) {
        int i = new Solution53().maxSubArray(new int[]{-2, 1});
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length + 1;
        int[] sum = new int[n];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        if (n == 2) return sum[1];
        int maxIdx = 1;
        for (int i = 1; i < sum.length; i++) {
            if (sum[i] > sum[maxIdx]) {
                maxIdx = i;
            }
        }
        int minIdx = 0;
        for (int i = 1; i < maxIdx; i++) {
            if (sum[i] < sum[minIdx]) {
                minIdx = i;
            }
        }
        return sum[maxIdx] - sum[minIdx];
    }
}
