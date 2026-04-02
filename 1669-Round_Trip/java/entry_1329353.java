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


/*
 *
 * HINT: OVERFLOW CHECK for INT
 *
 * Add to stringbuilder then print all at once when using java
 *
 * */
public class entry_1329353 {
    private static final int MOD = 1000000007;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";


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
        int second;

        Pair(int first, int second) {
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

            for (int i = 1; i < size; i++) {
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
            int pc1 = get(component1);
            int pc2 = get(component2);

            if (pc1 == pc2) return;

            if (sizes[pc1] > sizes[pc2]) {
                int temp = pc1;
                pc1 = pc2;
                pc2 = temp;

            }

            parents[pc1] = pc2;
            sizes[pc2] += pc1;

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

            if(v<0) return;

            list.add(v);

            if (v == target) {
                Collections.reverse(list);
                System.out.println(list.size()+1);
                for (int el : list) System.out.print(el + " ");
                return;
            }

            deq.push(parent[v]);

        }
    }

    static Map<Integer, List<Integer>> adjList = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();
    static int[] parent;
    static boolean found = false;

    static void dfs(int v, int p) {

        if(found) return;
        parent[v] = p;
        visited.add(v);
        if(adjList.get(v)==null) return;

        for (int nb: adjList.get(v)) {
            if(found) return;
            if(nb == p) continue;
            if(!visited.contains(nb)){
                dfs(nb,v);
            }else {
                //found cycle
                found = true;
//                printPath(parent,v,nb);
                List<Integer> ans = new LinkedList<>();
                while (nb!=v) {
                    ans.add(v);
                    v = parent[v];
                }
                System.out.println(ans.size()+2);
                System.out.print(nb +" ");
                for (int el : ans) System.out.print(el + " ");
                System.out.println(nb);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader(); //for faster input
        int n = reader.nextInt();
        int m = reader.nextInt();

        for (int i = 0; i < m; i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();

            adjList.putIfAbsent(a, new LinkedList<>());
            adjList.putIfAbsent(b, new LinkedList<>());

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        parent = new int[n + 1];

        for (int i = 1; i <= n && !found; i++) {

            if(adjList.get(i)==null) continue;

            if(!visited.contains(i)) {
                dfs(i,-i);
            }
        }

        if(!found) {
            System.out.println(IMPOSSIBLE);
        }

    }
}