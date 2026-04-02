import java.io.*;
import java.util.*;

public class entry_3560269 {
 static int MOD = (int)1e9 + 7;
 static int[] memo;

 public static void main(String[] args) throws IOException {
  FastScanner kb = new FastScanner(System.in);
  PrintWriter out = new PrintWriter(System.out);

  int num_coins = kb.nextInt();
  int target = kb.nextInt();

  int[] coins = new int[num_coins];
  for (int i = 0; i < num_coins; i++)
   coins[i] = kb.nextInt();

  memo = new int[target+1];
  memo[0] = 1;

   for (int j = num_coins-1; j >= 0; j--) {
    for (int i = 1; i <= target; i++) {
    if (i - coins[j] < 0) continue;
    memo[i] = (memo[i] + memo[i-coins[j]]) % MOD;
//     System.out.printf("memo[%d] += memo[%d] = %d\n", i, i-coins[j], memo[i-coins[j]]);
//     System.out.println(Arrays.toString(memo));
   } 
  }
//   out.println(Arrays.toString(memo));
  out.println(memo[target]);

  out.close();
 }

 //@
 static class FastScanner {
     BufferedReader br;
     StringTokenizer st;

     public FastScanner(InputStream i) {
         br = new BufferedReader(new InputStreamReader(i));
         st = new StringTokenizer("");
     }

     public String next() throws IOException {
         if(st.hasMoreTokens())
             return st.nextToken();
         else
             st = new StringTokenizer(br.readLine());
         return next();
     }

     public int nextInt() throws IOException {
         return Integer.parseInt(next());
     }
     //#
     public long nextLong() throws IOException {
         return Long.parseLong(next());
     }
     public double nextDouble() throws IOException {
         return Double.parseDouble(next());
     }
     //$
 }
}