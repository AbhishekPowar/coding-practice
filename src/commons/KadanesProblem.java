package commons;

/**
 * 
 * @author mohdasha
 *	Given an array, find max sum subarray
 */
public class KadanesProblem {
	
	public static int findMaxSum(int[] ar) {
		
		int currMax = ar[0];
		int max = ar[0];
		
		for(int i=1; i<ar.length; i++) {
			currMax = Math.max(ar[i], ar[i]+currMax);
			max = Math.max(max, currMax);
		}
		
		return max;
	}
	public static void main(String[] args) {
		int ar[] = {2, -1, 4, 3, 2, -5};
		
		System.out.println(findMaxSum(ar));
	}
}
