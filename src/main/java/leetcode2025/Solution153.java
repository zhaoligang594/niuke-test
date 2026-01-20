package leetcode2025;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/14
 */
public class Solution153 {

    public static void main(String[] args) {
        Solution153 sol = new Solution153();
        int min = sol.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        System.out.println(min);
    }

    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0];
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
