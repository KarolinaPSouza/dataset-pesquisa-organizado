import java.util.*;
import java.io.*;
public class entry_10087821 {
    public static void main(String[] args) throws IOException{
        Reader io = new Reader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = io.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for(int i = 0; i < n - 1; i++){
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        int end1 = bfs2(tree, 0, n);
        int end2 = bfs2(tree, end1, n);

        int[] dist1 = bfs(tree, end1, n);
        int[] dist2 = bfs(tree, end2, n);

        for(int i = 0; i < n; i++){
            pw.print(Math.max(dist1[i], dist2[i]) + " ");
        }
        pw.close();
        io.close();
    }
    private static int[] bfs(List<List<Integer>> tree, int start, int n){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;
        int[] dist = new int[n];
        dist[start] = 0;

        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                int curr = que.poll();
                for(int neighbour: tree.get(curr)) {
                    if (visited[neighbour]) continue;
                    que.offer(neighbour);
                    visited[neighbour] = true;
                    dist[neighbour] = dist[curr] + 1;
                }
            }
        }
        return dist;
    }
    private static int bfs2(List<List<Integer>> tree, int start, int n){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;
        int last = start;

        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++) {
                int curr = que.poll();
                for (int neighbour : tree.get(curr)) {
                    if (visited[neighbour]) continue;
                    que.offer(neighbour);
                    visited[neighbour] = true;
                }
                last = curr;
            }
        }
        return last;
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

        private void fillBuffer() throws IOException {

            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);

            if (bytesRead == -1) buffer[0] = -1;

        }


        private byte read() throws IOException {

            if (bufferPointer == bytesRead) fillBuffer();

            return buffer[bufferPointer++];

        }


        public void close() throws IOException {

            if (din == null) return;

            din.close();

        }

        public int nextInt() throws IOException {

            int ret = 0;

            byte c = read();

            while (c <= ' ') c = read();

            boolean neg = (c == '-');

            if (neg) c = read();

            do {

                ret = ret * 10 + c - '0';

            } while ((c = read()) >= '0' && c <= '9');


            if (neg) return -ret;

            return ret;

        }

    }
}