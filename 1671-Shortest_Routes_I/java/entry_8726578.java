import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue; 
import java.util.StringTokenizer;

public class entry_8726578 {
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

        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 

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
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt(); int m = sc.nextInt();
        ArrayList<Pair>[] adj = (ArrayList<Pair>[]) new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<Pair>();
        }
        int[] visited = new int[n+1];
        long[] dist = new long[n+1];
        for (int i = 2; i <= n; i++) dist[i] =(long) 2e15;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); long b = sc.nextInt(); long c = sc.nextInt();
            adj[a].add(new Pair(b, c));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.first));
        long root = 1;
        pq.add(new Pair(0, root));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (visited[(int) p.second] == 1) continue;
            visited[(int) p.second] = 1;
            for (Pair q : adj[(int) p.second]) {
                if (dist[(int) q.first] > dist[(int) p.second] + q.second) {
                    dist[(int) q.first] = dist[(int) p.second] + q.second;
                }
                pq.add(new Pair(dist[(int) q.first], q.first));
            }
        }
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 1; i <= n; i++) {out.print(dist[i] + " ");}
        out.print("\n");
        out.flush();
        return;
    }
}

class Pair {
    public long first;
    public long second;

    public Pair(long f, long s) { this.first = f; this.second = s;}
}