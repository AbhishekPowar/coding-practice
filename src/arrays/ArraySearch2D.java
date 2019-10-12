package arrays;

public class ArraySearch2D {
    public boolean searchMatrix1(int[][] matrix, int target) {

        int row = 0;
        int start = 0;
        int end = matrix.length-1;

        int rowCount = matrix[0].length-1;

        while(start <= end) {
            int mid = (start+end)/2;

            if(matrix[mid][0] > target) {
                end = mid-1;
            } else if(matrix[mid][0] < target && matrix[mid][rowCount] < target) {
                start = mid+1;
            } else if(matrix[mid][0] == target)
                return true;
            else {
                start = mid;
                break;
            }
        }

        if(start > matrix.length-1 )
            return false;
        row = start;
        start = 0;
        end = rowCount;
        while (start <= end) {
            int mid = (start+end)/2;
            if(matrix[row][mid] == target)
                return true;
            if(matrix[row][mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length <1 || matrix[0].length < 1)
            return false;
        int row = 0;
        int col = matrix[0].length -1;

        while (col >=0 && row <= matrix.length-1) {
            if(matrix[row][col] == target)
                return true;
            else if(target > matrix[row][col]) {
                row++;
            } else if(target < matrix[row][col])
                col--;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] ar = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target =5;
        // [[-9,-8,-8],[-5,-3,-2],[0,2,2],[4,6,8]]
        //15
        System.out.println(new ArraySearch2D().searchMatrix2(ar, target));
    }
}
