package commons;

public class SpiralMatrix {

	protected static void printSprialForm(int[][] ar, int n, int m) {
		
		int p = 0, q = 0;
		
		while(p < n && q < m) {
			for(int i=q; i<m; ++i) {
				System.out.print(ar[p][i]+" ");
			}
			p++;
			for(int i=p; i<n; ++i) {
				System.out.print(ar[i][m-1]+" ");
			}
			m--;
			
			if(p < n) {
				for(int i=m-1; i>=q; --i) {
					System.out.print(ar[n-1][i]+" ");
				}
				n--;
			}
			if(q < m) {
				for(int i=n-1; i>=p; --i) {
					System.out.print(ar[i][q]+" ");
				}
				q++;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int R = 4; 
        int C = 4;
        
		int[][] a = {
				{ 1, 2, 3, 4},
				{5, 6 , 7, 8},
				{9, 10, 11, 12}, 
				{ 13, 14, 15, 16} 
			}; 
		
		printSprialForm(a, R, C);
	}
}
