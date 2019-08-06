package commons;

public class PasacalTriangle {
	
	public static void printPascalTriangle(int k) {
		
		int coef[][] = new int[k+1][k+1];
		
		for(int i=0; i<k; i++) {
			for(int j=0; j<=i; j++) {
				
				if(j == 0 || j==i) {
					coef[i][j] = 1;
					System.out.print(1+" ");
				} else {
					coef[i][j] = coef[i-1][j-1] + coef[i-1][j];
					
					System.out.print(coef[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		printPascalTriangle(5);
	}
}
