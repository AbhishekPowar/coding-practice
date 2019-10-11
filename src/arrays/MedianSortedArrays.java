package arrays;

public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int start = 0;
        int end = nums1.length;

        int lenX = nums1.length;
        int lenY = nums2.length;

        double median = 0;

        while(start <= end) {
            int parX = (start + end)/2;
            int parY = (lenX + lenY + 1)/2 -  parX;

            // parx == 0 , means we have reached start of nums1, and there is no more element on left side
            // parx == lenX, menas we have reached far right, and there are no elements on right side
            int maxLeftX = (parX == 0) ? Integer.MIN_VALUE: nums1[parX-1];
            int minRightX = (parX == lenX) ? Integer.MAX_VALUE: nums1[parX];

            // pary == 0 , means we have reached start of nums1, and there is no more element on left side
            // pary == lenX, menas we have reached far right, and there are no elements on right side
            int maxLeftY = (parY == 0)? Integer.MIN_VALUE:nums2[parY-1];
            int minRightY = (parY == lenY) ? Integer.MAX_VALUE: nums2[parY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX)
                if((lenX + lenY)%2==0) {
                    median = (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                    break;
                }
                else {
                    median = Math.max(maxLeftX, maxLeftY);
                    break;
                }
            else if(maxLeftX > minRightY)
                end = parX-1;
            else
                start = parX + 1;
        }
        return median;
    }

    public static void main(String[] args) {

        int[] a1 = {1,3,7};
        int[] a2 = {5,6};
        System.out.println(new MedianSortedArrays().findMedianSortedArrays(a1, a2));
    }
}
