package com.breakpoint.leetcode;

import java.util.*;

/**
 * @author breakpoint/赵先生
 * 2020/09/11
 */
public class Solution49 {

    /*
        给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

        示例:

        输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
        输出:
        [
          ["ate","eat","tea"],
          ["nat","tan"],
          ["bat"]
        ]
        说明：

        所有输入均为小写字母。
        不考虑答案输出的顺序。
        通过次数104,539提交次数164,870


        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/group-anagrams
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Solution49().groupAnagrams(strs);
        System.out.println(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        if (null == strs || strs.length == 0) return res;
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        res.addAll(map.values());
        return res;
    }

}
