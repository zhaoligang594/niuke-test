package com.breakpoint.leetcode;

import com.breakpoint.annotation.Important;
import com.breakpoint.annotation.Success;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/10
 */
@Important
@Success
public class Solution15 {

    /*
        给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

        注意：答案中不可以包含重复的三元组。

         

        示例：

        给定数组 nums = [-1, 0, 1, 2, -1, -4]，

        满足要求的三元组集合为：
        [
          [-1, 0, 1],
          [-1, -1, 2]
        ]
        通过次数273,081提交次数958,351

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/3sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {

        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> lists = new Solution15().threeSum(nums);
        System.out.println(lists);
    }


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        int n = nums.length;
        qSort(nums, 0, n - 1);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            int pa = nums[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int temp_sum = pa + nums[j] + nums[k];
                if (temp_sum > 0) {
                    k--;
                } else if (temp_sum < 0) {
                    j++;
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(pa);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                }
            }
        }


        return lists;
    }


    private void qSort(int[] nums, int l, int r) {
        if (l < r) {
            int partition = getPartition(nums, l, r);
            qSort(nums, l, partition - 1);
            qSort(nums, partition + 1, r);
        }
    }


    private int getPartition(int[] nums, int l, int r) {
        int temp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= temp) r--;
            if (l < r) nums[l] = nums[r];
            while (l < r && nums[l] <= temp) l++;
            if (l < r) nums[r] = nums[l];
        }
        nums[l] = temp;
        return l;
    }

}

//@Success
//class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        if (nums.length < 3) {
//            return Collections.emptyList();
//        }
//        //qSort(nums, 0, nums.length - 1);
//
//        List<List<Integer>> lists = new ArrayList<List<Integer>>();
//        searchTowSum(nums, 0, -nums[0], lists);
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != nums[i - 1]) {
//                searchTowSum(nums, i, -nums[i], lists);
//            }
//        }
//        return lists;
//    }
//
//    Set<String> hash = new HashSet<>();
//
//    private void searchTowSum(int[] nums, int skipIndex, int target, List<List<Integer>> lists) {
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (i == skipIndex) continue;
//            Integer integer = map.get(target - nums[i]);
//            if (integer != null) {
//                int[] temp = {nums[integer], nums[skipIndex], nums[i]};
//                qSort(temp, 0, temp.length - 1);
//                if (hash.add(String.valueOf(temp[0]) + String.valueOf(temp[1]) + String.valueOf(temp[2]))) {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[integer]);
//                    list.add(nums[skipIndex]);
//                    list.add(nums[i]);
//                    lists.add(list);
//                }
//            } else {
//                map.put(nums[i], i);
//            }
//        }
//    }
//
//
//    private void qSort(int[] nums, int l, int r) {
//        if (l < r) {
//            int partition = getPartition(nums, l, r);
//            qSort(nums, l, partition - 1);
//            qSort(nums, partition + 1, r);
//        }
//    }
//
//
//    private int getPartition(int[] nums, int l, int r) {
//        int temp = nums[l];
//        while (l < r) {
//            while (l < r && nums[r] >= temp) r--;
//            if (l < r) nums[l] = nums[r];
//            while (l < r && nums[l] <= temp) l++;
//            if (l < r) nums[r] = nums[l];
//        }
//        nums[l] = temp;
//        return l;
//    }
//}
