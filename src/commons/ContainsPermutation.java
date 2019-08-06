//package commons;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ContainsPermutation {
//
//	public static boolean containsPermutation(String str1, String str2) {
//
//		Map<Character, Integer> countMap = new HashMap<Character, Integer>();
//		Map<Character, Integer> matchMap = new HashMap<Character, Integer>();
//
//		for(int i=0; i<str1.length(); i++) {
//			int count=1;
//			if(countMap.containsKey(str1.charAt(i)))
//				count = countMap.get(str1.charAt(i))+1;
//			int match = 1;
//
//			if(matchMap.containsKey(str1.charAt(i)))
//				match = matchMap.get(str1.charAt(i))+1;
//			matchMap.put(str1.charAt(i), count);
//		}
//
//		int currPos = 0;
//
////		for(int i=0; i)
//		while(currPos < str2.length()- str1.length()) {
//
////			if(isPermutation(countMap, matchMap))
//				return true;
//
////			currPos += 1;
//
//			if(matchMap.containsKey(str2.charAt(currPos))) {
//				int count = matchMap.get(str2.charAt(currPos));
//				matchMap.put(str2.charAt(currPos), count+1);
//			} else {
//				matchMap.put(str2.charAt(currPos), 1);
//			}
//
//
//		}
//		return false;
//	}
//
//	public static void main(String[] args) {
//		String str1 = "ab";
//		String str2 = "eldbaoo";
//
//		System.out.println(containsPermutation(str1, str2));
//	}
//}
