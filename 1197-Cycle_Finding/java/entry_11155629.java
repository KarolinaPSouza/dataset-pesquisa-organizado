import java.io.*;
import java.util.*;

public class entry_11155629 {

    public static void main(String[] args) {
        Solver s = new Solver();
        int t = 1;
        // t= s.in.nextInt();
        while (t-- > 0) {
            s.solve();
        }
        s.out.close();

    }

    static class Solver {
        int mod = (int) (1e9 + 7);
        int n,m;
        boolean done;
        public class Edge implements Comparable<Edge>{
            int from, to; 
            long wt;
            Edge(int from, int to, long wt){
                this.from = from;
                this.to = to ;
                this. wt = wt;
            }
            public int compareTo(Edge v){
                return Long.compare(wt, v.wt);
            }
        }
        ArrayList<Edge>[] g;
        boolean[] vis;
        boolean inf;
        public void solve() {
            n= in.nextInt();
            m= in.nextInt();
            g= new ArrayList[n];
            for(int i=0;i<n ;i++){
                g[i]= new ArrayList<>();
            }
            Edge[] edges =new Edge[m];
            for(int i=0;i<m;i++){
                int from = in.nextInt()-1, to =in.nextInt()-1, wt= in.nextInt();
                g[from].add(new Edge(from, to, wt));
                edges[i]= new Edge(from, to, wt);
            }
            long[] dist= new long[n];

            dist[0]=0;
            int[] p= new int[n];
            for(int i=0;i<n-1;i++){
                for(int j=0;j<m;j++){

                    if(dist[edges[j].to]> dist[edges[j].from]+edges[j].wt){
                        dist[edges[j].to]= dist[edges[j].from]+edges[j].wt;
                        p[edges[j].to]= edges[j].from;
                        //pn(edges[j].from+" "+edges[j].to+" "+edges[j].wt);
                    }
                }
            }
            for(int j=0;j<m;j++){

                if(dist[edges[j].to]> dist[edges[j].from]+edges[j].wt){

                    pn("YES");
                    int x= p[edges[j].to];
                    for(int i=0;i<n;i++){
                        x= p[x];
                    }
                    int c=0;
                    ArrayList<Integer> list= new ArrayList<>();
                    for(int curr=x;;curr=p[curr]){
                        c++;
                        list.add(curr+1);
                        if(curr== x && c>1 ){
                            break;
                        }

                    }
                    for(int i= list.size()-1;i>=0;i--){
                        p(list.get(i)+" ");
                    }

                    return;
                }
            }
            pn("NO");

        }
        void dfs(int nn, int st){
            if(vis[nn]) return;
            vis[nn]= true;
            p((nn+1)+" ");
            for(Edge e:g[nn]){
                dfs(e.to,st);
            }
        }


        long add(long a, long b) {

            return (a + b) % mod;

        }

        long sub(long a, long b) {

            return ((a - b) % mod + mod) % mod;

        }

        long mul(long a, long b) {

            return (a * b) % mod;

        }

        long modInverse(long b) {
            return power(b, mod - 2);
        }

        long power(long base, long exp) {
            long result = 1;
            while (exp > 0) {
                if ((exp & 1) == 1) {
                    result = (result * base) % mod;
                }
                base = (base * base) % mod;
                exp >>= 1;
            }
            return result;
        }

        long modDiv(long a, long b) {
            return (a * modInverse(b)) % mod;
        }

        void sort(int[] a) {
            int n = a.length;
            Random r = new Random();
            for (int i = 0; i < a.length; i++) {
                int oi = r.nextInt(n), temp = a[i];
                a[i] = a[oi];
                a[oi] = temp;
            }
            Arrays.sort(a);
        }

        void pn(Object o) {
            out.println(o);
        }

        void p(Object o) {
            out.print(o);
        }

        int[] readArray(int n) {
            int[] A = new int[n];
            for (int i = 0; i != n; i++) {
                A[i] = in.nextInt();
            }
            return A;
        }

        long[] readArrayL(int n) {
            long[] A = new long[n];
            for (int i = 0; i != n; i++) {
                A[i] = in.nextLong();
            }
            return A;
        }

        class InputReader {
            BufferedReader reader;
            StringTokenizer tokenizer;

            public InputReader(InputStream stream) {
                reader = new BufferedReader(new InputStreamReader(stream), 32768);
                tokenizer = null;
            }

            String next() {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    try {
                        tokenizer = new StringTokenizer(reader.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return tokenizer.nextToken();
            }

            public int nextInt() {
                return Integer.parseInt(next());
            }

            public long nextLong() {
                return Long.parseLong(next());
            }

            public double nextDouble() {
                return Double.parseDouble(next());
            }
        }

        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
    }

}