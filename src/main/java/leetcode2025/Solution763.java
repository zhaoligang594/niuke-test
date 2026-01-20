package leetcode2025;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/14
 */
public class Solution763 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<Integer>();
        int[] charIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charIdx[s.charAt(i) - 'a'] = i;
        }
        char[] chars = s.toCharArray();
        int start = 0, end = charIdx[chars[0] - 'a'];
        while (start < chars.length) {
            for (int i = start; i <= end; i++) {
                end = Math.max(end, charIdx[chars[i] - 'a']);
            }
            result.add(end - start + 1);
            if (end < chars.length) {
                start = end + 1;
                if (start < chars.length) {
                    end = charIdx[chars[start] - 'a'];
                }
            }
        }
        return result;
    }

}
