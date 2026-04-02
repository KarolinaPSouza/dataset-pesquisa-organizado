import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.math.BigDecimal;
import java.util.*;
public class entry_3260512 {
   static class Algebra {
      public static int GCD(int a, int b) {
         return b==0?a:GCD(b,a%b);
      }
   }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
           br = new BufferedReader(new InputStreamReader(System.in));
        }
        int[] nextintArr(int n, FastReader fs) {
           int[] arr = new int[n];
           for(int i=0;i<n;i++) {
              arr[i] = fs.nextInt();
           }
           return arr;
        }
        String next() {
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
        int nextInt() {
           return Integer.parseInt(next());
        }
        long nextLong() {
           return Long.parseLong(next());
        }
        double nextDouble() {
           return Double.parseDouble(next());
        }
        String nextLine() {
           String str = "";
           try {
              str = br.readLine();
           }
           catch (IOException e) {
              e.printStackTrace();
           }
           return str;
        }
     }
     static void ln(String s){
        System.out.println(s);   
     }

     static int abs(int a,int b){
      if(b>a) return b-a;
      return a-b;
  }

  public static char nextChar(char curr) {
     if(curr == 'z') return 'a';
     else return (char)((int)curr+1);
  }

  public static int factorial(int i) {
     int res = 1;
     while(i>0) res*=i--;
     return res;
  }
  public static void main(String[] args) {
   FastReader fs = new FastReader();
   String s = fs.nextLine();
   String s2 = fs.nextLine();
   int n = s.length();
   int m = s2.length();
   int[][] dp = new int[m+1][n+1];
   for(int i=0;i<=m;i++) for(int j=0; j<=n;j++) {
       if(i==0) dp[i][j] = j;
       else if(j==0) dp[i][j] = i;
       else if(s2.charAt(i-1) == s.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
       else dp[i][j] = 1+Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
   }
   // Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
   // int temp = solve(m, n, s2, s);
   System.out.println(dp[m][n]);
}
}