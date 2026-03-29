import java.util.*;
public class entry_12587820 {
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '.' && !visited[i][j]) {
                    bfs(grid, visited, i, j, m, n);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void bfs(char[][] grid, boolean[][] visited, int x, int y, int m, int n) {
        Queue<int[]> q1 = new LinkedList<>();
        q1.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q1.isEmpty()) {
            int[] curr = q1.poll();
            int i = curr[0];
            int j = curr[1];

            for (int k = 0; k < 4; k++) {
                int newRow = i + dirX[k];
                int newCol = j + dirY[k];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    grid[newRow][newCol] == '.' && !visited[newRow][newCol]) {

                    q1.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }
}