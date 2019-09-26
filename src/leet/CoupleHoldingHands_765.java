package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CoupleHoldingHands_765 {
    public int minSwapsCouples(int[] row) {

        HashMap<Integer, Integer> idxMapping = new HashMap<>();

        for(int i=0; i<row.length; i++) {
            idxMapping.put(row[i], i);
        }

        int swaps = 0;
        for(int i=0; i<row.length-1; i+=2) {
            if(row[i]%2 == 0 && row[i+1] != row[i]+1) {
                int couple = row[i] + 1;
                int toSwapIdx = idxMapping.get(couple);
                idxMapping.put(row[i+1], toSwapIdx);
                idxMapping.put(couple, i+1);
                row[toSwapIdx] = row[i+1];
                row[i+1] = couple;
                swaps++;
            } else if(row[i]%2 !=0 && row[i+1] != row[i]-1){
                int couple = row[i] - 1;
                int toSwapIdx = idxMapping.get(couple);
                idxMapping.put(row[i+1], toSwapIdx);
                idxMapping.put(couple, i+1);
                row[toSwapIdx] = row[i+1];
                row[i+1] = couple;
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {

        int[] ar = {0,2,4,6,7,1,3,5};
        System.out.println(new CoupleHoldingHands_765().minSwapsCouples(ar));

//        List<Integer> list = Arrays.asList(ar).stream().map(i -> new Integer(i)).collect(Collectors.toList());

//        System.out.println(list.subList(0,2));
    }
}
