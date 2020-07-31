package com.breakpoint.leetcode;

import com.breakpoint.annotation.Fail;

import java.util.HashMap;
import java.util.Map;

/**
 * 38. 外观数列\
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/11
 */
@Deprecated
@Fail
public class Solution38 {

    private static Map<Integer, String> map = new HashMap<>(30);

//    static {
//        map.put(1, "1");
//
//        String pre = "1";
//        int count = 0;
//        for (int i = 2; i < 30; i++) {
//            char[] chars = pre.toCharArray();
//            StringBuilder result = new StringBuilder();
//            for (int j = 0; j < chars.length; ) {
//                char ch = chars[j];
//                count++;
//                j++;
//                while (j < chars.length && chars[j] == ch) {
//                    j++;
//                    count++;
//                }
//                result.append(count).append(ch);
//            }
//            map.put(i, result.toString());
//            pre = result.toString();
//            result.delete(0, result.length());
//            count = 0;
//        }
//    }


    // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    // 运行不出来啊
    public static void main(String[] args) {
        String s = new Solution38().countAndSay(35);
        System.out.println(s);
    }


    // 编写代码的总则 经可能的减少变量以及字符串的操作
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder();
        int p1 = 0;
        int cur = 1;
        if ( n == 1 )
            return "1";
        String str = countAndSay(n - 1);
        for ( cur = 1; cur < str.length(); cur++ ) {
            if ( str.charAt(p1) != str.charAt(cur) ) {// 如果碰到当前字符与前面紧邻的字符不等则更新此次结果
                int count = cur - p1;
                s.append(count).append(str.charAt(p1));
                p1 = cur;
            }
        }
        if ( p1 != cur ){// 防止最后一段数相等，如果不等说明p1到cur-1这段字符串是相等的
            int count = cur - p1;
            s.append(count).append(str.charAt(p1));
        }
        return s.toString();
    }



//    public String countAndSay(int n) {
//        return map.get(n);
//    }


}
