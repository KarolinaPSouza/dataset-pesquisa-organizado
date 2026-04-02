import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
public class entry_9195696 {
    public static void ArrayInput(String [] Seq, FastReader fr){
        for(int i=0; i<Seq.length; i++){
            Seq[i] = fr.next();
        }
    }
    public static void ArrayInput(int [][] Seq, FastReader fr){
        for(int i=0; i<Seq.length; i++){
            for(int j=0; j<Seq[0].length; j++){
                Seq[i][j] = fr.nextInt();
            }
        }
    }
    public static void ArrayInput(int [] Seq, FastReader fr){
        for(int i=0; i<Seq.length; i++){
            Seq[i] = fr.nextInt();
        }
    }

    static StringBuilder p = new StringBuilder();
    static int ans = 0;
    public static boolean dfs(int curr, int parent, HashMap<Integer, List<Integer>> adj, int [] vis, int len, Stack<Integer> path){
        vis[curr] = len;
        adj.putIfAbsent(curr, new ArrayList<>());
        path.add(curr);
        for(int neighbor : adj.get(curr)){
            if(neighbor == parent) continue;

            if(vis[neighbor] == 0){
                boolean temp = dfs(neighbor, curr, adj, vis, len+1, path);
                if(temp) return true;
            } else {
                if(len - vis[neighbor] >= 2){
                    ans = len - vis[neighbor] + 2;
                    p.append(neighbor + " ");
                    while (path.peek() != neighbor){
                        p.append(path.pop() + " ");
                    }
                    p.append(neighbor);
                    return true;
                }
            }
        }
        path.pop();
        return false;
    }
    //    ---------------------------------------------MAIN CODE-------------------------------------------------
    public static void  Solve(FastReader fr, PrintWriter out) {
        int n = fr.nextInt();
        int m = fr.nextInt();
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0; i<m; i++){
            int u = fr.nextInt();
            int v = fr.nextInt();
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int [] vis = new int [n+1];
        for(int i=1; i<=n; i++){
            if(vis[i] == 0){
                boolean curr = dfs(i, -1, adj, vis, 1, new Stack<>());
                if(curr){
                    out.println(ans);
                    out.println(p.toString());
                    return;
                }
            }
        }
        out.println("IMPOSSIBLE");
    }

    public static long XorTillN(long n){
        if(n % 4L == 0L) return n;

        if(n % 4L == 1L) return 1;

        if(n % 4L == 2L) return n+1L;

        return 0L;
    }

    public static long RangedXOR(long a, long b){
        long X1 = XorTillN(a);
        long X2 = 0L;
        if(b-1L >= 0){
            X2 = XorTillN(b-1L);
        }

        X1 ^= X2;
        return X1;
    }
    static long [] fact = new long [200007];
    static long inv [] = new long[200007];

    public static void Factorials(){
        fact[0] = 1;
        fact[1] = 1;
        inv[0] = 1;
        inv[1] = BinaryExpo(1, MOD - 2);
        for(int i=2; i<200007; i++){
            fact[i] = ModMul(i, fact[i-1]);
            inv[i] = ModMul(inv[i-1], BinaryExpo(i, MOD-2));
        }
        return;
    }

    public static long nCr(int a, int b){
        if(a < b || b < 0){
            return 0L;
        }
        if(b == 0){
            return 1L;
        }
        long ans = fact[a];
        long denominator = ModMul(inv[b], inv[a-b]) % MOD;
        ans = ModMul(ans, denominator) % MOD;
        return ans;
    }
    public static void main(String args[]) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        //        Factorials();
//            int t = fr.nextInt();
//            while (t-- > 0) {
        Solve(fr, out);
//            }
        out.close();
    }

    //    -------------------------------------------------------------------------------------------------------

    //    ---------------------------------------GCD OF TWO NUMBERS-----------------------------------------------
    public static int gcd(int a, int b){
        if(a == 0){
            return b;
        }

        return gcd(b % a, a);
    }

    //    ----------------------------------LCM OF TWO NUMBERS------------------------------------------------
    public static int LCM(int a, int b){
        return  (a * b) / gcd(a, b);
    }

    //    ----------------------------LOWER BOUND-------------------------------------------------
    static int LowerBound(long [] arr, long target){
        int s = 0, e = arr.length-1;
        int index = -1;
        while (s <= e){
            int mid = s + (e - s) / 2;
            if(arr[mid] > target){
                e = mid - 1;
            } else {
                index = mid;
                s = mid +  1;
            }
        }
        return index;
    }

    //    ----------------------------UPPER BOUND-------------------------------------------------
    static int UpperBound(long [] arr, long target){
        int s = 0, e = arr.length-1;
        int index = -1;
        while (s <= e){
            int mid = s + (e - s) / 2;
            if(arr[mid] >= target){
                index = mid;
                e = mid - 1;
            } else {
                s = mid +  1;
            }
        }
        return index;
    }

    //    -----------------------------x ^ y binary exponentiation-----------------------------------------
    static long BinaryExpo(long x, long y) {
        if (y == 0) return 1;
        long temp = BinaryExpo(x, y / 2);
        temp = ModMul(temp, temp);
        if (y % 2 != 0) return ModMul(temp, x);
        return temp;
    }

    static long BinaryExpo2(long x, long y) {
        long res = 1l;
        x = x % MOD;
        while (y > 0){
            if((y & 1) != 0){
                res = (res * x) % MOD;
            }
            y >>= 1;
            x = (x * x) % MOD;
        }
        return res;
    }

    //    ------------------------------- Multiplicative Inverse ----------------------------------------

    static long modInverse(long a, long MOD){
        return BinaryExpo(a, MOD - 2);
    }

    //    -------------------------------(X * Y) % MOD-------------------------------------------------------

    public static long ModMul(long a, long b){
        return ((a % MOD) * (b % MOD)) % MOD;
    }


    static int[] Give_Primes(int n){
        boolean prime[] = new boolean[n+1];
        for(int j=2;(j*1*j)<=n;j++){
            if(!prime[j]){
                for(int k=j*j;k<=n;k+=j) prime[k]=true;
            }
        }
        int count=0;
        for(int j=2;j<=n;j++){
            if(!prime[j]) count++;
        }
        int arr[]  = new int[count],t=0;
        for(int j=2;j<=n;j++){
            if(!prime[j]) arr[t++]=j;
        }
        return arr;
    }
    //    --------------------------------FOR TAKING FASTER INPUTS----------------------------------------

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    static int MOD = (int)(1e8);
    static int maxI = Integer.MAX_VALUE;
    static int minI = Integer.MIN_VALUE;
    static long maxL = Long.MAX_VALUE;

    static long minL = Long.MIN_VALUE;
}

class Pair{
    int v;
    int wt;

    public Pair(int x, int y){
        this.v = x;
        this.wt = y;
    }
}

class DisjointIntervals {
    int nodes;
    int [] parent;
    public DisjointIntervals(int n) {
        this.nodes = n;
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
    }

    public int Setparent(int x){
        if(parent[x] == x) return x;
        int p = Setparent(parent[x]);
        parent[x] = p;
        return p;
    }

    public void Join(int a, int b){
        int p = Setparent(a);
        int p2 = Setparent(b);
        parent[p2] = p;
    }
}