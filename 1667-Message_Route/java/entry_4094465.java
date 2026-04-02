    //package com.company;

    // Day 34(57)

    import java.io.*;
    import java.util.*;

    public class entry_4094465 {

        static final Random random = new Random();
        static boolean[] primecheck;
        static ArrayList<Integer>[] adj;
        static int[] vis;
        static int[] dis;
        static int[] parent;
        static int[] rank;
        static int[] fact;
        static int[] invFact;
        static int[] ft;
        static int mod = (int)1e9 + 7;

        public static void main(String[] args) {
            OutputStream outputStream = System.out;
            FastReader in = new FastReader();
            PrintWriter out = new PrintWriter(outputStream);
            PROBLEM solver = new PROBLEM();
            int t = 1;
            //t = in.ni();
            for (int i = 0; i < t; i++) {
                //out.print("Case #" + (i+1) + ": ");
                solver.solve(in, out);
            }
            out.close();
        }

        static class PROBLEM {

            public static void solve(FastReader in, PrintWriter out) {

                int n = in.ni(), m = in.ni();
                adj = new ArrayList[n+1];
                vis = new int[n+1];
                dis = new int[n+1];
                parent = new int[n+1];
                for (int i = 1; i < n + 1; i++) adj[i] = new ArrayList<>();
                for (int i = 0; i < m; i++) {
                    int a = in.ni(), b = in.ni();
                    adj[a].add(b);
                    adj[b].add(a);
                }

                Queue<Integer> q = new LinkedList<>();

                q.add(1); vis[1] = 1; dis[1] = 1;
                while(!q.isEmpty()){
                    int cur = q.poll();
                    for(int i : adj[cur]){
                        if(vis[i] == 0){
                            q.add(i);
                            dis[i] = dis[cur]+1;
                            parent[i] = cur;
                            vis[i] = 1;
                        }
                    }
                }

                if(vis[n] == 0){
                    out.println("IMPOSSIBLE");
                    return;
                }

                int[] seq = new int[dis[n]];
                int cur = n;
                for (int i = dis[n]-1; i >= 0; i--) {
                    seq[i] = cur;
                    cur = parent[cur];
                }

                out.println(dis[n]);
                pa(seq, out);

            }
        }

        static char c[][];
        static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

        static void cc(int i, int j){
            if(c[i][j] == '#') return;
            c[i][j] = '#';
            for (int k = 0; k < 4; k++) {
                i+=dx[k]; j+=dy[k];
                if(i>=0 && i<c.length && j>=0 && j<c[0].length){
                    if(c[i][j] == '.'){
                        cc(i, j);
                    }
                }
                i-=dx[k]; j-=dy[k];
            }
        }

        static int lower_bound(int array[], int key) {

            int index = Arrays.binarySearch(array, key);

            // If key is not present in the array
            if (index < 0) {

                // Index specify the position of the key
                // when inserted in the sorted array
                // so the element currently present at
                // this position will be the lower bound
                return Math.abs(index) - 1;
            }

            // If key is present in the array
            // we move leftwards to find its first occurrence
            else {

                // Decrement the index to find the first
                // occurrence of the key

                while (index > 0) {

                    // If previous value is same
                    if (array[index - 1] == key)
                        index--;

                        // Previous value is different which means
                        // current index is the first occurrence of
                        // the key
                    else
                        return index;
                }

                return index;
            }
        }

        static int getKthElement(int k){
            int l = 0, r = ft.length-1, el = Integer.MAX_VALUE;

            while(l <= r){
                int mid = l+r>>1;
                if(sumFenwick(ft, mid) >= k){
                    el = Math.min(el, mid);
                    r = mid-1;
                }else l = mid+1;
            }
            return el;
        }


        static int rangeFenwick(int[] ft, int i, int j){
            return sumFenwick(ft, j) - sumFenwick(ft, i);
        }

        static int sumFenwick(int[] ft, int i){
            int sum = 0;
            for(; i>0; i&=~(i&-i)) sum+=ft[i];
            return sum;
        }

        static void addFenwick(int[] ft, int i, int x){
            int n = ft.length;
            for(; i<n; i+=i&-i) ft[i] += x;
        }

        static void combi(){
            fact = new int[200001]; fact[0] = 1;
            invFact = new int[200001]; invFact[0] = 1;
            for (int i = 1; i < fact.length; i++) {
                fact[i] = (int)(((long)fact[i-1]%mod * i%mod) % mod);
                invFact[i] = (mod - ((mod/i)*invFact[mod%i])%mod)%mod;
            }
        }

        static int nCk(int n, int k){
            return fact[n] * invFact[k]%mod * invFact[n-k]%mod;
        }

        static String reverse(String s){
            char[] ch = s.toCharArray();
            for (int j = 0; j < ch.length / 2; j++) {
                char temp = ch[j];
                ch[j] = ch[ch.length-j-1];
                ch[ch.length-j-1] = temp;
            }
            return String.valueOf(ch);
        }

        static int[][] matrixMul(int[][] a, int[][] m){
            if(a[0].length == m.length) {
                int[][] b = new int[a.length][m.length];
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m.length; j++) {
                        int sum = 0;
                        for (int k = 0; k < m.length; k++) {
                            sum += m[i][k] * m[k][j];
                        }
                        b[i][j] = sum;
                    }
                }
                return b;
            }
            return null;
        }

//        static void dfs(int i, int d){
//            vis[i] = 1;
//            if(d > dist){
//                maxNode = i;
//                dist = d;
//            }
//            for(int j : adj[i]){
//                if (vis[j] == 0) dfs(j, d+1);
//            }
//        }

        static int find(int u){
            if(u == parent[u]) return u;
            return parent[u] = find(parent[u]);
        }

        static void union(int u, int v){
            int a = find(u), b = find(v);

            if(a == b) return;

            if(rank[a] > rank[b]) parent[b] = a;
            else if(rank[a] < rank[b]) parent[a] = b;
            else{
                parent[b] = a;
                rank[a]++;
            }
        }

        static void dsu(int n){
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        static boolean isPalindrome(char[] s){
            boolean b = true;
            for (int i = 0; i < s.length / 2; i++) {
                if(s[i] != s[s.length-1-i]){
                    b = false;
                    break;
                }
            }
            return b;
        }

        static void yn(boolean b, PrintWriter out){
            if(b) out.println("YES");
            else out.println("NO");
        }

        static void pa(int[] a, PrintWriter out){
            for (int j : a) out.print(j + " ");
            out.println();
        }

        static void pa(long[] a, PrintWriter out){
            for (long j : a) out.print(j + " ");
            out.println();
        }
        public static void sortByColumn(int arr[][], int col)
        {
            // Using built-in sort function Arrays.sort
            Arrays.sort(arr, new Comparator<int[]>() {

                @Override
                // Compare values according to columns
                public int compare(final int[] entry1,
                                   final int[] entry2) {

                    // To sort in descending order revert
                    // the '>' Operator
                    if (entry1[col] > entry2[col])
                        return 1;
                    else
                        return -1;
                }
            });  // End of function call sort().
        }

        static boolean isPoT(long n){
            return ((n&(n-1)) == 0);
        }

        static long sigmaK(long k){
            return (k*(k+1))/2;
        }

        static void swap(int[] a, int l, int r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }

        static int binarySearch(int[] a, int l, int r, int x){
            if(r>=l){
                int mid = l + (r-l)/2;

                if(a[mid] == x) return mid;

                if(a[mid] > x) return binarySearch(a, l, mid-1, x);
                else return binarySearch(a,mid+1, r, x);
            }
            return -1;
        }

        static long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        static long lcm(long a, long b){
            return (a / gcd(a, b)) * b;
        }

        static int ceil(int a, int b){
            return (a+b-1)/b;
        }

        static long ceil(long a, long b){
            return (a+b-1)/b;
        }

        static boolean isSquare(double a) {
            boolean isSq = false;
            double b = Math.sqrt(a);
            double c = Math.sqrt(a) - Math.floor(b);

            if (c == 0) isSq = true;
            return isSq;
        }

        static long fast_pow(long a, long b) { //Jeel bhai OP
            if(b == 0)
                return 1L;

            long val = fast_pow(a, b / 2);

            if(b % 2 == 0)
                return val * val % mod;
            else
                return val * val % mod * a % mod;
        }


    //    static class Pair implements Comparable<Pair>{
    //
    //        int x;
    //        int y;
    //
    //        Pair(int x, int y){
    //            this.x = x;
    //            this.y = y;
    //        }
    //
    //        public int compareTo(Pair o){
    //
    //            int ans = Integer.compare(x, o.x);
    //            if(o.x == x) ans = Integer.compare(y, o.y);
    //
    //            return ans;
    //
    ////            int ans = Integer.compare(y, o.y);
    ////            if(o.y == y) ans = Integer.compare(x, o.x);
    ////
    ////            return ans;
    //        }
    //    }

        static class Tuple implements Comparable<Tuple>{

            int x, y, id;

            Tuple(int x, int y, int id){
                this.x = x;
                this.y = y;
                this.id = id;
            }

            public int compareTo(Tuple o){
                int ans = Integer.compare(x, o.x);
                if(o.x == x) ans = Integer.compare(y, o.y);

                return ans;
            }
        }

        public static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
            public U x;
            public V y;

            public Pair(U x, V y) {
                this.x = x;
                this.y = y;
            }

            public int hashCode() {
                return (x == null ? 0 : x.hashCode() * 31) + (y == null ? 0 : y.hashCode());
            }

            public boolean equals(Object o) {
                if (this == o)
                    return true;
                if (o == null || getClass() != o.getClass())
                    return false;
                Pair<U, V> p = (Pair<U, V>) o;
                return (x == null ? p.x == null : x.equals(p.x)) && (y == null ? p.y == null : y.equals(p.y));
            }

            public int compareTo(Pair<U, V> b) {
                int cmpU = x.compareTo(b.x);
                return cmpU != 0 ? cmpU : y.compareTo(b.y);
            }

            public int compareToY(Pair<U, V> b) {
                int cmpU = y.compareTo(b.y);
                return cmpU != 0 ? cmpU : x.compareTo(b.x);
            }

            public String toString() {
                return String.format("(%s, %s)", x.toString(), y.toString());
            }

        }

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

            int ni() {
                return Integer.parseInt(next());
            }

            long nl() {
                return Long.parseLong(next());
            }

            double nd() {
                return Double.parseDouble(next());
            }

            char nc() {
                return next().charAt(0);
            }

            boolean nb() {
                return !(ni() == 0);
            }
            // boolean nextBoolean(){return Boolean.parseBoolean(next());}

            String nline() {
                String str = "";
                try {
                    str = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return str;
            }

            public int[] ra(int size) {
                int[] array = new int[size];
                for (int i = 0; i < size; i++) array[i] = ni();
                return array;
            }

            public long[] ral(int size) {
                long[] array = new long[size];
                for (int i = 0; i < size; i++) array[i] = nl();
                return array;
            }

        }

        static void ruffleSort(int[] a) {
            int n=a.length;//shuffle, then sort
            for (int i=0; i<n; i++) {
                int oi=random.nextInt(n), temp=a[oi];
                a[oi]=a[i]; a[i]=temp;
            }
            Arrays.sort(a);
        }

        public static void Sieve(int n) {

            Arrays.fill(primecheck, true);
            primecheck[0] = false;
            primecheck[1] = false;

            for (int i = 2; i * i < n + 1; i++) {
                if (primecheck[i]) {
                    for (int j = i * 2; j < n + 1; j += i) {
                        primecheck[j] = false;
                    }
                }
            }
        }
    }


