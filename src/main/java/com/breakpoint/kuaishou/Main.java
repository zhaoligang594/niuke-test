package com.breakpoint.kuaishou;

import java.util.Scanner;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/06/30
 */
public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        String str = scanner.next();

        int[] temp = new int[str.length()];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = str.charAt(i) - '0';
        }

        int count = 0;

        if (k > 0) {
            boolean isEnd = false;

            int i = 0;

            while (i < temp.length && temp[i] == 0) i++;

            // 左面开始位置
            int left_index = i;
            k--;
            i++;

            while (i < temp.length && k > 0) {
                while (i < temp.length && temp[i] == 0) i++;
                k--;
                i++;
            }

            // 右边结束位置
            int right_index = i - 1;

            while (!isEnd && k == 0) {
                int start = left_index - 1;
                int end = right_index + 1;
                while (start >= 0 && temp[start] == 0) start--;
                while (end < temp.length && temp[end] == 0) end++;
                int left = left_index - start;
                int right = end - right_index;
                count += left * right;
                if (end >= temp.length) {
                    isEnd = true;
                } else {
                    right_index++;
                    while (right_index < temp.length && temp[right_index] == 0) right_index++;
                    left_index++;
                    while (left_index < temp.length && temp[left_index] == 0) left_index++;
                }
            }

        } else {
            // k==0 case
            int start = 0;
            int end = 0;
            for (; end < temp.length; ) {
                while (start < temp.length && temp[start] == 1) start++;
                end = start;
                while (end < temp.length && temp[end] == 0) end++;
                int r = end - start;
                count += (1 + r) * r / 2;
                while (end < temp.length && temp[end] == 1)end++;
                start=end;
            }
        }
        System.out.println(count);
    }
}
