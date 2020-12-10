package com.breakpoint.test20201025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/10/25
 */
public class Main01 {

    public static void main(String[] args) {
        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10}, l = {0,1,6,4,8,7}, r = {4,4,9,7,9,10};
        List<Boolean> booleans = new Main01().checkArithmeticSubarrays(nums, l, r);
        System.out.println(booleans);
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        orter:
        for (int i = 0; i < l.length; i++) {
            if (r[i] - l[i] >= 1) {
                int[] temp = getArr(nums, l[i], r[i]);
                Arrays.sort(temp);
                int pre = temp[0], gap = -1;
                for (int j = 1; j < temp.length; j++) {
                    if (j > 1) {
                        if (temp[j] - pre != gap) {
                            res.add(false);
                            continue orter;
                        }
                        pre = temp[j];
                    } else {
                        gap = temp[j] - pre;
                        pre = temp[j];
                    }
                }
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }


    private int[] getArr(int[] nums, int l, int r) {
        int[] res = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            res[i - l] = nums[i];
        }
        return res;
    }
}
