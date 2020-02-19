package bitwise;

/**
 * Problem Statement
 * Given input number 'n', find number 'x' which have the same 'weight' as that of 'n'
 * and |x-n| is as small as possible.
 *
 * Weight of a number 'n' => is number of bits set to 1
 */
public class FindNearestNumberWithSameWeight {

    private final static int WORD_SIZE = 64;

    public static long findNearest(long n) {

      for(long i=0; i < WORD_SIZE -1; i++) {
          if(((n >>> i) & 1) != ((n >>> (i+1)) & 1)) {
              return n ^ ((1L << i) | (1L << (i+1)));
          }
      }
      return n;
    }

    public static void main(String[] args) {

        long n = 15;
        long nearest = findNearest(n);
        System.out.println(Long.toBinaryString(n));
        System.out.println(Long.toBinaryString(nearest));
    }
}
