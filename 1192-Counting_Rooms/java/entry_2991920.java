import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.StringTokenizer;

public class entry_2991920 {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int R = fr.nextInt(), C = fr.nextInt();

        boolean[][] visited = new boolean[R][C];
        int cnt = 0;

        char[][] map = new char[R][C];

        for (int i = 0; i < R; ++i)
            map[i] = fr.next().toCharArray();

        for (int i = 0; i < R; ++i)
            for (int j = 0; j < C; ++j) {
                if (visited[i][j])
                    continue;
                if (map[i][j] == '#')
                    continue;
                cnt++;

                Queue<Point> queue = new LinkedList<>();

                queue.add(new Point(i, j));

                while (! queue.isEmpty()) {
                    Point next = queue.poll();

                    int r = next.r, c = next.c;

                    if (r < 0 || r >= R || c < 0 || c >= C)
                        continue;
                    if (visited[r][c] || map[r][c] == '#')
                        continue;
                    visited[r][c] = true;
                    queue.add(new Point(r+1, c));
                    queue.add(new Point(r-1, c));
                    queue.add(new Point(r, c+1));
                    queue.add(new Point(r, c-1));
                }

            }

        pw.println(cnt);

        pw.close();
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r; this.c = c;
        }
    }

    // **************** FastReader Class:  pre-made code prior to competition ************************* //

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            st = null;
            return str;
        }
    }

}