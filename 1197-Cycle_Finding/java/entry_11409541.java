import java.io.*;
import java.util.*;

public class entry_11409541 {

    final static int MOD = (int)1e9 + 7;

    // ----predefined for taking inputs---------------------

    static int toInt(StringTokenizer st) 
    {
        return Integer.parseInt(st.nextToken());
    }

    static long toLong(StringTokenizer st) 
    {
        return Long.parseLong(st.nextToken());
    }

    static double toDouble(StringTokenizer st) 
    {
        return Double.parseDouble(st.nextToken());
    }

    static float toFloat(StringTokenizer st) 
    {
        return Float.parseFloat(st.nextToken());
    }

    static StringTokenizer tokens(BufferedReader in) throws IOException 
    {
        return new StringTokenizer(in.readLine().strip());
    }

    static int[] toIntArr(BufferedReader in, int n) throws IOException
    {
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine().trim());
        for (int i = 0; i < n; i++) arr[i] = toInt(st);
        return arr;
    }

    static long[] toLongArr(BufferedReader in, int n) throws IOException
    {
        long arr[] = new long[n];
        StringTokenizer st = new StringTokenizer(in.readLine().trim());
        for (int i = 0; i < n; i++) arr[i] = toLong(st);
        return arr;
    }

    // -----------------------------------------------------

    public static void main(String[] args) throws IOException 
    {

        // ----------for reading from stdin-----------------

        PrintWriter out = new PrintWriter(System.out);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // -------------------------------------------------

        // ----------for reading from a file----------------

        // in = new BufferedReader(new FileReader("test_input.txt"));
        // out = new PrintWriter("test_output.txt");

        // -------------------------------------------------

        StringTokenizer st;
        var result = new StringBuilder();

        // ----------------solution here--------------------

        int t = 1;
        // t = toInt(tokens(in));
        while (t-- > 0)
        {

            st = tokens(in);
            int n = toInt(st);
            int m = toInt(st);

            int[][] edges = new int[m][3];
            for (int i = 0; i < m; i++) edges[i] = toIntArr(in, 3);

            int x = -1;

            int parent[] = new int[n+2];
            Arrays.fill(parent, -1);

            long dist[] = new long[n+2];
            Arrays.fill(dist, 0);

            dist[1] = 0;
            for (int i = 1; i <= n; i++)
            {
                x = -1;
                for (var edge: edges)
                {
                    if (dist[edge[0]] + edge[2] < dist[edge[1]]) 
                    {
                        dist[edge[1]] = dist[edge[0]] + edge[2];
                        parent[edge[1]] = edge[0];
                        x = edge[1];
                    }
                }
            }

            if (x == -1) result.append("NO\n");
            else 
            {

                result.append("YES\n");

                for (int i = 0; i < n; i++) x = parent[x]; // to make sure we are inside the cycle

                List<Integer> cycle = new ArrayList<>();
                for (int v = x; ; v = parent[v])
                {
                    cycle.add(v);
                    if (v == x && cycle.size() > 1) break;
                }

                Collections.reverse(cycle);

                for (int a: cycle) result.append(a + " ");

            }

        }

        // -------------------------------------------------

        in.close();
        out.print(result);
        out.close();

    }

    // -------------------functions here----------------

    // -------------------------------------------------


}