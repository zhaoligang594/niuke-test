package leetcode2025;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-01-29
 */
public class Solution134 {

    public static void main(String[] args) {
        Solution134 sol = new Solution134();
        int i = sol.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
            sum += gas[i];
        }
        // 不可能走过去的
        if (sum < 0) return -1;
        sum = 0;
        int idx = 0, idx2 = 0;
        while (idx < gas.length) {
            idx2 = 0;
            while (idx2 < gas.length) {
                sum += gas[(idx + idx2++) % gas.length];
                if (sum < 0) {
                    idx = (idx + idx2) % gas.length;
                    sum = 0;
                    break;
                }
            }
            if(idx2>=gas.length)
                return idx;
        }
        return idx;
    }

}
