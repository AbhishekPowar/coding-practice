package dp;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {

    /**
     * This solution is based on two
     * 1. https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem
     *    It states that any number can be decomposed into sum of 4 perfect square number
     * 2. https://en.wikipedia.org/wiki/Adrien-Marie_Legendre
     *    It states that any number which is not of the form 4^k(8m+7) can be decomposed into sum of three perfect square numbers
     *
     *
     *  1. First, we check if the number n is of the form n = 4^{k}(8m+7), if so we return 4 directly.
     *  2. Otherwise, we further check if the number is of a square number itself or the number can be decomposed the sum of two squares.
     *  3. In the bottom case, the number can be decomposed into the sum of 3 squares, though we can also consider it decomposable by 4 squares by adding zero according to the four-square theorem. But we are asked to find the least number of squares.
     *
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (this.isSquare(n))
            return 1;
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        for (int i = 1; i * i <= n; ++i) {
            if (this.isSquare(n - i * i))
                return 2;
        }
        // bottom case of three-square theorem.
        return 3;
    }

    protected boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }
}
