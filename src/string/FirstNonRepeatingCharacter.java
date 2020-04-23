package string;

@SuppressWarnings("")
public class FirstNonRepeatingCharacter {

    /**
     * s = "leetcode"
     * return 0.
     * <p>
     * s = "loveleetcode",
     * return 2.
     *
     * @param s
     * @return
     */
    public int firstUniqueCharacter(String s) {
        int[] counts = new int[26];

        for(char c: s.toCharArray()) {
            counts[c-'a'] += 1;
        }

        for(int i=0; i<s.length(); i++) {
            if(counts[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstNonRepeatingCharacter().firstUniqueCharacter("loveleetcode"));
    }
}
