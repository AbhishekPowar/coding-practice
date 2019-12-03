package dp;

import java.util.HashMap;
import java.util.Map;

public class BrokenCalculator {
    int ways;
    public int brokenCalc(int X, int Y) {
        HashMap<String, Integer> memo = new HashMap<>();
        return helper(X, Y, memo);
    }

    public int helper(int x, int y, Map<String, Integer> memo) {

        if(x == y) {
            return 1;
        }
        if(x > 2*y)
            return Integer.MAX_VALUE;

        int doubleWays = helper(x*2, y, memo) + 1;
        int deductWays = helper(x-1, y, memo) + 1;

        return Math.min(doubleWays, deductWays);
    }

    public static void main(String[] args) {
        System.out.println(new BrokenCalculator().brokenCalc(2,3));
    }
}
