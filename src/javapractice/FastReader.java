package javapractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastReader {
    BufferedReader bufferedReader;
    StringTokenizer stringTokenizer;

    public FastReader() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while(stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringTokenizer.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble() {
        return Double.parseDouble(next());
    }
    public String nextLine() {
        String input = "";
        try {
            input = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return input;
    }
}
