import java.util.*;


public class entry_10778849 {

 public static void main(String[] args) {
  Scanner scan =  new Scanner(System.in);

  int coinLen = scan.nextInt();
  int amount = scan.nextInt();

  int[] coins = new int[coinLen];
  int[] dp = new int[amount+1];

  dp[0] = 0;


  for(int i = 0; i < coinLen; i++) {
   coins[i] = scan.nextInt();
  }

  for(int j = 0; j < coinLen; j++) {
   for (int i = 1; i <= amount; i++) {
    if(i == coins[j]) {
     dp[i]+= 1;
     dp[i] = (dp[i]%1000000007);
     continue;
    }
    if(i-coins[j] < 0) {
     continue;
    }else if(i-coins[j] > 0) {
     dp[i] += dp[i-coins[j]];
     dp[i] = (dp[i]%1000000007);
    }
   }
  }
  System.out.print(dp[amount]);


 }

}