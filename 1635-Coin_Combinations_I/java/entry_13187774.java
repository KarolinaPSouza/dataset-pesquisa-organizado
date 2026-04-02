import java.util.Scanner;
import java.util.Arrays;
public class entry_13187774 {
 public static final int MOD = 1000000007;
 public static void main(String[] args){
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int x = sc.nextInt();
  int[] coins = new int[n];
  for(int i = 0; i<n; i++){
   coins[i] = sc.nextInt();
  }
  int[] dp = new int[x+1];
  Arrays.fill(dp, 0);
  dp[0] = 1;
  for(int i=1; i<=x ; i++){
   for(int j =0; j<n; j++){
    if(i - coins[j]>=0){
     dp[i] = (dp[i] + dp[i - coins[j]]) % MOD;
    }
   }
  }
  System.out.println(dp[x]);

 }
}