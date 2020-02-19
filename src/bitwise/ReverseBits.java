package bitwise;

import org.apache.commons.lang3.time.StopWatch;

import java.util.logging.Logger;

public class ReverseBits {

    private final static int BIT_MASK = 3;
    private final static int WORD_SIZE = 2;

    private static int[] cache = new int[(int) Math.pow(2, 2)];

    private static Logger logger = Logger.getLogger("ReversetBits");
    /**
     * Approach 1: We traverse given input bit by bit from LSB to MSB.
     *
     * Time Complexity: O(n) where n is number of bits in input
     * @param input
     * @return
     */
    public static long reverse1(long input) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int reverse = 0;

        while(input != 0) {
            reverse <<= 1;

            if((input & 1) == 1)
                reverse |= 1;
            input >>>= 1;
        }
//        logger.info("Time Elapsed: "+stopWatch.getTime(TimeUnit.MICROSECONDS)+" micros");
        return reverse;
    }

    /**
     * Time Complexity: O(n/2) where n is the index of MSB in given input
     * @param input
     * @return
     */
    public static long reverse2(long input) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int k = (int)(Math.log(input)/Math.log(2));

        int i=0;

        while(i <= k/2) {
            int j = k - i;
            if(((input>>i)&1) != ((input>>j)&1)) {
                input ^= ((1<<i) | (1<<j));
            }
            i++;
        }
        stopWatch.stop();
//        logger.info("Time Elapsed: "+stopWatch.getTime(TimeUnit.MICROSECONDS)+" micros");
        return input;
    }

    public static long reverse3(long input) {
        initializeCache();

        return cache[(int) input & BIT_MASK] << (3*WORD_SIZE)
                | cache[(int) ((input >>> WORD_SIZE) & BIT_MASK)] << (2*WORD_SIZE)
                | cache[(int) ((input >>> (2*WORD_SIZE)) & BIT_MASK)] << (WORD_SIZE)
                | cache[(int) ((input >>> (3*WORD_SIZE)) & BIT_MASK)] ;
    }

    private static void initializeCache() {
        for(int i=0; i<Math.pow(2, 2); i++) {
            cache[i] = (int)reverse2(i);
        }

        for (int i=0; i<cache.length; i++) {
            System.out.println((cache[i]));
        }
    }

    public static void main(String[] args) {

        long input = 105;
        System.out.println(Long.toBinaryString(input));
        System.out.println(Long.toBinaryString(reverse1(input)));
        System.out.println(Long.toBinaryString(reverse2(input)));
        System.out.println(Long.toBinaryString(reverse3(input)));
        System.out.println("BitMask: "+Long.toBinaryString(BIT_MASK));
    }
}
