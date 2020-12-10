package com.breakpoint.leetcode;

/**
 * 12. 整数转罗马数字
 *
 * @author breakpoint/赵先生
 * 2020/09/10
 */
public class Solution12 {

    /*
        罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

        字符          数值
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

        通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
        所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
        // 输入值的范围
        给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/integer-to-roman
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */

    public static void main(String[] args) {
        String s = new Solution12().intToRoman(123);
        System.out.println(s);
    }

    public String intToRoman(int num) {
        // 得到
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        sb.append(num);
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            int c = Character.getNumericValue(sb.charAt(i));
            switch (i) {
                case 0: {
                    if (c < 4) {
                        while (c > 0) {
                            res.insert(0, "I");
                            c--;
                        }
                    } else if (c == 4) {
                        res.insert(0, "IV");
                    } else if (c < 9) {
                        c -= 5;
                        while (c > 0) {
                            res.insert(0, "I");
                            c--;
                        }
                        res.insert(0, "V");
                    }else {
                        res.insert(0, "IX");
                    }
                    break;
                }
                case 1: {
                    if (c < 4) {
                        while (c > 0) {
                            res.insert(0, "X");
                            c--;
                        }
                    } else if (c == 4) {
                        res.insert(0, "XL");
                    } else  if (c < 9){

                        c -= 5;
                        while (c > 0) {
                            res.insert(0, "X");
                            c--;
                        }
                        res.insert(0, "L");
                    }else {
                        res.insert(0, "XC");
                    }
                    break;
                }
                case 2: {
                    if (c < 4) {
                        while (c > 0) {
                            res.insert(0, "C");
                            c--;
                        }
                    } else if (c == 4) {
                        res.insert(0, "CD");
                    } else if (c < 9) {

                        c -= 5;
                        while (c > 0) {
                            res.insert(0, "C");
                            c--;
                        }
                        res.insert(0, "D");
                    } else {
                        res.insert(0, "CM");
                    }
                    break;
                }
                case 3: {
                    if (c < 4) {
                        while (c > 0) {
                            res.insert(0, "M");
                            c--;
                        }
                    }
                    break;
                }
            }
        }
        return res.toString();
    }
}
