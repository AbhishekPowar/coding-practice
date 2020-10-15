package arrays;


public class RotateMatrix {

    public static void rotate1(int[][] matrix) {
        // step 1: Transpose
        int N = matrix.length;
        for(int i=0; i < N; i++) {
            for(int j=i; j<N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i< N; i++) {
            for(int j=0; j < N/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - j -1];
                matrix[i][N-j-1] = temp;
            }
        }
    }

    public static void rotate2(int[][] matrix) {
        int N = matrix.length;

        for(int x=0; x<N/2; x++) {
            for(int y=x; y < N-x-1; y++) {
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][N-x-1];
                matrix[y][N-x-1] = matrix[N-x-1][N-y-1];
                matrix[N-x-1][N-y-1] = matrix[N-y-1][x];
                matrix[N-y-1][x] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        rotate1(matrix);

    }
}
