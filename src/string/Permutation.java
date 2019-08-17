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
    public static void main(String[] args) {
        String str = "abc";
        new Permutation().print(str);
    }
}
