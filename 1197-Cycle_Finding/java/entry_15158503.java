import java.io.*;
import java.util.*;

public class entry_15158503 {

    private static final long MINA = 1;
    private static final long MAXA = 1000000000000L;
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static PrintWriter writer;

    static int MOD = (int) (1e9 + 7);
    static final int MOD1 = 998244353;

    public static Scanner scanner = new Scanner(System.in);

    public static boolean flag1 = true, flag2 = true;
    private static int[] p;
    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        tokenizer = new StringTokenizer("");
//        int n = nextInt();
        int n = 1;
//        for (int i = 1; i <= 50; i++) {
//            writer.println(i+" "+p[i]);
//        }
        while (n-- > 0) {
//            printArr(p);
            solve();
        }

        writer.close();
    }





    public static void solve2() throws IOException {
        int t = nextInt();
        long[] arr = new long[1000002];
        long[] brr = new long[1000002];
        arr[1] = 1;
        brr[1] = 1;
        int[] dp = new int[1000002];

        for (int i = 2; i < 1000002; i++) {
            arr[i] = (arr[i-1]*2 + brr[i-1])%MOD;
            brr[i] = (4*brr[i-1] + arr[i-1])%MOD;
        }

        while (t-- > 0) {
            int n = nextInt();
            writer.println((arr[n]+brr[n])%MOD);
        }

    }
    public static void solve() throws IOException {
        int n = nextInt(), m = nextInt();
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = nextInt(), v = nextInt(), c = nextInt();
            edges.add(new int[]{u, v, c});
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE / 4);
        dist[1] = 0;
        Arrays.fill(dist, 0);

        int[] par = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            for (int[] e : edges) {
                int u = e[0], v = e[1], c = e[2];
                if (dist[u] != Long.MAX_VALUE / 4 && dist[u] + c < dist[v]) {
                    dist[v] = dist[u] + c;
                    par[v] = u;
                }
            }
        }

        boolean isCycle = false;
        int node = -1;
        for (int[] e : edges) {
            int u = e[0], v = e[1], c = e[2];
            if (dist[u] != Long.MAX_VALUE / 4 && dist[u] + c < dist[v]) {
                isCycle = true;
                node = v;
                par[v] = u;
                break;
            }
        }

        if (!isCycle) {
            writer.println("NO");
            return;
        }

        for (int i = 0; i < n; i++) node = par[node];

        ArrayList<Integer> cycle = new ArrayList<>();
        int curr = node;
        do {
            cycle.add(curr);
            curr = par[curr];
        } while (curr != node);
        cycle.add(node);
        Collections.reverse(cycle);

        writer.println("YES");
        for (int x : cycle) writer.print(x + " ");
    }




    public static int[] find(long[] arr1, int l, long[] arr2, int m, int k) {

        int low = Math.max(0, k - m);
        int high = Math.min(k, l);

        while (low <= high) {
            int i = (low + high) >> 1;
            int j = k - i - 2;
            if (j<0){
               high = i - 1;
                continue;
            }
            long l1  = (i >= l) ? Long.MIN_VALUE : arr1[i];
            long r1 = (i+1 >= l) ? Long.MAX_VALUE : arr1[i+1];
            long l2  = (j >= m) ? Long.MIN_VALUE : arr2[j];
            long r2 = (j+1 >= m) ? Long.MAX_VALUE : arr2[j+1];

            if (l1 >= r2 && l2 >= r1) {
                return  new int[]{i, j};
            } else if (l1 < r2) {
                low = i + 1;
            } else {
                high = i - 1;
            }
        }

        return new int[]{};
    }


    public static long findKth(long[] arr1, int l, long[] arr2, int m, int k) {
        // Always binary search on smaller prefix for efficiency
//        if (l > m) return findKthLargest(arr2, m, arr1, l, k);

        int low = Math.max(0, k - m);
        int high = Math.min(k, l);

        while (low <= high) {
            int i = (low + high) / 2;  // elements taken from arr1
            int j = k - i;             // elements taken from arr2

            long Aleft  = (i == 0) ? Long.MIN_VALUE : arr1[i - 1];
            long Aright = (i == l) ? Long.MAX_VALUE : arr1[i];
            long Bleft  = (j == 0) ? Long.MIN_VALUE : arr2[j - 1];
            long Bright = (j == m) ? Long.MAX_VALUE : arr2[j];

            if (Aleft >= Bright && Bleft >= Aright) {
                return  Math.max(Aleft, Bleft); // kth largest
            } else if (Aleft < Bright) {
                low = i + 1;
            } else {
                high = i - 1;
            }
        }

        return -1L; // should never happen
    }
    public static int fun(int i, List<int[]> list, int n, int[] dp) {
        if( i >= n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int take = -1, ntakte = -1;
        int[] arr = list.get(i);
        int st = arr[1], ed = arr[2], wt = arr[0];

        ntakte = fun(i+1, list, n, dp);
        take = 0;
        int lb = i+1, ub = n-1, ans = n;
        while (lb <= ub){
            int mid = (lb+ub)>>1;
            int[] tem = list.get(mid);
            if (tem[1] > ed) {
                ans = mid;
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        take = wt + fun(ans, list, n, dp);
//        if(ans < n ){
//
//        }
        return dp[i] = Math.max(take, ntakte);
    }


    public static void dfs(int[] curr, int[] p, char[][] lists, boolean[][] vis, int[][] ans) {
        int x = curr[0], y = curr[1];
        vis[curr[0]][curr[1]] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int[] dir = new int[2];
        if (lists[x][y] == 'D'){
            dir[0] = 1;
            dir[1] = 0;
        } else if (lists[x][y] == 'U') {
            dir[0] = -1;
            dir[1] = 0;
        } else if (lists[x][y] == 'R') {
            dir[0] = 0;
            dir[1] = 1;
        } else if (lists[x][y] == 'L') {
            dir[0] = 0;
            dir[1] = -1;
        }else {
            return;
        }

        int nx = x + dir[0], ny = y + dir[1];

        if (nx < 0 || ny < 0 || nx >= lists.length || ny >= lists[0].length) {
            return;
        }
        if (vis[nx][ny]) {
            ans[nx][ny] = ans[x][y];
            return;
        }

    }
    public static int largestProperDivisor(int n) {
        if (n <= 1) return -1;

        // smallest divisor (excluding 1) gives the largest proper divisor as n / that
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return n / i;
            }
        }

        // If n is prime
        return 1;
    }


    public static boolean fun(int l, int n, int k, String s) {
        int ct = 0;
        for (int i = 1; i < n; i++) {
            int el = s.charAt(i) - '0', pel = s.charAt(i - 1) - '0';
            if(el < pel) {
                ct++;
            }
            if(ct >= l && k != 0) {
                ct = 0;
                k--;
                i++;
            }
        }

        return ct >= l && k == 0;
    }

    public static ArrayList<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        ArrayList<Integer> tem = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                tem.add(i);
            }
        }

        return tem;
    }
//    public static boolean isPrime(int n) {
//        if (n <= 1) return false;
//        if (n <= 3) return true;
//        if (n % 2 == 0 || n % 3 == 0) return false;
//        for (int i = 5; i * i <= n; i += 6) {
//            if (n % i == 0 || n % (i + 2) == 0) return false;
//        }
//        return true;
//    }
    public static int fun(int n, int[] st, ArrayList<int[]> ans){

        return 0;
    }

    public static long lcm(long a, long b) {
        return Math.abs(a * b) / gcd(a, b);
    }
    public static boolean isPS(long n){
        long r = (long) Math.sqrt(n);
        return r*r==n;
    }

    static void dfs(int curr, int p, int[] par, ArrayList<ArrayList<Integer>> lists, int[] dist) {
      par[curr] = p;
      for (int e: lists.get(curr)){
          if (e==p)continue;
          dist[e] = dist[curr] + 1;
          dfs(e, curr, par, lists, dist);
      }
    }

    private static int smallestMissingBit(int x) {
        for (int j = 0; j < 30; j++) {
            if (((x >> j) & 1) == 0) return j;
        }
        return 30; // if x == 2^30 - 1.
    }

    public static void solv() throws IOException {
        int n = nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = nextIntArray(n);
        }

    }

    public static boolean isPowerLogarithmic(int x, int y) {
        if (x <= 0 || y <= 0 || y == 1) return false; // Edge cases

        double logResult = Math.log(x) / Math.log(y);
        return Math.abs(logResult - Math.round(logResult)) < 1e-10;
    }


    /*
      */

    private static int ask(int l, int r) throws IOException {
        if (r - l + 1 <= 1)
            return 0;
        writer.println(String.valueOf("? ") + String.valueOf(l) + " " + String.valueOf(r));
        writer.flush();
        return nextInt();
    }

    public static int leftmostBit(int n) {
        return (int) Math.pow(2, (int) (Math.log(n) / Math.log(2)));
    }

    public static int leftmostBit(long n) {
        return (int) Math.pow(2, (long) (Math.log(n) / Math.log(2)));
    }

    public static int  gcdOfArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            if (result == 1)
                break; // Early exit if GCD is 1
        }
        return result;
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static List<Integer> findDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i); // Add the divisor
                if (i != n / i) { // Avoid duplicate for perfect squares
                    divisors.add(n / i);
                }
            }
        }

        // Optional: Sort the divisors if needed
        divisors.sort(Integer::compareTo);
        return divisors;
    }

    public static long[] unique(long[] arr) {
        int n = arr.length;
        ArrayList<Long> l1 = new ArrayList<>();
        l1.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                continue;
            } else {
                l1.add(arr[i]);
            }
        }
        n = l1.size();
        long[] tem = new long[n];
        for (int i = 0; i < n; i++) {
            tem[i] = l1.get(i);
        }
        return tem;
    }

    public static void reverseArray(long[] array) {
        int start = 0, end = array.length - 1;
        while (start < end) {
            long temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static <T> void printArr(int[] arr) {
        for (int e : arr) {
            writer.print(e + " ");
        }
        writer.println();
    }

    public static void printArr(long[] arr) {
        for (long e : arr) {
            writer.print(e + " ");
        }
        writer.println();
    }

    private static int lowerBound(long[] arr, long target, int start, int end) {
        int left = start, right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // Binary search for the last index where arr[index] <= target
    private static int upperBound(long[] arr, long target, int start, int end) {
        int left = start, right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
//        if (arr[right]>target)return -1;
        return right;
    }

    public static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" + "key=" + key + ", value=" + value + '}';
        }
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static String nextLine() throws IOException {
        return reader.readLine();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static int[] nextIntArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        return arr;
    }

    // Function to read the next array of longs
    static long[] nextLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }
        return arr;
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}