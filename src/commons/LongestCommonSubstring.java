package commons;

public class LongestCommonSubstring {
	
	public static String lcs(String s1, String s2) {
		
		int memo[][] = new int[s1.length()+1][s2.length()+1];
		
		int max = 0;
		int row = 0;
		int col = 0;
		for(int i=1; i<s1.length();i++) {
			for(int j=1; j<s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					memo[i][j] = 1 + memo[i-1][j-1];
				} else {
					memo[i][j] = 0;
				}
				
				if(memo[i][j] > max) {
					row = i;
					col = j;
					max = memo[i][j];
				}
		
			}
		}	
		
		
		String resultStr = new String();
		while(memo[row][col]!=0) {
			resultStr = s1.charAt(row - 1) + resultStr;
			row--;
			col--;
		}
		
		return resultStr;
	}
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "oHellgllo";
		
	}
}
