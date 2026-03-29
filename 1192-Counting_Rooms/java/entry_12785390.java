import java.util.*;

public class entry_12785390 {
    private static Scanner ip = new Scanner(System.in);
    private static int n;
    private static int m;

    private static char[][] array = new char[1005][1005];

    private static boolean[][] visited = new boolean[1005][1005];

    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int ans = 0;

    public static void main(String[] args) {
        System.out.println(solve());
    }

    public static int solve() {
        n = ip.nextInt();
        m = ip.nextInt();
        // Input the grid
        for (int i = 1; i <= n; i++) {
            String s = " " + ip.next();
            for (int j = 1; j <= m; j++) {
                array[i][j] = s.charAt(j);
                visited[i][j] = false;
            }
        }

        // Count the number of rooms
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (array[i][j] == '.' && visited[i][j] == false) {
                    ans++;
                    bfs(new Point(i, j));
                }
            }
        }
        return ans;
    }

    public static void bfs(Point p) {
        visited[p.x][p.y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false
                        && array[newPoint.x][newPoint.y] != '#') {
                    visited[newPoint.x][newPoint.y] = true;
                    queue.add(newPoint);
                }
            }
        }
    }

    public static boolean isValid(Point p) {
        if (p.x < 1 || p.x > n || p.y < 1 || p.y > m) {
            return false;
        }
        return true;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}