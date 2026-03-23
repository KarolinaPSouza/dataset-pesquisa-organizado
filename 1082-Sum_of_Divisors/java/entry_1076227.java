import java.util.Scanner;

public class entry_1076227 {
    public static void main(String[] args) {
        final long m_mod=1000000007;
        Scanner sc=new Scanner(System.in);
        long n =sc.nextLong();
        long s = 0;
        for (long i=1;i<=n/i;i++) {
            long q=n/i;
            s=(s+i*q)%m_mod;
            if (i!=q) {
                long p=n/(i + 1);
                p%=m_mod;
                q%=m_mod;
                long k=(q-p)*(q+p+1)/2%m_mod;
                s=(s+k*i)%m_mod;
            }
        }
        if (s<0){
            s+=m_mod;
        }
        System.out.println(s);
    }
}