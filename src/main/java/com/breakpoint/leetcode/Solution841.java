package com.breakpoint.leetcode;

import com.breakpoint.utils.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author breakpoint/zlg
 * 2020/08/31
 */
public class Solution841 {
    /*
        https://leetcode-cn.com/problems/keys-and-rooms/
        841. 钥匙和房间
     */

    public static void main(String[] args) {
        String data = "[[7,16,8,16,19,8],[10],[9,11],[3,14,16,19],[8,10,19,1,7],[13,5,10,15,4],[6,13],[14,14,11,12,18],[3],[17,9],[1,2,6,9,6],[12,12,2],[4,4],[2,13,17],[17],[],[11,15],[3,5],[15,18,5],[7,18,1]]";
        List<List<Integer>> rooms = ListUtils.getList2(data);
        boolean b = new Solution841().canVisitAllRooms(rooms);
        System.out.println(b);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (null == rooms || rooms.size() == 1) return true;
        //
        boolean[] tag = new boolean[rooms.size()];
        canVisitAllRooms(rooms, tag, 0);
        for (int i = 1; i < tag.length; i++) {
            if (!tag[i]) return false;
        }
        return true;
    }

    private void canVisitAllRooms(List<List<Integer>> rooms, boolean[] tag, int startIndex) {
        if (!tag[startIndex]) {
            tag[startIndex] = true;
            List<Integer> ids = rooms.get(startIndex);
            if (null != ids && ids.size() > 0) {
                for (Integer id : ids) {
                    canVisitAllRooms(rooms, tag, id);
                }
            }
        }
    }


}
