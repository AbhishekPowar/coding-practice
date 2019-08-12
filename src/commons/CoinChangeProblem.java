package com.commons;

import java.util.Arrays;

public class CoinChangeProblem {
	
	public static int minCoins(int coins[], int sum) {
		
		if(sum == 0)
			return 0;
		
		if(sum < 0)
			return Integer.MAX_VALUE;
		int minCoins = Integer.MAX_VALUE;
		
		for(int i=0; i<coins.length; i++) {
			int res = minCoins(coins, sum - coins[i]);
			
			if(res != Integer.MAX_VALUE)
				minCoins = Math.min(minCoins, res+1);
		}
		
		return minCoins;
		
	}
	public static void main(String[] args) {
		int coins[] = {1, 5, 3, 7};
		
		Arrays.sort(coins);
		for(int i: coins) {
		System.out.print(i+" ");
		}
	}
}
