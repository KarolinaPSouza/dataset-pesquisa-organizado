//package com.CSES.Graphs;

import java.util.*;
import java.io.*;

public class entry_9509041 {

    private static char[][] g;
    public static void main(String[] args) throws IOException {
        // Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        g = new char[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                g[i][j] = row.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '.') {
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static int[] d = {1, 0, 0, 1, -1, 0, 0, -1};

    private static void bfs(int rs, int cs) {
        Queue<int[]> queue = new LinkedList();
        g[rs][cs] = '#';
        queue.add(new int[]{rs, cs});
        while (queue.size() > 0) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int i = 0; i < 8; i += 2) {
                if (valid(r + d[i], c + d[i + 1])) {
                    g[r + d[i]][c + d[i + 1]] = '#';
                    queue.add(new int[]{r + d[i], c + d[i + 1]});
                }
            }
        }
    }

    private static void dfs(int r, int c) {
        g[r][c] = '#';
        for (int i = 0; i < 8; i += 2) {
            if (valid(r + d[i], c + d[i + 1])) {
                dfs(r + d[i], c + d[i + 1]);
            }
        }
    }

    private static boolean valid(int r, int c) {
        int n = g.length, m = g[0].length;
        if (r < 0 || c < 0 || r >= n || c >= m || g[r][c] == '#') {
            return false;
        }
        return true;
    }

}