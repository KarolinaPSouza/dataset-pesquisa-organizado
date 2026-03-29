//package cses;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_3274636 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][x+1];
        int[] price = new int[n];
        int[] weight = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            price[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            weight[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(dp[0],0);
        for (int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=x;j++){
                dp[i][j] = dp[i-1][j];
                if(j >= price[i-1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-price[i-1]]+weight[i-1]);
                }
            }
        }
        System.out.println(dp[n][x]);
    }
}