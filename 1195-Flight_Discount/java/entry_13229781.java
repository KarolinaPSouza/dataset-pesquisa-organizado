import java.io.*;
import java.util.*;

public class entry_13229781 {
    public static class Node implements Comparable<Node> {
        int des;
        long path;
        int state;

        public Node(int des, long path, int state) {
            this.des = des;
            this.path = path;
            this.state = state;
        }

        @Override
        public int compareTo(Node n2) {
            return Long.compare(this.path, n2.path);
        }
    }

    public static void main(String[] args) throws Exception {
        _BufferedReader br = new _BufferedReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            long c = Long.parseLong(st.nextToken());
            list[a].add(new Node(b, c, 0));
        }

        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], (long) 1e17);
        dist[0][0] = dist[0][1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] vis = new boolean[n][2];
        pq.add(new Node(0, 0, 0));
        pq.add(new Node(0, 0, 1));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int e = curr.des, state = curr.state;
            if (vis[e][state]) continue;
            vis[e][state] = true;

            for (Node x : list[e]) {
                int xn = x.des;
                long cost = x.path;
                if (state == 1) {
                    long newDist = dist[e][1] + cost;
                    if (dist[xn][1] > newDist) {
                        dist[xn][1] = newDist;
                        if (!vis[xn][1]) pq.add(new Node(xn, newDist, 1));
                    }
                } else {
                    long d0 = dist[e][0] + cost;
                    if (dist[xn][0] > d0) {
                        dist[xn][0] = d0;
                        if (!vis[xn][0]) pq.add(new Node(xn, d0, 0));
                    }
                    long d1 = dist[e][0] + cost / 2;
                    if (dist[xn][1] > d1) {
                        dist[xn][1] = d1;
                        if (!vis[xn][1]) pq.add(new Node(xn, d1, 1));
                    }
                }
            }
        }

        pw.println(Math.min(dist[n - 1][0], dist[n - 1][1]));
        pw.flush();
    }

    static class _BufferedReader {
        private final InputStream is;
        private final byte[] buf = new byte[1 << 16];
        private int idx, total;
        private final StringBuilder sb = new StringBuilder();

        public _BufferedReader(InputStream is) {
            this.is = is;
        }

        private byte read() throws IOException {
            if (idx == total) {
                total = is.read(buf);
                idx = 0;
                if (total == -1) return -1;
            }
            return buf[idx++];
        }

        public String readLine() throws IOException {
            sb.setLength(0);
            byte c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                if (c == '\r') continue;
                sb.append((char) c);
            }
            return sb.length() == 0 && c == -1 ? null : sb.toString();
        }
    }
}