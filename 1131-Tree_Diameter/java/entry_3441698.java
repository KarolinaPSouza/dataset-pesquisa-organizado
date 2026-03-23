import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_3441698 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> q=  new LinkedList<Integer>();
        int d = 0;
        int last = 0;
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()){
            int size = q.size();
            int count = 0;
            for (int i = 0; i < size; i++) {
                int get = q.remove();
                for (int a : adj[get]) {
                    if (!vis[a]) {
                        count++;
                        vis[a] = true;
                        q.add(a);
                        last = a;
                    }
                }
            }
            if(count > 0)
                d++;
        }
        d = 0;
        q.add(last);
//        System.out.println(last);
        vis = new boolean[n];
        vis[last] = true;
        while (!q.isEmpty()){
            int size = q.size();
            int count = 0;
            for (int i = 0; i < size; i++) {
                int get = q.remove();
                for (int a : adj[get]) {
                    if (!vis[a]) {
                        count++;
                        vis[a] = true;
                        q.add(a);
                    }
                }
            }
            if(count > 0)
                d++;
        }
        System.out.println(d);
    }
}
/*import java.io.*;
import java.util.*;
 public class entry_3441698 {
    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1<<16];
        private int curChar, numChars;
         // standard input
        public FastIO() { this(System.in,System.out); }
        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }
        // file input
        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }
         // throws InputMismatchException() if previously detected end of file
        private int nextByte() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1) return -1; // end of file
            }
            return buf[curChar++];
        }
         // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
        public String next() {
            int c; do { c = nextByte(); } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
            return res.toString();
        }
        public int nextInt() { // nextLong() would be implemented similarly
            int c; do { c = nextByte(); } while (c <= ' ');
            int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10*res+c-'0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
    static class Edge {
        int to, next;
         Edge(int a, int b) {
            to = a;
            next = b;
        }
         @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", next=" + next +
                    '}';
        }
    }
     static void addEdge(int a, int b, int i) {
        edges[i] = new Edge(b, head[a]);
        head[a] = i;
    }
     static class Point{
        int i, d;
        Point(int a, int b) {
            i = a;
            d = b;
        }
    }
    static int N;
    static int[] head; // head initialized to -1
    static Edge[] edges;
    static boolean[] visited;
     static Point dfs(Point i) {
        Point max = i;
        for (int curEdgeIndex = head[i.i]; curEdgeIndex != -1; curEdgeIndex = edges[curEdgeIndex].next) {
            int j = edges[curEdgeIndex].to;
            if (!visited[j]) {
                visited[j] = true;
                Point temp = dfs(new Point(j, i.d+1));
                if (temp.d > max.d) {
                    max = temp;
                }
            }
        }
        return max;
    }
     public static void main(String[] args) throws IOException {
        String name = "test";
        FastIO io = new FastIO();
        N = io.nextInt();
        head = new int[N];
        Arrays.fill(head, -1);
        visited = new boolean[N];
        edges = new Edge[2 * N - 2];
        for (int i = 0; i < N - 1; i++) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            addEdge(a, b, 2 * i);
            addEdge(b, a, 2 * i + 1);
        }
        Point a = dfs(new Point(0,0));
        Point b = dfs(new Point(a.i, 0));
         System.out.println(b.d);
    }
}*/