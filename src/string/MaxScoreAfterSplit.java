package string;

public class MaxScoreAfterSplit {

    public int maxScore(String s) {
        int totalOnes = 0;
        int currZeroes = 0;
        int currOnes = 0;

        for(int i=0; i<s.length(); i++) {
            int curr = s.charAt(i) - 48;
            if(curr == 1)
                totalOnes++;
        }
        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            int curr = s.charAt(i) -48;
            if(curr == 0)
                currZeroes++;
            else
                currOnes++;
            ans = Math.max(ans, currZeroes+totalOnes-currOnes);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxScoreAfterSplit().maxScore("00111"));
    }
}
