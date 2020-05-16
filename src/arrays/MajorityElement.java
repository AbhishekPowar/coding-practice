package arrays;

/**
 * Moore's Voting algorithm
 * @link <a>https://www.geeksforgeeks.org/majority-element/</a>
 */
public class MajorityElement {

    public int getMajorityElement(int[] ar, int times) {
        int majIdx = 0;
        int count = 1;
        int currIdx = 1;

        while(currIdx < ar.length) {
            if(ar[currIdx] == ar[majIdx]) {
                count++;
            } else
                count--;

            if(count == 0) {
                majIdx = currIdx;
                count = 1;
            }
            currIdx++;
        }
        int majElem = ar[majIdx];
        count = 0;

        for(int i=0; i<ar.length; i++) {
            if(ar[i] == majElem)
                count++;
        }
        if(count > ar.length/2)
            return majElem;
        return -1;
    }
    public static void main(String[] args) {
        int[] ar = {3,2,3,2,3,1,3,2,3}; // {1,2,2,3,3,3,3,}

        System.out.println(new MajorityElement().getMajorityElement(ar,0));
    }
}
