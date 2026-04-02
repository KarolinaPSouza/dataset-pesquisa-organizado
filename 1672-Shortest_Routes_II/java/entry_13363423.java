// import java.util.*;
// import java.io.*;

// public class entry_13363423 {
//     static FastReader in = new FastReader();
//     // static final Random random = new Random();
//     static final int MOD = (int) 1e9 + 7;
//     static StringBuilder res;

//     public static void main(String[] args) throws IOException {
//         res = new StringBuilder();
//         int t = 1;
//         while (t-- > 0) {
//             // for single integer
//             int n = in.nextInt();
//             int q = in.nextInt();
//             int m = in.nextInt();
//             long[][] matrix = new long[n + 1][n + 1];
//             for (long[] i : matrix)
//                 Arrays.fill(i, (long) 1e14);
//             for (int i = 1; i <= n; i++)
//                 matrix[i][i] = 0L;
//             for (int i = 0; i < q; i++) {
//                 int u = in.nextInt();
//                 int v = in.nextInt();
//                 int d = in.nextInt();
//                 matrix[u][v] = Math.min(matrix[u][v], d);
//                 matrix[v][u] = Math.min(matrix[v][u], d);
//             }
//             int iter = 1;
//             for (int i = 1; i <= n; i++) {
//                 for (int j = iter; j <= n; j++) {
//                     for (int k = 1; k <= n; k++) {
//                         matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
//                         matrix[j][i] = Math.min(matrix[i][j], matrix[j][i]);

//                     }
//                 }

//             }
//             for (int i = 0; i < m; i++) {
//                 long val = matrix[in.nextInt()][in.nextInt()];
//                 if (val == (long) 1e14)
//                     append(-1);
//                 else
//                     append(val);
//             }

//             // for int array
//             // int[] arr = in.readIntArray(n);

//             // Input a 2D integer matrix
//             // int[][] intMatrix = in.readIntMatrix(n, n);

//         }
//         print(res);
//     }

//     static int modAdd(int a, int b, int mod) {
//         return ((a % mod) + (b % mod)) % mod;
//     }

//     static int modSub(int a, int b, int mod) {
//         return ((a % mod) - (b % mod) + mod) % mod;
//     }

//     static int modMul(int a, int b, int mod) {
//         return (int) (((long) a * b) % mod);
//     }

//     static int modPow(int base, int exp, int mod) {
//         int res = 1;
//         while (exp > 0) {
//             if ((exp & 1) == 1) {
//                 res = modMul(res, base, mod);
//             }
//             base = modMul(base, base, mod);
//             exp >>= 1;
//         }
//         return res;
//     }

//     static int gcd(int a, int b) {
//         return b == 0 ? a : gcd(b, a % b);
//     }

//     static int lcm(int a, int b) {
//         return a / gcd(a, b) * b;
//     }

//     static <E> void print(E res) {
//         System.out.println(res);
//     }

//     static <E> void append(E s) {
//         res.append(s + "\n");
//     }

//     static <E> void appendSpace(E s) {
//         res.append(s + " ");
//     }

//     static <E> void appendLine() {
//         res.append("\n");
//     }

//     static class FastReader {
//         BufferedReader br;
//         StringTokenizer st;

//         public FastReader() {
//             br = new BufferedReader(new InputStreamReader(System.in));
//         }

//         String next() {
//             while (st == null || !st.hasMoreElements()) {
//                 try {
//                     st = new StringTokenizer(br.readLine());
//                 } catch (IOException e) {
//                     e.printStackTrace();
//                 }
//             }
//             return st.nextToken();
//         }

//         int nextInt() {
//             return Integer.parseInt(next());
//         }

//         long nextLong() {
//             return Long.parseLong(next());
//         }

//         double nextDouble() {
//             return Double.parseDouble(next());
//         }

//         String nextLine() {
//             String str = "";
//             try {
//                 str = br.readLine();
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//             return str;
//         }

//         int[] readIntArray(int n) {
//             int[] res = new int[n];
//             for (int i = 0; i < n; i++) {
//                 res[i] = nextInt();
//             }
//             return res;
//         }

//         long[] readLongArray(int n) {
//             long[] res = new long[n];
//             for (int i = 0; i < n; i++) {
//                 res[i] = nextLong();
//             }
//             return res;
//         }

//         int[][] readIntMatrix(int rows, int cols) {
//             int[][] matrix = new int[rows][cols];
//             for (int i = 0; i < rows; i++) {
//                 for (int j = 0; j < cols; j++) {
//                     matrix[i][j] = nextInt();
//                 }
//             }
//             return matrix;
//         }

//         char[][] readCharMatrix(int rows, int cols) {
//             char[][] matrix = new char[rows][cols];
//             for (int i = 0; i < rows; i++) {
//                 String line = next();
//                 for (int j = 0; j < cols; j++) {
//                     matrix[i][j] = line.charAt(j);
//                 }
//             }
//             return matrix;
//         }
//     }
// }

import java.util.*;
import java.io.*;

public class entry_13363423 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        // Initialize distance matrix with "infinity"
        long[][] dist = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE / 2); // Avoid overflow during addition
            dist[i][i] = 0; // Distance to self is 0
        }

        // Process roads
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            // There might be multiple roads between cities, keep the shortest
            dist[a][b] = Math.min(dist[a][b], c);
            dist[b][a] = Math.min(dist[b][a], c); // Two-way road
        }

        // Floyd-Warshall algorithm to find all shortest paths
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // Process queries
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (dist[a][b] == Long.MAX_VALUE / 2) {
                sb.append("-1\n");
            } else {
                sb.append(dist[a][b]).append("\n");
            }
        }

        System.out.print(sb);
    }
}