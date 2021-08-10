package com.breakpoint.leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * 1138. 字母板上的路径
 * https://leetcode-cn.com/problems/alphabet-board-path/submissions/
 * <p>
 * 计算的路径问题
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/08
 */
public class Solution1138 {

    public static void main(String[] args) {

    }

    // 字母表
    char[][] board = {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'j'},
            {'k', 'l', 'm', 'n', 'o'},
            {'p', 'q', 'r', 's', 't'},
            {'u', 'v', 'w', 'x', 'y'},
            {'z'}
    };

    public String alphabetBoardPath(String target) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                map.put(board[i][j], new int[]{i, j});
            }
        }
        char[] chars = target.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (chars[0] != 'a') {
            sb.append(seekPath(map.get('a'), map.get(chars[0])));
        }
        sb.append('!');
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                sb.append(seekPath(map.get(chars[i - 1]), map.get(chars[i])));
            }
            sb.append('!');
        }
        return sb.toString();
    }

    private String seekPath(int[] source, int[] target) {
        StringBuilder sb = new StringBuilder();
        char a = source[0] < target[0] ? 'D' : 'U';
        char b = source[1] < target[1] ? 'R' : 'L';
        int h = Math.abs(source[0] - target[0]);
        int w = Math.abs(source[1] - target[1]);
        if (source[0] < target[0]) {
            while (w > 0) {
                sb.append(b);
                w--;
            }
            while (h > 0) {
                sb.append(a);
                h--;
            }
        } else {
            while (h > 0) {
                sb.append(a);
                h--;
            }
            while (w > 0) {
                sb.append(b);
                w--;
            }
        }
        return sb.toString();
    }
}
