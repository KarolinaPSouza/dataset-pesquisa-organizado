import java.io.*;
import java.util.*;

public class entry_11154556 {

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

        public class Edge implements Comparable<Edge>{
            int to; 
            long wt;
            Edge( int to, long wt){

                this.to = to ;
                this. wt = wt;
            }
            public int compareTo(Edge v){
                return Long.compare(wt, v.wt);
            }
        }
        ArrayList<Edge>[] g;
        public void solve() {
            n= in.nextInt();
            m= in.nextInt();
            g= new ArrayList[n];
            for(int i=0;i<n ;i++){
                g[i]= new ArrayList<>();
            }
            for(int i=0;i<m;i++){
                int from = in.nextInt()-1, to =in.nextInt()-1, wt= in.nextInt();
                g[from].add(new Edge(to, wt));
            }

            PriorityQueue<Edge> pq= new PriorityQueue<>();
            boolean[] vis= new boolean[n];
            pq.add(new Edge(0,0));
            long[][] dist= new long[n][2];
            for(long[] r:dist){
                Arrays.fill(r, Long.MAX_VALUE);
            }
            dist[0][0]=dist[0][1]=0;
            while(!pq.isEmpty()){
                Edge x = pq.poll();
                if(vis[x.to]) continue;
                vis[x.to]= true;
                for(Edge e:g[x.to]){
                    if(dist[e.to][0]>dist[x.to][0]+e.wt){
                        dist[e.to][0]=dist[x.to][0]+e.wt;
                        pq.add(new Edge(e.to, dist[e.to][0]));
                    }

                }
            }
            pq.add(new Edge(0,0));
            vis= new boolean[n];
            while(!pq.isEmpty()){
                Edge x = pq.poll();
                if(vis[x.to]) continue;
                vis[x.to]= true;
                for(Edge e:g[x.to]){
                    if(dist[e.to][1]> dist[x.to][1]+e.wt || dist[e.to][1]> dist[x.to][0]+e.wt/2){
                        dist[e.to][1]= Math.min(dist[x.to][1]+e.wt, dist[e.to][1]= dist[x.to][0]+e.wt/2);
                        pq.add(new Edge(e.to, dist[e.to][1]));
                    }

                }
            }

            pn(dist[n-1][1]);
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