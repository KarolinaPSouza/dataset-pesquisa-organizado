import javax.swing.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.DecimalFormat;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class entry_1527701 {
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static long MOD = (long) (1e9 + 7);
    //static int MOD = 998244353;
    static long MOD2 = MOD * MOD;
    static Reader sc = new Reader();
    static int pInf = Integer.MAX_VALUE;
    static int nInf = Integer.MIN_VALUE;
    static long ded = (long)(1e16);
    public static void main(String[] args) throws Exception  {
        int test = 1;
        //test = sc.nextInt();
        while (test-- > 0) solve();
        out.flush();
        out.close();
    }
    static ArrayList<Integer>[] A;
    static int[] p;
    static boolean[] visited;
    static void solve() throws Exception {
        int n = sc.nextInt();
        int m = sc.nextInt();
        A = new ArrayList[n+1];
        p = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(p,-1);
        for(int i = 1; i <= n; i++){
            A[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            A[u].add(v);
            A[v].add(u);
        }
        for(int i = 1; i <= n; i++){
            if(!visited[i]&&!ans){
                dfs(i,0);
            }
            if(ans){
                return;
            }
        }
        out.println("IMPOSSIBLE");
    }
    static boolean ans = false;
    static void dfs(int u, int par){
        if(par!=0){
            p[u] = par;
        }
        visited[u] = true;
        for(int v: A[u]){
            if(v==par){
                continue;
            }
            if(visited[v]){
                p[v] = u;
                ans = true;
                ArrayList<Integer> ans = new ArrayList<>();
                int u2 = u;
                while((v^u)>0){
                    ans.add(u);
                    u = p[u];
                }
                ans.add(v);
                ans.add(u2);
                out.println(ans.size());
                for(int x:ans){
                    out.print(x+" ");
                }
                out.close();
                System.exit(0);
                return;
            }
            else{
                dfs(v,u);
            }
        }
    }
    public static long mul(long a, long b) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }
    public static long add(long a, long b) {
        return ((a % MOD) + (b % MOD)) % MOD;
    }
    public static long sub(long a, long b) {
        return ((a % MOD) - (b % MOD)) % MOD;
    }
    //Pair Class
    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        int idx;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
        @Override
        public int compareTo(Pair o) {
            if ((this.x == o.x)) {
                return (this.y - o.y);
            }
            return (this.x-o.x);
        }
    }
    static class TPair{
        long x;
        long y;
        public TPair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    //Shuffle Sort
    static final Random random = new Random();
    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
    //Brian Kernighans Algorithm
    static long countSetBits(long n) {
        if (n == 0) return 0;
        return 1 + countSetBits(n & (n - 1));
    }
    //Euclidean Algorithm
    static long gcd(long A, long B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
    //Modular Exponentiation
    static long fastExpo(long x, long n) {
        if (n == 0) return 1;
        if ((n & 1) == 0) return fastExpo((x * x) % MOD, n / 2) % MOD;
        return ((x % MOD) * fastExpo((x * x) % MOD, (n - 1) / 2)) % MOD;
    }
    //AKS Algorithm
    static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(n); i += 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;
        return true;
    }
    public static long modinv(long x) {
        return modpow(x, MOD - 2);
    }
    public static long modpow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long x = modpow(a, b / 2);
        x = (x * x) % MOD;
        if (b % 2 == 1) {
            return (x * a) % MOD;
        }
        return x;
    }

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
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
}