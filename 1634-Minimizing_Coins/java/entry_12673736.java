import java.util.*;
public class entry_12673736 {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int sum = sc.nextInt();
  int[] coins = new int[n];
  for(int i =0; i<n; i++) {
   coins[i] = sc.nextInt();
  }
  Arrays.sort(coins);
  int[] dp = new int[sum+1];
  Arrays.fill(dp, Integer.MAX_VALUE);
  dp[0] = 0;
  for(int i = 1; i<=sum; i++) {
   for(int j = 0; j<n; j++) {
    if(coins[j]>i)break;
    if(dp[i-coins[j]]!=Integer.MAX_VALUE)dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
   }
  }
  System.out.println(dp[sum]==Integer.MAX_VALUE?-1:dp[sum]);
 }

}