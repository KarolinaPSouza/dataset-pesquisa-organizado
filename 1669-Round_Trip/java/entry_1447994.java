import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jaynil
 */
public class entry_1447994 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Reader in = new Reader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        RoundTrip solver = new RoundTrip();
        solver.solve(1, in, out);
        out.close();
    }

    static class RoundTrip {
        ArrayList<Integer>[] g;
        ArrayList<Integer> ans;
        boolean[] vis;

        public void dfs(int r, int p) {
            if (vis[r]) return;
            vis[r] = true;
            if (ans.size() > 0) return;
//        System.out.println((r+1) + " " + ans.size());
            for (int x : g[r]) {
                if (x != p && vis[x] && ans.size() == 0) {
                    ans.add(x + 1);
                    break;
                }
                if (ans.size() == 0)
                    dfs(x, r);
                else {
                    break;
                }
            }
            if ((ans.size() > 0 && ans.get(0) - ans.get(ans.size() - 1) != 0) || ans.size() == 1) {
                ans.add((r + 1));
            }
        }

        public void solve(int testNumber, Reader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            ans = new ArrayList<>();
            vis = new boolean[n];
            g = new ArrayList[n + 1];
            for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                g[a].add(b);
                g[b].add(a);
            }
            for (int i = 0; i < n; i++) {
                if (ans.size() > 0) break;
                if (!vis[i]) {
                    dfs(i, -1);
                }
            }

            if (ans.size() == 0) {
                out.println("IMPOSSIBLE");
            } else {
                out.println(ans.size());
                for (int x : ans) out.print(x + " ");
            }
        }

    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer;
        private int bytesRead;

        public Reader(InputStream x) {
            din = new DataInputStream(x);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1)
                    buffer[0] = -1;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private byte read() {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

    }
}
