import java.io.*;
import java.util.*;
public class entry_5808352 {
    final static FastReader fr = new FastReader();
    final static PrintWriter out = new PrintWriter(System.out);
    static final long mod = (long) 1e9 + 7;
    static ArrayList<Integer> primes;
    static long[] fact;
    static void solve() {
        int n = fr.nextInt();
        int m = fr.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n+1] ;
        for(int i = 0; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            int u = fr.nextInt();
            int v = fr.nextInt();
            adj[u].add(v) ;
            adj[v].add(u) ;
        }
        ArrayList<Integer> nodes = new ArrayList<>() ;
        boolean[] vis = new boolean[n+1] ;
        for(int i = 1; i <= n; i++){
            if(!vis[i]){
                nodes.add(i);
                dfs(adj, i, vis) ;
            }
        }

        out.println(nodes.size()-1);

        for(int i = 1; i < nodes.size(); i++){
            out.println(nodes.get(i)+" "+nodes.get(0));
        }





    }

    private static void dfs(ArrayList<Integer>[] adj, int node, boolean[] vis) {
        vis[node] = true ;
        for(int nbr: adj[node]){
            if(!vis[nbr]){
                dfs(adj, nbr, vis);
            }
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

    static long[] inputArr(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = fr.nextInt();
        return arr;
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

    static class FenwickTree {
        long[] bit;
        int n;

        FenwickTree(int n) {
            bit = new long[n + 1];
            this.n = n;
        }

        void update(int ind, long val) {
            while (ind <= n) {
                bit[ind] += val;
                ind += (ind & -ind);
            }
        }

        long getSum(int ind) {
            long sum = 0;
            while (ind > 0) {
                sum += bit[ind];
                ind -= (ind & -ind);
            }
            return sum;
        }

    }

    private static class SegmentTree {
        long[] seg ;
        long[] lazy;
        void print(){
            for(int i = 0; i < seg.length; i++){
                out.print(i+" -> "+seg[i]+",  ");
            }
            out.println();
        }
        void build(long[] arr, int low, int high, int ind) {
            if (low == high) {
                seg[ind] = arr[low] ;
                return ;
            }
            int mid = low + ((high - low)>>1) ;
            build(arr, low, mid, 2 * ind + 1) ;
            build(arr, mid+1, high, 2 * ind + 2);
            seg[ind] = Math.max(seg[2*ind+1] , seg[2*ind+2]);
        }
        SegmentTree(int n){
            seg = new long[4 * n] ;
            lazy = new long[4 * n] ;
        }
        long query(int l, int r, int low, int high, int ind)
        {
            if (lazy[ind] != 0)
            {
                seg[ind] += (high - low + 1) * lazy[ind] ;

                if (low != high)
                {
                    lazy[2*ind+1] += lazy[ind] ;
                    lazy[2*ind+2] += lazy[ind] ;
                }
                lazy[ind] = 0 ;
            }

            if (r < low || l > high)
                return 0 ;

            if (l <= low && high <= r) {
                return seg[ind] ;
            }

            int mid = low + ((high - low)>>1) ;
            long left = query(l, r, low, mid, 2*ind+1) ;
            long right = query(l, r, mid+1, high, 2*ind+2) ;

            return Math.max(left, right);
        }

        void rangeUpdate(int l, int r, int low, int high, int ind, long val){
            if(lazy[ind] != 0){
                seg[ind] += (high - low + 1) * lazy[ind] ;
                if(low != high){
                    lazy[2 * ind + 1] += lazy[ind] ;
                    lazy[2 * ind + 2] += lazy[ind] ;
                }
                lazy[ind] = 0 ;
            }

            if(l > high || r < low){
                return;
            }

            if(l <= low && high <= r){
                seg[ind] += (long)(high - low + 1) * val ;
                if(low != high){
                    lazy[2 * ind + 1] += val ;
                    lazy[2 * ind + 2] += val ;
                }
                return;
            }

            int mid = low + ((high - low)>>1) ;
            rangeUpdate(l, r, low, mid, 2*ind+1, val);
            rangeUpdate(l, r, mid+1, high, 2*ind+2, val);
            seg[ind] = Math.max(seg[2*ind+1],seg[2*ind+2]) ;
        }

        void pointUpdate(int low, int high, int ind, int indToUpdate,long val){
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
            seg[ind] = Math.max(seg[2*ind+1] ,seg[2*ind+2]) ;
        }

        int find(int low, int high, int ind, long val){
            if(low == high){
                return low;
            }
            int mid = low + ((high-low)>>1);
            if(seg[2*ind+1] >= val){
                return find(low, mid, 2*ind+1, val) ;
            }
            return find(mid+1, high, 2*ind+2, val) ;
        }

    }
}