package commons;

public class BinarySearch {

    private int[] ar;

    BinarySearch(int[] ar) {
        this.ar = ar;
    }

    public int search(int elem) {
        return search(elem, 0, ar.length-1);
    }

    private int search(int elem, int left, int right) {

        if(left > right)
            return -1;

        int mid = (left + right) /2;

        if(ar[mid] == elem)
            return mid;

        if(ar[mid] > elem)
            return search(elem, left, mid-1);
        else
            return search(elem, mid+1, right);
    }

    public static void main(String[] args) {

        int[] ar = {2,3,4,6,8};

        BinarySearch binarySearch = new BinarySearch(ar);

        System.out.println(binarySearch.search(7));
    }
}
