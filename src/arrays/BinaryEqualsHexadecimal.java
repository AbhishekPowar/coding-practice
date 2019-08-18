package arrays;

/**
 * Check whether binary number given in string format equals to hexadecimal representation of string
 */
public class BinaryEqualsHexadecimal {
    public boolean compareBinToHex(String binary, String hex) {
        int binaryValue = convertFromBase(binary, 2);
        int hexValue = convertFromBase(hex, 16);

        if (binaryValue < 0 || hexValue < 0)
            return false;

        return binaryValue == hexValue;
    }

    public int convertFromBase(String number, int base) {

        int digitIdx = number.length() - 1;

        int value = 0;

        while (digitIdx >= 0) {
            int digit = digitToValue(number.charAt(digitIdx));

            if (digit < 0 || digit >= base)
                return -1;
            value += digit * Math.pow(base, number.length() - digitIdx - 1);
            digitIdx--;
        }

        return value;
    }

    private int digitToValue(char c) {
        return Integer.parseInt(String.valueOf(c));
    }

    public static void main(String[] args) {

        System.out.println(new BinaryEqualsHexadecimal().compareBinToHex("10000", "10"));
    }
}
