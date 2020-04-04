package commons;


/**
 * Calculate x power y
 * x: a double number
 * y: is an integer
 */
public class CalculatePower {


    /**
     * x^2 = x * x
     * x^3 = x^((y/2)*2) * x
     * x^4 = x^((y/2)*2)
     *
     * In general when LSB of y is 0 then result is: x^((y/2)*2)
     * else result is: x^((y/2)*2) * x
     *
     * @param x
     * @param y
     * @return
     */
    public static double power(double x, int y) {

        double result = 1.0;

        int power = y;

        x = (y < 0) ? (1.0/x): x;
        power = Math.abs(power);

        while(power != 0) {

            if((power & 1) != 0) {
                result *= x;
            }

            x *= x;

            power >>>= 1;
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(power(2,0));
    }
}
