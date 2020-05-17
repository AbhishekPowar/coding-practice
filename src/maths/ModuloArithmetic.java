package maths;

import java.math.BigInteger;

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
    }
}
