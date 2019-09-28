package dp;

public class TrappingRainWater {

    public int trappedWater(int[] ar) {
        int left[] = new int[ar.length];
        int right[] = new int[ar.length];

        left[0] = ar[0];
        for(int i=1; i<ar.length; i++) {
            left[i] = Math.max(left[i-1], ar[i]);
        }
        right[ar.length-1] = ar[ar.length -1];
        for(int i=ar.length-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], ar[i]);
        }

        int sumWater = 0;

        for(int i=0; i<ar.length; i++) {
            sumWater += Math.min(left[i], right[i]) - ar[i] ;
        }
        return sumWater;
    }
    public static void main(String[] args) {
        int[] ar = {3,0,0,2,0,4,0,5};

        System.out.println(new TrappingRainWater().trappedWater(ar));
    }
}
