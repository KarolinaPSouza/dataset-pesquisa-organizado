import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;
import static java.lang.System.out;
import static java.lang.System.setProperty;
import static java.util.Arrays.sort;

public class entry_12602724 implements Runnable{

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

    public static long mod = (long) 1e9 + 7;
    public static int[] dx = new int[]{0, 0, 1, -1};
    public static int[] dy = new int[]{1, -1, 0, 0};
    public static char[] dir = new char[]{'R', 'L', 'D', 'U'};
    public static long[] dp;
    public static char[][] ch;
    public static Boolean[][] pathExists;
    public static int gx, gy;

    public static void main(String[] args) {
        new Thread(null, new entry_12602724(), "never say never", 1 << 26).start();
    }
    public void run(){
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int test = 1;
        while (test-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for( int i = 0; i <= n+1 ; i++ ) adj.add(new ArrayList<>());
            for( int i = 0; i < m ; i++ ) {
                int u = in.nextInt();
                int v = in.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            boolean[] visited = new boolean[adj.size()];
            if(!bfs(1, n, visited, adj)) out.println("IMPOSSIBLE");
        }
        out.flush();
        out.close();
    }
    public static boolean bfs( int root, int dest, boolean[] visited, ArrayList<ArrayList<Integer>> adj ) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 1}); // node, depth
        boolean possible = false;
        int[] precedentNode = new int[dest+1];
        while( !queue.isEmpty()) {
            int[] top = queue.poll();
            if( visited[top[0]] ) continue;
            visited[top[0]] = true;
            if( top[0] == dest ) {
                possible = true;
                out.println(top[1]);
                ArrayList<Integer> path = new ArrayList<>();
                Arrays.fill(visited, false);
                int node = dest;
                while( !visited[node] && node != precedentNode[1] ) {
                    path.add(node);
                    visited[node] = true;
                    node = precedentNode[node];
                }
                Collections.reverse(path);
                for( int nodee : path ) out.print(nodee + " ");
                out.println();
            }
            for( int node : adj.get(top[0])) {
                if( !visited[node]) {
                    queue.offer(new int[]{node, top[1] + 1});
                    if( precedentNode[node] == 0 ) precedentNode[node] = top[0];
                }
            }
        }
        return possible;
    }
    public static long findMinCost( long[] a, int i, int k, TreeMap<Long, Integer> pq, HashMap<Integer, Long> map ) {
        if( i == a.length-1) {
//            pq.offer(a[i]+1);
            pq.put(a[i]+1, pq.getOrDefault(a[i]+1, 0)+1);
            map.put(a.length-1, a[i]+1);
            return a[i]+1;
        }
        findMinCost(a, i+1, k, pq, map);
        Long top = pq.firstKey(); //
        if( i+1+k < a.length){
            long remove = map.get(i+k+1);
            pq.put(remove, pq.get(remove)-1);
            if( pq.get(remove) == 0 ) pq.remove(remove);
        }
        dp[i] = top+a[i]+1;
        map.put(i, dp[i]);
        pq.put(dp[i], pq.getOrDefault(dp[i], 0)+1);
        return dp[i];
    }
    public static void sortArray(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(list);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }

    // returns a boolean array of size r-l+1 where arr[i] returns true if (i+l) is prime otherwise false
    public static boolean[] segmentedSieve(long L, long R) { // argument : l = 0 and r = n
        long lim = (long) Math.sqrt(R);
        boolean[] mark = new boolean[(int) (lim + 1)];
        Arrays.fill(mark, false);
        List<Long> primes = new ArrayList<>();

        for (long i = 2; i <= lim; ++i) {
            if (!mark[(int) i]) {
                primes.add(i);
                for (long j = i * i; j <= lim; j += i)
                    mark[(int) j] = true;
            }
        }

        boolean[] isPrime = new boolean[(int) (R - L + 1)];
        Arrays.fill(isPrime, true);

        for (long i : primes) {
            for (long j = max(i * i, (L + i - 1) / i * i); j <= R; j += i)
                isPrime[(int) (j - L)] = false;
        }

        if (L == 1)
            isPrime[0] = false;

        return isPrime;
    }

    public static int findIndex(int[] a , int target ) {
        int low = 0; int high = a.length-1;
        int res = -1;
        while( low <= high ) {
            int mid = (low+high)/2;
            if( a[mid] >= target ) {
                res = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return res != -1 ? res : a.length-1;
    }
    public static int findIndexSmaller(int[] a , int target ) {
        int low = 0; int high = a.length-1;
        int res = -1;
        while( low <= high ) {
            int mid = (low+high)/2;
            if( a[mid] <= target ) {
                res = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return res != -1 ? res : a.length-1;
    }
    public static int findIndex( ArrayList<Integer> primes, int i ) {
        int low = 0; int high = primes.size()-1;
        int res = -1;
        while( low <= high ) {
            int mid = (low+high)/2;
            if( primes.get(mid) <= i ) {
                res = mid;
                low = mid+1;
            } else high = mid-1;
        }
        return res;
    }
    public static String binary( int a ) {
        String s = "";
        for( int i = 31; i >= 0; i-- ) {
            if((a&(1<<i)) > 0 ) s = s + '1';
            else if( s.length() > 0 )  s = s + '0';
        }
        return s;
    }
    public static void computeSPF( int[] spf, boolean[] primes ) {
        for( int i = 2; i <= (int)1e7; i++ ) spf[i] = 2;

        for( int i = 3; i < (int)1e7; i+=2 ) {
            if( primes[i] ) {
                spf[i] = i;
                for( long j = (long)i; j*i < (long)1e7; j += 2) {
                    if( primes[ (int)(i*j)]) {
                        primes[(int)(i*j)] = false;
                        spf[(int)(i*j) ] = i;
                    }
                }
            }
        }
    }
    public static boolean isPrime( int n ) {
        boolean prime = true;
        for( int i = 2; i * i <= n ; i++ ) {
            if( n % i == 0 ) prime = false;
        }
        return prime;

    }
    public static long gcd( long a, long b ) {
        if( b == 0 ) return a;
        return gcd(b, a % b );
    }
    public static long lcm(long a, long b ) {
        return a*b/gcd(a, b);
    }
    public static int[] findRange( int[][] b, int r, char ch, int c ) {
        r--;
        if( ch == '>' ) {
            // find bi, r > c
            int[] range = new int[2];
            range[1] = b.length-1;
            range[0] = -1;
            int n = b.length;
            int low = 0; int high = n-1;
//            out.println(low + " " + high);
            while( low <= high ) {
                int mid = (low+high)/2;
                if( b[mid][r] > c ) {
                    range[0] = mid;
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            }
            if( range[0] == -1 ) range[1] = -1;
            return range;
        }
        else {
            // find bi, r < c
            int[] range = new int[2];
            range[1] = -1;
            range[0] = 0;
            int n = b.length;
            int low = 0; int high = n-1;
            while( low <= high ) {
                int mid = (low+high)/2;
                if( b[mid][r] < c ) {
                    range[1] = mid;
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
            if( range[1] == -1 ) range[0] = -1;
            return range;
        }
    }
    public static long nCr( int n, int r ) {
        if( r > n ) return 0;
        // nCr = n!/r!*(n-r)
        long x = 1;
        for( int i = n-r+1; i <= n ; i++ ) x *= i;
        for(int i = 2; i <= r; i++ ) x /= i;
        return x;
    }
    public static int dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj ) {
        if( visited[i]) return -1;
        visited[i] = true;
        int leaf = -1;
        boolean allVisited = true;

        for( int neighbour : adj.get(i)) {
            if( !visited[neighbour]) allVisited = false;
            if( leaf == -1 ) leaf = dfs(neighbour, visited, adj);
            else {
                dfs(neighbour, visited, adj);
            }
        }
        return (adj.isEmpty() || allVisited) ? i : leaf;
    }
    public static int xor( int x, int y ) {
        int xor = 0;
        for( int i = 0; i < 32; i++ ) {
            if((((1<<i) & x)) > 0 || (((1<<i) & y)) > 0 && (!((((1<<i) & x)) > 0 && (((1<<i) & y)) > 0))) xor = xor | (1<<i);
        }
        return xor;
    }
    static final int MOD = (int)(1e9+7);
    static long[] fac = new long[200001];

    static long power(long x, long y, long p) {
        long res = 1;
        x %= p;

        while (y > 0) {
            if ((y & 1) != 0)
                res = (res * x) % p;
            y >>= 1;
            x = (x * x) % p;
        }
        return res;
    }

    static long modInverse(long n, long p) {
        return power(n, p - 2, p);
    }

    static long nCr(int n, int r, long p) {
        if (n < r)
            return 0;

        if (r == 0)
            return 1;

        return fac[n] * modInverse(fac[r], p) % p * modInverse(fac[n - r], p) % p;
    }

    static void computeFactorials() {
        fac[0] = 1;
        for (int i = 1; i < fac.length; i++)
            fac[i] = fac[i - 1] * i % MOD;
    }
}

class Pair<key, value> {
    // if in set/mao, it will check by equality
    private final key key;
    private final value value;

    public Pair(key key, value value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
    public key getKey() {
        return key;
    }
    public value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}