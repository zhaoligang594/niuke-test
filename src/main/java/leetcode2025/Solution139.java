package leetcode2025;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 赵立刚
 * @email: zlgtop@163.com
 * create at: 2025/05/02
 */
public class Solution139 {

    // 深度优选搜索
    private Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s)) return map.get(s);
        if (s.length() == 0) return true;
        boolean res = false;
        for (String word : wordDict) {
            if (s.endsWith(word)) {
                boolean b = wordBreak(s.substring(0, s.length() - word.length()), wordDict);
                map.put(s.substring(0, s.length() - word.length()), b);
                if (b) return true;
                res = res || b;
            }
        }
        return res;
    }
}
