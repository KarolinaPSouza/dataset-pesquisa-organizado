import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.*;

public class entry_9606825 {

    static final int INF = Integer.MAX_VALUE;
    static final long MOD = 1000000007;

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

    static class Graph {
        int V;
        LinkedList<Integer>[] adjList;

        @SuppressWarnings("unchecked")
        Graph(int V) {
            this.V = V;
            adjList = new LinkedList[V];
            for (int i = 0; i < V; i++)
                adjList[i] = new LinkedList<>();
        }

        void addEdge(int u, int v) {
            adjList[u].add(v);
        }

        // Add more graph algorithms as needed
    }

    static class SegmentTree {
        int[] st;

        SegmentTree(int[] arr, int n) {
            int x = (int) Math.ceil(Math.log(n) / Math.log(2));
            int max_size = 2 * (int) Math.pow(2, x) - 1;
            st = new int[max_size];
            build(arr, 0, n - 1, 0);
        }

        int build(int[] arr, int ss, int se, int si) {
            if (ss == se) {
                st[si] = arr[ss];
                return arr[ss];
            }
            int mid = ss + (se - ss) / 2;
            st[si] = build(arr, ss, mid, si * 2 + 1) +
                    build(arr, mid + 1, se, si * 2 + 2);
            return st[si];
        }

        int getSum(int n, int qs, int qe) {
            if (qs < 0 || qe > n - 1 || qs > qe)
                return -1;
            return getSumUtil(0, n - 1, qs, qe, 0);
        }

        int getSumUtil(int ss, int se, int qs, int qe, int si) {
            if (qs <= ss && qe >= se)
                return st[si];
            if (se < qs || ss > qe)
                return 0;
            int mid = ss + (se - ss) / 2;
            return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                    getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
        }
    }

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot)
                return;
            if (rank[xRoot] < rank[yRoot])
                parent[xRoot] = yRoot;
            else if (rank[xRoot] > rank[yRoot])
                parent[yRoot] = xRoot;
            else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long power(long x, long y, long p) {
        long res = 1;
        x = x % p;

        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        return prime;
    }
//    static  long memo[][] = new long[100][100000];
    // static long solve(int i,int arr[],int s){
    //     int n = arr.length;  
    //     if(s==0){
    //         return 1;
    //       }

    //       if(i==n){
    //     return 0;
    //       }
    //       if(memo[i][s]!=-1){
    //             return memo[i][s];
    //       }
    //       long ss = 0;
    //       for (int j = i; j < arr.length; j++) {
    //           if((s-arr[j])>=0){
    //             ss  = (ss%MOD + (solve(j, arr, s-arr[j])%MOD))%MOD;
    //           }
    //         //   else{
    //         //     ss = (ss%MOD + solve(j+1,arr,s)%MOD)%MOD;
    //         //   }        
    //       }
    //     return memo[i][s] = ss%MOD;   
    // }
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        // int t = sc.nextInt();
        // while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            } 

            // for(int i = 0; i < n; i++) {
            //     for(int j = 0; j <= k; j++) {
            //         memo[i][j] = -1;
            //     }
            // }
            long dp []= new long[k+1];
            dp[0] = 1;

            for (int i = 0; i <n; i++) {
                for (int j  = 1;j<=k; j++) {
                    if(j-arr[i]>=0){
                        dp[j] = (dp[j]%MOD + dp[j-arr[i]]%MOD)%MOD;
                    }
                }
            }
            System.out.println(dp[k]);
        //     t--;
        // }
    }
}