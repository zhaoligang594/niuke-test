package com.breakpoint.offer;

/**
 * @author breakpoint/赵先生
 * 2020/12/03
 */
public class Offer51 {
    /*
        在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。


        示例 1:

        输入: [7,5,6,4]
        输出: 5
         
        限制：

        0 <= 数组长度 <= 50000

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */

    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        else return reversePairs(nums, 0, nums.length - 1);
    }

    public int reversePairs(int[] nums, int left, int right) {
        if (left == right) return 0;
        int mid = (left + right) / 2;
        int leftC = reversePairs(nums, left, mid);
        int rightC = reversePairs(nums, mid + 1, right);
        int res = 0;
        int l = left, r = mid + 1, index = 0;
        int[] sorted = new int[right - left + 1];
        while (l <= mid || r <= right) {
            if (l > mid) {
                sorted[index++] = nums[r++];
            } else if (r > right) {
                sorted[index++] = nums[l++];
            } else {
                if (nums[l] > nums[r]) {
                    res += (mid - l + 1);
                    sorted[index++] = nums[r++];
                } else {
                    sorted[index++] = nums[l++];
                }
            }
        }
        for (int i = left; i <= right; i++) {
            nums[i] = sorted[i - left];
        }
        return leftC + rightC + res;
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        int i = new Offer51().reversePairs(nums);
        System.out.println(i);
    }


}
