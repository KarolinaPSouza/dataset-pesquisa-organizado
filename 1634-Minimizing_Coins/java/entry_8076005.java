/*
            ##
           ####
          ##  ##
         ##    ##
        ##########
        ##########
        ##      ##
        ##      ##
*/



import java.io.*;
import java.util.*;

public class entry_8076005 {

 public static long lcm(long a, long b) 
    { 
        if(a==0) {return 0;}
        if(b==0) {return 0;}
        return (a*b)/gcd(a, b);
    } 
    static long gcd(long a, long b)
    {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        if (a == 0) {
            return b;
        }
        return a;
    }
    public static int lcm(int a, int b) 
    { 
        if(a==0) {return 0;}
        if(b==0) {return 0;}
        return (a*b)/gcd(a, b);
    } 
    static int gcd(int a, int b)
    {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        if (a == 0) {
            return b;
        }
        return a;
    }

    public static int helper(int i, int[] c, int x, int[] dp){
     if(x==0){
      return 0;
     }
     if(i==0){
      if(x%c[i]==0){
       return x/c[i];
      }
      return (int)Math.pow(10, 9);
     }

     if(dp[x]!=-1){
      return dp[x];
     }
     int take = Integer.MAX_VALUE;
     if(c[i]<=x){
      take = 1 + helper(i, c, x-c[i], dp);
     }

     int nt = helper(i-1, c, x, dp);

     return dp[x] = Math.min(take, nt);
    }

 public static void main(String[] args) {
  try {
   System.setIn(new FileInputStream("input.txt"));
   System.setOut(new PrintStream(new FileOutputStream("output.txt")));
  } catch (Exception e) {
   System.err.println("Error");
  }
  Scanner sc = new Scanner(System.in);
  int n =sc.nextInt();
  int x = sc.nextInt();

  int[] c = new int[n];
  for(int i=0; i<n ;i++){
   c[i] = sc.nextInt();
  }

  int[] dp = new int[x+1];
  Arrays.fill(dp, (int)Math.pow(10, 9));

  dp[0] = 0;
  for (int i = 1; i <= n; i++) {
   for (int weight = 0; weight <= x; weight++) {
    if (weight - c[i - 1] >= 0) {
     dp[weight] = Math.min(dp[weight], dp[weight - c[i - 1]] + 1);
    }
   }
  }



  if(dp[x]>=Math.pow(10, 9)){
   System.out.println(-1);
  } else{
   System.out.println(dp[x]);
  }

  sc.close();

 }
}