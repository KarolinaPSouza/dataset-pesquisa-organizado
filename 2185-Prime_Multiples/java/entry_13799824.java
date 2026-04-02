import java.util.*;
public class entry_13799824 {

 public static void main(String[] args) {
  Scanner in = new Scanner(System.in);
  long N = in.nextLong();
  int K = in.nextInt();
  long[] a = new long[K];
  for (int i=0; i<K; i++) {
   a[i] = in.nextLong();
  }
  in.close();
  long ans=0;
  for (int i=1; i<(1<<K); i++) {
   long prod=1;
   for (int j=0; j<K; j++) {
    if ((i & (1<<j)) !=0) {
     if (prod > N/a[j]) {
      prod=N+1;
      break;
     }
     prod*=a[j];
    }
   } 
   if (Integer.bitCount(i)%2==1) {
    ans+=N / prod;
   } else {
    ans-=N / prod;
   }
  }
  System.out.println(ans);

 }

}