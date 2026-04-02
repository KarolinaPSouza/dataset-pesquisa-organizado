import java.util.*;
import java.io.*;

public class entry_11579348 {
    static FastReader in = new FastReader();
    // static final Random random = new Random();
    static final int mod = (int) 1e9 + 7;
    static StringBuilder res;
    static int[][] ans = new int[2][1000001];

    public static void main(String[] args) throws IOException {
        res = new StringBuilder();

        int t = 1;
        while (t-- > 0) {
            String a = in.nextLine();
            String b = in.nextLine();
            int alen = a.length();
            int blen = b.length();
            // int[][] dp = new int[alen + 1][blen + 1];
            int[] prev = new int[blen + 1];
            for (int i = 0; i <= blen; i++)
                prev[i] = i;
            for (int i = 1; i <= alen; i++) {
                int[] curr = new int[blen + 1];
                curr[0] = i;
                for (int j = 1; j <= blen; j++) {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        // dp[i][j] = dp[i - 1][j - 1];
                        curr[j] = prev[j - 1];
                    } else {
                        curr[j] = 1 + Math.min(prev[j], Math.min(curr[j - 1], prev[j - 1]));
                        // dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j -
                        // 1]));
                    }
                }
                for (int j = 0; j <= blen; j++) {
                    prev[j] = curr[j];
                }
            }
            append(prev[blen]);
            // int[] prev= new int[alen];
            // for(int i=0;i<alen;i++){
            // prev[i]=++i;
            // }
            // boolean flag= false;
            // for(int i=0;i<alen;i++){
            // if(flag==false && a.charAt(i)==b.charAt(0) ){
            // flag=true;
            // while(i<alen){
            // prev[i]--;
            // i++;
            // }
            // break;
            // }
            // }
            // for(int i=1;i<blen;i++){
            // int[] curr= new int[alen];
            // for(int j=)
            // }

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