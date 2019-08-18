package commons;

public class CheckValidEdits {
	public static boolean isValidEdits(String a, String b) {
		
		int editCount = 0;
		
		int i = 0, j = 0;
		boolean lastMatch = false;
		
		do  {
			if(editCount > 1)
				return false;
			
			if(editCount == 0 && (j == b.length() && a.length() == b.length()+1) || (i==a.length() && a.length()+1 == b.length()) || i == j) {
				i++; j++;
				editCount += 1;
			} else if(a.charAt(i) == b.charAt(j)) {
				i++; j++;
				lastMatch = true;
			} else if(lastMatch == true) {
				i++; 
				editCount += 1;
			}else {
				i++;
				j++;
				editCount += 1;
			}
		} while(i < a.length() || j < b.length() );

		return true;
	}
	public static void main(String[] args) {
		
		String a = "pale";
		String b = "ple";
		
		System.out.println(isValidEdits(a, b));
	}
}
