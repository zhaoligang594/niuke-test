package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 计算罗马数字
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/06/30
 */
public class Solution13 {

    /*

        字符          数值
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/roman-to-integer
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/roman-to-integer
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int iii = new Solution13().romanToInt("MCDLXXVI");
        System.out.println(iii);
    }

    // switch 要比索引快
    private static final Map<String, Integer> map = new HashMap<>();
    private static final List<Character> list = new ArrayList<>();

    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        map.put("IV", 4);
        map.put("IX", 9);

        map.put("XL", 40);
        map.put("XC", 90);

        map.put("CD", 400);
        map.put("CM", 900);

        list.add('I');
        list.add('X');
        list.add('C');
    }

    public int romanToInt(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char one = s.charAt(i);
            boolean isHave = false;
            if (i - 1 >= 0 && list.contains(s.charAt(i - 1))) {
                final String key = String.valueOf(s.charAt(i - 1)) + String.valueOf(one);
                Integer integer = map.get(key);
                if (null != integer) {
                    count += integer;
                    i--;
                    isHave = true;
                }
            }
            if (!isHave) {
                count += map.get(String.valueOf(one));
            }
        }
        // return
        return count;
    }

}
