//package DP;
import java.io.*;

public class entry_10138246 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);

        int[] weight = new int[n];
        int[] val = new int[n];

        input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(input[i]);
        }

        input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(input[i]);
        }

        int[] prev = new int[x + 1];

        for (int i = 1; i <= n; i++) {
//            dp[i][j] = current[j];
//            dp[i - 1][j] = prev[j];
            int[] curr = new int[x + 1];
            for (int j = 0; j <= x; j++) {
                int w = weight[i - 1];
                int value = val[i - 1];

                int pick = (j >= w) ? prev[j - w] + value : 0;
                int skip = prev[j];

                curr[j] = Math.max(skip, pick);
            }
            prev = curr;
        }

        writer.println(prev[x]);
        writer.close();
        reader.close();
    }
}