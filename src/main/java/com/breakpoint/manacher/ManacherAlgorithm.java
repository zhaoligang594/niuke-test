package com.breakpoint.manacher;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-07
 */
public class ManacherAlgorithm {

    public static void main(String[] args) {

    }

    // manacher 算法
    public int countSubstrings(String s) {
        if (s.length() == 0) return 0;
        int res = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        s = sb.toString();
        int[] radis = new int[s.length()];
        int c = 0, R = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i >= R) {
                int k = 1;
                while (i - k >= 0 && i + k < s.length() && s.charAt(i - k) == s.charAt(i + k)) {
                    k++;
                }
                radis[i] = k - 1;
            } else {
                int L = 2 * c - R;// 左面的点
                int ii = 2 * c - i;
                if (ii - radis[ii] <= L) {
                    radis[i] = R - i;
                } else {
                    radis[i] = radis[ii];
                }
                // 再一次尝试扩张
                int k = radis[i];
                while (i - k >= 0 && i + k < s.length() && s.charAt(i - k) == s.charAt(i + k)) {
                    k++;
                }
                radis[i] = k - 1;
            }
            if (i + radis[i] > R) {
                R = i + radis[i];
                c = i;
            }
        }

        for (int i = 0; i < s.length(); i ++) {
            res += (radis[i] + 1) / 2;
        }

        return res;
    }

}
