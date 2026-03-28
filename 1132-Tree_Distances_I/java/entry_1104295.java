import java.lang.*;
import java.io.*;
import java.util.*;
@SuppressWarnings({"unchecked", "rawtypes"})
public class entry_1104295 {
    public static void main(String[] args) throws Exception {
        Reader br = new Reader();
        int n = br.nextInt();
        Queue<Integer>[] adj = new Queue[n], tree = new Queue[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new LinkedList<Integer>();
            tree[i] = new LinkedList<Integer>();
        }
        for (int i = 1; i < n; ++i) {
            int a = br.nextInt() - 1, b = br.nextInt() - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        int[][] subMax = new int[n][3];
        final Deque<Integer> dq = new LinkedList<Integer>();
        dq.add(0);
        while (!dq.isEmpty()) {
            while (!adj[dq.peekLast()].isEmpty()) {
                int root = dq.peekLast(), child = adj[root].poll();
                adj[child].remove(root);
                dq.add(child);
            }
            int child = dq.pollLast();
            if (dq.isEmpty()) continue;
            int parent = dq.peekLast(), dist = subMax[child][0] + 1;
            tree[parent].add(child);
            if (subMax[parent][0] < dist) {
                subMax[parent][1] = subMax[parent][0];
                subMax[parent][0] = dist;
            } else if (subMax[parent][1] < dist) subMax[parent][1] = dist;
        }
        dq.add(0);
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (0 < size--) {
                int root = dq.poll();
                for (int child : tree[root]) {
                    if (subMax[root][0] == subMax[child][0] + 1) {
                        subMax[child][2] = Math.max(subMax[root][1], subMax[root][2]) + 1;
                    } else {
                        subMax[child][2] = Math.max(subMax[root][0], subMax[root][2]) + 1;
                    }
                    dq.add(child);
                }
                if (subMax[root][0] < subMax[root][2]) subMax[root][0] = subMax[root][2];
            }
        }
        final StringBuilder sb = new StringBuilder(n << 1);
        for (int i = 0; i < n; ++i) sb.append(subMax[i][0]).append(' ');
        System.out.println(sb.toString());
    }

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }
    }
}