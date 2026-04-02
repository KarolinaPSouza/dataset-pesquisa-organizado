import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_1539806 {
    static class FastIO {

        InputStream dis;
        byte[] buffer = new byte[1 << 17];
        int pointer = 0;

        public FastIO(String fileName) throws Exception {
            dis = new FileInputStream(fileName);
        }

        public FastIO(InputStream is) throws Exception {
            dis = is;
        }

        int nextInt() throws Exception {
            int ret = 0;

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }

            return (negative) ? -ret : ret;
        }

        long nextLong() throws Exception {
            long ret = 0;

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }

            return (negative) ? -ret : ret;
        }

        byte nextByte() throws Exception {
            if (pointer == buffer.length) {
                dis.read(buffer, 0, buffer.length);
                pointer = 0;
            }
            return buffer[pointer++];
        }

        String next() throws Exception {
            StringBuffer ret = new StringBuffer();

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            while (b > ' ') {
                ret.appendCodePoint(b);
                b = nextByte();
            }

            return ret.toString();
        }

    }
    public static void main(String[] args) throws Exception {
        FastIO sc = new FastIO(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        long inf = Long.MAX_VALUE/2;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        long[][] dist = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], inf);
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int weight = sc.nextInt();
            dist[a][b] = Math.min(weight, dist[a][b]);
            dist[b][a] = dist[a][b];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int q1 = sc.nextInt() - 1;
            int q2 = sc.nextInt() - 1;
            if (dist[q1][q2] >= inf) s.append(-1 + "\n");
            else s.append(dist[q1][q2]).append("\n");
        }
        pw.write(s.toString());
        pw.close();
    }
}