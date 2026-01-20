package leetcode2025;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/04
 */
public class Solution1695 {
    public static void main(String[] args) {
        int i = new Solution1695().maximumUniqueSubarray(new int[]{4,2,4,5,6});
    }

    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0, max = 0;
        int[] count = new int[10001];
        int left = 0, right = 0;
        while (right < nums.length) {
            while (count[nums[right]] > 0) {
                count[nums[left]]--;
                sum -= nums[left];
                left++;
            }
            count[nums[right]]++;
            sum = sum + nums[right];
            max = Math.max(max, sum);
            right++;
        }
        return max;
    }
}
