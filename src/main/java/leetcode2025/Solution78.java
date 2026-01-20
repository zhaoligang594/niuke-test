package leetcode2025;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/12
 */
public class Solution78 {

    /**
     * 求解子集 深度优先遍历
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, ans);
        ans.add(new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, int i, List<List<Integer>> ans) {
        if (i == nums.length) {
            return;
        }
        dfs(nums, i + 1, ans);
        List<Integer> unitList = new ArrayList<>();
        unitList.add(nums[i]);
        List<List<Integer>> list = new ArrayList<>();
        list.add(unitList);
        for (List<Integer> list1 : ans) {
            list.add(new ArrayList<>(list1));
            list1.add(0, nums[i]);
            list.add(new ArrayList<>(list1));
        }
        ans.clear();
        ans.addAll(list);
    }
}
