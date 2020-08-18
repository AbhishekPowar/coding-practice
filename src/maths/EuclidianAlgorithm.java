package maths;

public class EuclidianAlgorithm {

    public int gcd(int n, int m) {
        if(n == 0 || m == 0)
            return 0;

        if(n/m == 0)
            return m;
        return gcd(n/m, n%m);
    }
}
