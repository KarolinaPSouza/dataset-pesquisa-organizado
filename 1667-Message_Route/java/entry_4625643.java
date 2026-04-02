import java.io.*;
import java.util.*;

public class entry_4625643 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        // next int, skippt zeilen wenn nötig
        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Node {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "(id:" + v + "| w:" + w + ")";
        }
    }

    static class Graph {

        ArrayList<Integer>[] adjMap;
        int size;
        int egdes;

        public Graph(int vertices, int m) {
            this.size = vertices;
            this.egdes = m;
            adjMap = (ArrayList<Integer>[]) new ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjMap[i] = new ArrayList<Integer>();
            }
        }

        void addEdge(int start, int end, int weight) {
            adjMap[start].add(end);
            adjMap[end].add(start);
        }

        int[] bfs(int start, int end) {
            Queue<Integer> queue = new ArrayDeque<Integer>();
            boolean[] visited = new boolean[this.size];
            int[] parent = new int[this.size];

            queue.add(start);
            visited[start] = true;

            while (!queue.isEmpty()) {
                int cur = queue.remove();

                for (Integer outNode : adjMap[cur]) {

                    if (!visited[outNode]) {
                        parent[outNode] = cur;
                        visited[outNode] = true;
                        queue.add(outNode);
                    }

                    if (outNode == end) {
                        return parent;
                    }
                }
            }

            return parent;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();

        int n = s.nextInt(); //height
        int m = s.nextInt(); //width

        Graph g = new Graph(n, 0);

        for (int i = 0; i < m; i++) {
            g.addEdge(s.nextInt()-1, s.nextInt()-1, 0);
        }

        int[] parent = g.bfs(0, n-1);

        if (parent[n-1] == 0 && !g.adjMap[n-1].contains(0)) {
            System.out.println("IMPOSSIBLE");
        } else {
            StringBuilder path = new StringBuilder();

            int c = n-1;
            int l = 1;
            while (c != 0) {
                path.insert(0, c+1);
                path.insert(0, ' ');
                c = parent[c];
                l++;
            }
            path.insert(0, 1);
            System.out.println(l);
            System.out.println(path);

        }
    }

}