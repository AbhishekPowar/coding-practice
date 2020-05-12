package arrays;

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
    }
}
