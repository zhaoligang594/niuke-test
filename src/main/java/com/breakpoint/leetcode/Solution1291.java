//package com.breakpoint.leetcode;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author breakpoint/赵先生
// * 2020/09/13
// */
//public class Solution1291 {
//
//    /*
//        我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
//
//        请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
//
//         
//
//        示例 1：
//
//        输出：low = 100, high = 300
//        输出：[123,234]
//        示例 2：
//
//        输出：low = 1000, high = 13000
//        输出：[1234,2345,3456,4567,5678,6789,12345]
//         
//
//        提示：
//
//        10 <= low <= high <= 10^9
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/sequential-digits
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//     */
//
//    public static void main(String[] args) {
//        List<Integer> list = new Solution1291().sequentialDigits(8511, 23553);
//        for (Integer num : list) {
//            System.out.println(num);
//        }
//    }
//
//
//    public List<Integer> sequentialDigits(int low, int high) {
//        String minNumStr = String.valueOf(low);
//        String maxNumStr = String.valueOf(high);
//        int minLen = minNumStr.length(), maxLength = maxNumStr.length();
//        List<Integer> res = new ArrayList<>();
//        Integer startNumber = minNumStr.charAt(0) - '0';
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < minLen; i++) {
//            sb.append(startNumber++);
//        }
//        while ()
//        if (startNumber <=10){
//            Integer pre = Integer.valueOf(sb.toString());
//            if (pre >= low && pre <= high) {
//                res.add(pre);
//            }
//        }
//        outer:
//        while (minLen <= maxLength) {
//            while (pre % 10 != 9 && pre <= high) {
//                sb.delete(0, 1);
//                sb.append(startNumber++);
//                if (startNumber > 10) break outer;
//                pre = Integer.valueOf(sb.toString());
//                if (pre <= high && pre >= low) {
//                    res.add(pre);
//                } else {
//                    break outer;
//                }
//            }
//            sb.delete(0, sb.length());
//            minLen++;
//            startNumber = 1;
//            for (int i = 0; i < minLen; i++) {
//                sb.append(startNumber++);
//            }
//            if (startNumber > 10) break;
//            pre = Integer.valueOf(sb.toString());
//            if (pre <= high && pre >= low) {
//                res.add(pre);
//            } else {
//                break;
//            }
//        }
//
//        return res;
//    }
//}
