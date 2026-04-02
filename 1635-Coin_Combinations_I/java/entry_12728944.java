import java.io.*;
import java.util.*;

public class entry_12728944 {
    private static int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        solve(sc);
        out.flush();
        out.close();
    }

    private static void solve(MyScanner sc) {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = readIntArray(sc, n);

        int[] memo = new int[x + 1];
        memo[0] = 1;

        for (int i = 0; i <= x; i++) {
            if (memo[i] == 0) continue;
            for (int coin : coins) {
                if (i + coin > x) continue;

                memo[i + coin] += memo[i];
                memo[i + coin] %= mod;
            }
        }
        out.print(memo[x]);
    }

    private static void add(TreeMap<Integer, Integer> lower, int val) {
        lower.compute(val, (k, v) -> (v == null) ? 1 : v + 1);
//        lower.put(val, lower.getOrDefault(val, 0) + 1);
    }

    private static void remove(TreeMap<Integer, Integer> lower, int val) {
        lower.compute(val, (k, v) -> v - 1);

        if (lower.get(val) == 0) {
            lower.remove(val);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        if (arr.length <= Math.max(a, b)) return;

        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static int GCD(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        return Math.max(a, b);
    }

    private static int[] readIntArray(MyScanner sc, int size) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = sc.nextInt();
        }
        return res;
    }

    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() throws Exception {
//            br = new BufferedReader(new FileReader("./src/test_input.txt"));
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

}