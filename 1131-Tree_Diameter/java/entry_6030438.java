import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_6030438 {
    final static private FastReader fr = new FastReader();
    final static private PrintWriter out = new PrintWriter(System.out);
    final static long mod = (long)1e9+7;
    static void solve() throws IOException {
        int n = fr.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n+1] ;
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>() ;
        }
        int[] freq = new int[n+1] ;
        for(int i = 1; i < n; i++){
            int u = fr.nextInt();
            int v = fr.nextInt();
            freq[u]++;
            freq[v]++;
            adj[u].add(v) ;
            adj[v].add(u) ;
        }

        if(n == 1){
            out.println(0);
            return;
        }

        int srcFreq = 0, src =0 ;
        for(int i = 1; i <= n; i++){
            if(srcFreq < freq[i]){
                srcFreq = freq[i];
                src = i ;
            }
        }
        int[] ans = {0} ;
        getHeight(adj, src, ans, -1) ;
        out.println(ans[0]);
    }

    static int getHeight(
            ArrayList<Integer>[] adj,
            int node, int[] ans, int par
    ){
        if(adj[node].size() == 0){
            return 1;
        }
        int maxHeight = 0, sMaxHeight = 0 ;
        for(int nbr: adj[node]){
            if(nbr == par)
                continue;
            int height = getHeight(adj, nbr, ans, node) ;
            if(maxHeight < height){
                sMaxHeight = maxHeight;
                maxHeight = height;
            } else if(sMaxHeight < height){
                sMaxHeight = height;
            }
        }
        ans[0] = Math.max(ans[0], maxHeight+sMaxHeight) ;
        return maxHeight + 1 ;
    }
    public static void main(String[] args) throws IOException {
        int t = 1;
        //t = fr.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    private static int[] inputArr(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
        }
        return arr;
    }
    private static void prefixSum(long[] arr) {
        for (int i = 1; i < arr.length; i++)
            arr[i] += arr[i - 1];
    }
    private static void sort(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int x : arr) {
            al.add(x);
        }
        Collections.sort(al);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = al.get(i);
        }
    }
    private static void sort(long[] arr) {
        ArrayList<Long> al = new ArrayList<>();
        for (long x : arr) {
            al.add(x);
        }
        Collections.sort(al);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = al.get(i);
        }
    }
    static void rev(long[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            long temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    private static long getMax(long... a) {
        long max = Long.MIN_VALUE;
        for (long x : a) max = Math.max(x, max);
        return max;
    }
    private static long getMin(long... a) {
        long max = Long.MAX_VALUE;
        for (long x : a) max = Math.min(x, max);
        return max;
    }
    private static long fastPower(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) != 0) ans *= a;
            a *= a;
            b >>= 1;
        }
        return ans;
    }
    private static long fastPower(long a, long b, long mod) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) != 0) ans = (ans % mod * a % mod) % mod;
            b >>= 1;
            a = (a % mod * a % mod) % mod;
        }
        return ans;
    }
    private static int upper_bound(long[] arr, long key) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] <= key) start = mid + 1;
            else end = mid;
        }
        return start;
    }
    private static int lower_bound(long[] arr, long key) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] >= key) {
                end = mid;
            } else start = mid + 1;
        }
        return start;
    }
    private static class Pair {
        long a;
        long b ;
        Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }
    }
    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
    private static boolean isPrime(int num) {
        if (num <= 2) return true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    private static HashSet<Integer> seive(int n) {
        // all are false by default
        // false -> prime, true -> composite
        boolean[] nums = new boolean[n + 1];
        HashSet<Integer> primes = new HashSet<>();

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!nums[i]) {
                primes.add(i);
                for (int j = i * i; j <= n; j += i) {
                    nums[j] = true;
                }
            }
        }
        return primes;
    }
    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
//    private static class FastReader {
//        BufferedReader br;
//        StringTokenizer st;
//        public FastReader() {
//            br = new BufferedReader(
//                    new InputStreamReader(System.in));
//        }
//        String next() {
//            while (st == null || !st.hasMoreElements()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        long nextLong() {
//            return Long.parseLong(next());
//        }
//
//        double nextDouble() {
//            return Double.parseDouble(next());
//        }
//
//        String nextLine() {
//            String str = "";
//            try {
//                str = br.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
static class FastReader
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public FastReader()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException
    {
        if (din == null)
            return;
        din.close();
    }
    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do
        {
            ret = ret * 10 + c - '0';
        }  while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }
}
    static class SegmentTree {
        long[] seg ;
        void build(int[] arr, int low, int high, int ind) {
            if (low == high) {
                seg[ind] = arr[low] ;
                return ;
            }
            int mid = low + ((high - low)>>1) ;
            build(arr, low, mid, 2 * ind + 1) ;
            build(arr, mid+1, high, 2 * ind + 2);
            seg[ind] = seg[2*ind+1] ^ seg[2*ind+2];
        }

        SegmentTree(int n){
            seg = new long[4 * n] ;
        }

        long query(int l, int h, int low, int high, int ind) {
            if (high < l || low > h)
                return 0;

            if (l <= low && high <= h)
                return seg[ind] ;

            int mid = low + ((high - low)>>1) ;
            long left = query(l, h, low, mid, 2 * ind + 1) ;
            long right = query(l, h, mid + 1, high, 2 * ind + 2) ;

            return left ^ right ;
        }

        void pointUpdate(int low, int high, int ind, int indToUpdate,int val){
            if(low == high){
                seg[ind] = val ;
                return ;
            }
            int mid = low + ((high-low)>>1) ;
            if(indToUpdate <= mid) {
                pointUpdate(low, mid, 2 * ind + 1, indToUpdate, val);
            } else {
                pointUpdate(mid + 1, high, 2 * ind + 2,indToUpdate, val);
            }
            seg[ind] = seg[2*ind+1] ^ seg[2*ind+2] ;
        }
    }
}