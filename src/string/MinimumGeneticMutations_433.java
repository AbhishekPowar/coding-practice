package string;

import java.util.HashSet;
import java.util.Set;

public class MinimumGeneticMutations_433 {
    public int minMutation(String start, String end, String[] bank) {

        Set<String> mutationBank = new HashSet<>();
        int minMutations = 0;
        for(String mutation: bank)
            mutationBank.add(mutation);

        int i = 0, j = 7;

        StringBuilder mutString = new StringBuilder();
        while(i<j) {
            if(start.charAt(i) != end.charAt(i)) {
                String s = mutString.append(end.charAt(i)).append(end.substring(i+1)).toString();
                if(mutationBank.contains(s)) {
                    minMutations++;
                    i++;
                    mutString = mutString.append(end.charAt(i));
                }
            } else {
                mutString = mutString.append(end.charAt(i));
                i++;
            }
            if(start.charAt(j) != end.charAt(j)) {
                String s = mutString.append(end.charAt(j)).append(end.substring(j+1)).toString();
                if(mutationBank.contains(mutString.toString())) {
                    minMutations++;
                    j--;
                    mutString = mutString.append(end.charAt(j));
                }
            } else {
                j--;
            }
        }
        return minMutations == 0 ? -1: minMutations;
    }
    public static void main(String[] args) {

        /**
         * "AACCTTGG"
         * "AATTCCGG"
         * ["AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"]
         */
        String start = "AACCTTGG";
         String end =  "AATTCCGG";
         String[] bank = {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
        System.out.println(new MinimumGeneticMutations_433().minMutation(start, end, bank));
    }
}
/**
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 *
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
 *
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 *
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 *
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 *
 * Note:
 *
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 *
 *
 * Example 1:
 *
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 *
 * return: 1
 *
 *
 * Example 2:
 *
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 *
 * return: 2
 *
 *
 * Example 3:
 *
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * return: 3
 */
