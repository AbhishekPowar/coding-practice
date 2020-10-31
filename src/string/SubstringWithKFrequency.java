package string;

public class SubstringWithKFrequency {

    public static int getCount(String str, int k) {
        int answer = 0;

        int left = 0, right = 0;
        int[] freq = new int[26];

        while(right < str.length() && left <= right ) {
            freq[str.charAt(right) - 'a']++;

            if(contract(freq, k)) {
                freq[str.charAt(left)-'a']--;
                left++;
                right++;
            } else if(valid(freq, k) ){
                freq[str.charAt(left) - 'a']--;
                left++;
                right++;
                answer++;
            } else
                right++;
        }
        return answer;
    }

    public static int get(String str, int k) {
        int left = 0, right = 0, N = str.length(), answer = 0;
        int[] chars = new int[26];
        while(right < N) {
            if(contract(chars, k)) {
                chars[str.charAt(left)-'a']--;
                left++;
            } else if(valid(chars, k)) {
                answer++;
                right++;
            } else {
                right++;
            }
        }

        return answer;
    }

    private static boolean valid(int[] freq, int k) {
        for(int i=0; i<26; i++) {
            if(freq[i] !=0 && freq[i] != k)
                return false;
        }
        return true;
    }

    public static boolean contract(int[] chars, int k) {
        for(int i=0; i<26; i++) {
            if(chars[i] > k)
                return true;
        }
        return false;
    }

    private static boolean expand(int[] freq, int k) {
        for(int i=0; i<26; i++) {
            if(freq[i] != 0 && freq[i] < k)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(get("ababbaab",2));
    }
}


