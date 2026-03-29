import java.util.*;
import java.io.*;

public class entry_11003186 {
    private static char[][] grid;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        int roomCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') {
                    optimized_bfs(i, j);
                    roomCount++;
                }
            }
        }

        out.println(roomCount);
        out.close();
    }

    private static int[] directions = {1, 0, 0, 1, -1, 0, 0, -1}; // all the four directions

    private static void optimized_bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        grid[i][j] = '#'; // mark it visited
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int p = 0; p < 8; p+=2) {
                if (valid(r + directions[p], c + directions[p + 1])) {
                    grid[r + directions[p]][c + directions[p + 1]] = '#';
                    queue.add(new int[] {r + directions[p], c + directions[p + 1]});
                }
            }
        }
    }

    private static void dfs(int r, int c) {
        grid[r][c] = '#';
        for (int p = 0; p < 8; p+=2) {
            if (valid(r + directions[p], c + directions[p + 1])) {
                dfs(r + directions[p], c + directions[p + 1]);
            }
        }
    }

    private static boolean valid(int r, int c) {
        int n = grid.length, m = grid[0].length;
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == '#') {
            return false;
        }
        return true;
    }
}