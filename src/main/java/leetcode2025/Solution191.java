package leetcode2025;

/**
 * @author 赵立刚
 * @email: zlgtop@163.com
 * create at: 2025/05/02
 */
public class Solution191 {

    public static void main(String[] args) {
        int x = 5, y = 3;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println(x + ", " + y); // 输出: 3, 5
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }
}
