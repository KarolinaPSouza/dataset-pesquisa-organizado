import java.util.*;
import java.io.*;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;

public class entry_15793992 {
    public static int mod = (int) 1e9 + 7;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

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
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void println() throws IOException {
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }

        public void printLongArr(long[] arr) throws IOException {
            for (long ele : arr) {
                print(ele + " ");
            }
            println();
        }

        public void printIntArr(int[] arr) throws IOException {
            for (int ele : arr) {
                print(ele + " ");
            }
            println();
        }
    }

    public static void main
            (String[] args) {
        try {
            FastReader fin = new FastReader();
            FastWriter fout = new FastWriter();

            int n = fin.nextInt();
            if (n == 1) {
                fout.print(0);
                fout.close();
                return;
            }
            List<List<Integer>> tree = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                int u = fin.nextInt();
                int v = fin.nextInt();
                tree.get(u).add(v);
                tree.get(v).add(u);
            }
            int[] distanceFromRoot = new int[n + 1];
            bfs(1, -1, 0, tree, distanceFromRoot);
            int node1 = -1;
            int maxDistanceFromNode1 = 0;
            for (int i = 1; i <= n; i++) {
                if (maxDistanceFromNode1 < distanceFromRoot[i]) {
                    maxDistanceFromNode1 = distanceFromRoot[i];
                    node1 = i;
                }
            }
            bfs(node1, -1, 0, tree, distanceFromRoot);
            int maxDistanceFromNode2 = 0;
            for (int i = 1; i <= n; i++) {
                maxDistanceFromNode2 = max(maxDistanceFromNode2, distanceFromRoot[i]);
            }
            fout.print(maxDistanceFromNode2);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static void bfs(int node, int parent, int level, List<List<Integer>> tree, int[] distanceFromRoot) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(distanceFromRoot, -1);
        queue.add(node);
        while (!queue.isEmpty()) {
            int k = queue.size();
            while (k-- > 0) {
                int currentNode = queue.poll();
                distanceFromRoot[currentNode] = level;
                for (int child : tree.get(currentNode)) {
                    if (distanceFromRoot[child] != -1) continue;
                    queue.add(child);
                }
            }
            level++;
        }
    }

    public static void dfsUsingStack(int node, int parent, int level, List<List<Integer>> tree, int[] distanceFromRoot) {
        Stack<int[]> dfsStack = new Stack<>();
        dfsStack.add(new int[]{node, parent, level});
        while (!dfsStack.isEmpty()) {
            int[] nodeData = dfsStack.pop();
            int nodeVal = nodeData[0];
            int parentVal = nodeData[1];
            int levelVal = nodeData[2];
            distanceFromRoot[nodeVal] = levelVal;
            for (int child : tree.get(nodeVal)) {
                if (child != parentVal) {
                    dfsStack.push(new int[]{child, nodeVal, levelVal + 1});
                }
            }
        }
    }

    public static void dfsUsingStack2(int node, int parent, int level, List<List<Integer>> tree, int[] distanceFromRoot) {
        Deque<int[]> dfsStack = new ArrayDeque<>();
        dfsStack.add(new int[]{node, parent, level});
        while (!dfsStack.isEmpty()) {
            int[] nodeData = dfsStack.pop();
            int nodeVal = nodeData[0];
            int parentVal = nodeData[1];
            int levelVal = nodeData[2];
            distanceFromRoot[nodeVal] = levelVal;
            for (int child : tree.get(nodeVal)) {
                if (child != parentVal) {
                    dfsStack.push(new int[]{child, nodeVal, levelVal + 1});
                }
            }
        }
    }

    public static void dfs(int node, int parent, int level, List<List<Integer>> tree, int[] distanceFromRoot) {
        distanceFromRoot[node] = level;
        for (int child : tree.get(node)) {
            if (child == parent) continue;
            dfs(child, node, level + 1, tree, distanceFromRoot);
        }
    }
}
