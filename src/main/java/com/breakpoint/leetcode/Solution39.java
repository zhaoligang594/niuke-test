package com.breakpoint.leetcode;

import java.util.*;

/**
 * 39. 组合总和
 *
 * @author breakpoint/zlg
 * 2020/08/31
 */
public class Solution39 {
    /*
            给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

            candidates 中的数字可以无限制重复被选取。

            说明：

            所有数字（包括 target）都是正整数。
            解集不能包含重复的组合。 
            示例 1：

            输入：candidates = [2,3,6,7], target = 7,
            所求解集为：
            [
              [7],
              [2,2,3]
            ]
            示例 2：

            输入：candidates = [2,3,5], target = 8,
            所求解集为：
            [
              [2,2,2,2],
              [2,3,3],
              [3,5]
            ]
             

            提示：

            1 <= candidates.length <= 30
            1 <= candidates[i] <= 200
            candidate 中的每个元素都是独一无二的。
            1 <= target <= 500
            通过次数129,025提交次数185,379

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/combination-sum
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        List<List<Integer>> lists = new Solution39().combinationSum(candidates, 8);
        System.out.println(lists);
    }

        /*
        产生重复的原因是：在每一个结点，做减法，展开分支的时候，由于题目中说 每一个元素可以重复使用，我们考虑了 所有的 候选数，因此出现了重复的列表。

        一种简单的去重方案是借助哈希表的天然去重的功能，但实际操作一下，就会发现并没有那么容易。

        可不可以在搜索的时候就去重呢？答案是可以的。遇到这一类相同元素不计算顺序的问题，我们在搜索的时候就需要 按某种顺序搜索。
        具体的做法是：每一次搜索的时候设置 下一轮搜索的起点 begin，请看下图。

        作者：liweiwei1419
        链接：https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Deque<Integer> queue = new ArrayDeque<>();
        //Arrays.sort(candidates);
        combinationSum(candidates, target, queue, 0);
        return res;
    }

    public void combinationSum(int[] candidates, int target, Deque<Integer> queue, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(queue));
            return;
        } else if (target > 0) {
            for (int i = begin; i < candidates.length; i++) {
                Integer candidate = candidates[i];
                if (target - candidate >= 0) {
                    queue.addLast(candidate);
                    combinationSum(candidates, target - candidate, queue, i);
                    queue.pollLast();
                } else {
                    break;
                }
            }
        }
    }
}
