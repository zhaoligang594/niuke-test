package com.breakpoint.offer;

import com.breakpoint.annotation.Fail;

import java.util.HashMap;
import java.util.Map;

/**
 * @author breakpoint/赵先生
 * 2020/12/04
 */
@Fail
public class Offer60 {

    public static void main(String[] args) {
        double[] doubles = new Offer60().dicesProbability(2);
        System.out.println(doubles);
    }

    public double[] dicesProbability(int n) {
        Msg dp = dp(n);
        return dp.vals;
    }

    public Msg dp(int n) {
        if (valMap.containsKey(n)) return valMap.get(n);
        if (n == 1) {
            Msg msg = new Msg(1);
            msg.vals = new double[]{0, 1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6};
            return msg;
        } else {
            Msg msg = new Msg(n);
            Msg dp_n_1 = dp(n - 1);
            for (int i = n; i <= n * 6; i++) {
                for (int j = n - 1; j <= (n - 1) * 6 && j < i; j++) {
                    msg.vals[i] += dp_n_1.vals[i - j] * (1.0 / 6);
                }
            }
            valMap.put(n, msg);
            return msg;
        }
    }

    private static Map<Integer, Msg> valMap = new HashMap<Integer, Msg>();

    private static class Msg {
        public double[] vals;

        public Msg(int n) {
            this.vals = new double[n * 6 - n];
        }
    }
}
