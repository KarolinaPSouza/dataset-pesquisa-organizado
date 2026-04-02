import java.util.*;

public class entry_11094835 {
 public static void main(String[] args) {

  Scanner scr = new Scanner(System.in);
  long n = scr.nextLong();
  int t = scr.nextInt();
  long[] arr = new long[t];
  for(int i=0;i<t;i++) arr[i] = scr.nextLong();

  long ans = 0;

  for(int num = 1 ;num<(1<<t);num++) {

      long div =n;
      int c= 0;

      for(int i=0;i<t;i++) {
          if((num>>i)%2==1) {
              div/= arr[i];
              c++;
          }
      }

      if(c%2==1) ans+= div;
      else ans-= div;

  }

  System.out.println(ans);

 }
}