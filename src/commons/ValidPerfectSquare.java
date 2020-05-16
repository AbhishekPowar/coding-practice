package commons;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {

        int last_digit = num%10;
        int second_last_digit = (num%100)/10;

        if(last_digit%4 ==0  && last_digit%8 !=0)
            return false;
        if(last_digit%5 ==0 && second_last_digit!=2)
            return false;
        int[] last_digit_check = new int[]{2,3,7,8};
        int[] digital_root_check = new int[]{0,1,4,7};
        for(int i=0; i<last_digit_check.length;i++)
            if(last_digit_check[i] == last_digit)
                return false;
        int digital_root = num;
        while(digital_root > 10) {
            int sum = 0;
            while(digital_root > 0) {
                sum += digital_root%10;
                digital_root /= 10;
            }
            digital_root = sum;
        }
        for(int i=0; i<digital_root_check.length; i++)
            if(digital_root == digital_root_check[i])
                return true;

        return false;
    }

    public static void main(String[] args) {
        new ValidPerfectSquare().isPerfectSquare(76);
    }
}
