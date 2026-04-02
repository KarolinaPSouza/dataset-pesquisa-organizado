import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_6030295 {
    final static private FastReader fr = new FastReader();
    final static private PrintWriter out = new PrintWriter(System.out);
    final static long mod = (long)1e9+7;
    static void solve(){
        int n = fr.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n+1] ;
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>() ;
        }
        int[] indegree = new int[n+1] ;
        for(int i = 2; i <= n; i++){
            int par = fr.nextInt();
            adj[i].add(par) ;
            indegree[par]++;
        }
        Queue<Integer> q = new LinkedList<>() ;
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                q.add(i) ;
            }
        }
        int[] ans = new int[n] ;
        while (!q.isEmpty()){
            int node = q.poll();
            for(int nbr: adj[node]){
                ans[nbr-1] += (ans[node-1]+1) ;
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr) ;
                }
            }
        }
        for(int ele: ans){
            out.print(ele+" ");
        }
        out.println();
    }

    static void dfs(ArrayList<Integer>[] adj, int node, int[] ans){
        for(int nbr: adj[node]){
            dfs(adj, nbr, ans) ;
            ans[node-1] += (ans[nbr-1] + 1) ;
        }
    }

    public static void main(String[] args) {
        int t = 1;
        //t = fr.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    private static long[] inputArr(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextLong();
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
    private static class FastReader {
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
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
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