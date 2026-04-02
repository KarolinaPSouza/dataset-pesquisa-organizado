import java.util.Arrays;
import java.util.Scanner;

public class entry_3706629 {

    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int x = sc.nextInt();

            int[] coins = new int[n];
            for (int i = 0 ; i<n  ; i++){
                coins[i] = sc.nextInt();
            }

            int[] dp = new int[x+1];
            Arrays.fill(dp, -1);
            dp[0] = 0;

            for (int i = 1 ; i<=x ; i++){
                int temp = Integer.MAX_VALUE;
                for (int j = 0 ; j<n ; j++){
                    if (i-coins[j] >=0 && dp[i-coins[j]]>=0){
                        temp = Math.min(dp[i-coins[j]]+1 , temp);
                    }
                }
                if (temp == Integer.MAX_VALUE){
                    dp[i] = -1;
                }else {
                    dp[i] = temp;
                }

//            for (int p : dp){
//                System.out.print(p+" ");
//            }
//            System.out.println();
            }

//        for (int p : dp){
//            System.out.print(p+" ");
//        }
//        System.out.println();
        if (dp[x] == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
            System.out.println(dp[x]);
    }




}