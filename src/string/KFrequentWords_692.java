package string;

import java.util.*;

public class KFrequentWords_692 {

    public List<String> topKFrequent(String[] words, int k) {

        TreeMap<String, Integer> frequencyCount = new TreeMap<>();
        for(String s: words) {
            int count = 0;
            if(frequencyCount.containsKey(s))
                count = frequencyCount.get(s);

            frequencyCount.put(s, count+1);
        }
        TreeMap<Integer, TreeSet<String>> sortedOP = new TreeMap<>(Collections.reverseOrder());


        for (Map.Entry entry: frequencyCount.entrySet()) {
            if(sortedOP.containsKey(entry.getValue())) {
                TreeSet<String> t = sortedOP.get(entry.getValue());
                t.add((String)entry.getKey());
            } else {
                TreeSet<String> t = new TreeSet<>();
                t.add((String)entry.getKey());
                sortedOP.put((Integer)entry.getValue(), t);
            }
        }

        List<String> op = new ArrayList<>();
        for(Map.Entry<Integer, TreeSet<String>> entry: sortedOP.entrySet()) {
            for(String word: entry.getValue()) {
                if(k > 0) {
                    op.add(word);
                    k--;
                }
                else
                    return op;
            }
        }
//        System.out.println(sortedOP);

        return  op;
    }
    public static void main(String[] args) {
        String[] ar = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        int k = 4;

        System.out.println(new KFrequentWords_692().topKFrequent(ar, k));

    }
}
