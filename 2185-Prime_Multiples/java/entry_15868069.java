import java.util.*;
public class entry_15868069 {

 public static void main(String[] args){
  Scanner sc = new Scanner(System.in);
  long n = sc.nextLong(), ans = n;
  int k = sc.nextInt();
  long[] a = new long[k];
  for (int i=0; i<k; i++) a[i] = sc.nextLong();
  for (int i=0; i < 1<<k; i++) {
   long prod=1;
   boolean fit = true;
   for (int j=0; j<k; j++) {
    if ((i & (1<<j))==0);
    else if (prod > n / a[j]) fit = false;
    else prod *= a[j];
   }
   int sign=1;
   if (Integer.bitCount(i)%2==0) sign=-1;
   if (fit) ans += sign * n / prod;
  }
  System.out.print(ans);
 }

}