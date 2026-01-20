package leetcode2025;

/**
 * @author 赵立刚
 * @email: zlgtop@163.com
 * create at: 2025/05/02
 */
public class Solution2401 {

    public static void main(String[] args) {
        System.out.println(3 & 8);
        System.out.println(3 & 48);
        System.out.println(8 & 48);
        System.out.println(3 & 48);
    }

    public int longestNiceSubarray(int[] nums) {
        int mask = 0;
        int max = 1;
        for (int i = 0, j = 0; i < nums.length; ++i) {
            // 不停地右滑左边界 j
            while ((mask & nums[i]) != 0) mask ^= nums[j++];
            mask ^= nums[i];
            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}
