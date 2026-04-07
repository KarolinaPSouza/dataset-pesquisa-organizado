import java.io.*;
import java.util.*;

class Main {

    FastReader in = new FastReader();
    StringBuilder out = new StringBuilder();

    public void solve() throws Exception {
        int n = in.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(in.nextInt());

        out.append(set.size());

        System.out.print(out);
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }

    // reusable fast input
    class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
        double nextDouble() throws IOException { return Double.parseDouble(next()); }
        String nextLine() throws IOException { return br.readLine(); }
    }
}