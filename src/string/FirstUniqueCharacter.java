package string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Find first unique character in a string:
 * eg., for "aabcdcefggh" Answer will be b
 */
public class FirstUniqueCharacter {

    public Character find(String str) {

        LinkedHashMap<Character, Integer> freqCount = new LinkedHashMap<>();

        for(int i=0; i<str.length(); i++) {
            int count = 0;

            char currChar = str.charAt(i);
            if(freqCount.containsKey(currChar))  {
                count = freqCount.get(currChar);
            }

            freqCount.put(currChar, count+ 1);
        }

        Optional<Map.Entry<Character, Integer>> result = freqCount.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst();

        return result.isPresent() ? result.get().getKey(): null;
    }
    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacter().find("abcdbaef"));
    }
}
