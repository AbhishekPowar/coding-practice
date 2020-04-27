package dp;

public class BuyAndSellStocks {

    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;

        int[][] profit = new int[prices.length/2+1][prices.length];

        for (int t=1; t<profit.length; t++) {
            int maxThusFar = Integer.MIN_VALUE;
            for(int d=1; d<prices.length; d++) {
                maxThusFar = Math.max(maxThusFar, profit[t-1][d-1] - prices[d-1]);
                profit[t][d] = Math.max(profit[t][d-1], maxThusFar+prices[d]);
            }
        }
        return profit[prices.length/2][prices.length-1];
    }
    public static void main(String[] args) {
        System.out.println(new BuyAndSellStocks().maxProfit(new int[]{2,5,7,1,4,3,1,3}));
    }
}
