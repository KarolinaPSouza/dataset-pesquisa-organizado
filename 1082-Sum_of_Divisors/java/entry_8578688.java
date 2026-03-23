/******************************************************************************
                             Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.
 *******************************************************************************/
import java.util.Scanner;
import java.util.*; 

public class entry_8578688 {

    public static long help(long start,long end){
        long MOD=(long)1e9 + 7;
        long TWO_MOD_INV=500000004;
        return ((((end - start + 1) % MOD) * ((start + end) % MOD) % MOD) *
         TWO_MOD_INV % MOD);
    }

 public static void main(String[] args) {
      int maxVal=1000001;
  Scanner myObj=new Scanner(System.in);
     long n=myObj.nextLong();
      long mod=(long)1e9 + 7;


     long ans=0;
     long st=1;
     while(st<=n){
         long currTimes=n/st;
         long last=n/currTimes;
        // System.out.println(currTimes+" "+last);
         ans=(ans+(currTimes*help(st,last)))%mod;
         st=last+1;
     }
     System.out.println(ans);


 }
}