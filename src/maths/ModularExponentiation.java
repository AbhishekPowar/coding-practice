package maths;


public class ModularExponentiation {

    private static int PRIME = 100000007;

    public int binary_exp(int x, int y) {
        if(y == 0)
            return 1;
        if(y==1)
            return x % PRIME;
        int temp = binary_exp(x, y/2);
        temp = (temp * temp) % PRIME;

        if(y%2==0)
            return temp;

        return (x%PRIME*temp)%PRIME;
    }
}
