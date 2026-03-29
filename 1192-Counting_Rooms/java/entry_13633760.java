import java.util.*;

public class entry_13633760 {

    static boolean[][] visited;
    static char[][] grid;
    static int[] dr = {-1, 1, 0, 0}; // up, down, left, right
    static int[] dc = {0, 0, -1, 1}; 

    public static int countingRooms() {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isValid(i, j)) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];

            for (int d = 0; d < 4; d++) {
                int nr = row + dr[d];
                int nc = col + dc[d];
                if (isValid(nr, nc)) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    public static boolean isValid(int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length 
               && !visited[i][j] && grid[i][j] == '.';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // rows
        int n = sc.nextInt(); // cols
        sc.nextLine(); // consume newline

        grid = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        System.out.println(countingRooms());
    }
}