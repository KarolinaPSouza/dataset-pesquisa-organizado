import java.io.*;
import java.util.*;

public class entry_9899374 {
    static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 

        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
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

    static final int mod = 1000000007;
    static final long INF = (long)(1e18);

    static class Pair
    {
        int v;
        long weight;
        boolean isInverted;
        Pair(int entry_9899374, long b, boolean c)
        {
            v = entry_9899374;
            weight = b;
            isInverted = c;
        }
    }

    public static void main(String args[]) throws IOException
    {
        FastReader fr = new FastReader();
        // Scanner fr = new Scanner(new File("C:\\Users\\ykgup\\Downloads\\test_input.txt"));
        // int t = fr.nextInt();
        int t = 1;
        StringBuilder _v = new StringBuilder();
        PrintWriter out = new PrintWriter(System.out);
        while(t-- > 0)
        {
            int n = fr.nextInt();
            int m = fr.nextInt();
            List<List<Pair>> graph = new ArrayList<>();
            long[][] distance = new long[2][n];
            for(int i = 0; i < n; i++)
            {
                distance[0][i] = distance[1][i] = INF;
                graph.add(new ArrayList<>());
            }
            for(int i = 0; i < m; i++)
            {
                int u = fr.nextInt() - 1, v = fr.nextInt() - 1;
                int w = fr.nextInt();
                graph.get(u).add(new Pair(v, w, false));
                graph.get(v).add(new Pair(u, w, true));
            }
            dijkstra(0, distance[0], graph, false);
            dijkstra(n-1, distance[1], graph, true);
            long ans = INF;
            for(int i = 0; i < n; i++)
            {
                for(Pair p : graph.get(i))
                {
                    if(p.isInverted || distance[0][i] == INF || distance[1][p.v] == INF)
                        continue;
                    //      1 -> ... -> i -> p.v -> ... -> N
                    // =    1 -> ... -> (i -> p.v) / 2 -> ... -> N
                    ans = Math.min(ans, distance[0][i] + (p.weight / 2) + distance[1][p.v]);
                }
            }
            _v.append(ans);
            _v.append("\n");
        }
        out.print(_v);
        out.flush();
    }

    public static void dijkstra(int src, long[] distance, List<List<Pair>> graph, boolean isInverted)
    {
        PriorityQueue<Pair> q = new PriorityQueue<>((entry_9899374, b) -> entry_9899374.weight < b.weight ? -1 : entry_9899374.weight > b.weight ? 1 : 0);
        q.add(new Pair(src, 0, isInverted));
        distance[src] = 0;
        boolean[] visited = new boolean[distance.length];
        while(!q.isEmpty())
        {
            Pair u = q.poll();
            if(visited[u.v])
                continue;
            visited[u.v] = true;
            for(Pair v : graph.get(u.v))
            {
                if(v.isInverted != isInverted)
                    continue;
                if(distance[v.v] > distance[u.v] + v.weight)
                {
                    distance[v.v] = distance[u.v] + v.weight;
                    q.add(new Pair(v.v, distance[v.v], isInverted));
                }
            }
        }
    }
}