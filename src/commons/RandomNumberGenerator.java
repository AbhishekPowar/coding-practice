package commons;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RandomNumberGenerator {
    public static void main(String[] args) {

        Map<Integer, Integer> m = new HashMap<>();

        m.getOrDefault(2, 0);


        System.out.println(countLargestGroup(13));
    }

    public static int countLargestGroup(int n) {
        // 1 ->  power of 10
        // 2 -> 2, 11, 20, 101, 200, 2000
        // 3 -> 3, 12, 21, 30, 102, 120, 201, 300, 1011, 1101, 1110,

        Map<Long, Integer> count= new HashMap<>();

        int answer = 0;

        for(int i=1; i<=n; i++) {
            long digitSum = sum(i);
            int c = count.getOrDefault(digitSum, 0);
            count.put(digitSum, c+1);

            answer = Math.max(answer, c+1);
        }

        final int finalAnswer = answer;
//        count.entrySet().stream().filter((k, v) -> v != finalAnswer).map((k, v)-> 1).count();
        return answer;
    }

    private static long sum(int n) {
        int sum = 0;
        while(n != 0) {
            sum += n % 10;
            n /=10;
        }
        return sum;
    }
}
