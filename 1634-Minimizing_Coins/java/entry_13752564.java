import java.util.*;

public class entry_13752564 {
 static final int MAX=(int)1e6+2;
 public static void main(String[] args) {
  Scanner in = new Scanner(System.in);
  int N = in.nextInt();
  int sum = in.nextInt();
  int[] coins = new int[N];
  for (int i=0; i<N; i++) {
   coins[i]=in.nextInt();
  }
  in.close();

  int[] dp = new int[sum+1];
  for (int i=0; i<=sum; i++) {dp[i]=MAX;}
  dp[0]=0;

  for (int val : coins) {
   for (int i=val; i<=sum; i++) {
    dp[i] = Math.min(dp[i], dp[i-val]+1);
   }
  }

  if (dp[sum]==MAX) {
   System.out.println(-1);
  } else {
   System.out.println(dp[sum]);
  }


 }

}