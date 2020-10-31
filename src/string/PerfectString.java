package string;

public class PerfectString {

    public static int solve(String str, int k) {

        if(str.length() < k)
            return 0;

        int answer = 0;

        for(int i=0; i<str.length(); i++) {
            int[] freq = new int[26];
            for(int j=i; j<str.length(); j++) {
                int idx = str.charAt(j) - 'a';
                freq[idx]++;

                if(freq[idx] > k)
                    break;
                else if(freq[idx] == k && check(freq, k))
                    answer++;
            }
        }
        return answer;
    }

    private static boolean check(int[] freq, int k) {
        for (int j : freq) {
            if (j != 0 && j != k)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solve("aabbccababcc",2));
    }
}
