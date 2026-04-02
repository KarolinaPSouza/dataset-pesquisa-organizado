import java.util.*;
import java.io.*;

public class entry_13157218 {
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
            long sum = in.nextLong();
            HashMap<Long, int[]> map = new HashMap<>();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = i;
            }
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        map.put((long) arr[i][0] + arr[j][0], new int[] { i, j });
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (flag)
                    break;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        long csum = (long) arr[i][0] + arr[j][0];
                        if (map.containsKey(sum - csum)) {
                            int[] curr = map.get(sum - csum);
                            if (curr[0] != i && curr[0] != j && curr[1] != i && curr[1] != j) {
                                appendSpace(arr[i][1] + 1);
                                appendSpace(arr[j][1] + 1);
                                appendSpace(arr[curr[0]][1] + 1);
                                appendSpace(arr[curr[1]][1] + 1);
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }

            // while (start < end && (long) arr[start] + arr[end] >= sum) {
            // start++;
            // end--;
            // }
            // boolean flag = false;
            // if (end - start <= 1) {
            // append("IMPOSSIBLE");
            // flag = true;
            // continue;
            // } else {
            // int curr = start;
            // for (; curr < n - 2; curr++) {
            // if (flag)
            // break;
            // int s = curr + 1;
            // int e = n - 1;
            // while (s < e) {
            // if ((long) arr[s] + arr[e] == sum - arr[curr]) {
            // appendSpace(curr);
            // flag = true;
            // appendSpace(s);
            // appendSpace(e);
            // break;
            // } else if ((long) arr[s] + arr[e] > sum - arr[curr])
            // e--;
            // else
            // s++;
            // }
            // }
            // }
            if (!flag)
                append("IMPOSSIBLE");
            // for int array
            // int[] arr = in.readIntArray(n);

            // Input a 2D integer matrix
            // int[][] intMatrix = in.readIntMatrix(n, n);

        }
        print(res);
    }

    static boolean func(long mid, int[] arr, long total) {
        long curr = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += mid / arr[i];
            if (curr >= total)
                return true;
        }
        return false;

    }

    static int index(ArrayList<int[]> arr, int num) {
        int start = 0;
        int end = arr.size() - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid)[0] < num) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
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