package arrays;

/**
 *
 */
public class EvenAndOddMove {
    private void classify(int[] nums) {
        int ne = 0, no = nums.length-1;

        while (ne < no) {
            if(nums[ne] %2==0)
                ne++;
            else {
                swap(nums, ne, no--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i]+nums[j];
        nums[j] = nums[i]-nums[j];
        nums[i] = nums[i]-nums[j];
    }

    public static void main(String[] args) {
        int[] ar = new int[]{2, 3, 1, 5, 7, 4, 6};
        new EvenAndOddMove().classify(ar);
    }
}
