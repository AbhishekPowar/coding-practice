package string;

/***
 *
 */
public class RabinKarpStringSearching {

    public static int findFirstOccurence(String text, String str) {
        if(str.length() > text.length())
            return -1;

        final int BASE = 26;
        int tHash = 0, sHash = 0;
        int powerS = 1;

        for(int i=0; i<str.length(); i++) {
            powerS = i > 0 ? powerS * BASE: 1;
            tHash = tHash * BASE + text.charAt(i);
            sHash = sHash * BASE + str.charAt(i);
        }

        for(int i=str.length(); i < text.length(); i++) {
            if(tHash == sHash && text.substring(i-str.length(), i).equals(str))
                return i - str.length();
            //uses rolling hash to compute the new hash code.
            tHash -= text.charAt(i-str.length()) * powerS;
            tHash = tHash * BASE + text.charAt(i);
        }

        if(tHash == sHash && text.substring(text.length() - str.length()).equals(str))
            return text.length() - str.length();
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findFirstOccurence("GACGCCA", "CGC"));

        int value = 0xFFFFFFF;

        System.out.println(value);
    }
}
