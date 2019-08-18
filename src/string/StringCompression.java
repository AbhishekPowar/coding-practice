package string;

/**
 *
 */
public class StringCompression {

    public String compress(String str) {

        StringBuilder compressedString = new StringBuilder();

        char c = str.charAt(0);
        int count = 1;
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) == c)
                count += 1;
            else {
                compressedString.append(c).append(count);
                count = 1;
                c = str.charAt(i);
            }
        }

        compressedString.append(c).append(count);

        return (compressedString.length() >= str.length()) ? str: compressedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringCompression().compress("aabccccdefghij"));
        System.out.println(new StringCompression().compress("aabcccccaaa"));
    }
}
