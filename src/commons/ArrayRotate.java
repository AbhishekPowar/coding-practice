package commons;

public class ArrayRotate {
	
	public static int[] rotateLeft(int a[], int d) {
		int swapWith = 0;
        for(int i=d; i<a.length; i++) {
            int tmp = a[swapWith];
            a[swapWith] = a[i];
            a[i] = tmp;
            swapWith++;
        }

        int currPos = d;
        while(swapWith < a.length-1) {
            int tmp = a[swapWith];
            a[swapWith] = a[currPos];
            a[currPos] = tmp;
            swapWith++;
            if(currPos <a.length-1)
                currPos++;
            else
                currPos = d;
        }

        return a;
	}
	public static void main(String[] args) {
		int ar[] = {431,397,149,275,556,362,852,789,601,357,516,575,670,507,127,888,284,405,806,27,495,879,976,467,342,356,908,750,769,947,425,643,754,396,653,595,108,75,347,394,935,252,683,966,553,724,629,567,93,494,693,965,328,187,728,389,70,288,509,252,449};
				
				
		int d = 48;
		
		int output[] = rotateLeft(ar, 48);
		
		for(int i: output) {
			System.out.print(i+" ");
		}
		
	}
}
