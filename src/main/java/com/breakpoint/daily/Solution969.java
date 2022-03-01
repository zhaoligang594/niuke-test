package com.breakpoint.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : breakpoint
 * create date : 2022/02/19
 * 欢迎关注公众号 《代码废柴》
 */
public class Solution969 {

    public static void main(String[] args) {

    }

    public List<Integer> pancakeSort(int[] arr) {

        List<Integer> ret = new ArrayList<Integer>(); // 初始化返回值
        for (int n = arr.length; n > 1; n--) { // 从最后一位起进行计算
            int index = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] >= arr[index]) {
                    index = i;
                }
            }
            if (index == n - 1) { // 如果最大值的位置与当前N的位置是一个那么就不需要转换了
                continue;
            }
            reverse(arr, index); // 将最大值转换到开头位置
            reverse(arr, n - 1); // 将最大值转换到末尾
            ret.add(index + 1); // 增加返回信息
            ret.add(n); // 增加返回信息
        }
        return ret;
    }

    // 反转数组
    public void reverse(int[] arr, int end) {
        for (int i = 0, j = end; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
