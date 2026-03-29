import java.util.*;

public class entry_10577548 {

    private static final char F = '.';
    private static final char W = '#';
    private static final int[] dR = {-1, 0, 1, 0}; // Up, Right, Down, Left
    private static final int[] dC = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Rows
        int m = sc.nextInt(); // Columns
        sc.nextLine(); // Consume the newline

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        System.out.println(countRooms(map, n, m));
    }

    private static int countRooms(char[][] map, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        int roomCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == F && !visited[i][j]) {
                    bfs(map, visited, i, j, n, m);
                    roomCount++;
                }
            }
        }
        return roomCount;
    }

    private static void bfs(char[][] map, boolean[][] visited, int startX, int startY, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for (int d = 0; d < 4; d++) {
                int newX = x + dR[d];
                int newY = y + dC[d];

                if (isValid(newX, newY, n, m, map, visited)) {
                    visited[newX][newY] = true;
                    q.add(new int[]{newX, newY});
                }
            }
        }
    }

    private static boolean isValid(int x, int y, int n, int m, char[][] map, boolean[][] visited) {
        return x >= 0 && x < n && y >= 0 && y < m && map[x][y] == F && !visited[x][y];
    }
}