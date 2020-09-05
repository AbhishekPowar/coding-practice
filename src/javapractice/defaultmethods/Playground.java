package javapractice.defaultmethods;

interface A {
    default void log() {
        System.out.println("Log from Interface A");
    }
}
interface B {
    default void log2() {
        System.out.println("Log from Interface B");
    }
}

class C implements A, B {
}

/**
 *
 */
public class Playground {
    public static void main(String[] args) {
        new C().log();
    }
}
