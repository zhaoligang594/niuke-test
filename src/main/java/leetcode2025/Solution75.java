package leetcode2025;

/**
 * 典型的荷兰
 *
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/04
 */
public class Solution75 {

    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[l] == 0) l++;
            while (l < r && nums[r] == 2) r--;
        }
    }
}
