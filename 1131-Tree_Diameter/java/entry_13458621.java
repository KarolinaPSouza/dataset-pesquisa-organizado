import java.io.*;
import java.util.*;

public class entry_13458621 {
    static int N;
    static int[] head, to, nxt;
    static int edgeCnt = 0;
    static int[] dist, q;

    static void addEdge(int u, int v) {
        to[edgeCnt] = v; nxt[edgeCnt] = head[u]; head[u] = edgeCnt++;
    }

    static int bfs(int src) {
        Arrays.fill(dist, -1);
        int qt = 0, qh = 0;
        q[qt++] = src;
        dist[src] = 0;

        int far = src;
        while (qh < qt) {
            int u = q[qh++];
            for (int e = head[u]; e != -1; e = nxt[e]) {
                int v = to[e];
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q[qt++] = v;
                    far = v;
                }
            }
        }
        return far;
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        N = in.nextInt();

        head = new int[N]; to = new int[(N - 1) * 2];
        nxt = new int[(N - 1) * 2];
        Arrays.fill(head, -1);

        dist = new int[N];
        q = new int[N];

        for (int i = 0; i < N - 1; i++) {
            int u = in.nextInt() - 1, v = in.nextInt() - 1;
            addEdge(u, v);
            addEdge(v, u);
        }

        int far1 = bfs(0);
        int far2 = bfs(far1);
        out.println(dist[far2]);
        out.flush();
    }

    static class FastReader {
        final BufferedInputStream bis = new BufferedInputStream(System.in, 1<<20);
        byte[] buf = new byte[1<<20];
        int bufLen = 0, bufPos = 0;
        int nextByte() throws IOException {
            if (bufPos >= bufLen) {
                bufPos = 0;
                bufLen = bis.read(buf);
                if (bufLen == -1) return -1;
            }
            return buf[bufPos++];
        }
        int nextInt() throws IOException {
            int c, x = 0;
            do { c = nextByte(); } while (c <= ' ');
            boolean neg = (c == '-');
            if (neg) c = nextByte();
            for (; c >= '0' && c <= '9'; c = nextByte())
                x = x * 10 + (c - '0');
            return neg ? -x : x;
        }
    }
}