package leetcode2025;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/25
 */
public class Solution2131 {

    public static void main(String[] args) {
        Solution2131 sol = new Solution2131();
        int i = sol.longestPalindrome(new String[]{"lc", "cl", "gg"});
    }

    private int getIdx(char a, char b) {
        return 1 << a | 1 << b;
    }

    public int longestPalindrome(String[] words) {
        int ret = 0;
        int[] count = new int[1 << 27];
        for (String word : words) {
            int idx = getIdx(word.charAt(1), word.charAt(0));
            if (count[idx] > 0) {
                ret += 4;
                count[idx]--;
            } else {
                count[getIdx(word.charAt(0), word.charAt(1))]++;
            }
        }
        int maxCount = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            maxCount = Math.max(maxCount, count[getIdx(i, i)]);
        }
        return ret + maxCount * 2;
    }
}
