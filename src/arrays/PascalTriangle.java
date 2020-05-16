package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	
	public static List<List<Integer>> printTriangle(int numRows) {
		
		List<List<Integer>> coefficient = new ArrayList<>();
		for(int i=0; i<numRows; i++) {
			coefficient.add(new ArrayList<>());
			for(int j=0; j<=i; j++) {
				if(j==0 || j==i) {
					System.out.print(1+" ");
					coefficient.get(i).add(j,1);
				} else {
					coefficient.get(i).add(j, coefficient.get(i-1).get(j-1)+coefficient.get(i-1).get(j));
				}
			}
		}
		return coefficient;
	}
	public static void main(String[] args) {
		
		// print kth pascal triangle
		int k = 3;
		printTriangle(k);
	}
}

	