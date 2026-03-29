import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

//Start: 1:22 PM
//Finish: 

public class entry_11721286 {
    public static boolean[][] visited;
    public static char[][] grid;
    public static int n, m;
    public static int rooms;
    public static void main(String[] args) throws IOException {
        input inp = new input();

        n = inp.nextInt();
        m = inp.nextInt();

        grid = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = inp.next().toCharArray();
        }

        rooms = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (!visited[r][c] && grid[r][c] == '.') {
                    rooms++;
                    floodfill(r, c, '.');
                }
                visited[r][c] = true;
            }
        }

        inp.println(rooms);

        inp.close();
    }

    static void floodfill(int r, int c, char type) {
        if (r < 0 || r >= n || c < 0 || c >= m) {
            return;
        }

        if (visited[r][c] || grid[r][c] != type) {
            return;
        }

        visited[r][c] = true;

        floodfill(r + 1, c, type);
        floodfill(r - 1, c, type);
        floodfill(r, c + 1, type);
        floodfill(r, c - 1, type);
    }

    static class input extends PrintWriter {
        private BufferedReader reader;
        private StringTokenizer stringer;

        public input() {
            this(System.in, System.out);
        }

        public input(String problemName) throws IOException {
            super(problemName + ".out");
            reader = new BufferedReader(new FileReader(problemName + ".in"));
        }

        public input(InputStream i, OutputStream o) {
            super(o);
            reader = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            try {
                while (stringer == null || !stringer.hasMoreTokens()) {
                    stringer = new StringTokenizer(reader.readLine());
                }
                return stringer.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}