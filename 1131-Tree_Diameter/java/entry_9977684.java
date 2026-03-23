import java.io.*;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

@SuppressWarnings("unused")
public class entry_9977684 {

    final static int MOD = (int)1e9 + 7;
    final static long INF = (long)1e18;
    // final static int INF = (int)1e9;

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

    // -----------------------------------------------------

    public static void main(String[] args) throws IOException 
    {

        PrintWriter out = new PrintWriter(System.out);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // BufferedReader in = new BufferedReader(new FileReader("test_input.txt"));
        // PrintWriter out = new PrintWriter("test_output.txt");

        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        // ----------solution here--------------------------

        int n = toInt(tokens(in));
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int e = 0; e < n-1; e++) 
        {

            st = tokens(in);
            int a = toInt(st);
            int b = toInt(st);

            adj.get(a).add(b);
            adj.get(b).add(a);

        }

        int[] ans = {0};
        dfs(n >> 1, adj, new boolean[n+1], ans);
        result.append(ans[0]);

        // ---------------------------------------------------

        in.close();
        out.print(result);
        out.close();

    }

    // ---------functions used in the solution are here-------

    private static int dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] ans)
    {

        vis[node] = true;

        // if (isEnd(node, adj, vis)) return 1;

        int max1 = 0, max2 = 0;
        for (int child: adj.get(node))
        {

            if (vis[child]) continue;

            int temp = dfs(child, adj, vis, ans);
            if (temp > max1) 
            {
                max2 = max1;
                max1 = temp;
            }
            else if (temp > max2) max2 = temp;

        }

        ans[0] = Math.max(max1 + max2, ans[0]);

        return max1 + 1;

    }

    private static boolean isEnd(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis)
    {

        for (int x: adj.get(node))
        {
            if(!vis[x]) return false;
        }

        return true;

    }


    // -------------------------------------------------------


}