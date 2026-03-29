import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class entry_11744453 {
    static FastReader in = new FastReader();
    // static final Random random = new Random();
    static final int MOD = (int) 1e9 + 7;
    static StringBuilder res;
    static ArrayList<Integer> list;
    static int start;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        res = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            // for single integer
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<ArrayList<int[]>> forward = new ArrayList<>();
            ArrayList<ArrayList<int[]>> backward = new ArrayList<>();
            ArrayList<int[]> edges = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                forward.add(new ArrayList<>());
            }
            for (int i = 0; i <= n; i++) {
                backward.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int src = in.nextInt();
                int dest = in.nextInt();
                int cost = in.nextInt();
                edges.add(new int[] { src, dest, cost });
                forward.get(src).add(new int[] { dest, cost });
                backward.get(dest).add(new int[] { src, cost });
            }
            long[] f = dijkstra(forward, 1, n);
            long[] b = dijkstra(backward, n, n);
            long ans = Long.MAX_VALUE;
            for (int[] i : edges) {
                int src = i[0];
                int dest = i[1];
                int cost = i[2];
                if (f[src] == Long.MAX_VALUE || b[dest] == Long.MAX_VALUE)
                    continue;
                ans = Math.min(ans, f[src] + b[dest] + (cost / 2));
            }
            append(ans);

            // append(cost[n]);

            // for int array
            // int[] arr = in.readIntArray(n);

            // Input a 2D integer matrix
            // int[][] intMatrix = in.readIntMatrix(n, n);

        }
        print(res);
    }

    static long[] dijkstra(ArrayList<ArrayList<int[]>> graph, int start, int size) {
        int n = graph.size();
        long[] visited = new long[size + 1];
        Arrays.fill(visited, Long.MAX_VALUE);
        visited[start] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[] { start, 0 });
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            if (curr[1] > visited[(int) curr[0]])
                continue;
            for (int[] i : graph.get((int) curr[0])) {
                int dest = i[0];
                int cost = i[1];
                if (visited[(int) curr[0]] + cost < visited[dest]) {
                    visited[dest] = visited[(int) curr[0]] + cost;
                    pq.add(new long[] { dest, visited[dest] });
                }
            }
        }

        return visited;
    }

    static void dfs(int currr, boolean[] visited, ArrayList<Integer>[] graph, int parent) {
        for (int child : graph[currr]) {
            if (child != parent && !flag) {
                if (!visited[child]) {

                    visited[child] = true;

                    list.add(child);
                    if (child == start) {
                        flag = true;
                        return;
                    }
                    dfs(child, visited, graph, currr);

                }
            }
        }
        if (!flag && list.size() > 0)
            list.remove(list.size() - 1);

    }

    static int detectCycle(ArrayList<Integer>[] graph, int currr, boolean[] visited, int parent) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { currr, parent });
        while (!stack.isEmpty()) {
            int[] arr = stack.pop();
            for (Integer i : graph[arr[0]]) {
                if (i != arr[1]) {
                    if (!visited[i]) {
                        visited[i] = true;
                        stack.push(new int[] { i, arr[0] });
                    } else if (visited[i]) {
                        return i;
                    }
                }
            }
        }
        // for (int child : graph[currr]) {
        // if (child != parent) {
        // if (!visited[child]) {
        // visited[child] = true;
        // return detectCycle(graph, child, visited, currr);

        // } else if (visited[child]) {
        // return child;
        // }
        // }
        // }
        return -1;
    }

    static int modAdd(int a, int b, int mod) {
        return ((a % mod) + (b % mod)) % mod;
    }

    static int modSub(int a, int b, int mod) {
        return ((a % mod) - (b % mod) + mod) % mod;
    }

    static int modMul(int a, int b, int mod) {
        return (int) (((long) a * b) % mod);
    }

    static int modPow(int base, int exp, int mod) {
        int res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = modMul(res, base, mod);
            }
            base = modMul(base, base, mod);
            exp >>= 1;
        }
        return res;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    static <E> void print(E res) {
        System.out.println(res);
    }

    static <E> void append(E s) {
        res.append(s + "\n");
    }

    static <E> void appendSpace(E s) {
        res.append(s + " ");
    }

    static <E> void appendLine() {
        res.append("\n");
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readIntArray(int n) {
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = nextInt();
            }
            return res;
        }

        long[] readLongArray(int n) {
            long[] res = new long[n];
            for (int i = 0; i < n; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        int[][] readIntMatrix(int rows, int cols) {
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = nextInt();
                }
            }
            return matrix;
        }

        char[][] readCharMatrix(int rows, int cols) {
            char[][] matrix = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                String line = next();
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }
            return matrix;
        }
    }
}