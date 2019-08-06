package commons;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicString {
	public String longestPalindrome(String s) {
        
        if(s.length() <= 0)
            return "";
          
        return getLongestPalindrome(s, new HashMap<String, String>());
        
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
