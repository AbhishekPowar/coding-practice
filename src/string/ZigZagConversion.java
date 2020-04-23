package string;

import java.util.Arrays;

public class ZigZagConversion {
    public String convert(String s, int numRows) {

        StringBuilder output = new StringBuilder();
        for(int i=0; i<numRows; i++) {
            boolean low = true;
            int idx = i;
            int size = s.length();
            if (i == 0 || (i == numRows - 1)) {
                while (idx < size) {
                    output.append(s.charAt(idx));
                    idx = idx + (numRows - 1) * 2;
                }
                continue;
            }
            while (idx < size) {
                output.append(s.charAt(idx));
                if (low) {
                    idx = idx + (numRows - i - 1) * 2;
                    low = false;
                } else {
                    idx = idx + ((i) * 2);
                    low = true;
                }
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
    }
}
