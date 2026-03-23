// package com.adityap.thecool;
import java.util.Scanner;
public class entry_2711114 {
    final static int MOD = (int)1e9+7;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long ans = 0;
        long stop = -1;
        // 65+...+128 = 128(129)/2-64(65)/2
        // (n/i)((n/i)+1)/2 - (n/(i+1))(n/(i+1)+1)/2
        for (long i = 1; i <= n; i++) {
            if (n/i-n/(i+1) == 0) {stop = n/i; break;}
            ans = (ans%MOD +
                    ((i%MOD) * ((((n/i)%MOD)*(((n/i)+1)%MOD)/2-((n/(i+1))%MOD)*((n/(i+1)+1)%MOD)/2)%MOD)))
                        %MOD;
            // System.out.println(ans+" "+i);
        }
        for (long i = 1; i <= stop; i++) {
            ans = (ans%MOD + ((i*((n/i)%MOD))%MOD))%MOD;
            // System.out.println(ans+" "+i);
        }
        System.out.println(ans%MOD);
    }
}