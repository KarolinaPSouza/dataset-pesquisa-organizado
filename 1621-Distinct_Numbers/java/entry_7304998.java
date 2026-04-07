import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class entry_7304998 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static PrintWriter pw = new PrintWriter(System.out);

    private static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    private static String nextLine() {
        String s = "";
        try {
            if (st != null && st.hasMoreTokens())
                s = st.nextToken("\n");
            else
                s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    private static int nextInt() {
        return Integer.parseInt(next());
    }

    private static int[] nextIntArr(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextInt();
        }
        return res;
    }

    private static long[] nextLongArr(int n) {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextLong();
        }
        return res;
    }

    private static long nextLong() {
        return Long.parseLong(next());
    }

    private static double nextDouble() {
        return Double.parseDouble(next());
    }

    private static void printf(String format, Object... args) {
        pw.printf(format, args);
    }

    private static void print(Object o) {
        pw.print(o);
    }

    private static void println() {
        pw.println();
    }

    private static void println(Object o) {
        pw.println(o);
    }

    private static void println(int[] a) {
        for (int i : a) {
            printf("%d ", i);
        }
        println();
    }

    private static void println(int[][] a) {
        for (int[] i : a) {
            println(i);
        }
        println();
    }

    private static void println(long[] a) {
        for (long i : a) {
            printf("%d ", i);
        }
        println();
    }

    private static void println(long[][] a) {
        for (long[] i : a) {
            println(i);
        }
        println();
    }

    private static void close() {
        pw.flush();
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.close();
    }









    public static void main(String[] args) {
        int t = 1;
        //t = nextInt();
        while (t-- > 0) {
            solve();
        }
        close();
    }

    private static void sort(int[] a) {
        List<Integer> b = new ArrayList<>();
        for (int el : a) {
            b.add(el);
        }
        Collections.sort(b);
        for (int i = 0; i < a.length; i++) {
            a[i] = b.get(i);
        }
    }

    private static void solve() {
        int n = nextInt();
        int[] a = nextIntArr(n);
        sort(a);
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i - 1]) {
                cnt++;
            }
        }
        println(cnt);
    }

    // private static void solve() {
    //     int n = nextInt();
    //     Set<Integer> uniq = new HashSet<>();
    //     for (int i = 0; i < n; i++) {
    //         uniq.add(nextInt());
    //     }
    //     println(uniq.size());
    // }

    // Array sorting then counting give TLE on one test...
    // ArrayList is ok
}