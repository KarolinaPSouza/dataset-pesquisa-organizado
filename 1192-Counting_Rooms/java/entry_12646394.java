import java.util.*;

public class entry_12646394 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        boolean[][] visited = new boolean[n][m];
        int roomCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && !visited[i][j]) {
                    bfs(grid, visited, i, j, n, m);
                    roomCount++;
                }
            }
        }

        System.out.println(roomCount);
    }

    private static void bfs(char[][] grid, boolean[][] visited, int i, int j, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}