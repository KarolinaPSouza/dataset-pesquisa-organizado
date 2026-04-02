import java.io.*;
import java.util.*;

@SuppressWarnings("unused")
public class entry_14248723 {

    static FastReader in = new FastReader();
    static FastWriter out = new FastWriter();

    // Common constants
    static final int MOD = 1000000007;
    static final int INF = Integer.MAX_VALUE;
    static final long LINF = Long.MAX_VALUE;
    static final double EPS = 1e-9;

    public static void main(String[] args) throws IOException {
        int t = 1;
        // t = in.nextInt(); // Uncomment for multiple test cases

        while (t-- > 0) {
            solve();
        }

        out.flush();
    }

    static void solve() throws IOException {
        int n = in.nextInt();
        long x = in.nextLong();
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextLong();
            arr[i][1] = i + 1;
        }

        Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));

        Map<Long, long[]> sumMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sum = arr[i][0] + arr[j][0];
                long target = x - sum;

                if (sumMap.containsKey(target)) {
                    long[] p = sumMap.get(target);
                    long a = arr[i][1], b = arr[j][1];
                    long c = p[0], d = p[1];
                    if (a != c && a != d && b != c && b != d) {
                        out.print(a + " " + b + " " + c + " " + d);
                        return;
                    }
                }
            }

            for (int k = 0; k < i; k++) {
                long sum = arr[k][0] + arr[i][0];
                sumMap.putIfAbsent(sum, new long[]{arr[k][1], arr[i][1]});
            }
        }

        out.print("IMPOSSIBLE");
    }

    // ==================== SORTING ALGORITHMS ====================
    /**
     * Merge Sort - O(n log n) stable sort
     */
    static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, k);
    }

    /**
     * Merge Sort for long arrays
     */
    static void mergeSort(long[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    static void mergeSort(long[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(long[] arr, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, k);
    }

    /**
     * Counting Sort - O(n + k) where k is range of values Use when values are
     * in small range
     */
    static void countingSort(int[] arr, int maxVal) {
        int[] count = new int[maxVal + 1];

        // Count frequencies
        for (int val : arr) {
            count[val]++;
        }

        // Reconstruct array
        int idx = 0;
        for (int i = 0; i <= maxVal; i++) {
            while (count[i]-- > 0) {
                arr[idx++] = i;
            }
        }
    }

    // ==================== BINARY SEARCH ====================
    /**
     * Binary search - returns index of target or -1 if not found
     */
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Lower bound - first element >= target
     */
    static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    /**
     * Upper bound - first element > target
     */
    static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // ==================== COORDINATE COMPRESSION ====================
    /**
     * Compress coordinates and return mapping
     */
    static int[] compress(int[] coords) {
        int[] sorted = coords.clone();
        Arrays.sort(sorted);

        // Remove duplicates
        int unique = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                sorted[unique++] = sorted[i];
            }
        }

        return Arrays.copyOf(sorted, unique);
    }

    // ==================== MATHEMATICAL UTILITIES ====================
    /**
     * Fast exponentiation - O(log n)
     */
    static long power(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }

    /**
     * GCD using Euclidean algorithm
     */
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * LCM
     */
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    /**
     * Check if number is prime - O(sqrt(n))
     */
    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Sieve of Eratosthenes - O(n log log n)
     */
    static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, 2, n + 1, true);

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    // ==================== ARRAY UTILITIES ====================
    /**
     * Reverse array
     */
    static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Check if array is sorted
     */
    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Find maximum element
     */
    static int max(int[] arr) {
        int max = arr[0];
        for (int val : arr) {
            max = Math.max(max, val);
        }
        return max;
    }

    /**
     * Find minimum element
     */
    static int min(int[] arr) {
        int min = arr[0];
        for (int val : arr) {
            min = Math.min(min, val);
        }
        return min;
    }

    /**
     * Sum of array elements
     */
    static long sum(int[] arr) {
        long sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return sum;
    }

    // ==================== BINARY INDEXED TREE ====================
    /**
     * Binary Indexed Tree (Fenwick Tree) for range sum queries
     */
    static class BIT {

        private int[] tree;
        private int n;

        public BIT(int size) {
            n = size;
            tree = new int[n + 1];
        }

        public void update(int i, int delta) {
            for (; i <= n; i += i & -i) {
                tree[i] += delta;
            }
        }

        public int query(int i) {
            int sum = 0;
            for (; i > 0; i -= i & -i) {
                sum += tree[i];
            }
            return sum;
        }

        public int rangeQuery(int left, int right) {
            return query(right) - query(left - 1);
        }
    }

    // ==================== GRAPH UTILITIES ====================
    /**
     * DFS template
     */
    static void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    /**
     * BFS template
     */
    static void bfs(List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    // ==================== FAST I/O ====================
    static class FastReader {

        private final int BUFFER_SIZE = 1 << 16;
        private final byte[] buffer = new byte[BUFFER_SIZE];
        private int bufferPointer = 0, bytesRead = 0;
        private final InputStream inputStream;

        public FastReader() {
            inputStream = System.in;
        }

        public FastReader(String fileName) throws IOException {
            inputStream = new FileInputStream(fileName);
        }

        private byte read() throws IOException {
            if (bufferPointer >= bytesRead) {
                bytesRead = inputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1) {
                    return -1;
                }
            }
            return buffer[bufferPointer++];
        }

        public String next() throws IOException {
            byte c = read();
            while (c <= ' ') {
                c = read();
            }

            StringBuilder sb = new StringBuilder();
            do {
                sb.append((char) c);
            } while ((c = read()) > ' ');

            return sb.toString();
        }

        public String nextLine() throws IOException {
            byte[] buf = new byte[1024];
            int cnt = 0, c;
            while ((c = read()) != -1 && c != '\n') {
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }

            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return neg ? -ret : ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }

            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return neg ? -ret : ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }

            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            return neg ? -ret : ret;
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        public void close() throws IOException {
            inputStream.close();
        }
    }

    static class FastWriter {

        private final BufferedWriter writer;

        public FastWriter() {
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public FastWriter(String fileName) throws IOException {
            writer = new BufferedWriter(new FileWriter(fileName));
        }

        public void print(Object obj) throws IOException {
            writer.write(obj.toString());
        }

        public void println(Object obj) throws IOException {
            writer.write(obj.toString());
            writer.newLine();
        }

        public void println() throws IOException {
            writer.newLine();
        }

        public void flush() throws IOException {
            writer.flush();
        }

        public void close() throws IOException {
            writer.close();
        }
    }
}