import java.util.*;
import java.io.*;
import java.lang.Math;

public class entry_9973550 {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = 1;
        while (t > 0) {
            t--;
            problemSolver();
        }
        out.close();
    }

    public static void problemSolver() {
        // Code Solver

        // HashMap<Long, Long> mp = new HashMap<>();
        // HashSet<Long> s1 = new HashSet<>();
        // List<Integer> ls = new ArrayList<>();
        // NavigableSet<Integer> se = new TreeSet<>();
        // StringBuilder sb = new StringBuilder();

        int n = readInt();
        // long x = readLong();
        int a[] = new int[n - 1];
        intArr(a, n - 1);
        List<List<Integer>> lt = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lt.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            lt.get(a[i]).add(i + 2);
        }
        int sub[] = new int[n + 1];
        dfs(1, lt, sub);
        for (int i = 1; i <= n; i++) {
            out.print((sub[i] - 1) + " ");
        }
        out.println();
        // long n = readLong();
        // String s = readWord();
        // long a[] = new long[n];
        // longArr(a, n);
        // int MOD = 1000000007;
        // PriorityQueue<Integer> pq = new PriorityQueue<>(n);
        // int n=s.length();
        // Arrays.sort(a);
        // int pre[]=new int[n];
        // long ans=0;
        // int x = minI(a, n);
        // int y = maxI(a, n);
        // boolean flag=true;
        // Arrays.sort(p, Comparator.comparingInt(Pair::getY));
        // boolean flag = true;

        // printArr(a, n);
        // pYes(flag);
        // out.println();

    }

    public static void dfs(int node, List<List<Integer>> lt, int[] sub) {
        for (int i : lt.get(node)) {
            dfs(i, lt, sub);
            sub[node] += sub[i];
        }
        sub[node] += 1;
    }

    public static int[] lastGreatest(long[] a) {
        int n = a.length;
        int[] b = new int[n];
        Arrays.fill(b, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] <= a[i])
                stack.pop();
            if (!stack.isEmpty())
                b[i] = stack.peek();
            stack.push(i);
        }
        return b;
    }

    static long findIntersection(int intervals[][], int N) {
        int l = intervals[0][0];
        int r = intervals[0][1];
        for (int i = 1; i < N; i++) {
            if (intervals[i][0] > r ||
                    intervals[i][1] < l) {
                return 0l;
            } else {
                l = Math.max(l, intervals[i][0]);
                r = Math.min(r, intervals[i][1]);
            }
        }
        long ans = 0;
        for (long i = l; i <= r; i++) {
            ans += i;
        }
        return ans;
    }

    public static void sieve_of_eratosthenes(int n, HashSet<Long> s, List<Integer> k) {
        boolean[] is_prime = new boolean[n + 1];
        Arrays.fill(is_prime, true);
        is_prime[0] = is_prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (is_prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    is_prime[i] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (is_prime[i]) {
                long h = (long) i;
                h *= h;
                s.add(h);
                k.add(i);
            }
        }
    }

    public static int findSmallestX(long l) {
        if (l <= 1) {
            return 0; // Because 2^0 = 1 which is the smallest power of 2
        }
        double logBase2 = Math.log(l) / Math.log(2);
        return (int) Math.ceil(logBase2);
    }

    public static void init(long dp[][]) {
        long h = 1;
        for (int i = 1; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = h;
            }
            h *= 9;
        }
        return;
    }

    public static boolean palin(long num) {
        String numStr = Long.toString(num);
        return numStr.equals(new StringBuilder(numStr).reverse().toString());
    }

    static int search(long arr[], int n, long m) {
        int ind = -1;
        int start = 0;
        int end = n - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] >= m) {
                ind = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ind;
    }

    public static void removeLeadingZeros(StringBuilder input) {
        int i = 0;
        while (i < input.length() && input.charAt(i) == '0') {
            i++;
        }
        input.delete(0, i);
    }

    static int binarySearch(List<Pair> sortedListOfPairs, long target) {
        int left = 0;
        int right = sortedListOfPairs.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedListOfPairs.get(mid).getY() == target) {
                return mid; // Found the target
            } else if (sortedListOfPairs.get(mid).getY() < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }

    static int freq(int[] arr, int n) {

        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int element : arr) {
            uniqueElements.add(element);
        }
        int c = uniqueElements.size();
        return c;
    }

    static int missing(int[] arr, int n) {
        int x = arr[0];
        for (int i = 1; i < n; i++) {
            x = x ^ arr[i];
        }
        for (int i = 1; i <= n; i++) {
            x = x ^ i;
        }
        return x;
    }

    static void preMax(long[] arr, long[] prefixMax) {
        int n = arr.length;
        prefixMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }
    }

    static void preSum(long[] arr, long[] prefixSum) {
        int n = arr.length;
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
    }

    static void sufSum(long[] arr, long[] suffixSum) {
        int n = arr.length;
        suffixSum[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i];
        }
    }

    static boolean vowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        else
            return false;
    }

    static int findMaxCharFrequency(String input) {
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

        // Count the frequency of each character
        for (char ch : input.toCharArray()) {
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Find the maximum frequency
        int maxFrequency = 0;
        for (int frequency : charFrequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        return maxFrequency;
    }

    static boolean sorted(long a[], int i, int j) {
        for (int h = i; h < j; h++) {
            if (a[h] > a[h + 1])
                return false;
        }
        return true;
    }

    static boolean prime(int n) {
        boolean prime = true;
        if (n % 2 == 0 && n != 2) {
            prime = false;
        } else {
            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) {
                    prime = false;
                }
            }
        }
        return (prime);
    }

    static long minL(long a[], int n) {
        long m = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] < m)
                m = a[i];
        }
        return m;
    }

    static long maxL(long a[], int n) {
        long m = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] > m)
                m = a[i];
        }
        return m;
    }

    static int minI(int a[], int n) {
        int m = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] < m)
                m = a[i];
        }
        return m;
    }

    static int maxI(int a[], int n) {
        int m = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] > m)
                m = a[i];
        }
        return m;
    }

    static long sum(long x) {
        long sum = 0;
        while (x > 0) {
            sum = sum + x % 10;
            x = x / 10;
        }
        return sum;
    }

    static void pYes(boolean flag) {
        if (flag)
            out.println("YES");
        else
            out.println("NO");
    }

    static void intArr(int a[], int n) {
        for (int i = 0; i < n; i++) {
            a[i] = readInt();
        }
    }

    static void longArr(long a[], int n) {
        for (int i = 0; i < n; i++) {
            a[i] = readLong();
        }
    }

    static void printArr(int a[], int n) {
        for (int i = 0; i < n; i++) {
            out.print(a[i] + " ");
        }
        out.println();
    }

    static void printArrL(long a[], int n) {
        for (int i = 0; i < n; i++) {
            out.print(a[i] + " ");
        }
        out.println();
    }

    static long sumL(long a[], int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
        }
        return sum;
    }

    static int sumI(int a[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
        }
        return sum;
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    static int readInt() {
        return sc.nextInt();
    }

    static long readLong() {
        return sc.nextLong();
    }

    static double readDouble() {
        return sc.nextDouble();
    }

    static String readString() {
        return sc.nextLine();
    }

    static String readWord() {
        return sc.next();
    }
}

class FastReader {
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
            if (st.hasMoreTokens()) {
                str = st.nextToken("\n");
            } else {
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}

class Pair {
    private int x;
    private long y;

    public Pair(int x, long y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Triplet {
    private int x;
    private int y;
    private int z;

    public Triplet(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Triplet triplet = (Triplet) o;
        return x == triplet.x && y == triplet.y && z == triplet.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}

class LList {
    int v;
    LList next;
    LList prev;

    public LList(int val) {
        v = val;
        next = null;
        prev = null;
    }

    void connect(LList b) {
        next = b;
        b.prev = this;
    }

    void insert(LList b) {
        b.next = next;
        if (next != null)
            next.prev = b;
        next = b;
        b.prev = this;
    }

    void disconnect(LList b) {
        next = b.next;
        if (b.next != null)
            b.next.prev = this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v, next, prev);
    }
}