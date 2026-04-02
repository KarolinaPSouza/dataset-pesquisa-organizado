import java.io.*;
import java.util.*;
import java.util.function.Function;

public class entry_15262337 {
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
//        int tt = nint();
        int tt = 1;
        for (int i = 1; i <= tt; i++) {
            solve(i);
        }
        out.close();
    }

    private static void solve(int idx) {
        int n = nint(), x = nint();
        int[] arr = readIntArr(n);

        int MOD = 1_000_000_007;
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int c : arr) {
            for (int i = c; i <= x; i++) {
                dp[i] = (dp[i] + dp[i - c]) % MOD;
            }
        }

        out.println(dp[x]);
    }

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
    }

    public static int nint() {
        return scanner.nextInt();
    }

    public static long nlong() {
        return scanner.nextLong();
    }

    public static double ndouble() {
        return scanner.nextDouble();
    }

    public static String nline() {
        return scanner.nextLine();
    }

    public static int[] readIntArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nint();
        }
        return arr;
    }

    public static long[] readLongArr(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nlong();
        }
        return arr;
    }

    public static long power(long a, long b, long mod) {
        if (b == 0) {
            return 1 % mod;
        }
        long c = power(a, b / 2, mod);
        if (b % 2 == 0) {
            return (c * c) % mod;
        }
        return (((c * c) % mod) * a) % mod;
    }

    public static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    public static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        System.arraycopy(arr, left, temp, left, right - left + 1);

        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) arr[k++] = temp[i++];
        while (j <= right) arr[k++] = temp[j++];
    }
}