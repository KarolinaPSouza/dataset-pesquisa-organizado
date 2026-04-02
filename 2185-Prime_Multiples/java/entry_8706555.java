import java.util.*;

public class entry_8706555 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long k= sc.nextLong();
        long n = sc.nextLong();
        long primes[] = new long[(int)n+1];
        for (long i = 0; i < n; i++) {
            primes[(int)i] = sc.nextLong();
        }
        long a[]=new long[(int)n+1];
        for(long i=1;i<(1<<n);i++){
            long count=0;
           long temp=k;
            for(long j=0;j<n;j++){
              if(((1<<j)&i)!=0){  
                count++;
                temp/=primes[(int)j];
              }
            }
            a[(int)count]+=temp;
        }
        long result=0;
        for(long i=1;i<=n;i++){
            if(i%2==0)
                result-=a[(int)i];
            else 
               result+=a[(int)i];
        }
        System.out.println(result);
    }
}
