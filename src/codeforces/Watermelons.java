package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Watermelons {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int weight = fastReader.nextInt();

        int part1 = 2;
        int part2 = weight - part1;

        while (part1 <= part2) {
            if((part1&1)==0 && (part2&1)== 0) {
                System.out.println("YES");
                return;
            }
            part1 +=2;
            part2 -= 2;
        }
        System.out.println("NO");
    }
}

class FastReader {
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
