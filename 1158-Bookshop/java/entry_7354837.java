import java.util.*;
import java.io.*;

public class entry_7354837 {
    static FastReader sc = new FastReader();

    public static PrintWriter pw = new PrintWriter(System.out);

    // static final int MOD = (int) 1e9 + 7;

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

    }

    public static <T> void print(T num) {
        if (num instanceof int[]) {
            pw.println(Arrays.toString((int[]) num));
        } else if (num instanceof long[]) {
            pw.println(Arrays.toString((long[]) num));
        } else if (num instanceof char[]) {
            pw.println(Arrays.toString((char[]) num));
        } else if (num instanceof String[]) {
            pw.println(Arrays.toString((String[]) num));
        } else if (num instanceof double[]) {
            pw.println(Arrays.toString((double[]) num));
        } else if (num instanceof boolean[]) {
            pw.println(Arrays.toString((boolean[]) num));
        } else {
            pw.println(num);
        }
    }

    public static void printMultiple(Object... inputs) {
        for (Object input : inputs) {
            pw.print(input + " ");
        }
        pw.println();
    }

    static <T> void printMap(Map<T, T> mp) {
        for (var e : mp.entrySet()) {
            printMultiple(e.getKey(), "->", e.getValue());
        }
    }

    static <T> void printSet(Set<T> set) {
        for (var e : set) {
            print(e);
        }
    }

    public static int[] intArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    public static long[] longArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        return arr;
    }

    public static double[] doubleArray(int n) {
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        return arr;
    }

    public static int upperBound(int[] arr, int key) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static int lowerBound(Pair[] arr, int key) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid].b >= key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static <T> void addOne(Map<T, Integer> mp, T value) {
        mp.put(value, mp.getOrDefault(value, 0) + 1);
    }

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] cost = intArray(n);
        int[] pages = intArray(n);
        int[] dp = new int[x + 1];
        int[] last = new int[x + 1];
        for (int i = 0; i < n; i++) {
            int[] curr = new int[x + 1];
            for (int j = 1; j <= x; j++) {
                if (cost[i] <= j) {
                    dp[j] = Math.max(last[j], pages[i] + last[j - cost[i]]);
                } else {
                    dp[j] = last[j];
                }
                curr[j] = dp[j];
            }
            last = curr;
        }

        print(dp[x]);
        pw.close();
    }
}