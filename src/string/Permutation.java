package string;

/**
 * Print permutation of a string
 */
public class Permutation {

    public void print(String str) {
        helper(str, "");
    }

    private void helper(String str, String pre) {

        if(str.length() == 0) {
            System.out.println(pre);
            return;
        }

        for(int i=0; i < str.length(); i++) {
            String r = str.substring(0,i) + str.substring(i+1);
            helper(r, pre + str.charAt(i));
        }
    }

    /**
     * Permutation based on backtracking
     * @param str
     * @param l
     * @param r
     */
    public static void permute(String str, int l, int r) {
        if(l==r)
            System.out.println(str);
        for(int i=l; i<=r; i++) {
            str = swap(str, l,i);
            permute(str, l+1, r);
            str = swap(str,l,i);
        }
    }

    private static String swap(String s, int l, int i) {
        char[] chars = s.toCharArray();
        char t = chars[l];
        chars[l] = chars[i];
        chars[i] = t;
        return String.valueOf(chars);
    }


    public static void main(String[] args) {
        String str = "abc";
        new Permutation().print(str);
    }
}
