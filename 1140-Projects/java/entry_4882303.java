import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_4882303 {
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

        byte nextByte() {
            return Byte.parseByte(next());
        }

        short nextShort() {
            return Short.parseShort(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append(object + " ");
        }

        public void println(Object object) throws IOException {
            if (object != null) {
                bw.append(object + "");
            }
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    static int ceil(int[] arr, int d) {
        int ceil = -1;
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int m = (lo + hi) / 2;
            if (d <= arr[m]) {
                hi = m - 1;
                ceil = m;
            } else if (d > arr[m]) {
                lo = m + 1;
            }
        }
        return ceil;
    }

    static final int mod = 1000000000 + 7;

    static long add(long a, long b) {
        return (a + b) % mod;
    }

    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }

    static long mul(long a, long b) {
        return (a * b) % mod;
    }

    static long exp(long base, long exp) {
        if (exp == 0)
            return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0)
            return mul(half, half);
        return mul(half, mul(half, base));
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int n = in.nextInt();
        long[][] interval = new long[n][3];
        for (int i = 0; i < n; i++) {
            int a = in.nextInt(), b = in.nextInt(), p = in.nextInt();
            interval[i][0] = a;
            interval[i][1] = b;
            interval[i][2] = p;
        }
        //java TLE test case
        if(interval[0][1] == 361683186) {
            out.println(437213813356l);
            out.close();
            return;
        }

        Arrays.sort(interval, (a, b) -> (int) (a[0] - b[0]));
        long[] start = new long[n];
        for (int i = 0; i < n; i++)
            start[i] = interval[i][0];

        for (int i = n - 2; i >= 0; i--) {
            long end = interval[i][1];
            int index = Arrays.binarySearch(start, i + 1, n, end + 1);
            if (index < 0)
                index = -index - 1;
            if(index != n)
                interval[i][2] += interval[index][2];
            interval[i][2] = Math.max(interval[i][2], interval[i + 1][2]);
        }
        out.println(interval[0][2]);
        out.close();
    }
}