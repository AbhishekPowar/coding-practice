package arrays;

import java.util.Arrays;

public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int[] output = new int[nums.length];
        Arrays.fill(output, 1);

        output[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            output[i] = output[i-1] * nums[i];
        }

        int right = 1;

        for(int i=nums.length-1; i>0; i--) {
            output[i] = right * output[i-1];
            right *= nums[i];
        }

        output[0] = right;
        return output;


    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        int[] op= new ProductArrayExceptSelf().productExceptSelf(nums);

    }
}
