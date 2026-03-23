/******************************************************************************
 Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.
 *******************************************************************************/
import java.util.*;
import java.io.*;
public class entry_5654272 {
    static long MOD =(long) 1e9 + 7;
    static long TWO_MOD_INV = 500000004;
    static long sum(long start,long end)
    {
        return ((((end - start + 1) % MOD) * ((start + end) % MOD) % MOD) *
         TWO_MOD_INV % MOD);
    }
 public static void main(String[] args)throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
           String s[] = (sc.readLine()).split(" ");
           long n  = Long.parseLong(s[0]);
         //  long mod = 1000000007;
           long ans=0;
           for(long i=1;i<=n;)
           {

                long q = n/i;
                long lastSame = n/q;
                   ans=(ans+(sum(i,lastSame)*q))%MOD;
                i = lastSame+1;


           }
          System.out.println(ans);

 }
}