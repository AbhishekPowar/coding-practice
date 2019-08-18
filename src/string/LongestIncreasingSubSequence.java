package string;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

	public int getLIS(int[] ar) {

		int[] memo = new int[ar.length];

		Arrays.fill(memo, 1);

		int maxSoFar = Integer.MIN_VALUE;

		for(int i=1;  i < ar.length; i++) {
			for(int j=0; j < i; j++) {
				if(ar[j] < ar[i]) {
					memo[i] = Math.max(memo[i], memo[j]+1);
				}
			}
			maxSoFar = Math.max(maxSoFar, memo[i]);
		}

//		for(int i=0; i<ar.length; i++)
//			System.out.print(memo[i]+" ");
//		return maxSoFar;

		int count = 0;
		for(int i=0; i<ar.length; i++) {
			if(memo[i] == maxSoFar)
				++count;
		}
		return count;
	}
	public static void main(String[] args) {

		int[] sequence = {1, 3, 5, 4, 7};

		// answer: -3, 0, 1, 4, 5: Length: 5

//		new LongestIncreasingSubSequence().getLIS(sequence);
		System.out.println(new LongestIncreasingSubSequence().getLIS(sequence));
	}
}
