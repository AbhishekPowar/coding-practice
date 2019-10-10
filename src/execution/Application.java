package execution;

class Super {
    static int taxi = 123;
    static { System.out.println(taxi);}
}
class Sub extends Super {
    static { System.out.println("Sub ");}
}
public class Application {
    private static int counter = 1;
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(Sub.taxi);
    }
}
