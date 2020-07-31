package com.breakpoint.leetcode;

/**
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/09
 */
public class Solution56 {

    /*
            输入: [[1,3],[2,6],[8,10],[15,18]]
            输出: [[1,6],[8,10],[15,18]]
            解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/merge-intervals
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = new Solution56().merge(intervals);
        System.out.println(merge);

    }

    // 合并区间
    public int[][] merge(int[][] intervals) {
        if (null == intervals || intervals.length == 0) {
            return new int[0][];
        }

        if (1 == intervals.length) {
            return intervals;
        }

        // 排序
        qSort(intervals, 0, intervals.length - 1);

        // merge
        int k = 0;
        for (int i = 0, j = 1; j < intervals.length; ) {
            if (intervals[i][1] >= intervals[j][0]) {
                intervals[k][0] = intervals[i][0];
                intervals[k][1] = intervals[i][1] > intervals[j][1] ? intervals[i][1] : intervals[j][1];
                j++;
                //j = i + 1;
                //k++;
            } else {
                k++;
                intervals[k][0] = intervals[j][0];
                intervals[k][1] = intervals[j][1];
                i = k;
                j++;
            }
        }

        // 一直存储的是当前的索引 并不是数组的长度
        k++;

        if (k == intervals.length) {
            return intervals;
        }

        int[][] value = new int[k][];

        for (int i = 0; i < k; i++) {
            value[i] = intervals[i];
        }
        return value;

    }


    // 快速排序的操作
    private void qSort(int[][] intervals, int l, int r) {
        if (l < r) {
            int part = getPartition(intervals, l, r);
            qSort(intervals, l, part - 1);
            qSort(intervals, part + 1, r);
        }
    }

    private int getPartition(int[][] intervals, int l, int r) {
        int[] temp = intervals[l];
        while (l < r) {
            while (l < r && intervals[r][0] >= temp[0]) r--;
            if (l < r) intervals[l] = intervals[r];
            while (l < r && intervals[l][0] <= temp[0]) l++;
            if (l < r) intervals[r] = intervals[l];
        }
        intervals[l] = temp;
        return l;
    }


}
