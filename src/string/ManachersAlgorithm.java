package string;

public class ManachersAlgorithm {

    /**
     * Finding Longest Palindromic String using Manacher's Algorithm
     * Runtime for this algorithm is O(2N + 1) ~ O(N)
     * Space complexity : O(2N+1) ~ O(N)
     * @param s
     * @return
     */
    public String findLCS(String s) {
        StringBuilder _S = new StringBuilder();
        int[] P = new int[2*s.length()+1];
        int N = s.length();
        for(char c: s.toCharArray()) {
            _S.append('#');
            _S.append(c);
        }
        _S.append('#');

        int center = 0, right = 0;

        for(int i=0; i<2*N+1; i++) {
            int mirror = 2*center -i;
            if(right > i)
                P[i] = Math.min(right-i, P[mirror]);
            int l = i-1-P[i];
            int r = i+1+P[i];

            while(l >=0 && r <(2*N)+1 && _S.charAt(l) == _S.charAt(r)) {
                P[i]++;
                l--;
                r++;
            }

            if(i + P[i] > right) {
                center = i;
                right = i+P[i];
            }
        }

        int maxPalindromeLength = 0, centerIndex = 0;
        for(int i=0; i<P.length; i++) {
            if(P[i] > maxPalindromeLength) {
                maxPalindromeLength = P[i];
                centerIndex = i;
            }
        }
        System.out.println(maxPalindromeLength);
        System.out.println(centerIndex);
        int idx = (centerIndex-maxPalindromeLength)/2;
        return s.substring(idx, idx+maxPalindromeLength);
    }

    public static void main(String[] args) {
        System.out.println(new ManachersAlgorithm().findLCS("kiomaramol"));
    }
}
