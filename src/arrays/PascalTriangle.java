package arrays;

public class PascalTriangle {
	
	public static void printTrianlge(int k) {
		
		int[][] coef = new int[k+1][k+1];
		
		for(int i=0; i<k; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0 || j==i) {
					System.out.print(1+" ");
					coef[i][j] = 1;
				} else {
					coef[i][j] = coef[i-1][j-1] + coef[i-1][j];
					System.out.print(coef[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		// print kth pascal triangle
		
		int k = 3;
		printTrianlge(k);
	}
}

	