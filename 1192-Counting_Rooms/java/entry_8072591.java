import java.util.*;
import java.io.*;

public class entry_8072591 {
    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static class Tuple {
        int x;
        int y;
        Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || o.getClass() != this.getClass()) return false;
            Tuple cur = (Tuple) o;
            return cur.x == this.x && cur.y == this.y;
        }        
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(Tuple startNode, char[][] grid, int n, int m, boolean[][] visited) {
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(startNode);
        while(!queue.isEmpty()) {
            Tuple top = queue.poll();
            visited[top.x][top.y] = true;
            for(int i = 0; i < 4; ++i) {
                int nextx = top.x + dx[i];
                int nexty = top.y + dy[i];
                if(nextx >= 0 && nextx < n && nexty >= 0 && nexty < m && grid[nextx][nexty] == '.' && !visited[nextx][nexty]) {
                    visited[nextx][nexty] = true;
                    queue.add(new Tuple(nextx, nexty));
                }
            }
        }
    }

    public static void solve(FastScanner fs, PrintWriter pr, int t) {
        int n = fs.nextInt();
        int m = fs.nextInt();
        char[][] grid = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; ++i) {
            char[] row = fs.next().toCharArray();
            for(int j = 0; j < row.length; ++j) {
                grid[i][j] = row[j];
                visited[i][j] = false;
            }
        }
        Queue<Tuple> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(grid[i][j] == '.' && !visited[i][j]) {
                    bfs(new Tuple(i, j), grid, n, m, visited);
                    count++;
                }
            }
        }
        pr.println(count);
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int testCase = 1;
        for (int t = 0; t < testCase; t++) {
            solve(fs, out, t);
        }
        out.flush();
        out.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}