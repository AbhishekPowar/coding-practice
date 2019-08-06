package sorting;

public class InsertionSort {
	protected static int[] sort(int[] ar) {
		
		for(int i=1; i<ar.length; i++) {
			int key = ar[i];
			
			int j = i -1;
			while(j >= 0 && ar[j] > key ) {
				ar[j+1] = ar[j];
				j -= 1;
			}
			ar[j+1] = key;
		}
		return ar;
	}
	
	public static void main(String[] args) {
		int[] ar = {5,2,4,6,1,3};
		
		int[] s = sort(ar);
		
		for(int i: ar) {
			System.out.println(i);
		}
	}
}
