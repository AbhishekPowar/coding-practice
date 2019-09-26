package arrays;

public class FindInRotatedSortedArray {


    public int search(int[] ar, int elem) {

        return search(ar, elem, 0, ar.length-1);
    }

    private int search(int[] ar, int elem, int left, int right) {
        if(left > right)
            return -1;

        int mid = (left+right)/2;

        if(ar[mid] == elem)
            return mid;

        // interval is sorted increasingly
        if(ar[left] < ar[mid]) {
            if (elem >= ar[left] && elem < ar[mid])
                return search(ar, elem, left, mid - 1);

            return search(ar, elem, mid + 1, right);
        }

        if(elem >= ar[mid] && elem <= ar[right])
            return search(ar, elem, mid+1, right);

        return search(ar,elem, left, mid-1);
    }
    public static void main(String[] args) {
        int[] ar = {4, 5, 6, 7, 8, 9, 1, 2, 3};

        System.out.println(new FindInRotatedSortedArray().search(ar, 2));

    }
}
