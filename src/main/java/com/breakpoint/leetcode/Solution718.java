package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 718. 最长重复子数组
 *
 * @author breakpoint/赵先生
 * 2020/09/06
 */
public class Solution718 {
    /*
    给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

    示例：

    输入：
    A: [1,2,3,2,1]
    B: [3,2,1,4,7]
    输出：3
    解释：
    长度最长的公共子数组是 [3, 2, 1] 。
     

    提示：

    1 <= len(A), len(B) <= 1000
    0 <= A[i], B[i] < 100

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        int[] A = {0, 0, 0, 0, 1};
        int[] B = {1, 0, 0, 0, 0};
        int length = new Solution718().findLength(A, B);
        System.out.println(length);
    }

    // 使用的是滑动窗口的解法
    public int findLength(int[] A, int[] B) {
        return A.length < B.length ? findMax(A, B) : findMax(B, A);
    }

    private int findMax(int[] A, int[] B) {
        int max = 0;
        int an = A.length, bn = B.length;

        for (int len = 1; len <= an; len++) {
            max = Math.max(max, maxLength(A, 0, B, bn - len, len));
        }
        for (int j = bn - an; j >= 0; j--) {
            max = Math.max(max, maxLength(A, 0, B, j, an));
        }
        for (int i = 1; i < an; i++) {
            max = Math.max(max, maxLength(A, i, B, 0, an - i));
        }
        return max;
    }

    // 求解最大的值
    private int maxLength(int[] a, int i, int[] b, int j, int len) {
        int count = 0, max = 0;
        for (int k = 0; k < len; k++) {
            if (a[i + k] == b[j + k]) {
                count++;
            } else if (count > 0) {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return count > 0 ? Math.max(max, count) : max;
    }


    /*===========================  下面是自己写的垃圾的方法 =================================*/

    public int findLength2(int[] A, int[] B) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!indexMap.containsKey(A[i])) {
                indexMap.put(A[i], new ArrayList<>());
            }
            indexMap.get(A[i]).add(i);
        }
        int res = 0;
        outer:
        for (int i = 0; i < B.length; i++) {
            if (!indexMap.containsKey(B[i])) continue;
            for (Integer index : indexMap.get(B[i])) {
                int k = i, m = index;
                while (k < B.length && m < A.length && B[k] == A[m]) {
                    k++;
                    m++;
                }
                res = Math.max(res, k - i);
                if (k >= B.length) break outer;
            }
        }
        return res;
    }
}
