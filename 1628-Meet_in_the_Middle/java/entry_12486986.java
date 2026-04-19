import java.io.*;
import java.util.*;
 
public class entry_12486986 {
    private static int mod = (int) 1e9 + 7;
 
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
 
        solve(sc);
        out.flush();
        out.close();
    }
 
    private static void solve(MyScanner sc) {
        int n = sc.nextInt();
        long k = sc.nextInt();
        int[] arr = readIntArray(sc, n);
 
        if (n > 1) {
            int tmp = arr[0];
            arr[0] = arr[1];
            arr[1] = tmp;
        }
 
        Arrays.sort(arr);
        int n1 = n / 2;
        int n2 = n - n1;
 
        long[] s1 = new long[1 << (n + 1) / 2];
        Map<Long, Long> c1 = new HashMap<>(1 << n1 ,1f);
        c1.put(0L, 1L);
        for (int i = 1; i < (1 << n1); i++) {
            int i1 = Integer.highestOneBit(i);
            int prev = i - i1;
            long sum = s1[prev] + arr[Integer.numberOfTrailingZeros(i1)];
            s1[i] = sum;
            if (sum > k) continue;
            c1.put(sum, c1.getOrDefault(sum, 0L) + 1);
        }
 
//        long[] s2 = new long[1 << n2];
//        Map<Long, Long> c2 = new HashMap<>();
 
//        c2.put(0L, 1L);
 
        for (int i = 0; i < s1.length; i++) {
            s1[0] = 0;
        }
        long total = c1.getOrDefault(k, 0L);
        for (int i = 1; i < (1 << n2); i++) {
            int i1 = Integer.highestOneBit(i);
            int prev = i - i1;
            long sum = s1[prev] + arr[n1 + Integer.numberOfTrailingZeros(i1)];
            s1[i] = sum;
            if (sum > k) continue;
            total += c1.getOrDefault(k - sum, 0L);
//            c2.put(sum, c2.getOrDefault(sum, 0L) + 1);
        }
 
//        for (long sum : c1.keySet()) {
//            total += c1.get(sum) * c2.getOrDefault(k - sum, 0L);
//        }
 
        out.println(total);
    }
 
    private static boolean check(int[] arr, int u, double mid) {
        for (int i = 0; i < arr.length - 2; i++) {
            double total = (arr[i + 1] - arr[i]) / (1 - mid);
 
            if (total > u) continue;
 
            int l = i + 1;
            int r = arr.length;
            while (l + 1 != r) {
                int m = (l + r) / 2;
                if (arr[m] - arr[i] < total) {
                    l = m;
                    continue;
                }
                if (arr[m] - arr[i] > u) {
                    r = m;
                    continue;
                }
                return true;
            }
        }
        return false;
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
 
        public MyScanner() {
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