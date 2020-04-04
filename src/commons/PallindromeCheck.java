package commons;

public class PallindromeCheck {

    public static boolean check(long number) {

        if(number < 0)
            return false;

        while(number != 0) {

            int n = (int) Math.log10(number) + 1;
            int lsDigit = (int) number % 10;
            int msDigit = (int) (number/ Math.pow(10, n-1));

            // if least significant and most significant digit are not equal, return false;
            if(lsDigit != msDigit)
                return false;

            // Remove most significant digit
            number -= Math.pow(10, n-1) * msDigit;
            // Remove least significant digit
            number /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(check(1221));
    }
}
