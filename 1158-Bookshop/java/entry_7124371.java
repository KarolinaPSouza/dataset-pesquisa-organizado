//package CSESProblemSet.DynamicProgramming;

import java.io.*;
import java.util.*;

public class entry_7124371 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer line1 = new StringTokenizer(br.readLine());

        StringTokenizer line2 = new StringTokenizer(br.readLine());

        StringTokenizer line3 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(line1.nextToken());
        int x = Integer.parseInt(line1.nextToken()); //
        int pages[] = new int[n];
        int cost[] = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(line2.nextToken());
            pages[i] = Integer.parseInt(line3.nextToken());
        }

        System.out.println(bookShop(cost, pages, x));
    }

    public static int bookShop(int cost[], int pages[], int x) {

        int n = cost.length;
        int dp[][] = new int[n + 1][x + 1];


        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= x; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < x + 1; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= cost[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cost[i - 1]] + pages[i - 1]);
                }

            }
        }

        return dp[n][x];

    }

}