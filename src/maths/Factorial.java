package maths;

import java.math.BigInteger;

public class Factorial {

    public int find_I(int n) {
        int factorial = 1;
        for(int i=1; i<=n;i++) {
            factorial *= i;
        }
        return factorial;
    }

    public long find_II(int n) {
        long factorial = 1;
        for(int i=1; i<=n;i++) {
            factorial *= i;
        }
        return factorial;
    }

    public BigInteger find_III(int n) {
        BigInteger factorial = new BigInteger("1");
        for(int i=1; i<=n;i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
    public static void main(String[] args) {
        System.out.println(new Factorial().find_I(10));
        System.out.println(new Factorial().find_II(40));
        System.out.println(new Factorial().find_III(2000));
    }
}
