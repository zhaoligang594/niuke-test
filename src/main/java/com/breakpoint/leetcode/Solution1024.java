package com.breakpoint.leetcode;

import com.breakpoint.annotation.Fail;
import com.breakpoint.utils.GridUtils;

import java.util.*;

/**
 * @author breakpoint/赵先生
 * 2020/10/24
 */
@Fail
public class Solution1024 {

    public static void main(String[] args) {
        // [[0,5],[1,6],[2,7],[3,8],[4,9],[5,10],[6,11],[7,12],[8,13],[9,14],[10,15],[11,16],[12,17],[13,18],[14,19],[15,20],[16,21],[17,22],[18,23],[19,24],[20,25],[21,26],[22,27],[23,28],[24,29],[25,30],[26,31],[27,32],[28,33],[29,34],[30,35],[31,36],[32,37],[33,38],[34,39],[35,40],[36,41],[37,42],[38,43],[39,44],[40,45],[41,46],[42,47],[43,48],[44,49],[45,50],[46,51],[47,52],[48,53],[49,54]]
        //50
        //int[][] gridByString = GridUtils.getGridByString("[[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]]");
        //int[][] gridByString = GridUtils.getGridByString("[[18,24],[18,38],[23,29],[11,22],[6,35],[3,32],[21,29],[13,33],[31,34]]");
        int[][] gridByString = GridUtils.getGridByString("[[0,5],[1,6],[2,7],[3,8],[4,9],[5,10],[6,11],[7,12],[8,13],[9,14],[10,15],[11,16],[12,17],[13,18],[14,19],[15,20],[16,21],[17,22],[18,23],[19,24],[20,25],[21,26],[22,27],[23,28],[24,29],[25,30],[26,31],[27,32],[28,33],[29,34],[30,35],[31,36],[32,37],[33,38],[34,39],[35,40],[36,41],[37,42],[38,43],[39,44],[40,45],[41,46],[42,47],[43,48],[44,49],[45,50],[46,51],[47,52],[48,53],[49,54]]");
        int i = new Solution1024().videoStitching(gridByString, 50);
        System.out.println(i);
    }

    public int videoStitching(int[][] clips, int T) {
        qSort(clips, 0, clips.length - 1);
        Deque<int[]> stack = new LinkedList<>();
        for (int i = 0; i < clips.length; i++) {
            if (!stack.isEmpty()) {
                int[] pre = stack.peekLast();
                if (clips[i][0] == pre[0] && clips[i][1] > pre[1]) {
                    stack.pollLast();
                    stack.addLast(clips[i]);
                } else if (clips[i][0] != pre[0] && clips[i][1] > pre[1]) {
                    stack.addLast(clips[i]);
                } else if (pre[1] >= clips[i][1]) {

                } else if (clips[i][1] >= pre[1]) {
                    if (stack.size() > 1) {
                        int[] ints = stack.pollLast();
                        if (stack.peekLast()[1] >= clips[i][0]) {
                            stack.addLast(clips[i]);
                        } else {
                            stack.addLast(ints);
                            stack.addLast(clips[i]);
                        }

                    }
                }
            } else {
                stack.addLast(clips[i]);
            }

        }
        int res = 0;
        if (stack.size() > 0) {
            boolean[] tag = new boolean[stack.size()];
            List<int[]> temp = new ArrayList<>(stack);
            int[] pre = temp.get(0);
            if (pre[0] != 0) return -1;
            if (pre[1] >= T) return 1;
            res++;
            for (int i = 1; i < temp.size(); i++) {

                if (pre[1] < temp.get(1)[0]) return -1; // 不连续
                // [0,4] [3,5]
                if (temp.get(i)[1] >= T) return res + 1;
                if (pre[1] >= temp.get(i)[0] && temp.get(i)[1] > pre[1]) {
                    res++;
                    pre = temp.get(i);
                }
                if (pre[1] <= temp.get(i)[0] && temp.get(i)[1] <= pre[1]) continue;
                if (i >= 2) {
                    if (temp.get(i - 2)[1] >= temp.get(i)[0]) {
                        res--;
                        tag[i - 1] = true;
                        pre = temp.get(i);
                        //System.out.println(1);
                    }
                }
            }
        } else {
            return T == 0 ? -1 : 0;
        }

        return -1;
    }


    private void qSort(int[][] clips, int l, int r) {
        if (l < r) {
            int partition = getPartition(clips, l, r);
            qSort(clips, l, partition - 1);
            qSort(clips, partition + 1, r);
        }
    }

    private int getPartition(int[][] clips, int l, int r) {
        int[] temp = clips[l];
        while (l < r) {
            while (l < r && clips[r][0] >= temp[0]) r--;
            if (l < r) clips[l] = clips[r];
            while (l < r && clips[l][0] <= temp[0]) l++;
            if (l < r) clips[r] = clips[l];
        }
        clips[l] = temp;
        return l;

    }
}
