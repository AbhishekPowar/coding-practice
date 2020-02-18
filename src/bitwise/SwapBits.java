package bitwise;

public class SwapBits {

    private static int swap(int n, int i, int j) {
        if(((n>>i)&1) != ((n>>j)&1)) {
            return (n^(1<<i | 1<<j));
        }
        return n;
    }

    public static void printBinary(int input, String msg) {
        System.out.println(msg+": "+Integer.toBinaryString(input));
    }

    public static void main(String[] args) {

        int i = 1, j= 5;
        int n = 97;
        printBinary(n, "Number");
        printBinary(swap(n, i, j), "Swap "+n+", i="+i+",j="+j);
    }
}
