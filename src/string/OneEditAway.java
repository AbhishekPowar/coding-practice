package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two string, find if they are one edit away to be same
 *
 * Valid Operations: Insertion, Deletion, or replacement
 */
public class OneEditAway {
    public boolean test(String s1, String s2) {
        return helper1(s1, s2, 0);
    }

    private boolean helper(String s1, String s2, int edits) {
        if(edits > 1)
            return false;

        if(s1.length() == 0 && s2.length() == 0)
            return true;

        if(s1.length() == 0 && s2.length() > 1) {
            return helper("", "", edits+s2.length());
        }
        if(s2.length() == 0) {
            return helper("", "", edits+s1.length());
        }

        if(s1.charAt(0) == s2.charAt(0))
            return helper(s1.substring(1), s2.substring(1), edits);
        else {
            return helper(s1.substring(1), s2.substring(1), edits+1) || helper(s1.substring(1), s2.substring(0), edits+1) || helper(s1.substring(0), s2.substring(1), edits+1);
        }
    }

    private boolean helper1(String s1, String s2, int edits) {
        if(edits > 1)
            return false;

        if(s1 == null && s2 == null)
            return true;

        if(s1.length() == 0 && s2.length() == 0)
            return true;
        if(s1.length() == 0 || s2.length() == 0)
            return false;

        if(s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1))
            return helper1(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1), edits);

        return helper1(s1.substring(0, s1.length()-1), s2, edits+1) || helper1(s1, s2.substring(0, s2.length()-1), edits+1) || helper1(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1), edits+1);
    }
    public static void main(String[] args) {

        Arrays.copyOf(new int[]{1,2,3}, 3);
        Set<Integer> set = new HashSet<>();
        set.stream().forEach(System.out::println);
//        set.co
        System.out.println(new OneEditAway().test("pale", "ple"));
        System.out.println(new OneEditAway().test("pales", "pale"));
        System.out.println(new OneEditAway().test("pale", "bale"));
        System.out.println(new OneEditAway().test("pale", "baeke"));
    }
}
