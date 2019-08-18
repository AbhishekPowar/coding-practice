package string;

/**
 * Given two string, find if they are one edit away to be same
 *
 * Valid Operations: Insertion, Deletion, or replacement
 */
public class OneEditAway {
    public boolean test(String s1, String s2) {
        return helper(s1, s2, 0);
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
    public static void main(String[] args) {
        System.out.println(new OneEditAway().test("pale", "ple"));
    }
}
