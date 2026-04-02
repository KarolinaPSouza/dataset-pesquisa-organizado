import java.util.*;
public class entry_15752062 {  
       public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int x = sc.nextInt();

          int[] coins = new int[n];
          for(int i = 0; i < n; i ++){
            coins[i] = sc.nextInt();
          }

          int[] dp = new int[x + 1];
          int INF = (int)1e9;

          Arrays.fill(dp,INF);
          dp[0] = 0;

          for(int i = 1; i <= x; i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i],dp[i - coin]+ 1); 
                }
            }

          }
          if (dp[x] == INF)
            System.out.println(-1);
          else
            System.out.println(dp[x]);
       }
}


