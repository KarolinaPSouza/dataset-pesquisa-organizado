/*
سبحان الله
والحمدلله
ولا إله إلا الله
ولا حول ولا قوة إلا بالله
والله أكبر
اللهم صلِ وسلم على نبينا محمد
 */

import java.util.*;
import java.io.*;

public class entry_10576865 {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    static final int mod = 1000000007;
    static int n,x;
    static int[] c ;
    static int[]dp;
//-----------------------------------------------------------------------------
    public static void main (String[] args ) throws IOException {

n = sc.nextInt() ; x = sc.nextInt();
c = sc.nextIntArray(n);
dp = new int[x+1];
dp[0]=1;

for (int i = 1 ; i<=x ; i++){
    for (int j = 0 ; j<n ; j++){
        if (i>=c[j]){
            dp[i] +=dp[i-c[j]];
            dp[i] %=mod;
        }
    }
}

pw.print(dp[x]);







    pw.flush();
}
//-----------------------------------------------------------------------------


static int coincomb(int i){
     if (dp[i]!=-1)return dp[i];
dp[i]=0;
     for (int j = 0 ; j<n ; j++){
         if (i>=c[j]) {
             dp[i] += coincomb(i - c[j]) % mod ;
         }
    }
 return dp[i];
}






//---------------Methods to use------------------------------------------------
    public static void fordiv() throws IOException {
    int t = sc.nextInt();
    while (t-- > 0) {



    }
}
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    static boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }
    public static long[] prefix_sum (long[] a){
        long[] out = new long[a.length];
        out[0] = a[0];
        for (int i = 1; i < a.length; i++)
            out[i] = out[i - 1] + a[i];
        return out;
    }
    public static int[] prefix_sum(int[] a){
        int[] out = new int[a.length];
        out[0] = a[0];
        for(int i = 1 ; i <a.length ; i++)
            out[i] = out[i-1] + a[i];
        return out;
    }

    static void inialize(LinkedList[] arr){
        for (int i = 0 ; i<arr.length ; i++)
            arr[i]=new LinkedList<>();
    }
    static boolean[] visited;
    static LinkedList<Integer>[] adj;
    static void dfs(int node){

        visited[node]=true;

        for (int i : adj[node]){
            if (!visited[i]){
                dfs(i);
            }
        }
    }
    static void bfs(int node){
        Queue<Integer> qu = new LinkedList<>();

        qu.add(node);

        while (!qu.isEmpty()){

            int curr = qu.poll();
            visited[curr]=true;
            for (int i : adj[curr]){
                if (!visited[i]){
                    qu.add(i);
                }
            }

        }
    }

//-----------------------------------------------------------------------------
    // Class : Pair
    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }


        public String toString() {
            return "{" + this.x + ", " + this.y + "}";
        }

        @Override
        public int compareTo(Pair other) {

            return (this.x == other.x) ?   (this.y -other.y) :  (this.x -other.x);
        }
    }

    // Class : Scanner
    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(String file) throws IOException {
            br = new BufferedReader(new FileReader(file));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String readAllLines(BufferedReader reader) throws IOException {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
            return content.toString();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        public Long[] nextlongArray(int n) throws IOException {
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
    }
