import java.io.*;
import java.util.*;

public class entry_3770659 {

 public static void main(String[] args) throws IOException {

  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
  StringTokenizer st = new StringTokenizer(br.readLine());

  int n = Integer.parseInt(st.nextToken());
  int x = Integer.parseInt(st.nextToken());

  int[] coins = new int[n];

  st = new StringTokenizer(br.readLine());

  for(int i = 0; i < n; i++)
   coins[i] = Integer.parseInt(st.nextToken());

  int[] dp = new int[x+1];

  Arrays.fill(dp, -1);  
  dp[0] = 0;

  for(int i = 0; i < x; i++) {

   if(dp[i] == -1)
    continue;

   for(int j = 0; j < n; j++) {

    if(coins[j] + i <= x)
     dp[i + coins[j]] = Math.min(dp[i + coins[j]] == -1 ? Integer.MAX_VALUE : dp[i + coins[j]], dp[i] + 1);

   }

  }

  pw.println(dp[x]);
  pw.close();

 }

}