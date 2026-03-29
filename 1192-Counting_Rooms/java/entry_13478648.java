import java.util.*;

public class entry_13478648 {
    static int n, m;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }
        int rooms = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '.') {
                    dfs(i, j);
                    rooms++;
                }
            }
        }
        System.out.println(rooms);
    }

    static void dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && grid[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
    }
}