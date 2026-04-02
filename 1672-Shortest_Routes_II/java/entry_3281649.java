import java.util.*;
import java.io.*;
public class entry_3281649 {
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out);

        int N = in.nextInt(), M = in.nextInt(), Q = in.nextInt();
        long[][] dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 1000000000000000000L);
            dp[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            int u = in.nextInt() - 1, v = in.nextInt() - 1, c = in.nextInt();
            dp[u][v] = Math.min(dp[u][v], c);
            dp[v][u] = Math.min(dp[v][u], c);
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        for (int q = 0; q < Q; q++) {
            int u = in.nextInt() - 1, v = in.nextInt() - 1;
            out.println(dp[u][v] == 1000000000000000000L ? -1 : dp[u][v]);
        }

        out.close();
    }
    static class Reader {
        BufferedInputStream in;
        public Reader() {
            in = new BufferedInputStream(System.in);
        }
        public String nextLine() throws IOException {
            int c;
            StringBuilder sb = new StringBuilder("");
            while ((c = in.read()) != '\n')
                sb.append((char)(c));
            return sb.toString();
        }
        public String next() throws IOException {
            int c;
            StringBuilder sb = new StringBuilder("");
            while ((c = in.read()) != ' ' && c != '\n')
                sb.append((char)(c));
            return sb.toString();
        }
        public int nextInt() throws IOException {
            return (int)nextLong();
        }
        public long nextLong() throws IOException {
            int c;
            long res = 0;
            boolean start = false, negative = false;
            while ((c = in.read()) != ' ' && c != '\n' || !start)
                if (c >= '0' && c <= '9' || c == '-') {
                    start = true;
                    if (c == '-')
                        negative = true;
                    else
                        res = res * 10 + c - '0';
                }
            return res * (negative ? -1 : 1);
        }
    }
    public static void sort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
}