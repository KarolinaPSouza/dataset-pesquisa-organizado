import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.concurrent.LinkedTransferQueue;
import java.util.*;

public class entry_11522723 {

    public static ArrayList<Integer>[] adjlist;
    public static int lastnode;
    public static boolean[] visited;
    public static int[] distances;

    public static void main(String[] args) throws IOException {
        Reader scanner = new Reader();
        int n = scanner.nextInt();
        adjlist = new ArrayList[n];
//        Arrays.fill(adjlist,new ArrayList<Integer>());
        for (int i = 0; i < n; i++) {
            adjlist[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            adjlist[a].add(b);
            adjlist[b].add(a);
        }
        visited = new boolean[n];
        distances = new int[n];
        int[] dp = new int[n];
        bfs(0);
//        System.out.println(lastnode);
        Arrays.fill(visited, false);
        bfs(lastnode);
//        System.out.println(lastnode);
        System.out.println(distances[lastnode]);
        //now bfs from this node again

    }

    //pehle take any node and max node dekho usses pehle and then uss node se vapas furthest nikalo and that is the diameter
    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        distances[start] = 0;
        lastnode = -1;
        while (!q.isEmpty()) {
//            System.out.println("queue is: " + q);
            int poll = q.poll();
            lastnode = poll;
            //need to add the children na uska
            for (int child : adjlist[poll]) {
                if (!visited[child]) {
                    q.add(child);
                    visited[child] = true;
                    distances[child] = distances[poll] + 1;
//                    System.out.println("for the node: "+child+" distance is: "+distances[child]);
//                    System.out.println(distances[child]);
                }
            }

//            adjlist[poll].stream().forEach(child -> {
//                if (!visited[child]) {
//                    q.add(child);
//                    visited[child] = true;
//                    distances[child] = distances[poll] + 1;
////                    System.out.println(distances[child]);
////                    System.out.println(distances[child]);
//                }
//            });
        }
    }

    static class Reader {
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
            byte[] buf = new byte[10000000]; // line length
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

}