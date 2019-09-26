package commons;

public class Amex {

    public static int convertToBase(String n, int base) {
        int value = 0;
        for(int i=n.length()-1; i>=0; i--) {
            int digit = Integer.parseInt(String.valueOf(n.charAt(i)));
            if(digit < 0 || digit >= 2) {
                return -1;
            }
            int exp = n.length() - 1 - i;
            value += digit * Math.pow(base,exp);
        }
        return value;
    }
    public static void main(String[] args) {
        String n = "00011100";

        System.out.println(convertToBase(n, 2));
    }
}