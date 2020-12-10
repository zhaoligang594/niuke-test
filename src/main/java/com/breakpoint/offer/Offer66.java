package com.breakpoint.offer;

/**
 * @author breakpoint/赵先生
 * 2020/12/04
 */
public class Offer66 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] ints = new Offer66().constructArr(a);
        System.out.println(ints);
    }

    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        int temp = 1;
        for (int i = 0; i < a.length - 1; i++) {
            temp *= a[i];
            res[i] = temp;
        }
        temp = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            res[i] = temp * (i > 0 ? res[i - 1] : 1);
            temp *= a[i];
        }
        return res;
    }
}
