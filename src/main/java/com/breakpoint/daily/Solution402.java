package com.breakpoint.daily;

/**
 * @author breakpoint
 * @email: zlgtop@163.com
 * create date: 2025/04/30
 */
public class Solution402 {

    public static void main(String[] args) {
        String s = new
                Solution402().removeKdigits("10200", 1);
        System.out.println(s);
    }

    public String removeKdigits(String num, int k) {
        StringBuffer sb = new StringBuffer();
        int remain = num.length() - k;
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > num.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(num.charAt(i));
        }
        if (remain == 0) {
            return "0";
        }
        String result = sb.toString();
        if (sb.length() > remain) {
            result = sb.substring(0, remain);
        }
        sb = new StringBuffer(result);
        while (sb.length()>0){
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }else {
                break;
            }
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

}
