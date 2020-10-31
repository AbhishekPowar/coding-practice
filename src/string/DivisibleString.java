package string;

public class DivisibleString {

    public static int solve(String word1, String word2) {
        int N = word1.length(), M = word2.length();

        if(N % M != 0)
            return -1;
        for(int i=0; i<N; i++) {
            if(word1.charAt(i) != word2.charAt(i%M))
                return -1;
        }

        for(int i=0; i<M ;i++) {
            int j = 0;
            for(; j< M; j++) {
                if(word2.charAt(j) != word2.charAt(j%(i+1)))
                    break;
            }
            if(j == word2.length())
                return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solve("bcdbcdbcdbcd", "bcdbcd"));
    }
}
