//package codeforces;

import java.io.*;
import java.util.*;

public class entry_3037700 {
    //    private final static FastScanner scanner = new FastScanner();
    private final static Reader scanner = new Reader();
    private static final int[][] fourWayDirections = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final int[][] eightWayDirection = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    private final static long M = 1000000007L;

    public static void main(String[] args) throws IOException {
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            solve();
//        }
        solve();
    }

    public static void solve() throws IOException {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            adjList[u].add(v);
            adjList[v].add(u);
        }
        int[] ans = new int[n];
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)){
                boolean result = mark(i, visited, ans, adjList);
                if (!result){
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }

        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();
    }

    static boolean mark(int curr, Set<Integer> visited, int[] ans, List<Integer>[] adjList){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{curr, 1});
        ans[curr] = 1;
        visited.add(curr);
        while (!queue.isEmpty()){
            int[] front = queue.poll();
            for (Integer to : adjList[front[0]]) {
                if (ans[to] == front[1]){
                    return false;
                }else{
                    if (!visited.contains(to)){
                        visited.add(to);
                        ans[to] = front[1] == 1 ? 2 : 1;
                        queue.add(new int[]{to, ans[to]});
                    }
                }
            }
        }
        return true;
    }

    static boolean isItOutside(int i, int j, int[][] grid) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }

    static boolean isItOutside(int i, int j, char[][] grid) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }

    static int __gcd(int a, int b) {
        return b == 0 ? a : __gcd(b, a % b);
    }

    static int gcdOfArray(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        int a = arr[idx];
        int b = gcdOfArray(arr, idx + 1);
        return __gcd(
                a, b);
    }

    public static long getManhattanDistance(long x1, long y1, long x2, long y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    static void swap(int[][] arr, int l, int r) {
        int[] temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    static void swap(long[] arr, int l, int r) {
        long temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private static int getTickSize(char[][] mat, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == '.') return 0;
        mat[i][j] = '.';
        return Math.min(getTickSize(mat, i - 1, j - 1), getTickSize(mat, i - 1, j + 1));
    }

    private static Boolean isSquare(long x) {
        long y = (long) Math.sqrt(x);
        return y * y == x;
    }

    private static int getMax(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy[arr.length - 1];
    }

    private static double customLog(double logNumber, double base) {
        return Math.log(logNumber) / Math.log(base);
    }


    static int checkSim(String n1, String n2, int i, int j) {
        if (i >= n1.length() || j >= n2.length()) return 0;
        if (n1.charAt(i) == n2.charAt(j)) return 1 + checkSim(n1, n2, i + 1, j + 1);
        return checkSim(n1, n2, i + 1, j);
    }

    static int computeXOR(int n) {
        if (n % 4 == 0)
            return n;
        if (n % 4 == 1)
            return 1;
        if (n % 4 == 2)
            return n + 1;
        return 0;
    }

    static boolean isPowerOfTwo(long n) {
        if (n == 0)
            return false;

        double v = Math.log(n) / Math.log(2);
        return (long) (Math.ceil(v)) == (long) (Math.floor(v));
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        else if (n == 2)
            return true;

        else if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static boolean checkSorted(int[] arr) {
        return arr[0] == arr[arr.length - 1];
    }

    static void print(int from, int to) {
        if (from <= to) {
            for (int i = from; i <= to; i++) {
                System.out.print(i + " ");
            }
        } else {
            System.out.print(from + " ");
            for (int i = 1; i <= to; i++) {
                System.out.print(i + " ");
            }
        }
    }

    static long moduloMultiplication(long a, long b, long mod) {
        long res = 0;
        a %= mod;
        while (b > 0) {
            if ((b & 1) > 0) {
                res = (res + a) % mod;
            }
            a = (2 * a) % mod;
            b >>= 1;
        }
        return res;
    }

    static long moduloPower(long x, long y, long p) {
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if ((y & 1) > 0)
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }
        return res % p;
    }

    static int lowerBound(long a[], long x) { // x is the target value or key
        int l = -1, r = a.length;
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (a[m] >= x) r = m;
            else l = m;
        }
        return r;
    }

    static int upperBound(long a[], long x) {// x is the key or target value
        int l = -1, r = a.length;
        while (l + 1 < r) {
            int m = (l + r) >>> 1L;
            if (a[m] <= x) l = m;
            else r = m;
        }
        return l + 1;
    }

    static long upperBound(long[] arr, int start, int end, long k) {
        int N = end;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (k >= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start < N && arr[start] <= k) {
            start++;
        }
        return start;
    }

    static long lowerBound(long[] arr, int start, int end, long k) {
        int N = end;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (k <= arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (start < N && arr[start] < k) {
            start++;
        }
        return start;
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static int sumOfNNaturalNumbers(int n) {
        return (n * (n + 1)) / 2;
    }

    static long sumOfNNaturalNumbers(long n) {
        return (n * (n + 1)) / 2;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        {
//            try {
//                br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\shind\\IdeaProjects\\ds\\src\\main\\java\\codeforces\\input.txt")));
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }

        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}