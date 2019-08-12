package com.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

class Palindrome {
    public static void main(String args[] ) throws Exception {
        FastReader reader = new FastReader();
        int tc = reader.nextInt();

        while(tc-- > 0) {

            long l = reader.nextLong();
            System.out.println(l);
            int[] arr = new int[10];
            int maxCount = -1;
            int elem = 100000;
            int index=0;
            while(l > 0 )
            {
                int a = Math.toIntExact(l % 10);
                arr[a] = arr[a]+1;
                l = l/10;

                if(arr[a] > maxCount) {
                    maxCount = arr[a];
                    elem = a;
                } else if(arr[a] == maxCount && arr[a] < elem) {
                    elem = arr[a];
                } else {
                    ;
                }
            }
            System.out.println(elem);
        }
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    public String next() {
        while(st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
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
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

