package leetcode;

import java.util.Scanner;

public class JewelsAndStone_771 {
    public int numJewelsInStones(String J, String S) {
        int m1 = 0;
        int m2 = 0;

        for(int i=0; i<J.length();i++) {
            char c = J.charAt(i);
            if(c >= 'a' && c <= 'z')
                m1 |= (1<<c-'a');
            else
                m2 |= (1<<(c-'A'));
        }

        int answer = 0;
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(c >= 'a' && c<='z' && (m1&(1<<(c-'a'))) > 0) answer++;
            else if((m2&(1<<(c-'A'))) > 0) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
//        System.out.print(new JewelsAndStone_771().numJewelsInStones("ony", "hukp"));
//        System.out.print(String.format());

        String s1 = "Hello";
        int x = 2;
        System.out.print(String.format("%1$-15s",s1));
        System.out.print(String.format("%03d",x));
    }
}
