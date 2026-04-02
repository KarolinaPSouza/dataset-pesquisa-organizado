import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class entry_2365303 {
    public static ArrayList<Integer>[] graph;
    public static int[] assignments;
    static class FastScanner {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        public FastScanner() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public FastScanner(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do ret = ret * 10 + c - '0';
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }
    public static boolean dfsIter(int start) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{start,1});
        assignments[start]=1;
        while (!stack.isEmpty()) {
            int[] node = stack.pop();
            for (int neighbor : graph[node[0]]) {
                if (assignments[neighbor]==node[1]) return false;
                if (assignments[neighbor]==0) {
                    assignments[neighbor]=3-node[1];
                    stack.add(new int[]{neighbor,3-node[1]});
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner();
        int N = input.nextInt();
        int M = input.nextInt();
        graph = new ArrayList[N+1];
        assignments = new int[N+1];
        for (int i = 1; i<=N; i++) graph[i]=new ArrayList<>();
        for (int i = 0; i<M; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }
        boolean works = true;
        for (int i = 1; i<=N; i++) {
            if (assignments[i]==0) {
                if (!dfsIter(i)) {
                    works=false;
                    break;
                }
            }
        }
        if (works) {
            for (int i = 1; i<=N; i++) System.out.print(assignments[i]+" ");
            System.out.println();
        } else System.out.println("IMPOSSIBLE");
    }
}