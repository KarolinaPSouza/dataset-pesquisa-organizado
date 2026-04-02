import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class entry_5029869 {
    // #region GraphClass
    public class Edge {
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        public Edge(int dest) {
            this.dest = dest;
            this.weight = 0;
        }
    }

    public ArrayList<ArrayList<Edge>> vtces = new ArrayList<>();

    public entry_5029869(int n) {
        for (int i = 0; i <= n; i++) {
            this.vtces.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        this.vtces.get(src).add(new Edge(dest));
        this.vtces.get(dest).add(new Edge(src));
    }

    public void addEdge(int src, int dest, int weight) {
        this.vtces.get(src).add(new Edge(dest, weight));
        this.vtces.get(dest).add(new Edge(src, weight));
    }

    public void removeEdge(int src, int dest) {
        int idx = -1;
        for (Edge e : this.vtces.get(src)) {
            idx++;
            if (e.dest == dest) {
                this.vtces.get(src).remove(idx);
                break;
            }
        }

        idx = -1;
        for (Edge e : this.vtces.get(dest)) {
            idx++;
            if (e.dest == src) {
                this.vtces.get(dest).remove(idx);
                break;
            }
        }
    }

    public boolean isEdge(int src, int dest) {
        for (Edge e : this.vtces.get(src)) {
            if (e.dest == dest)
                return true;
        }
        return false;
    }

    public void print() {
        for (int i = 1; i < this.vtces.size(); i++) {
            System.out.print(i + ":");
            for (Edge e : this.vtces.get(i)) {
                System.out.print(" {" + e.dest + ", " + e.weight + "}");
            }
            System.out.println();
        }
    }
    // #endregion

    // #region FastReaderClass
    public static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
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

        public long nextLong() throws IOException {
            long ret = 0;
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

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
    // #endregion

    public static void main(String[] args) throws IOException {
        Reader scn = new Reader();
        int n = scn.nextInt();
        int edges = scn.nextInt();

        entry_5029869 graph = new entry_5029869(n);

        for (int i = 0; i < edges; i++) {
            graph.addEdge(scn.nextInt(), scn.nextInt());
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n + 1];
        ArrayList<Integer> connections = new ArrayList<>();
        int components = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                connections.add(i);
                ++components;
                visited[i] = 1;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int current = queue.remove();

                    for (Edge e : graph.vtces.get(current)) {
                        if (visited[e.dest] == 0) {
                            queue.add(e.dest);
                            visited[e.dest] = visited[current] + 1;
                        }
                    }
                }
            }
        }

        System.out.println(components - 1);
        for (int i = 0; i < connections.size() - 1; i++) {
            System.out.println(connections.get(i) + " " + connections.get(i + 1));
        }

        scn.close();
    }
}
