package com.breakpoint.bytedance;


import java.util.*;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/08
 */
public class Str01 {
    /*
           https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
     */
    public static void main(String[] args) {

        int abcabcbb = new Str01().lengthOfLongestSubstring("aav");
        System.out.println(abcabcbb);

    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || Objects.equals(s, "")) {
            return 0;
        }

        final int len = s.length();
        if (1 == len) {
            return 1;
        } else {
            int max = 0, a = 0, b = 1, k = 0;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(a));


            while (b < len) {
                while (b < len && s.charAt(a) != s.charAt(b) && set.add(s.charAt(b))) b++;
                if ((k = set.size()) > max) {
                    max = k;
                }
                do{
                    set.remove(s.charAt(a));
                    a++;
                }while (a < b && b < len && s.charAt(a) != s.charAt(b));
                if(a<len){
                    set.remove(s.charAt(a));
                }

                if(b<len){
                    set.add(s.charAt(b));
                }
                //a++;
                b = a;
            }
            return max;
        }
    }
}
