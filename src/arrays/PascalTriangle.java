package arrays;

public class PascalTriangle {
	
	public static void printTriangle(int k) {
		
		int[][] coefficient = new int[k+1][k+1];
		
		for(int i=0; i<k; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0 || j==i) {
					System.out.print(1+" ");
					coefficient[i][j] = 1;
				} else {
					coefficient[i][j] = coefficient[i-1][j-1] + coefficient[i-1][j];
					System.out.print(coefficient[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		// print kth pascal triangle
		int k = 3;
		printTriangle(k);
	}
}

	