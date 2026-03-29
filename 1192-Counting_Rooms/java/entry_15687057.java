//package com.apps.playground.CSES.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_15687057 {
    private static int m, n;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        char[][] grid = new char[m][n];
        for(int i=0; i<m; i++) {
            String line = br.readLine();
            for(int j=0; j<n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '.') {
                    bfs(grid, i, j);
                    count ++;
                }
            }
        }
        System.out.println(count);;
    }

    private static void bfs(char[][] grid, int X, int Y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{X, Y});
        grid[X][Y] = '#';

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            for(int i=0; i<4; i++) {
                int xx = x+dx[i];
                int yy = y+dy[i];

                if(xx >=0 && xx< m && yy>=0 && yy <n && grid[xx][yy] == '.') {
                    grid[xx][yy] = '#';
                    q.offer(new int[]{xx, yy});
                }
            }
        }
    }
}