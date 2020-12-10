package com.breakpoint.shijie;

import java.util.Scanner;

/**
 * @author breakpoint/赵先生
 * 2020/09/09
 */
public class Main04 {

    /*
        只计算丑数，而不计算非丑数。丑数=丑数*（2/3/5），所以创建数组保存有序的丑数。关键在于如何在计算丑数的过程中保持数组有序。当前的丑数必然是之前某一个丑数*因子的结果，但是不需要每个数都要乘一遍2、3、5。要获得的丑数必然是大于现在已有的，在计算得出丑数中选择一个最小的放入数组中，来保持数组的有序，因为新放入的丑数是根据之前的丑数计算得到的，所以必然是有序的。为了每次新得到的三个丑数都是比已有丑数大，且最小，所以要记录各个因子下次计算要使用的已有丑数在什么位置，否则就会出现跳数，比如已有{1,2,3,4}，我们知道下一个丑数应该是5，但是如果因子5没有选择第一个丑数1来相乘，就会漏掉5这个丑数。

     https://blog.csdn.net/zl18310999566/article/details/80224147?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] result = findUglyNumbers2(n);
        System.out.println(result[n-1]);
    }
    public static int[] findUglyNumbers2(int n) {
        if (n <= 0) {
            return null;
        }
        int[] result = new int[n];
        result[0] = 1;
        int divisor2 = 0;
        int divisor3 = 0;
        int divisor5 = 0;
        for (int i = 1; i < n ; i++) {
            int multiply2 = result[divisor2] * 2;
            int multiply3 = result[divisor3] * 3;
            int multiply5 = result[divisor5] * 5;
            int min = Math.min(multiply2, Math.min(multiply3, multiply5));
            result[i] = min;
            if (multiply2 == result[i]) {
                divisor2++;
            }
            if (multiply3 == result[i]) {
                divisor3++;
            }
            if (multiply5 == result[i]) {
                divisor5++;
            }
        }
        return result;
    }
}
