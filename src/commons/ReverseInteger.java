package commons;

public class ReverseInteger {

    public static long reverse(int n) {

        int remaining = Math.abs(n);
        long result = 0;

        while(remaining != 0) {
            result = result*10 + remaining % 10;
            remaining /= 10;
        }

        return n < 0 ? -result: result;
    }


    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
