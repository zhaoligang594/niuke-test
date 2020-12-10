package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/10/21
 */
public class Solution925 {

    public static void main(String[] args) {
        //"kikcxmvzi"
        //"kiikcxxmmvvzz"
        boolean longPressedName = new Solution925().isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz");
        System.out.println(longPressedName);
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name.length() == 0 && typed.length() == 0) return true;
        if (name.length() > 0 && typed.length() > 0) {
            int cur = 0, next = 0;
            for (; cur < name.length() && next < typed.length(); ) {
                if (name.charAt(cur) == typed.charAt(next)) {
                    cur++;
                    next++;
                } else if (cur > 0 && name.charAt(cur - 1) == typed.charAt(next)) {
                    while (next < typed.length() && name.charAt(cur - 1) == typed.charAt(next)) {
                        next++;
                    }
                } else {
                    break;
                }
            }
            // 最后的位置
            while (next > 0 && next < typed.length() && typed.charAt(next - 1) == typed.charAt(next)) {
                next++;
            }
            if (cur == name.length() && typed.length() == next) return true;
        }
        return false;
    }
}
