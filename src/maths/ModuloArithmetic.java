package maths;

import java.math.BigInteger;
import java.util.Arrays;

public class ModuloArithmetic {

    public int find(int x, int y) {
        int prime = 1000000007;
        Factorial factorial = new Factorial();
        BigInteger a = factorial.find_III(x);
        BigInteger b = factorial.find_III(y);

        a.mod(BigInteger.valueOf(2)).equals(0);
        return a.mod(BigInteger.valueOf(prime)).add(b.mod(BigInteger.valueOf(prime))).mod(BigInteger.valueOf(prime)).intValue();

    }

    public static void main(String[] args) {
        System.out.println(new ModuloArithmetic().find(20,19));
        int sq = (int)Math.sqrt(100000000);
        boolean[] primes = new boolean[100000000+1];
        Arrays.fill(primes, true);
        for(int i=2; i<=sq; i++) {
            if(primes[i]) {
                for (int j = i * i; j <= 100000000; j += i)
                    primes[j] = false;
            }
        }

        int k=1;
        int next =1;
        for(int i=2; i<=100000000;i++) {
            if(primes[i]) {
                if(k == next) {
                    System.out.println(i);
                    next +=100;
                }
                k++;
            }
        }
    }
}
