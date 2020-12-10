package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 22. 括号生成
 *
 * @author breakpoint/赵先生
 * 2020/09/03
 */
public class Solution22 {

    /*
        数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
        示例：
        输入：n = 3
        输出：[
               "((()))",
               "(()())",
               "(())()",
               "()(())",
               "()()()"
             ]
        通过次数172,936提交次数227,123
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/generate-parentheses
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        List<String> list = new Solution22().generateParenthesis(3);
        System.out.println(list);
    }

    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, n, "");
        return new ArrayList<>(res);
    }

    Set<String> res = new TreeSet<>();

    public void generateParenthesis(int left, int right, String tempStr) {
        if (left == 0 && right == 0 && !"".equals(tempStr)) {
            res.add(tempStr);
            return;
        }
        if (left > right) return;
        if (left > 0) {
            generateParenthesis(left - 1, right, tempStr + "(");
        }
        if (right > 0) {
            generateParenthesis(left, right - 1, tempStr + ")");
        }
    }
}
