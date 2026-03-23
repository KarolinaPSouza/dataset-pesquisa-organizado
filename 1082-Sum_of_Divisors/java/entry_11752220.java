//  Sum of Divisors

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n=in.nextLong();
        long ans=0;
        long mod=1000000007;
        double f=Math.sqrt(n);
        long first=(long)f+1;
        for(long i=1;i*i<=n;i++)
        {
            long contri=n/i;
            ans+=contri*i;
            long last=n/i;
            long sum=(first+last);
            long mul=(last-first)+1;
            if(sum%2==0)
                sum/=2;
            else
                mul/=2;
            sum%=mod;
            mul%=mod;
            long aftersum=(sum*mul)%mod;
            ans+=aftersum;
            ans%=mod;
        }
        System.out.println(ans);
    }
}