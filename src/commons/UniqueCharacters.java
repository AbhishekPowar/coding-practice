package commons;

public class UniqueCharacters {
	
	public static boolean allUniqueChars(String str) {
		int flag = 0;
		
		for(int i=0; i<str.length(); i++) {
			int charPos = str.charAt(i);
						
			if((flag & (1 << charPos)) > 0) {
				return false;
			} else {
				flag = (flag | 1 << charPos);
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		
		String a = "abcdea";
		System.out.println(allUniqueChars(a));
	}
}
