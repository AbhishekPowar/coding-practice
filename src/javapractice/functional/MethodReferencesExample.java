package javapractice.functional;

import java.io.File;
import java.util.Arrays;

public class MethodReferencesExample {

    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

        System.out.println(Arrays.toString(hiddenFiles));
    }
}
