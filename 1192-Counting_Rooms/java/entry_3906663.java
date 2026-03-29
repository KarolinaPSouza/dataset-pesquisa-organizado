import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_3906663 {
    public static final String YES = "YES";
    public static final String NO = "NO";
    public static FastReader sc;
    private static Long[] memo;
    public static void main(String[] args) {
        sc = new FastReader();
        int n = sc.nextInt(), m = sc.nextInt();
        char[][] chars = readArray(n, m);
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (chars[row][col] == '.' && visited[row][col] == false) {
                    floodFill(row, col, visited, chars);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void floodFill(int row, int col, boolean[][] visited, char[][] chars) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});
        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        while (q.isEmpty() == false) {
            int[] current = q.poll();
            for (int[] dir: dirs) {
                int cRow = current[0] + dir[0], cCol = current[1] + dir[1];
                if (cRow < 0 || cCol < 0 || cRow >= chars.length ||
                        cCol >= chars[0].length || chars[cRow][cCol] =='#' || visited[cRow][cCol]) {
                    continue;
                }
                visited[cRow][cCol] = true;
                q.add(new int[]{cRow, cCol});
            }
        }
    }

    static char[][] readArray(int rows, int cols) {
        char[][] ch = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String s = sc.next();
            for (int col = 0; col < cols; col++) {
                ch[row][col] = s.charAt(col);
            }
        }
        return ch;
    }

    static int[] readArray(int size) {
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) arr[i] = sc.nextInt();
        return arr;
    }

    // method runs in an assumption (a > b)
    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private static long binaryExponentiation(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long result = binaryExponentiation(a, b/2);
        if (b % 2 == 0) {
            return result * result;
        } else {
            return result * result * a;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}