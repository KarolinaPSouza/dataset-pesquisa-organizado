import java.util.Arrays;
import java.util.Scanner;

public class entry_14275833 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int x = sc.nextInt();
         int[] arr = new int[n];
         for(int i = 0; i < n; i++) {
             arr[i] = sc.nextInt();
         }
         int[] dp = new int[x+1];
         Arrays.fill(dp,(int)1e7);
         dp[0] = 0;
//         for(int i = 0; i < n; i++) {
//             dp[arr[i]] = 1 ;
//         }
         for(int i  = 1 ; i <= x ; i++){
             for(int j = 0 ; j < n ; j++){
                 if(i >= arr[j]) {
                     dp[i] = Math.min(dp[i], dp[i-arr[j]] + 1);
                 }
             }
//             System.out.println(Arrays.toString(dp));
         }
         if(dp[x] >= (int)1e7) {
             System.out.println("-1");
             return;
         }
         System.out.println(dp[x]);
    }
}