package arrays;

import java.util.Arrays;

public class PossibleToReachEnd {

    public boolean canJump(int[] nums) {
        int n = nums.length-1;
        int can_reach = 0;
        for(int i=0; i<=can_reach; i++) {
            if(i==n) return true;
            can_reach = Math.max(can_reach, i+nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PossibleToReachEnd().canJump(new int[]{3,3,1,0,2,0,1}));
        System.out.println(new PossibleToReachEnd().canJump(new int[]{3,2,0,0,2,0,1}));


        byte[] bytes = new byte[] {123, 34, 100, 97, 116, 97, 34, 58, 123, 34, 97, 99, 116, 105, 118, 101, 34, 58, 102, 97, 108, 115, 101, 125, 44, 34, 100, 111, 109, 97, 105, 110, 34, 58, 34, 100, 105, 115, 116, 117, 114, 98, 97, 110, 99, 101, 65, 108, 101, 114, 116, 67, 111, 110, 102, 105, 103, 34, 44, 34, 118, 101, 114, 115, 105, 111, 110, 34, 58, 34, 118, 49, 34, 44, 34, 99, 111, 109, 109, 97, 110, 100, 34, 58, 34, 112, 117, 116, 34, 44, 34, 116, 105, 109, 101, 115, 116, 97, 109, 112, 34, 58, 49, 53, 56, 57, 51, 53, 54, 49, 54, 48, 54, 49, 56, 125};
        System.out.print(new String(bytes));
    }
}
