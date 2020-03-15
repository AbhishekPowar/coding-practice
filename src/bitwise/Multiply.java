package bitwise;

public class Multiply {

   public static long invoke(long x, long y) {
      long anw = 0;
      while(x != 0) {
         if((x & 1) != 0){
            anw = add(anw, y);
         }
         x >>>= 1;
         y <<= 1;
      }

      return anw;
   }

   private static long add(long x, long y) {
      long carry = 0;
      long sum = 0;

      long tx = x;
      long ty = y;
      long k = 1;
      while(tx !=0 || ty != 0) {
         long xk = x & k;
         long yk = y & k;

         long carryOut = (xk & yk) | (xk & carry) | (yk & carry);

         sum |= (xk ^ yk ^ carry);

         carry = carryOut << 1;
         k <<= 1;
         tx >>>= 1;
         ty >>>= 1;
      }
      return sum | carry;
   }

   public static void main(String[] args) {
      int x = 4;
      int y = 7;

      System.out.println(invoke(x, y));
   }
}
