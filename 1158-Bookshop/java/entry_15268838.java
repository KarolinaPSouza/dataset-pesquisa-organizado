import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.util.*;


public class entry_15268838 {
    static final long MOD = 1_000_000_007L;


    private static int f(int n, int x, int price[], int pages[]) {
       int dp[] = new int[x+1];
       Arrays.fill(dp,-1);
       dp[0] = 0;
        for(int i =0;i<n;i++) {
            for(int j = x;j>=price[i];j--){
                if(dp[j - price[i]] != -1){
                    dp[j] = Math.max(dp[j], dp[j-price[i]] + pages[i]);
                }
            }
        }

        int best  =0;
        for(int i = 0;i<=x;i++){
            if(dp[i]>best) best = dp[i];
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int prices[] = new int[n];
        int pages[] = new int[n];
        for(int i =0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        for(int i = 0;i<n;i++){
            pages[i] = sc.nextInt();
        }

        System.out.println(f(n,x,prices,pages));
    }


}