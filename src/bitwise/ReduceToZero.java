package bitwise;

public class ReduceToZero {

    public int solution(String number) {

        int n  = Integer.valueOf(number, 2);
        System.out.println("Number: "+n);
        int steps = 0;

        while(n > 0) {
            if((n&1) > 0)
                n -= 1;
            else
                n >>= 1;
            steps++;
        }

        return steps;
    }
    public static void main(String[] args) {
        System.out.println(new ReduceToZero().solution("011100"));
        System.out.println(new ReduceToZero().solution("0"));
        System.out.println(new ReduceToZero().solution("111"));
    }
}
