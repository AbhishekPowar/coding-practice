package bitwise;

public class NumberOfONBits {

    /**
     * Looping though each bit and counting if current bit is set to 1
     * @param n
     * @return Number of bits set to 1
     * Time Complexity: Since loop count is always O(log(n))
     * Space Complexity: O(1)
     */
    public static int countSetBits_1stApproach(int n) {
        int count = 0;
        int loopCount = 0;
        while(n > 0) {
            count += (n & 1);
            n = n>>1;
            loopCount++;
        }

        System.out.println("1st Approach Loop Count: "+ loopCount);
        return count;
    }

    /**
     * Using Bit masking
     * <b>x & ~(x-1)</b> => it will isolate the lowest bit that is set to 1 in given number
     * <b>x & (x-1)</b> => it will replace the lowest bit that is set to 1 with 0
     *
     * Time Complexity: O(x), where x is not of bits set to 1
     * @param n
     * @return
     */
    public static int countSetBits_2ndApproach(int n) {
        int count = 0;
        int mask;
        int loopCount = 0;
        while(n > 0) {
            mask = n & ~(n-1);
            count += (mask > 0) ? 1: 0;
            n = n & (n-1);
            loopCount++;
        }
        System.out.println("2nd Approach Loop Count: "+ loopCount);
        return count;
    }

    public static void play(int x) {
        int y = x | ((x & ~(x-1)) -1);
        print(y, "play");
    }

    /**
     * This function work only if divisor is number of power 2
     * @param quotient
     * @param divisor
     * @return
     */
    public static int modulo(int quotient, int divisor) {
        return quotient & (divisor -1);
    }

    public static void print(int x, String message) {
        System.out.println(message+": "+Integer.toBinaryString(x));
    }

    public static boolean testPowerOfTwo(int x) {
        return (x & (x-1)) == 0;
    }

    public static void main(String[] args) {
        int x = 80;

        System.out.println("x: "+Integer.toBinaryString(x));
        System.out.println("x-1: "+Integer.toBinaryString(x-1));
        System.out.println("~(x-1): "+Integer.toBinaryString(~(x-1)));
        System.out.println("x&~(x-1): "+Integer.toBinaryString(x&~(x-1)));
        System.out.println("x&(x-1): "+Integer.toBinaryString(x&(x-1)));

        System.out.println("1: "+countSetBits_1stApproach(x));
        System.out.println("2: "+countSetBits_2ndApproach(x));

        play(x);

        print(77, "77");
        print(64, "64");
        print(modulo(77, 64), "77 modulo 64");
        System.out.println("4 is power of 2: "+testPowerOfTwo(4) );
        System.out.println("10000005 is power of 2: "+testPowerOfTwo(10000005) );

        int mask_16bits = (1<<16) -1;
        long number = Long.MAX_VALUE;

        int h0 = (int) (number & mask_16bits);
        int h1 = (int) (number>>16 & mask_16bits);
        int h2 = (int) (number>>32 & mask_16bits);
        int h3 = (int) (number>>48 & mask_16bits);
        int answer = countSetBits_2ndApproach(h0) + countSetBits_2ndApproach(h1) + countSetBits_2ndApproach(h2) + countSetBits_2ndApproach(h3);
        System.out.println(Long.toBinaryString(number));
        System.out.println(number+": "+answer);
    }
}
