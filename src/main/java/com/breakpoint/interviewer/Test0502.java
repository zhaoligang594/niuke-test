package com.breakpoint.interviewer;

/**
 * @author breakpoint/赵先生
 * 2020/12/06
 */
public class Test0502 {

    public static void main(String[] args) {
        String s = new Test0502().printBin(0.1);
        System.out.println(s);
    }

    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (num != 0) {
            if(sb.length()>=32) return "ERROR";
            num = num * 2;
            sb.append(((int) num) & 1);
            if (num >= 1) num -= 1;
        }
        return sb.toString();
    }
}
