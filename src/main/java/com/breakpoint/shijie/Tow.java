package com.breakpoint.shijie;

/**
 * @author breakpoint/zlg
 * 2020/08/29
 */
public class Tow {

    public static void main(String[] args) {
        String[] points = {"1,1", "2,2", "1,2", "1,3"};
        int index = new Tow().get_index(points);
        System.out.println(index);
    }

    public int get_index(String[] points) {
        if (points.length == 1) return 0;
        double x, y, sum_x = 0, sum_y = 0;
        for (int i = 0; i < points.length; i++) {
            String[] split = points[i].split(",");
            sum_x += Integer.valueOf(split[0]);
            sum_y += Integer.valueOf(split[1]);
        }
        x = sum_x / (points.length * 1.0);
        y = sum_y / (points.length * 1.0);

        double min_gap = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < points.length; i++) {
            String[] split = points[i].split(",");
            double pow = Math.pow(Integer.valueOf(split[0]) - x, 2.0);
            double pow1 = Math.pow(Integer.valueOf(split[1]) - y, 2.0);
            double gap = Math.sqrt(pow + pow1);
            if (gap < min_gap) {
                min_gap = gap;
                index = i;
            }
        }
        return index;
    }
}
