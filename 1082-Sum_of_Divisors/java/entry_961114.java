//package Quarantine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_961114 {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long n=Long.parseLong(br.readLine());
        long ans=0;
        int mod=1000000007;
        long modinv=modexp(2,mod-2,mod);
        for(long i=1;i*i<=n;i++){
            long j=n/i;
            long temp=(i*j)%mod;
            ans=(ans+temp)%mod;
            if(j!=i){
                long s=n/(i+1)+1;
                long e=n/i;
                if(s<=e){
                    long r=((e%mod)*((e+1)%mod))%mod;
                    r=(r*modinv)%mod;
                    s--;
                    long l=((s%mod)*((s+1)%mod))%mod;
                    l=(l*modinv)%mod;
                    temp=(r-l+mod)%mod;
                    temp=(temp*i)%mod;
                    ans=(ans+temp)%mod;
                }
            }
        }
        System.out.println(ans);
    }
    public static long modexp(long num,long pow,int mod){
        if(pow==0){
            return 1;
        }
        if(pow==1){
            return num%mod;
        }
        long small=modexp(num,pow/2,mod);
        long ans=(small*small)%mod;
        if(pow%2!=0){
            ans=(ans*num)%mod;
        }
        return ans;
    }
}