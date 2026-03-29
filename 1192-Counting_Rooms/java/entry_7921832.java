import javax.swing.plaf.IconUIResource;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.Array;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;



public class entry_7921832 {



    static class FastReader {
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
    /***************************************************************************************/
    /***************************************************************************************/


    /**
     * GCD
     */
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;

        }
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b){
        return (a*b)/gcd(a,b);
    }

    static long mo = (long) 1e9 + 7;

    public static long mulmod(long a, long b) {
        long res = 0;

        a = a % mo;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res + a) % mo;
            a = (a + a) % mo;
            b >>= 1;

        }
        return res;

    }

    /**
     * Binary Exponenetiation
     */


    public static long binpow(long a, long b) {
        long res = 1;

        a = a % mo;

        while (b > 0) {
            if ((b & 1) == 1)
                res = mulmod(res, a);
            a = mulmod(a, a);
            b >>= 1;

        }
        return res;
    }


    /**
     * Factorial
     */
    static long fact(long n) {
        long m = (long) 1e9 + 7;
        if (n == 0)
            return 1;
        long res = 1;
        for (long i = 2; i <= n; i++)
            res = (res * i) % m;
        return res % m;
    }


    /**
     * Lower Bound
     */
    public static int lowerBound(int[] arr, long x) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= x) {
                // If current element is less than or equal to x, update result and move right
                result = mid;
                left = mid + 1;
            } else {
                // If current element is greater than x, move left
                right = mid - 1;
            }
        }

        return result;
    }
    /**
     * Upper Bound
     */
    public static int UpperBound(int[] arr, long x) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                // Element found at mid index
                result = mid;
                break;
            } else if (arr[mid] < x) {
                // If current element is less than x, move right
                left = mid + 1;
            } else {
                // If current element is greater than x, update result and move left
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }







/**
 * nCr
 */
    public static long nck(long n, long k) {
        long r = 1;
        for (long i = n; i > n - k; i--) {
            r *= i;

        }
        for (long i = 2; i <= k; i++) {
            r /= i;
        }
        return r;
    }


    /**
     * Sieve of Eratosthenes
     */
    public static void sieveOfEratosthenes(int n) {

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        for (int p = 2; p * p <= n; p++) {

            if (prime[p]) {

                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }


    /**
     * Prime Check
     */
    public static boolean isPrime(int number) {
        if (number <= 1) return false;

        boolean[] primeFlags = new boolean[number + 1];
        for (int i = 2; i <= number; i++) {
            primeFlags[i] = true;
        }

        for (int p = 2; p * p <= number; p++) {
            if (primeFlags[p]) {
                for (int i = p * p; i <= number; i += p) {
                    primeFlags[i] = false;
                }
            }
        }

        return primeFlags[number];
    }

    static int kadane(int A[]) {
        int lsum = A[0], gsum = A[0];
        for (int i = 1; i < A.length; i++) {
            lsum = Math.max(lsum + A[i], A[i]);
            gsum = Math.max(gsum, lsum);
        }
        return gsum;
    }

    public static class DisjointUnionSets {
        int[] rank, parent;
        int n;

        // Constructor
        public DisjointUnionSets(int n) {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            makeSet();
        }

        // Creates n sets with single item in each
        void makeSet() {
            for (int i = 0; i < n; i++) {
                // Initially, all elements are in
                // their own set.
                parent[i] = i;
            }
        }

        // Returns representative of x's set
        int find(int x) {
            // Finds the representative of the set
            // that x is an element of
            if (parent[x] != x) {
                // if x is not the parent of itself
                // Then x is not the representative of
                // his set,
                parent[x] = find(parent[x]);

                // so we recursively call Find on its parent
                // and move i's node directly under the
                // representative of this set
            }

            return parent[x];
        }

        // Unites the set that includes x and the set
        // that includes x
        void union(int x, int y) {
            // Find representatives of two sets
            int xRoot = find(x), yRoot = find(y);

            // Elements are in the same set, no need
            // to unite anything.
            if (xRoot == yRoot)
                return;

            // If x's rank is less than y's rank
            if (rank[xRoot] < rank[yRoot])

                // Then move x under y  so that depth
                // of tree remains less
                parent[xRoot] = yRoot;

                // Else if y's rank is less than x's rank
            else if (rank[yRoot] < rank[xRoot])

                // Then move y under x so that depth of
                // tree remains less
                parent[yRoot] = xRoot;

            else // if ranks are the same
            {
                // Then move y under x (doesn't matter
                // which one goes where)
                parent[yRoot] = xRoot;

                // And increment the result tree's
                // rank by 1
                rank[xRoot] = rank[xRoot] + 1;
            }
        }

    }


    static ArrayList<ArrayList<Integer>> g;
    static long mod=1000000007;
    static boolean SET[];
    static int seg[],col[];

    static int D[];

    static void setGraph(int N)
    {
        SET=new boolean[N];
        D=new int[N];
        g=new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<N; i++)
        {

            D[i]=Integer.MAX_VALUE;
            g.add(new ArrayList<>());
        }
    }
















/***************************************************************************************/
    /***************************************************************************************/
    /***************************************************************************************/




   // static final int N = 2 * 100000 + 5;
   // static ArrayList<Pair>[] adj = new ArrayList[N];




    static List<Integer>[] edges;
    static boolean[][] vis;





    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static class Sorting implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            if(p2.y==p1.y){
                return p1.x-p2.x;
            }
            return p2.y - p1.y;
        }
    }


    public static long bb(long x){
        return (long)(x*(x+1)/2);
    }
    static int countBits(long a) {
        return (int) (Math.log(a) / Math.log(2) + 1);
    }




    public static void dfs(Character[][] matrix, int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col]=='#') {
            return; // Reached boundary
        }
        if (vis[row][col]) {
            return; // Already visited
        }
        vis[row][col] = true; // Mark current element as visited



        // Explore neighbors (up, down, left, right)
        dfs(matrix, row + 1, col);
        dfs(matrix, row - 1, col);
        dfs(matrix, row, col + 1);
        dfs(matrix, row, col - 1);
    }








    public static void main(String[] args) {
        //int mod = (int)1e9+7;



        FastReader sc = new FastReader();



         //int t = sc.nextInt();
         int t =1;


        //int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();


            //ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            Character mp[][] = new Character[n][m];

            for(int i=0; i<n; i++){
                String s = sc.next();
                for(int j=0; j<m; j++){
                    mp[i][j] = s.charAt(j);
                    //System.out.println(mp[i][j]);
                }
            }
            vis = new boolean[n][m];

            int c=0;

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(mp[i][j]=='.' && vis[i][j]==false){

                        dfs(mp,i,j);
                        c++;


                    }
                }
            }
            System.out.println(c);

//            for(int i=0;i<n; i++){
//                ArrayList<Integer> in = new ArrayList<>();
//
//                for(int j=0; j<m;j++){
//                    int el = sc.nextInt();
//                    in.add(el);
//
//                }
//                adj.add(in);
//            }






























        }











    }





}