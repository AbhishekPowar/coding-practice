package divideandconquer;

import java.util.Arrays;

/**
 * 973. K Closest Points to Origin
 * Leetcode: https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPoints {

    public int[][] kClosest(int[][] points, int K) {
        int left = 0, right = points.length-1;
        while(left <= right) {
            int pivot = partition(points, left, right);
            if(pivot == K)
                break;
            if(pivot < K)
                left = pivot + 1;
            else
                right = pivot - 1;
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] points, int left, int right) {
        int[] pivot = points[left];

        while(left < right) {
            while (left < right && compare(points[right], pivot) <= 0) right--;
            points[left] = points[right];
            while (left < right && compare(points[left], pivot) >= 0) left++;
            points[right] = points[left];
        }
        points[left] = pivot;
        return left;
    }

    private int compare(int[] point, int[] pivot) {
        return (pivot[1]*pivot[1] + pivot[0]*pivot[0]) - (point[1]*point[1]+point[0]*point[0]);
    }
}

