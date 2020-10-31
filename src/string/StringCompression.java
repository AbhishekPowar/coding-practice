package string;

/**
 *
 */
public class StringCompression {

    public String compress(String str) {

        StringBuilder compressedString = new StringBuilder();

        char c = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == c)
                count += 1;
            else {
                compressedString.append(c).append(count);
                count = 1;
                c = str.charAt(i);
            }
        }

        compressedString.append(c).append(count);

        return (compressedString.length() >= str.length()) ? str : compressedString.toString();
    }

    public String compress2(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) != str.charAt(i - 1)) {
                stringBuilder.append(str.charAt(i - 1)).append(count);
                count = 1;
            } else
                count++;
        }
        return stringBuilder.toString();
    }

    public String decompress(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); ++i) {
            char currChar = str.charAt(i);
            if (Character.isDigit(currChar))
                count = count * 10 + currChar - '0';
            else {
                while (count > 0) {
                    stringBuilder.append(currChar);
                    count--;
                }
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringCompression().compress("aabccccdefghij"));
        System.out.println(new StringCompression().compress("aabcccccaaa"));
        System.out.println(new StringCompression().compress2("aabcccccaaa"));
        System.out.println(new StringCompression().decompress("2a1b5c3a"));
    }
}
