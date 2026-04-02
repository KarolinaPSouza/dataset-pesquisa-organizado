import java.util.*;
import java.io.*;

public class entry_12940381 {
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
            int[] arr = in.readIntArray(n);
            long sum = Integer.MIN_VALUE;
            long curr = Integer.MIN_VALUE;
            for (int i : arr) {
                curr = Math.max(curr + i, i);
                sum = Math.max(sum, curr);
            }
            append(sum);
            // TreeMap<Integer, Integer> map = new TreeMap<>();
            // for (int i = 0; i < n; i++) {
            // int a = in.nextInt();
            // int b = in.nextInt() + 1;
            // map.put(a, map.getOrDefault(a, 0) + 1);
            // map.put(b, map.getOrDefault(b, 0) - 1);
            // // map.put(in.nextInt(), -1); 3-1 4-1 5-1 6- -1 9- -1 10- -1
            // }
            // int count = 0;
            // int curr = 0;
            // ArrayList<Integer> list = new ArrayList<>();
            // for (Integer i : map.keySet()) {
            // curr += map.get(i);
            // list.add(curr);
            // }
            // if (list.size() < 3) {
            // append(1);
            // continue;
            // }
            // for (int i = 1; i < list.size() - 1; i++) {
            // if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1))
            // count++;
            // }
            // System.out.println(list);
            // append(count);

            // for int array
            // int[] arr = in.readIntArray(n);

            // Input a 2D integer matrix
            // int[][] intMatrix = in.readIntMatrix(n, n);

        }
        print(res);
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