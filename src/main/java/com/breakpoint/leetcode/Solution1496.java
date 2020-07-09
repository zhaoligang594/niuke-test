package com.breakpoint.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/06/30
 */
public class Solution1496 {
    /*
        https://leetcode-cn.com/problems/path-crossing/
     */
    public static void main(String[] args) {
        boolean nes = new Solution1496().isPathCrossing("NESWW");
        System.out.println(nes);
    }

    public boolean isPathCrossing(String path) {
        if (null == path || "".equals(path)) {
            return false;
        }
        int len = path.length();
        final Set<String> point = new HashSet<>();
        int x = 0, y = 0;
        point.add(x + "-" + y);
        for (int i = 0; i < len; i++) {
            switch (path.charAt(i)) {
                case 'N': {
                    y++;
                    break;
                }
                case 'S': {
                    y--;
                    break;
                }
                case 'E': {
                    x++;
                    break;
                }
                case 'W': {
                    x--;
                    break;
                }
            }
            if (!point.add(x + "-" + y)) {
                return true;
            }
        }
        return false;
    }
}
