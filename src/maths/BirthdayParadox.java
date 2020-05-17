package maths;

public class BirthdayParadox {

    public double find(double probability) {
        return Math.ceil(Math.sqrt(2 * 365*Math.log(1/(1-probability))));
    }
    public static void main(String[] args) {
        System.out.println(new BirthdayParadox().find(0.50));
    }
}
