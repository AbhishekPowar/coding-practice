package commons;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicString {
    private int maxLen, location;

	public String longestPalindrome(String s) {
        
        if(s == null || s.length() < 2)
            return s;

        for(int i=0; i<s.length()-1; i++) {
            extendSearch(s, i, i); // for odd length
            extendSearch(s, i, i+1); // for even length
        }
        return s.substring(location, location+maxLen);
    }

    private void extendSearch(String str, int i, int j) {
	    while (i >=0  && j<=str.length()-1 && str.charAt(i) == str.charAt(j)) {
	        i--;
	        j++;
        }

	    if(j - i  -1 > maxLen) {
	        maxLen = j - i - 1;
	        location = i+1;
        }
    }
	public static String getLongestPalindrome(String s, Map<String, String> memo) {

		 if(!memo.containsKey(s)) {
             if(isPalindrome(s)) {
                 memo.put(s, s);
                 return s;
             } else {
                
            	 String p1 = getLongestPalindrome(s.substring(1), memo);
            	 String p2 = getLongestPalindrome(s.substring(0, s.length()-1), memo);
            	 
            	 memo.put(s.substring(1), p1);
            	 memo.put(s.substring(0, s.length()-1), p2);
            	 return p1.length() > p2.length() ? p1: p2;
             }       
		 } else {
			 return memo.get(s);
		 }
	}
	public static boolean isPalindrome(String s) {
        
        int start = 0;
        int end = s.length() -1;
        
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
		
    	String s= "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
    	
    	LongestPalindromicString l = new LongestPalindromicString();
    	
    	System.out.println(l.longestPalindrome(s));
	}
}
