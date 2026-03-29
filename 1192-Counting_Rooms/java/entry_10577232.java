import java.util.*;
//used chatgpt to convert my python code to java for better runtimes
public class entry_10577232 {

    static int n, m;
    static char[][] grid;
    static boolean[][] visited;

    // Directions: up, down, left, right
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read grid dimensions
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();  // Consume the newline

        // Initialize the grid
        grid = new char[n][m];
        visited = new boolean[n][m];

        // Read the grid
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            grid[i] = line.toCharArray();
        }

        // Room counter
        int entry_10577232 = 0;

        // Traverse the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If we find an unvisited floor, it's a new room
                if (grid[i][j] == '.' && !visited[i][j]) {
                    bfs(i, j);  // Perform BFS to explore the entire room
                    entry_10577232++;  // Increment the room count
                }
            }
        }

        // Print the total number of rooms
        System.out.println(entry_10577232);
    }

    // BFS function to explore the entire room starting from (x, y)
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // Explore all 4 directions
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                // Check if the next cell is within bounds and is an unvisited floor
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
