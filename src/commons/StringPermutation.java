package commons;

public class StringPermutation {
	public static void permutation(String str) {
//		permutation(str, "");
		printPermutation(str, "");
	}
	public static void permutation(String str,String prefix) {
		if(str.length() == 0) {
			System.out.println(prefix);
		}
		for(int i=0; i<str.length(); i++) {
			String r = str.substring(0,i) + str.substring(i+1);
			permutation(r, prefix + str.charAt(i));
		}
	}
	public static void main(String[] args) {
		String str= "abc";
		
		permutation(str);
	}
	
	
	public static void printPermutation(String str, String prefix) {
		if(str.length() == 0)
			System.out.println(prefix);
		
		for(int i=0; i<str.length(); i++) {
			String pre = str.substring(0, i) + str.substring(i+1);
			printPermutation( pre, prefix+  str.charAt(i));
		}
	}
}
