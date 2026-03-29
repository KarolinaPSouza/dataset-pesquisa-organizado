// package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class entry_12743969 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for fast input
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // number of books
        int x = Integer.parseInt(st.nextToken()); // maxi total price

        int[] price = new int[n];
        int[] pages = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken()); // prices
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pages[i] = Integer.parseInt(st.nextToken()); // pages
        }

        int[] dp = new int[x + 1]; // dp[i] = max pages we can get with total price i

        for (int i = 0; i < n; i++) {
            // Traverse backwards to ensure each book is picked at most once
            for (int j = x; j >= price[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - price[i]] + pages[i]);
            }
        }

        System.out.println(dp[x]); // Print maximum pages
    }
}