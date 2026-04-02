import java.io.*;
import java.util.*;

@SuppressWarnings("unused")
public class entry_9925958 {

    final static int MOD = (int)1e9 + 7;
    final static int INF = (int)1e9;

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

        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        // ----------solution here--------------------------

        st = tokens(in);
        int v = toInt(st);
        int e = toInt(st);

        DisjointSet djs = new DisjointSet(v);
        for (int i = 0; i < e; i++)
        {
            st = tokens(in);
            djs.union(toInt(st)-1, toInt(st)-1);
        }

        ArrayList<Integer> ulps = new ArrayList<>();
        for (int i = 0; i < v; i++)
        {
            if (djs.parent.get(i) == i) ulps.add(i);
        }


        result.append(ulps.size()-1).append("\n");
        if (ulps.size() < 2)
        {
            out.print(result);
            out.close();
            return;
        }

        for (int i = 1; i < ulps.size(); i++)
        {
            result.append(ulps.get(i)+1).append(" ").append(ulps.get(i-1)+1).append("\n");
        }

        // ---------------------------------------------------

        out.print(result);
        out.close();
        in.close();

    }

    // ---------functions used in the solution are here-------

    static class DisjointSet 
    {

        ArrayList<Integer> rank = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();

        DisjointSet (int n)
        {
            for (int i = 0; i < n; i++)
            {
                rank.add(0);
                parent.add(i);
            }
        }

        int findUpar(int node)
        {

            if (node == parent.get(node)) return node;

            int ulp = findUpar(parent.get(node));
            parent.set(node, ulp); // path compression

            return parent.get(node);

        }

        void union(int u, int v) // by rank
        {

            int pu = findUpar(u);
            int pv = findUpar(v);

            if (pu == pv) return;

            if (rank.get(pu) < rank.get(pv)) parent.set(pu, pv);
            else if (rank.get(pu) > rank.get(pv)) parent.set(pv, pu);
            else 
            {
                parent.set(pv, pu);
                rank.set(pu, rank.get(pu) + 1);
            }

        }

    }

}