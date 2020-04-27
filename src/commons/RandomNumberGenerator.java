package commons;

import java.util.Random;

public class RandomNumberGenerator {

    public static void main(String[] args) {
        for (int i=0; i < 20; i++)
            System.out.println(uniformRandom(1,6));
    }

    public static int uniformRandom(int lowerBound, int upperBound) {
        int numberOfOccurrence = upperBound - lowerBound + 1, result;
        do {
            result = 0;
            for(int i=0; (1 << i) < numberOfOccurrence; ++i) {
                result = (result << 1) | zeroOneRandom();
            }
        } while (result >= numberOfOccurrence);
        return result + lowerBound;
    }

    public static int zeroOneRandom() {
        return new Random().nextInt(2);
    }
}
