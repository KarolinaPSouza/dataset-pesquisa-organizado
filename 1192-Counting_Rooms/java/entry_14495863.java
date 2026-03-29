import java.util.*;

public class entry_14495863 {
    private static void dfs(char[][] grid, boolean[][] visited, int startX, int startY, int n, int m) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && 
                    grid[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            // String line = sc.nextLine().trim();
            // grid[i] = line.toCharArray();
            grid[i] = sc.next().toCharArray();
        }

        boolean[][] visited = new boolean[n][m];
        int roomCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && !visited[i][j]) {
                    dfs(grid, visited, i, j, n, m);
                    roomCount++;
                }
            }
        }

        System.out.println(roomCount);
        sc.close();
    }
}