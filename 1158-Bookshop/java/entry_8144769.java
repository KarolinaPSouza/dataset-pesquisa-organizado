//package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class entry_8144769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());

        int[] h = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] s = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[n+1][x+1];

        for(int i=1;i<=n;i++){
            int currPrice = h[i-1];
            int currPages = s[i-1];
            for(int j=1;j<=x;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=currPrice){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-currPrice] + currPages);
                }
            }
        }

        System.out.println(dp[n][x]);
    }
}