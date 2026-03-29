//package com.rajan.codeforces.csesProblemSet.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class entry_4144214 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = reader.readLine().split("\\s+");
        int n = Integer.parseInt(temp[0]), m = Integer.parseInt(temp[1]);
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++)
            edges[i] = parseInt(reader.readLine(), 3);
        long[] cost = new long[n];
        Arrays.fill(cost, Long.MAX_VALUE / 2);
        cost[0] = 0L;


        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            for (int[] edge : edges) {
                int a = edge[0] - 1, b = edge[1] - 1, w = edge[2];
                if (cost[b] > cost[a] + w) {
                    cost[b] = cost[a] + w;
                    parent[b] = a;
                }
            }
        }

        boolean cycleExists = false;
        int cycleB = -1;
        for (int[] edge : edges) {
            int a = edge[0] - 1, b = edge[1] - 1, w = edge[2];
            if (cost[b] > cost[a] + w) {
                cycleExists = true;
                cycleB = b;
                break;
            }
        }

        if (!cycleExists) {
            writer.write("NO\n");
            writer.flush();
            return;
        }
        writer.write("YES\n");
        for (int i = 0; i < n; i++) {
            if (parent[cycleB] >= 0)
                cycleB = parent[cycleB];
        }
        List<Integer> cycle = new ArrayList<>();
        for (int i = cycleB; ; i = parent[i]) {
            cycle.add(i);
            if (i == cycleB && cycle.size() > 1)
                break;

        }
//            writer.write(cycle.size() + "\n");
        for (int i = cycle.size() - 1; i >= 0; i--) {
            writer.write(((i == cycle.size() - 1) ? "" : " ") + (cycle.get(i) + 1));
        }
        writer.write("\n");
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