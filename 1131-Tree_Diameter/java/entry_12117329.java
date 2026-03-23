import java.util.*;
import java.io.*;

public class entry_12117329 {
    static FastReader in = new FastReader();
    // static final Random random = new Random();
    static final int MOD = (int) 1e9 + 7;
    static StringBuilder res;

    public static void main(String[] args) throws IOException {
        res = new StringBuilder();
        int t = 1;
        while (t-- > 0) {
            // for single integer
            int n = in.nextInt();
            int[] inorder = new int[n + 1];
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i <= n; i++)
                graph.add(new ArrayList<>());
            for (int i = 1; i < n; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
                inorder[v]++;
                inorder[u]++;

            }
            for (int i = 1; i <= n; i++) {
                if (inorder[i] == 1) {
                    q.add(new int[] { i, -1 });
                }
            }
            int level = 0;
            int node = n;
            while (node > 2) {
                int len = q.size();
                for (int j = 0; j < len; j++) {
                    int[] curr = q.poll();
                    node--;
                    int child = curr[0];
                    int parent = curr[1];
                    for (Integer i : graph.get(child)) {
                        if (i == parent)
                            continue;
                        inorder[i]--;
                        if (inorder[i] == 1) {
                            q.add(new int[] { i, child });
                        }
                    }
                }

                level++;
            }
            int ans = level * 2;
            if (node == 2)
                ans++;
            append(ans);
            // append(Math.max(f(graph, 1, -1, 0), f(graph, 1, -1, 1)));

            // for int array
            // int[] arr = in.readIntArray(n);

            // Input a 2D integer matrix
            // int[][] intMatrix = in.readIntMatrix(n, n);

        }
        print(res);
    }

    // static int f(ArrayList<ArrayList<Integer>> graph, int curr, int[] dp) {

    // int total = 0;
    // for (Integer i : graph.get(curr)) {

    // total += 1 + f(graph, i, dp);
    // }
    // dp[curr] = total;
    // return total;
    // }
    static int f(ArrayList<ArrayList<Integer>> graph, int curr, int parent, int status) {
        boolean check = false;
        for (Integer i : graph.get(curr)) {
            if (i != parent) {
                check = true;
                // f(graph, i, curr);
            }
        }
        if (!check)
            return 0;
        int count = 0;
        if (status == 0) {
            for (Integer i : graph.get(curr)) {
                if (i != parent) {
                    count += f(graph, i, curr, 1);
                }
            }
        } else {
            int min = Integer.MAX_VALUE;

            for (Integer i : graph.get(curr)) {
                if (i != parent) {
                    int c = 1 + f(graph, i, curr, 1);
                    count += c;
                    min = Math.min(c, min);
                }
            }
            count -= min;
        }
        return count;
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