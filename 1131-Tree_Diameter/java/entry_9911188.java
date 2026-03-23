import java.io.*;
import java.util.*;

public class entry_9911188 {
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
        int start, end, duration;
        Pair(int entry_9911188, int b)
        {
            start = entry_9911188;
            end = b;
            duration = end - start;
        }

        public String toString()
        {
            return "(" + start + ", " + end + ")";
        }
    }

    static List<List<Integer>> graph;

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
            graph = new ArrayList<>();
            for(int i = 0; i < n; i++)
                graph.add(new ArrayList<>());
            for(int i = 1; i < n; i++)
            {
                int u = fr.nextInt() - 1, v = fr.nextInt() - 1;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            int[] last = bfs(0);
            int[] ans = bfs(last[0]);
            _v.append(ans[1]);
            _v.append("\n");
        }
        out.print(_v);
        out.flush();
    }

    public static int[] bfs(int src)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {src, 0});
        boolean[] visited = new boolean[graph.size()];
        int[] last = null;
        while(!q.isEmpty())
        {
            last = q.poll();
            visited[last[0]] = true;
            for(int child : graph.get(last[0]))
            {
                if(visited[child])
                    continue;
                q.add(new int[] {child, last[1] + 1});
            }
        }
        return last;
    }
}