package commons;

import java.util.HashMap;
import java.util.Map;

public class DBS {
	
	static void fix(String s) {
		s = s+"a";
	}
	public static void main(String[] args) {
		
		String s1 = "Hello";
		String s2 = new String(s1);
		String s3 = "HELLO";
		
		System.out.println(20+1.34f+"A"+"B");
		
		Map<String, String> a = new HashMap<>();
		
		a.put("a", "a");
		for(Map.Entry<String, String> entry: a.entrySet()) {
//			a.get(entry.getKey()).
		}
		
		System.out.println(a);
	}
}
