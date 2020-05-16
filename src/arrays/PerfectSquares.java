package arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int sq = (int) Math.sqrt(n);

        int[][] dp = new int[n+1][sq+1];

        for(int i=0;i<n+1; i++){
            dp[i][1] = i;
        }
        for(int i=1; i<=n; i++) {
            for(int j=2; j<=sq; j++) {
                if(j*j <= i)
                    dp[i][j]= Math.min(dp[i][j-1], 1 + dp[i-j*j][j]);
                else
                    dp[i][j] = dp[i][j-1];
            }
        }
        return dp[n][sq];
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
        System.out.println(new PerfectSquares().numSquares(13));
    }
}
