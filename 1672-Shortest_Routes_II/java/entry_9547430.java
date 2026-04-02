import java.io.*;
import java.util.*;

public class entry_9547430 {
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

    public static final long BIG = (long)1e18;

    public static void main(String args[])
    {
        FastReader fr = new FastReader();
        // int t = fr.nextInt();
        int t = 1;
        PrintWriter out = new PrintWriter(System.out);
        while(t-- > 0)
        {
            int n = fr.nextInt();
            int m = fr.nextInt();
            int q = fr.nextInt();
            long[][] distance = new long[n][n];
            for(long[] ar : distance)
                Arrays.fill(ar, BIG);
            for(int i = 0; i < m; i++)
            {
                int u = fr.nextInt() - 1;
                int v = fr.nextInt() - 1;
                int wt = fr.nextInt();
                if(distance[u][v] < wt)
                    continue;
                distance[u][v] = distance[v][u] = wt;
            }
            for(int k = 0; k < n; k++)
            {
                for(int i = 0; i < n; i++)
                {
                    for(int j = i+1; j < n; j++)
                    {
                        long x = distance[i][k] + distance[k][j];
                        if(x < distance[i][j])
                        distance[i][j] = distance[j][i] = x;
                    }
                }
            }

            for(int i = 0; i < q; i++)
            {
                int u = fr.nextInt() - 1;
                int v = fr.nextInt() - 1;
                out.println(u == v ? 0 : distance[u][v] != BIG ? distance[u][v] : -1);
            }
        }
        out.flush();
    }
}