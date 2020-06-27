package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    private static Set<Integer> cycleMembers =
            new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    public boolean isHappy_1(int n) {
        int slow = n;
        int fast = getNext(n);

        while(fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    private int getNext(int n) {
        int ans = 0;
        while(n > 0) {
            int digit = n%10;
            ans += digit*digit;
            n/=10;
        }
        return ans;
    }

    public boolean isHappy_II(int n) {
        while(n !=1 && !cycleMembers.contains(n))
            n = getNext(n);

        return n == 1;
    }
}
