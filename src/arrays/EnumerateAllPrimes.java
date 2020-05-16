package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class EnumerateAllPrimes {

    /**
     * First approach would be to traverse from 2 to n-1
     * and check primality for each number and add to answer if prime.
     * @param n
     */
    public void enumerate_I(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=2; i<n;i++) {
            if(isPrime(i)) answer.add(i);
        }
        System.out.println(answer);
    }

    public void enumerate_II(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        ArrayList<Integer> ans = new ArrayList<>();
        isPrime[0] = false;
        isPrime[1] = true;
        for(int i=2; i<=n; i++) {
            if(isPrime[i]) {
                ans.add(i);
                for(int j=i; j<=n; j+=i)
                    isPrime[j] = false;
            }
        }
        System.out.println(ans);
    }

    private static boolean isPrime(int n) {
        int i=2;
        int bound = (int) Math.sqrt(n);
        while(i<=bound) {
            if(n%i==0)
                return false;
            i++;
        }
        return true;
    }
    public static void main(String[] args) {
        new EnumerateAllPrimes().enumerate_I(18);
        new EnumerateAllPrimes().enumerate_II(18);
    }
}
