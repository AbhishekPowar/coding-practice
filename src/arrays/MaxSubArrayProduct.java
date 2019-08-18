package arrays;

public class MaxSubArrayProduct {
	public int maxProduct(int[] nums) {
        
        int currMax = nums[0];
        int currMin = nums[0];
        
        int max = nums[0];
        
        int flag = 0;
        
        for(int i=1; i<nums.length; i++) {
           if(nums[i] > 0) {
               currMax = currMax * nums[i];
               currMin = currMin*nums[i] > 1 ? 1: currMin*nums[i];
               flag = 1;
           } else if(nums[i] < 0) {
               int temp = currMax;
               currMax = currMin*nums[i] > currMax? currMin*nums[i]: currMax;
               currMin = temp *  nums[i] > nums[i] ? nums[i]: temp*nums[i];
           } else {
               
               currMax = 1;
               currMin = 1;
           }
            if(max < currMax) {
                max = currMax;
            }
           System.out.println("CurrMax: "+currMax+", currMin: "+currMin+", maxSoFar: "+max);
        }
        if(flag == 0 && max == 1) 
        	return 0;
        return max;
    }
	
	public static void main(String[] args) {
		MaxSubArrayProduct m = new MaxSubArrayProduct();
		
		int ar[] = {-1, 0, -10};
		
		System.out.println(m.maxProduct(ar));
	}
}
