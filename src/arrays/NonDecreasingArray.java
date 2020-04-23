package arrays;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {

        if(nums == null || nums.length ==1)
            return true;

        int leftToRightCounter = 0;
        int leftCurr = nums[0];
        int left_modify_count = 0;

        int rightToLeftCounter = nums.length-1;
        int rightCurr = nums[rightToLeftCounter];
        int right_modify_count = 0;

        while(leftToRightCounter < nums.length-1 || rightToLeftCounter > 0) {
            if(leftToRightCounter < nums.length-1) {
                if(leftCurr > nums[leftToRightCounter+1]) {
                    left_modify_count++;
                } else {
                    leftCurr = nums[leftToRightCounter+1];
                }
                leftToRightCounter++;
            }

            if(rightToLeftCounter > 0) {
                if(rightCurr < nums[rightToLeftCounter-1]) {
                    right_modify_count++;
                } else {
                    rightCurr = nums[rightToLeftCounter-1];
                }
                rightToLeftCounter--;
            }
        }

        return left_modify_count <= 1 || right_modify_count <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new NonDecreasingArray().checkPossibility(new int[]{3,4,2,3}));
    }
}
