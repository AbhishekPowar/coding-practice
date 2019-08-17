package commons;

import java.util.Arrays;

public class MinMoves {
public int movesToMakeZigzag(int[] nums) {
        
        int minMoves = Integer.MAX_VALUE;
        
        int evenMoves = 0;
        int prevValue, nextValue;
        
        int even[] = Arrays.copyOf(nums, nums.length);
        int odd[] = Arrays.copyOf(nums, nums.length);
        // checking even values
        for(int i=0; i<even.length; i+=2) {
            prevValue = i-1 < 0 ? Integer.MIN_VALUE:even[i-1];
            nextValue = i+1 > even.length -1 ? Integer.MIN_VALUE: even[i+1];
            
            if(prevValue >= even[i]) {
                evenMoves += prevValue - even[i] + 1;
                even[i-1] = even[i] - 1;
            }
            
            if(nextValue >= even[i]) {
                evenMoves += nextValue - even[i] + 1;
                even[i+1] = even[i] - 1;
            }
        }
        
        int oddMoves = 0;
        for(int i=1; i<odd.length; i+=2) {
            prevValue = i-1 < 0 ? Integer.MIN_VALUE:odd[i-1];
            nextValue = i+1 > odd.length -1 ? Integer.MIN_VALUE: odd[i+1];
            
            if(prevValue >= odd[i]) {
                oddMoves += prevValue - odd[i] + 1;
                odd[i-1] = odd[i] - 1;
            }
            
            if(nextValue >= odd[i]) {
                oddMoves += nextValue - odd[i] + 1;
                odd[i+1] = odd[i] - 1;
            }
        }
        return Math.min(oddMoves, evenMoves);
    }
public static void main(String[] args) {
	
	int ar[] = {2,7, 10, 9, 8, 9};
	System.out.println(new MinMoves().movesToMakeZigzag(ar));
}
}
