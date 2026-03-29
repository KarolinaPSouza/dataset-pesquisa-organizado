import java.util.*;
import java.io.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.math.BigInteger; 
import java.util.Comparator;
public class entry_9271274 {
    static FastReader sc = new FastReader();
   static final int MOD = 1000000007;
    public static void main(String args[]) {

        // int test = sc.nextInt();
        // while(test-- > 0){

            int n = sc.nextInt();
            int x = sc.nextInt();
            int [] price = new int[n];
            int []pages = new int[n];


            for(int i = 0; i<n; i++){
              price[i] = sc.nextInt();
            }

            for(int i = 0; i<n; i++){
              pages[i] = sc.nextInt();
            }
            // int [][]dp = new int[n+1][x+1];
            // for(int []s : dp){
            //   Arrays.fill(s,-1);
            // }
            int ans = countWays2(n,x,price,pages);
            System.out.println(ans);


      //  }

    }

  //  public static int func(int n, char [][] arr){
  //       int [][]dp = new int[n][n];
  //       if(arr[0][0] == '*'){
  //         return 0;
  //       }

  //       boolean flag1 = true, flag2 = true;
  //       for(int i = 0; i<n; i++){
  //         if(flag1 && arr[i][0] != '*'){
  //           dp[i][0] = 1;
  //         }
  //         else{
  //           dp[i][0] = 0;
  //           flag1 = false;
  //         }

  //         if(flag2 && arr[0][i] != '*'){
  //           dp[0][i] = 1;
  //         }
  //         else{
  //           dp[0][i] = 0;
  //           flag2 = false;
  //         }
  //       }

  //       for(int i = 1; i<n; i++){
  //         for(int j = 1; j<n; j++){
  //           if(arr[i][j] == '*'){
  //             dp[i][j] = 0;
  //           }
  //           else{
  //             dp[i][j] = (dp[i-1][j]%MOD + dp[i][j-1]%MOD)%MOD;
  //           }
  //         }
  //       }
  //        return dp[n-1][n-1];


  //  }



    public static int func(int idx, int amount,int [] pages,int []price, int [][] dp){

      if(amount == 0) return 0;

      if(idx == pages.length) return 0;

      if(dp[idx][amount] != -1){
        return dp[idx][amount];
      }

      int ans = 0;

      // pick
      int pick = 0; 
      if(amount >= price[idx]){
        pick = func(idx+1,amount - price[idx],pages,price,dp) + pages[idx];
      }

      int nopick = func(idx+1,amount,pages,price,dp);

      return dp[idx][amount] = Math.max(pick,nopick);

    }

  public static int countWays2( int n, int amount, int []price, int []pages){

      //int [][]dp = new int[target+1][n+1];
      int []prev = new int[amount+1];

      for(int idx = n-1; idx >=0; idx--){
        int []dp = new int[amount+1];
          for(int am = 1; am <= amount; am++){ 
            // pick
            int pick = 0; 
            if(am >= price[idx]){
              pick = prev[am-price[idx]] + pages[idx];
            }

            int nopick = prev[am];

            dp[am] = Math.max(pick,nopick);
        }
        prev = dp;
      }
      return prev[amount];
    }

  // public static boolean check(long []arr, long steps, long maxSum,long []prefix){
  //     long n  =arr.length;
  //     //System.out.println(k +" "+ maxSum);
  //     long small = arr[0];
  //     if(steps > n-1){
  //          small = arr[0] - (steps - (n-1));
  //         long currSum = small*n;
  //         if(currSum <= maxSum) return true;
  //         steps = n-1;
  //     }
  //      for(long i = 0; i<= steps; i++){
  //           long smallest = small - i;
  //           long csum = smallest*(steps+1-i) + prefix[(int)(n-(steps+1-i) + 1)] - prefix[1];
  //           if(csum <= maxSum) return true;
  //     }

  //     return false;

  // }

  //  static long gcd(long a, long b)
  //   {
  //     if (b == 0)
  //       return a;
  //     return gcd(b, a % b); 
  //   }

  //   public static class Pair{
  //       int ele;
  //       int i;
  //       public Pair(int s, int c){
  //           ele = s;
  //           i = c;
  //       }
  //   }

    static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 

        public FastReader() 
        { 
            br = new BufferedReader( 
                new InputStreamReader(System.in)); 
        } 

        String next() 
        { 
            while (st == null || !st.hasMoreElements()) { 
                try { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 

        int nextInt() { return Integer.parseInt(next()); } 

        long nextLong() { return Long.parseLong(next()); } 

        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 

        String nextLine() 
        { 
            String str = ""; 
            try { 
                if(st.hasMoreTokens()){ 
                    str = st.nextToken("\n"); 
                } 
                else{ 
                    str = br.readLine(); 
                } 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
}