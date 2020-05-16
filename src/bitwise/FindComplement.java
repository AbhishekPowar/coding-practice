package bitwise;

public class FindComplement {

    public int findComplement(int num) {
        int ans = 0;
        int pos = 0;
        while(num > 0) {
            if((num&1) == 0) {
                ans |= (1<<pos);
            }
            num >>>= 1;
            pos++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(new FindComplement().findComplement(4)));
        System.out.println(Integer.toBinaryString(new FindComplement().findComplement(3)));
        System.out.println(Integer.toBinaryString(new FindComplement().findComplement(5)));
        System.out.println(Integer.toBinaryString(new FindComplement().findComplement(2)));
        System.out.println(Integer.toBinaryString(new FindComplement().findComplement(1)));
        System.out.println(Long.toBinaryString(2147483647));
    }
}
