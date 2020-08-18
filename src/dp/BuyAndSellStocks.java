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

    /**
     * Find maximum profit by buying and selling a stock only once.
     * You should buy a stock before selling
     * @param nums
     * @return
     */
    public int maxProfit_I(int[] nums) {
        int msf = nums[0];
        int maxProfit = 0;
        for(int i=1; i<nums.length;i++) {
            maxProfit = Math.max(maxProfit, nums[i] - msf);
            msf = Math.min(msf, nums[i]);
        }
        return maxProfit;
    }

    /**
     * Find maximum profit by buying and selling a stock at most twice.
     * You should buy a stock before selling and cannot sell and buy at same day
     * @param prices
     * @return
     */
    public int maxProfit_II(int[] prices) {
        int[] mProfit = new int[prices.length];
        int maxSoFar = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++) {
            maxSoFar = Math.min(maxSoFar, prices[i]);
            mProfit[i] = Math.max(mProfit[i], prices[i]-maxSoFar);
        }

        maxSoFar = Integer.MIN_VALUE;
        int max_profit = Integer.MIN_VALUE;
        for(int i=prices.length-1; i>0; i--) {
            maxSoFar = Math.max(maxSoFar, prices[i]);
            max_profit = Math.max(max_profit, maxSoFar-prices[i] + mProfit[i-1]);
        }
        return max_profit;
    }

    public int maxProfit_III(int[] prices) {
        if(prices.length <= 1)
            return 0;

        int[] profit= new int[prices.length];
        int min_far = prices[0];
        for(int i=1; i<prices.length; i++) {
            profit[i] = Math.max(profit[i], prices[i]-min_far);
            min_far = Math.min(min_far, prices[i]);
        }

        int max_far = prices[prices.length-1];
        int max_profit_right = 0;
        int max = 0;
        for(int i=prices.length-1; i>0; i--) {
            max_profit_right = Math.max(max_profit_right, max_far-prices[i]);
            profit[i] = Math.max(profit[i] + max_profit_right, profit[i-1]+ max_profit_right);
            max_far = Math.max(max_far, prices[i]);
            max = Math.max(max, profit[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        "".compareTo("abc");
        System.out.println(new BuyAndSellStocks().maxProfit(new int[]{2,5,7,1,4,3,1,3}));
        System.out.println(new BuyAndSellStocks().maxProfit_I(new int[]{310, 315, 275, 295,260, 270, 290, 230, 255, 250}));
        System.out.println(new BuyAndSellStocks().maxProfit_II(new int[]{12,11,13, 9, 12,8, 14, 13, 15}));
        System.out.println(new BuyAndSellStocks().maxProfit_III(new int[]{3,2,6,5,0,3}));
    }
}
