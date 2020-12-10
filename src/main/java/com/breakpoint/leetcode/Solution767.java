package com.breakpoint.leetcode;

import com.breakpoint.annotation.Fail;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author breakpoint/赵先生
 * 2020/11/30
 */
@Fail
public class Solution767 {

    public static void main(String[] args) {
        String aaab = new Solution767().reorganizeString("aab");
        System.out.println(aaab);
    }

    public String reorganizeString(String S) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : S.toCharArray()) {
            if (deque.isEmpty()) {
                deque.addLast(ch);
            } else {
                if (deque.peekLast() != ch) {
                    deque.addLast(ch);
                } else if (deque.peekFirst() != ch) {
                    deque.addFirst(ch);
                } else {
                    return "";
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }

//    public boolean reorganizeString(char[] chars) {
//        int i = 0, j = 1;
//        for (; j < chars.length; ) {
//            if (chars[i] != chars[j]) {
//                i++;
//                j++;
//            } else {
//                int k = j;
//                while (k < chars.length && chars[k] == chars[i]) k++;
//                if (k < chars.length) {
//                    char temp = chars[k];
//                    chars[k] = chars[j];
//                    chars[j] = temp;
//                    i = j;
//                    j = i + 1;
//                } else {
//                    j = k;
//                    break;
//                }
//            }
//        }
//        return i + 1 == j;
//    }
}
