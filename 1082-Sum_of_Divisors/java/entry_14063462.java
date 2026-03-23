import java.util.*;
public class entry_14063462 {
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  long n=sc.nextLong();
  long ans=0;
  long m=1000000007;
  for (long i=1; i<=n/i; i++) {
   long l=(n/(i+1))+1;
   long r=n/i;
   long terms=(r-l+1)%m;
   long add=(r+l)%m;
   long sum=((terms*add)%m*(i%m))%m;
   sum=(sum*500000004)%m;
   ans=((ans%m)+sum)%m;
   if (n/i!=i) {
    long x=n/i;
    l=(n/(x+1))+1;
    r=n/x;
    terms=(r-l+1)%m;
    add=(r+l)%m;
    sum=((terms*add)%m*(x%m))%m;
    sum=(sum*500000004)%m;
    ans=((ans%m)+sum)%m;
   }
  }
  System.out.println(ans);
 }
}