import java.io.*;
import java.util.*;

public class entry_16018183 {

    static final long MOD = 1_000_000_007;

    // Segment tree start
    public static long findSum(int si, int ei, int i, int qi, int qj) {
        if (si >= qi && ei <= qj) {
            return sum[i];
        } else if (ei < qi || si > qj) {
            return 0;
        } else {
            int mid = si + (ei - si) / 2;
            long l = findSum(si, mid, 2 * i + 1, qi, qj);
            long r = findSum(mid + 1, ei, 2 * i + 2, qi, qj);
            return l + r;
        }
    }

    public static long[] sum;

    public static void createTree(int[] arr) {
        sum = new long[4 * arr.length];
        create(arr, 0, arr.length - 1, 0);
    }

    public static void create(int[] arr, int si, int ei, int i) {
        if (si == ei) {
            sum[i] = arr[si];
            return;
        }
        int mid = si + (ei - si) / 2;
        create(arr, si, mid, 2 * i + 1);
        create(arr, mid + 1, ei, 2 * i + 2);
        sum[i] = sum[2 * i + 1] + sum[2 * i + 2];
    }

    // Mathematical functions
    public static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        long sqrt = (long) Math.sqrt(number);
        for (long i = 5; i <= sqrt; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int ceil(int a, int b) {
        if (a % b == 0) {
            return a / b;
        } else {
            return (a / b) + 1;
        }
    }

    public static long ceil(long a, long b) {
        if (a % b == 0) {
            return a / b;
        } else {
            return (a / b) + 1;
        }
    }

    public static int flor(int a, int b) {
        if (a % b == 0) {
            return a / b;
        } else {
            return a / b - 1;
        }
    }

    public static long power(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans *= a;
            }
            a *= a;
            b >>= 1;
        }
        return ans;
    }

    public static long power_mod(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return ans;
    }

    static final int SIZE = 1_000_00;
    private static long[] fact = new long[SIZE + 1];
    private static boolean[] isPrime = new boolean[SIZE + 1];

    public static long add_mod(long a, long b) {
        return ((a % MOD) + (b % MOD)) % MOD;
    }

    public static long sub_mod(long a, long b) {
        return (((a % MOD) - (b % MOD)) + MOD) % MOD;
    }

    public static long multiply_mod(long a, long b) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    public static long inv(long a) {
        return power_mod(a, MOD - 2);
    }

    public static long divide_mod(long a, long b) {
        return multiply_mod(a, inv(b));
    }

    public static long nCr(long n, long r) {
        if (n < r) {
            return 0;
        }
        return divide_mod(fact[(int) n], multiply_mod(fact[(int) r], fact[(int) (n - r)]));
    }

    public static long nPr(long n, long r) {
        if (n < r) {
            return 0;
        }
        return divide_mod(fact[(int) n], fact[(int) (n - r)]);
    }

    public static void preFactorial() {
        fact[0] = 1;
        for (int i = 1; i <= SIZE; i++) {
            fact[i] = multiply_mod(i, fact[i - 1]);
        }
    }

    public static void Sieve_Of_Eratosthenes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= SIZE; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= SIZE; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    public static long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static long max(long x, long y) {
        return Math.max(x, y);
    }

    public static long min(long x, long y) {
        return Math.min(x, y);
    }

    public static int max(int x, int y) {
        return Math.max(x, y);
    }

    public static int min(int x, int y) {
        return Math.min(x, y);
    }

    // Fast Reader and Writer
    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) {
                        return null; // or throw new RuntimeException("No more input");
                    }
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }


        int Int() {
            return Integer.parseInt(next());
        }

        long Long() {
            return Long.parseLong(next());
        }

        double Double() {
            return Double.parseDouble(next());
        }

        String Line() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {

        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void p(Object object) throws IOException {
            bw.append(String.valueOf(object));
        }

        public void pln(Object object) throws IOException {
            p(object);
            bw.append("\n");

        }

        public void y() throws IOException {
            pln("YES");
            // bw.append("\n");
        }

        public void n() throws IOException {
            pln("NO");
            // bw.append("\n");
        }

        public void nxt() throws IOException {
            bw.append("\n");
        }

        public void arr(long[] arr) throws IOException {
            for (long value : arr) {
                p(value + " ");
            }
            bw.append("\n");
        }

        public void arr(int[] arr) throws IOException {
            for (int value : arr) {
                p(value + " ");
            }
            bw.append("\n");
        }

        public void lst(List<Long> lst) throws IOException {
            for (long value : lst) {
                p(value + " ");
            }
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    public static void arrInput(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.Int();
        }
    }

    public static void arrInput(long arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.Long();
        }
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder("");
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if(low>= arr.length) {
            low = arr.length-1;
        }
        return low;
    }
    public static long sumInput(int arr[]){
        long sum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = in.Int();
            sum+= arr[i];
        }
        return sum;
    }

    static FastReader in;
    static FastWriter p;

    public static void copyArr(int a[] , int b[] , int c[]){
        for(int i = 0 ; i < c.length ; i++){
            if(i < a.length){
                c[i] = a[i];
            }
            else{
                c[i] = b[i%a.length];
            }
        }
    }
    public static void revercer(int arr[] , int si , int end){
        arr[si] = end+1;
        for(int i = si +1 ; i < end+1 ; i++){
            arr[i] = i;
        }
    }
    public static int countBit(int num){
        int bit = 0;
        while(num != 0){
            bit++;
            num = num >> 1;
        }
        return bit;
    }

    static class edges{
        int src ;
        int dest ;
        edges(int src , int dest ){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void main(String[] args) throws IOException {
        in = new FastReader();
        p = new FastWriter();
        // int test = in.Int();
        // while(test-->0){
        // }
        // p.close();
        int m = in.Int();
        int n = in.Int();
        int grid[][] = new int[m][n];
        for(int i = 0 ; i < grid.length ; i++){
            String s = in.next();
            for(int j = 0 ; j < grid[0].length ; j++){
                grid[i][j] = s.charAt(j) == '#' ? 0 : 1; 
            }
        }   
        int count = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }    
    public static void dfs(int[][] grid , int r , int c ){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0){
            return;
        }
        grid[r][c] = 0;
        dfs(grid,r-1,c);
        dfs(grid,r,c-1);
        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
    }
}