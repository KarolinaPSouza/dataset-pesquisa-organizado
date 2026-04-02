import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


/*
 *
 * HINT: OVERFLOW CHECK for INT
 *
 * Add to stringbuilder then print all at once when using java
 *
 * */
public class entry_1324417 {
    private static final int MOD = 1000000007;


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
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
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
            }
            while ((c = read()) >= '0' && c <= '9');
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
            }
            while ((c = read()) >= '0' && c <= '9');

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
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
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

    static class Pair {
        int first;
        String second;

        Pair(int first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    static class DSU {
        int[] parents;
        int[] sizes;

        DSU(int size) {
            this.parents = new int[size];
            this.sizes = new int[size];

            for (int i = 1; i <size ; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        int get(int component) {
            if (parents[component] == component) {
                return component;
            }

            int parent = get(parents[component]);
            parents[component] = parent;
            return parent;

        }

        void union(int component1, int component2) {
            int pc1= get(component1);
            int pc2= get(component2);

            if(pc1==pc2) return;

            if(sizes[pc1] > sizes[pc2]) {
                int temp = pc1;
                pc1 = pc2;
                pc2 = temp;

            }

            parents[pc1] = pc2;
            sizes[pc2]+=pc1;

        }

        List<Integer> getComponents() {

            List<Integer> components = new ArrayList<>();
            for (int i = 1; i < parents.length; i++) {
                if (get(i) == i) {
                    components.add(i);
                }
            }
            return components;
        }
    }

    static void printPath(int[] parent, int src, int target) {

        List<Integer> list = new ArrayList<>();

        Deque<Integer> deq = new LinkedList<>();
        deq.push(src);

        while (!deq.isEmpty()) {
            int v = deq.pop();

            list.add(v);

            if(v==target) {
                Collections.reverse(list);
                System.out.println(list.size());
                for (int el: list) System.out.print(el +" ");
                return;
            }

            deq.push(parent[v]);

        }
    }

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader(); //for faster input
        int n = reader.nextInt();
        int m = reader.nextInt();

        Map<Integer,List<Integer>> adjList = new HashMap<>();
        int[] parent = new int[n + 1];
        for (int i = 0; i <m ; i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();

            adjList.putIfAbsent(a, new LinkedList<>());
            adjList.putIfAbsent(b, new LinkedList<>());

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            if(visited.contains(cur)) {
                continue;
            }
//            System.out.println(cur);
            if(cur == n) {
                printPath(parent,n,1);
                return;
            }

            visited.add(cur);

            List<Integer> list = adjList.get(cur);

            if(list==null) continue;

            for (int i = 0; i < list.size() ; i++) {
                if(!visited.contains(list.get(i))) {
                    queue.add(list.get(i));
                    if(parent[list.get(i)]==0)
                        parent[list.get(i)]=cur;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}