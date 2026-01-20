package leetcode2025;

import java.util.Arrays;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/06/02
 */
public class Solution135 {

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            } else {
                candies[i] = Math.max(candies[i], 1);
            }
        }
        return Arrays.stream(candies).sum();
    }
}
