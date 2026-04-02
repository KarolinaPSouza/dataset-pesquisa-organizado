import java.io.*;
import java.util.*;

public class entry_11890776 {

    public static void solve() {
        long n = in.nextLong(), ans = 0;
        int k = in.nextInt();
        long[] arr = in.nextLongs(" ");
        int N = (1 << k);

        for (int i = 1; i < N; i++) {
            long mul = 1;
            for (int j = 0; j < k; j++)
                if ((i & (1 << j)) > 0) {
                    if (n / mul < arr[j]) {
                        mul = n + 1;
                        break;
                    }

                    mul *= arr[j];

                }
            if (mul > n)
                continue;
            ans += (n / mul) * (Long.bitCount(i) % 2 == 1 ? 1 : -1);
        }
        out.println(ans);
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

        int[] nextInts(String regex) {
            String[] line = nextLine().split(regex);
            return Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        }

        long[] nextLongs(String regex) {
            String[] line = nextLine().split(regex);
            return Arrays.stream(line).mapToLong(Long::parseLong).toArray();
        }

    }

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        // int q = in.nextInt();
        // while (q-- > 0) {
        solve();
        // }
        out.close();
    }
}