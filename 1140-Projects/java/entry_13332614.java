import java.io.*;
import java.util.*;

public class entry_13332614 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){br = new BufferedReader(new InputStreamReader(System.in));}
        String next(){while (st == null || !st.hasMoreElements()) {try {st = new StringTokenizer(br.readLine());}catch (IOException e) {e.printStackTrace();}}return st.nextToken();}
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() {return Double.parseDouble(next());}
    }

    void yes() {out.println("Yes");}
    void no() {out.println("No");}

    // INPUT
    int ini(){return sc.nextInt();}
    long inl(){return sc.nextLong();}
    String ins(){return sc.next();}
    void inArr(int[] a){for(int i=0;i<a.length;i++){a[i]=sc.nextInt();}}
    void inArr(double[] a){for(int i=0;i<a.length;i++){a[i]=sc.nextDouble();}}
    void inArr(char[][] a){for (int i=0; i<a.length; i++){String s = sc.next();for (int j=0;j<s.length();j++){a[i][j] = s.charAt(j);}}}
    void inArr(long[] a){for(int i=0;i<a.length;i++){a[i]=sc.nextLong();}}
    void inArr(String[] a){for(int i=0;i<a.length;i++){a[i]=sc.next();}}
    void pArr(int[] a){for(int i=0; i<a.length;i++){out.print(a[i]+" ");}}
    void pArr(long[] a){for(int i=0; i<a.length;i++){out.print(a[i]+" ");}}
    //    void pArr(ArrayList<Integer> a){for(int i=0; i<a.size();i++){out.print(a.get(i)+" ");}}
    void pArr(ArrayList<Integer> a){for(int i=0; i<a.size();i++){out.print(a.get(i)+" ");}}

    // PRINT
    void pl(){out.println();}
    void pl(int x){out.println(x);}
    void pl(long x){out.println(x);}
    void pl(double x){out.println(x);}
    void pl(String x){out.println(x);}
    void pl(char x){out.println(x);}
    int getInt(char ch){return Integer.parseInt(String.valueOf(ch));}
    long max(long a, long b){return Math.max(a, b);}
    long min(long a, long b){return Math.min(a, b);}
    double max(double a, double b){return Math.max(a, b);}
    double min(double a, double b){return Math.min(a, b);}
    int gcd(int a, int b) {while (b != 0) {int temp = b;b = a % b;a = temp;}return a;}
    long gcd(long a, long b) {while (b != 0) {long temp = b;b = a % b;a = temp;}return a;}
    long lcm(long a, long b) {return ((a * b) / gcd(a, b));}
    public static boolean isSorted(int[] a) {for (int i = 0; i < a.length - 1; i++) {if (a[i] > a[i + 1]) {return false;}}return true;}
    public static void reverseArr(int[] a){int i=0, j=a.length-1;while (i<j){int temp=a[i];a[i]=a[j];a[j]=temp;i++;j--;}}
    public static void reverseArr(long[] a){int i=0, j=a.length-1;while (i<j){long temp=a[i];a[i]=a[j];a[j]=temp;i++;j--;}}
    void sort(long a[]) {divide(a, 0, a.length - 1, true);}
    void rsort(long a[]) {divide(a, 0, a.length - 1, false);}
    void divide(long a[], int l, int r, boolean order) {if (l < r) {int m = l + (r - l) / 2;divide(a, l, m, order);divide(a, m + 1, r, order);merge(a, l, m, r, order);}}
    void merge(long a[], int l, int m, int r, boolean order) {int n1 = m - l + 1;int n2 = r - m;long L[] = new long[n1];long R[] = new long[n2];for (int i = 0; i < n1; ++i) L[i] = a[l + i];for (int j = 0; j < n2; ++j) R[j] = a[m + 1 + j];int i = 0, j = 0; int k = l;while (i < n1 && j < n2) {if ((L[i] <= R[j] && order) || (L[i] >= R[j] && !order)) {a[k] = L[i];i++;} else {a[k] = R[j];j++;}k++;}while (i < n1) {a[k] = L[i];i++;k++;}while (j < n2) {a[k] = R[j];j++;k++;}}
    void sort(long a[][]) {divide(a, 0, a[0].length - 1, true);}
    void rsort(long a[][]) {divide(a, 0, a[0].length - 1, false);}
    void divide(long a[][], int l, int r, boolean order) {if (l < r) {int m = l + (r - l) / 2;divide(a, l, m, order);divide(a, m + 1, r,order);merge(a, l, m, r, order);}}
    void merge(long a[][], int l, int m, int r, boolean order) {int n1 = m - l + 1;int n2 = r - m;long L[] = new long[n1]; long R[] = new long[n2];long b1[][] = new long[a.length][n1]; long b2[][] = new long[a.length][n2];for (int i = 0; i < n1; ++i) {L[i] = a[0][l + i];for (int p = 1; p < a.length; p++) b1[p][i] = a[p][l + i];}for (int j = 0; j < n2; ++j) {R[j] = a[0][m + 1 + j];for (int p = 1; p < a.length; p++) b2[p][j] = a[p][m + 1 + j];}int i = 0, j = 0; int k = l;while (i < n1 && j < n2) {if ((L[i] <= R[j] && order) || (L[i] >= R[j] && !order)) {a[0][k] = L[i]; for (int p = 1; p < a.length; p++) a[p][k] = b1[p][i];i++;} else {a[0][k] = R[j];for (int p = 1; p < a.length; p++) a[p][k] = b2[p][j];j++;}k++;}while (i < n1) {a[0][k] = L[i];for (int p = 1; p < a.length; p++) a[p][k] = b1[p][i];i++;k++;}while (j < n2) {a[0][k] = R[j];for (int p = 1; p < a.length; p++) a[p][k] = b2[p][j];j++;k++;}}


    long maxInArr(long[] a){long m = Long.MIN_VALUE;for (int i=0; i<a.length; i++){m=max(m, a[i]);}return m;}
    int maxInArr(int[] a){int m = Integer.MIN_VALUE;for (int i=0; i<a.length; i++){m=Math.max(m, a[i]);}return m;}
    long minInArr(long[] a){long m = Long.MAX_VALUE;for (int i=0; i<a.length; i++){m=min(m, a[i]);}return m;}
    int minInArr(int[] a){int m = Integer.MAX_VALUE;for (int i=0; i<a.length; i++){m=Math.min(m, a[i]);}return m;}


    int upper_bound(long a[], long val) {int start = 0;int end = a.length - 1;while (start <= end) {int mid = (start + end) / 2;if (a[mid] >= val) {if (mid == 0 || a[mid-1] < val)return mid;end = mid - 1;} else start = mid + 1;}return -1;}
    int upper_bound(ArrayList<Long> a, long val) {if (a.size() == 0)return -1;int start = 0;int end = a.size() - 1;while (start <= end) {int mid = (start + end) / 2;if (a.get(mid) >= val) {if (mid == 0 || a.get(mid-1) < val) return mid;end = mid - 1;} else start = mid + 1;}return -1;}
    int lower_bound(ArrayList<Long> a, long val) {if (a.size() == 0)return -1;int start = 0;int end = a.size() - 1;while (start <= end) {int mid = (start + end) / 2;if (a.get(mid) > val) {end = mid - 1;continue;} else {if (mid == a.size() - 1 || a.get(mid+1) > val) return mid; start = mid + 1;}}return -1;}
    int lower_bound(long a[], long val) {int start = 0;int end = a.length - 1;while (start <= end) {int mid = (start + end) / 2;if (a[mid] > val) {end = mid - 1;continue;} else {if (mid == a.length - 1 || a[mid + 1] > val) return mid; start = mid + 1;}}return -1;}


    long mod = (int)1e9+7;

    long add(long a, long b) {return (((a + mod) % mod + (b + mod) % mod) % mod);}
    long sub(long a, long b) {return (((a + mod) % mod + ((-b) + mod) % mod) % mod);}
    long mul(long a, long b) {return ((a % mod * b % mod) % mod);}
    long inv(long x) {return pow(x, mod - 2);}
    long div(long x, long y) {return mul(x, inv(y));}
    long pow(long a, long b) {a %= mod;long res = 1;while (b > 0) {if ((b & 1) != 0)res = mul(res, a);a = mul(a, a);b /= 2;}return res;}
    long sqrt(long x) {long start = 0, end = (long) 3e9, ans = 1; while (start <= end) {long mid = (start + end) / 2; if (mid * mid <= x) {ans = mid;start = mid + 1;} else end = mid - 1;} return ans;}
    long modInverse(long a, long mod) {return pow(a, mod - 2);}
    long ceil(long a, long b) {return ((long) Math.ceil(((double) (a) / b)));}





    // Extended Euclideans Algorithm -----> used to find variables of x and y
    public static class Result {
        int gcd, x, y;

        public Result(int gcd, int x, int y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }
    public static Result extendedGCD(int a, int b) {
        if (b == 0) {
            return new Result(a, 1, 0); // Base case: gcd(a, 0) = a
        }
        Result result = extendedGCD(b, a % b); // Recursive step
        int gcd = result.gcd;
        int x1 = result.x;
        int y1 = result.y;

        int x = y1;
        int y = x1 - (a / b) * y1;

        return new Result(gcd, x, y);
    }


    public void seive(int[] a){
        // declare array globally and precompute
        int n=a.length;
        for (int i=2; i<n; i++){
            a[i] = 1;
        }
        for (int i=2; i * i <= n; i++){
            for (int j = i*i; j<n; j+=i){
                a[j] = 0;
            }
        }
//        int l = ini();
//        int r = ini();
//        int cnt=0;
//        for (int i=l; i<=r; i++){
//            if (a[i]==1) cnt++;
//        }
//        pl(cnt);
    }


    // function tofind prime factors of any number
    public void spfPrecomp(int[] a){
        // declare array globally and precompute
        int n=a.length;
        for (int i=2; i<n; i++){
            a[i]=i;
        }
        for (int i=2; i*i<n; i++){
            if (a[i]!=i) continue;
            for (int j=i*i; j<n; j+=i){
                if (a[j]==j){
                    a[j] = i;
                }
            }
        }
//        int q=ini();
//        while (q-->0){
//            int num=ini();
//            while (num!=1){
//                out.print(a[num]+" ");
//                num/=a[num];
//            }
//            pl();
//        }
    }


    long[] fact = new long[(int) (1e5 + 1)];
    long[] modInv = new long[(int) (1e5 + 1)];

    public void precompFactorial(){
        fact[0] = 1;
        for (long i=1; i<=1e5; i++){
            fact[(int) i] = (fact[(int) i-1] * i) % mod;
            modInv[(int) i] = pow(fact[(int) i], mod-2);
        }
    }

    public long ncr(long n, long r){
        if (n<r) return 0;
        long numo = fact[(int) n];
        long Invdeno = (modInv[(int) r]* modInv[(int) (n-r)]) % mod;
        long ans = (numo * Invdeno) % mod;
        return ans;
    }






    public static final int MOD = 1000000000 + 7;

    FastReader sc=new FastReader();
    PrintWriter out=new PrintWriter(System.out);

    public static void main(String args[]) {
        entry_13332614 pp = new entry_13332614();
        pp.solve();
    }



    static class Pair {
        long a, b;

        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    /*
        DP me 4 stages are imp
        1.State
        2.Transition
        3.Base Case
        4.Final SubProblem
    */

    int bs(long[][] a, long num, int i) {
        int n = a.length;
        int ans = n;
        int st = i, end = n - 1;
        while (st <= end) {
            int mid = (st + end) / 2;
            if (a[mid][0] > num) {
                ans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }

    void ans() {
        int n = ini();
        long[][] a = new long[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = ini();  // start
            a[i][1] = ini();  // end
            a[i][2] = ini();  // profit
        }

        Arrays.sort(a, Comparator.comparingLong(x -> x[0])); // sort by start time

        long[] dp = new long[n + 1];  // dp[i] = max profit from i to n-1

        for (int i = n - 1; i >= 0; i--) {
            int nextIdx = bs(a, a[i][1], i);  // first job with start > current job's end
            long take = a[i][2] + dp[nextIdx];
            long notTake = dp[i + 1];
            dp[i] = Math.max(take, notTake);
        }

        pl(dp[0]);
    }








    public void solve() {
//        int t = sc.nextInt();
        int t = 1;
        while(t-- > 0){
            ans();
        }
        out.close();
    }

    public static class DSU {
        private int[] parent;
        private int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);  // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            // Union by rank
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}