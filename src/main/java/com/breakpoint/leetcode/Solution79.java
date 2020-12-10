package com.breakpoint.leetcode;

/**
 * 79. 单词搜索
 * @author breakpoint/赵先生
 * 2020/09/02
 */
public class Solution79 {

    /*
        给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。



        示例:

        board =
        [
          ['A','B','C','E'],
          ['S','F','C','S'],
          ['A','D','E','E']
        ]

        给定 word = "ABCCED", 返回 true
        给定 word = "SEE", 返回 true
        给定 word = "ABCB", 返回 false
         

        提示：

        board 和 word 中只包含大写和小写英文字母。
        1 <= board.length <= 200
        1 <= board[i].length <= 200
        1 <= word.length <= 10^3
        通过次数82,059提交次数193,565

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/word-search
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        boolean abcced = new Solution79().exist(board, "ABCCED");
        System.out.println(abcced);
    }

    public boolean exist(char[][] board, String word) {
        if (null == board || board.length == 0) return false;
        if (null == word || "".equals(word)) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (exist(board, word.toCharArray(), 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, char[] words, int start, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            if (board[i][j] == words[start] && start == words.length - 1) {
                return true;
            } else if (board[i][j] == words[start]) {
                board[i][j] = '@';
                if (exist(board, words, start + 1, i + 1, j)) {
                    return true;
                }
                if (exist(board, words, start + 1, i - 1, j)) {
                    return true;
                }
                if (exist(board, words, start + 1, i, j + 1)) {
                    return true;
                }
                if (exist(board, words, start + 1, i, j - 1)) {
                    return true;
                }
                board[i][j] = words[start];
            } else {
                return false;
            }
        }
        return false;
    }
}
