package com.breakpoint.utils;

/**
 * 二维数组的工具类
 *
 * @author breakpoint/赵先生
 * 2020/09/07
 */
public abstract class GridUtils {


    // eg: [[0,6,0],[5,8,7],[0,9,0]]
    // 返回二维矩阵
    public static int[][] getGridByString(String data) {
        //data = data.substring(2, data.length() - 2);
        String[] items = data.split("],\\[");
        int[][] res = new int[items.length][];
        for (int i = 0; i < items.length; i++) {
            if (i == 0) {
                items[i] = items[i].substring(2);
            }
            if (i == items.length - 1) {
                items[i] = items[i].substring(0, items[i].length() - 2);
            }
            String[] split = items[i].split(",");
            if (split.length == 1 && "".equals(split[0])) {
                res[i] = new int[0];
            } else {
                res[i] = new int[split.length];
                if (split.length > 0) {
                    for (int j = 0; j < split.length; j++) {
                        if (!"".equals(split[j])) {
                            res[i][j] = Integer.valueOf(split[j]);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        getGridByString("[[0,6,0],[5,8,7],[0,9,0]]");
    }

}
