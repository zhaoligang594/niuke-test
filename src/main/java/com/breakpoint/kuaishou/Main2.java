package com.breakpoint.kuaishou;

import java.util.Scanner;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/06/30
 */
public class Main2 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        int[] temp = new int[k];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = scanner.nextInt();
        }
        int end = k - 1;
        qSort(temp, 0, end);

        for (int j = end; j >= 0; j--) {
            if (j - 1 >= 0) {
                int rest = temp[j] - temp[j - 1];
                if (rest > 0) {
                    temp[j - 1] = rest;
                    temp[j]=0;
                    qSort(temp, 0, j - 1);
                } else {
                    temp[j]=0;
                    temp[j-1]=0;
                    j--;
                }

            }
        }
        System.out.println(temp[0]);

    }


    private static void qSort(int[] arr, int l, int r) {
        if (l < r) {
            int partition = getPartition(arr, l, r);
            qSort(arr, l, partition - 1);
            qSort(arr, partition + 1, r);
        }
    }

    private static int getPartition(int[] arr, int l, int r) {
        int temp = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= temp) r--;
            arr[l] = arr[r];
            while (l < r && arr[l] <= temp) l++;
            arr[r] = arr[l];
        }
        arr[r] = temp;
        return l;
    }


}
