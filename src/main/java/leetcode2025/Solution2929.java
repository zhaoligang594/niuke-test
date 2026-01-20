package leetcode2025;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/06/01
 */
public class Solution2929 {

    public long distributeCandies(int n, int limit) {
        long ans = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            if (n - i > limit << 1) {
                continue;
            }
            ans += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return ans;
    }
}
