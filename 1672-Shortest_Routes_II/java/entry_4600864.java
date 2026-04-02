//package com.rajan.codeforces.csesProblemSet.graph;

import java.io.*;

public class entry_4600864 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = parseInt(reader.readLine(), 3);
        int n = input[0], m = input[1], q = input[2];
        long[][] distance = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                distance[i][j] = (i == j) ? 0 : Long.MAX_VALUE / 2L;


        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i] = parseInt(reader.readLine(), 3);
            int a = edges[i][0], b = edges[i][1], w = edges[i][2];
            distance[a][b] = Math.min(distance[a][b], w);
            distance[b][a] = Math.min(distance[b][a], w);
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < q; i++) {
            int[] query = parseInt(reader.readLine(), 2);
            int a = query[0], b = query[1];
            writer.write(((distance[a][b] < 0 || distance[a][b] >= Long.MAX_VALUE / 2L) ? -1 : distance[a][b]) + "\n");
        }
        writer.flush();
    }

    private static int[] parseInt(String str, int n) {
        int[] ans = new int[n];
        int idx = 0;
        for (int k = 0; k < str.length(); ) {
            int j = k;
            int sum = 0;
            while (j < str.length() && str.charAt(j) != ' ') {
                if (str.charAt(j) == '-') {
                    j++;
                    continue;
                }
                sum = sum * 10 + str.charAt(j) - '0';
                j++;
            }
            ans[idx++] = (str.charAt(k) == '-' ? -1 : 1) * sum;
            k = j + 1;
        }
        return ans;
    }
}