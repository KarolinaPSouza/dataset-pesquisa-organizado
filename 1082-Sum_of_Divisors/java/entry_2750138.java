import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class entry_2750138 {
    static int mod = (int)1e9 + 7;
    static long binPow = 500000004; //binpow(2, mod - 2);
    public static long binpow(long base, long exp){
        if(exp == 0)
            return 1;
        long res = binpow(base, exp/2);
        if(exp%2 == 1)
            return (((res * res)%mod) * base)%mod;
        return (res * res)%mod;
    }
    public static long calcSum(long a, long b){
        // System.out.println(binPow);
        long sumTillBeforeA = (((a%mod)*(++a%mod))%mod)*binPow;
        long sumTillB = (((b%mod)*(++b%mod))%mod)*binPow;

        sumTillBeforeA %= mod;
        sumTillB %= mod;

        return sumTillB - sumTillBeforeA + mod;
    }
 public static void main(String[] args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long sum = 0;
        long curr = 1;
        while(curr <= n){
            long count = n/curr;
            long next = n/count + 1;
            count %= mod;
            long currSegmentSum = calcSum(curr - 1, next - 1);
            currSegmentSum %= mod;
            sum += (count * currSegmentSum)%mod;
            sum %= mod;
            curr = next;
        }
  System.out.print(sum);
 }
}

