package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 与合并区间是相似的操作
 *
 * @author breakpoint/赵先生
 * 2020/09/05
 */
public class Solution228 {

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        List<String> list = new Solution228().summaryRanges(nums);
        System.out.println(list);
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        int pre = 0, cur = 0;
        for (; cur < nums.length; cur++) {
            if (cur > pre && nums[cur - 1] + 1 != nums[cur]) {
                if (pre != cur - 1) {
                    res.add(nums[pre] + "->" + nums[cur - 1]);
                } else {
                    res.add(nums[pre] + "");
                }
                pre = cur;
            }
        }
        if (pre != cur - 1) {
            res.add(nums[pre] + "->" + nums[cur - 1]);
        } else {
            res.add(nums[pre] + "");
        }
        return res;
    }


//    public List<String> summaryRanges(int[] nums) {
//        if (nums == null || nums.length == 0) return Collections.emptyList();
//        List<String> res = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        sb.append(nums[0]);
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i - 1] + 1 == nums[i]) {
//                sb.append("@").append(nums[i]);
//            } else {
//                int index = sb.lastIndexOf("@");
//                int start = sb.indexOf("@");
//                if (index <= 0) {
//                    res.add(sb.toString());
//                } else {
//                    res.add(sb.substring(0, start) + "->" + sb.substring(index + 1));
//                }
//                sb.delete(0, sb.length());
//                sb.append(nums[i]);
//            }
//        }
//        int index = sb.lastIndexOf("@");
//        int start = sb.indexOf("@");
//        if (index <= 0) {
//            res.add(sb.toString());
//        } else {
//            res.add(sb.substring(0, start) + "->" + sb.substring(index + 1));
//        }
//        return res;
//    }
}
