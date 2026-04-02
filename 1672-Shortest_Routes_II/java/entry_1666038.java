import java.util.*;
import java.io.*;
import java.math.*;

public class entry_1666038 {

    final static int mod = 1000000007;
    static FastReader sc;
    static PrintWriter out;
    static boolean test_case_input = false;

    public static void solution() throws IOException
    {
        // code
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        long adj[][] = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
        {
            Arrays.fill(adj[i], Long.MAX_VALUE);
            adj[i][i] = 0;
        }
        for (int i = 0; i < m; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();
            adj[a][b] = Math.min(c, adj[a][b]);
            adj[b][a] = Math.min(c, adj[b][a]);
        }

        // floyd warshall algorithm
        for (int k = 1; k <= n; k++)
        {
            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    if(adj[i][j] > adj[i][k] + adj[k][j] && adj[k][j] != Long.MAX_VALUE && adj[i][k] != Long.MAX_VALUE)
                    {
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }

//        debug(adj);

        for(int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long ans = adj[a][b];
            ans = (ans == Long.MAX_VALUE) ? -1 : ans;
            out.println(ans);
        }
    }

    // log A base B
    public static int logint(int x, int base)
    {
        return (int) (Math.log(x) / Math.log(base));
    }

    public static int logint(long x, long base)
    {
        return (int) (Math.log(x) / Math.log(base));
    }

    public static int logint(double x, double base)
    {
        return (int) (Math.log(x) / Math.log(base));
    }

    public static double logdouble(int x, int base)
    {
        return (Math.log(x) / Math.log(base));
    }

    public static double logdouble(long x, long base)
    {
        return (Math.log(x) / Math.log(base));
    }

    public static double logdouble(double x, double base)
    {
        return (Math.log(x) / Math.log(base));
    }

    public static long loglong(int x, int base)
    {
        return (long) (Math.log(x) / Math.log(base));
    }

    public static long loglong(long x, long base)
    {
        return (long) (Math.log(x) / Math.log(base));
    }

    public static long loglong(double x, double base)
    {
        return (long) (Math.log(x) / Math.log(base));
    }

    // Debug
    public static void debug(String msg, Object value)
    {
        File output = new File("output.txt");
        if (!output.exists()) return;
        String type = value.getClass().getSimpleName();
        if (type.equals("int[]")) out.println(msg + " => " + Arrays.toString((int[]) value));
        else if (type.equals("double[]")) out.println(msg + " => " + Arrays.toString((double[]) value));
        else if (type.equals("float[]")) out.println(msg + " => " + Arrays.toString((float[]) value));
        else if (type.equals("long[]")) out.println(msg + " => " + Arrays.toString((long[]) value));
        else if (type.equals("char[]")) out.println(msg + " => " + Arrays.toString((char[]) value));
        else if (type.equals("String[]")) out.println(msg + " => " + Arrays.toString((String[]) value));
        else if (type.equals("int[][]")) out.println(msg + " => " + Arrays.deepToString((int[][]) value));
        else if (type.equals("double[][]")) out.println(msg + " => " + Arrays.deepToString((double[][]) value));
        else if (type.equals("float[][]")) out.println(msg + " => " + Arrays.deepToString((float[][]) value));
        else if (type.equals("long[][]")) out.println(msg + " => " + Arrays.deepToString((long[][]) value));
        else if (type.equals("char[][]")) out.println(msg + " => " + Arrays.deepToString((char[][]) value));
        else if (type.equals("String[][]")) out.println(msg + " => " + Arrays.deepToString((String[][]) value));
        else out.println(msg + " => " + value);
    }

    public static void debug(Object value)
    {
        File output = new File("output.txt");
        if (!output.exists()) return;
        String type = value.getClass().getSimpleName();
        if (type.equals("int[]")) out.println(" => " + Arrays.toString((int[]) value));
        else if (type.equals("double[]")) out.println(" => " + Arrays.toString((double[]) value));
        else if (type.equals("float[]")) out.println(" => " + Arrays.toString((float[]) value));
        else if (type.equals("long[]")) out.println(" => " + Arrays.toString((long[]) value));
        else if (type.equals("char[]")) out.println(" => " + Arrays.toString((char[]) value));
        else if (type.equals("String[]")) out.println(" => " + Arrays.toString((String[]) value));
        else if (type.equals("int[][]")) out.println(" => " + Arrays.deepToString((int[][]) value));
        else if (type.equals("double[][]")) out.println(" => " + Arrays.deepToString((double[][]) value));
        else if (type.equals("float[][]")) out.println(" => " + Arrays.deepToString((float[][]) value));
        else if (type.equals("long[][]")) out.println(" => " + Arrays.deepToString((long[][]) value));
        else if (type.equals("char[][]")) out.println(" => " + Arrays.deepToString((char[][]) value));
        else if (type.equals("String[][]")) out.println(" => " + Arrays.deepToString((String[][]) value));
        else out.println(" => " + value);
    }

    // Graph Functions
    public static void addUndirectedEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void addDirectedEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
    }

    public static void addUndirectedEdge(ArrayList<ArrayList<Point>> adj, int u, int v, int weight)
    {
        adj.get(u).add(new Point(v, weight));
        adj.get(v).add(new Point(u, weight));
    }

    public static void addDirectedEdge(ArrayList<ArrayList<Point>> adj, int u, int v, int weight)
    {
        adj.get(u).add(new Point(v, weight));
    }

    public static <T> void toString(String msg, ArrayList<ArrayList<T>> adj)
    {
        out.println(msg + ":");
        int count = 0;
        for (ArrayList<T> i : adj)
        {
            out.print("\t" + count++ + ": ");
            for (T j : i)
            {
                out.print(j + " ");
            }
            out.println();
        }
    }

    public static void addUndirectedEdge(Map<Integer, ArrayList<Integer>> adj, int u, int v)
    {
        if (adj.containsKey(u))
        {
            ArrayList<Integer> temp = adj.get(u);
            temp.add(v);
            adj.put(u, temp);
        } else
        {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(v);
            adj.put(u, temp);
        }
        if (adj.containsKey(v))
        {
            ArrayList<Integer> temp = adj.get(v);
            temp.add(u);
            adj.put(v, temp);
        } else
        {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(u);
            adj.put(v, temp);
        }
    }

    public static void addDirectedEdge(Map<Integer, ArrayList<Integer>> adj, int u, int v)
    {
        if (adj.containsKey(u))
        {
            ArrayList<Integer> temp = adj.get(u);
            temp.add(v);
            adj.put(u, temp);
        } else
        {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(v);
            adj.put(u, temp);
        }
    }

    public static void addUndirectedEdge(Map<Integer, ArrayList<Point>> adj, int u, int v, int weight)
    {
        if (adj.containsKey(u))
        {
            ArrayList<Point> temp = adj.get(u);
            temp.add(new Point(v, weight));
            adj.put(u, temp);
        } else
        {
            ArrayList<Point> temp = new ArrayList<>();
            temp.add(new Point(v, weight));
            adj.put(u, temp);
        }
        if (adj.containsKey(v))
        {
            ArrayList<Point> temp = adj.get(v);
            temp.add(new Point(u, weight));
            adj.put(v, temp);
        } else
        {
            ArrayList<Point> temp = new ArrayList<>();
            temp.add(new Point(u, weight));
            adj.put(v, temp);
        }
    }

    public static void addDirectedEdge(Map<Integer, ArrayList<Point>> adj, int u, int v, int weight)
    {
        if (adj.containsKey(u))
        {
            ArrayList<Point> temp = adj.get(u);
            temp.add(new Point(v, weight));
            adj.put(u, temp);
        } else
        {
            ArrayList<Point> temp = new ArrayList<>();
            temp.add(new Point(v, weight));
            adj.put(u, temp);
        }
    }

    public static <T> void toString(String msg, Map<T, ArrayList<T>> adj)
    {
        out.println(msg + ":");
        for (Map.Entry<T, ArrayList<T>> entry : adj.entrySet())
        {
            out.println("\t" + entry.getKey() + ": " + entry.getValue());
        }
    }

    // GCD
    public static int __gcd(int a, int b)
    {
        BigInteger n1 = BigInteger.valueOf(a);
        BigInteger n2 = BigInteger.valueOf(b);
        BigInteger gcd = n1.gcd(n2);
        return gcd.intValue();
    }

    public static long __gcd(long a, long b)
    {
        BigInteger n1 = BigInteger.valueOf(a);
        BigInteger n2 = BigInteger.valueOf(b);
        BigInteger gcd = n1.gcd(n2);
        return gcd.longValue();
    }

    public static void main(String args[]) throws IOException
    {
        long start = 0, end = 0;
        try
        {
            File output = new File("output.txt");
            sc = new FastReader();
            if (output.exists())
            {
                out = new PrintWriter(new FileOutputStream("output.txt"));
                start = System.nanoTime();
            } else
            {
                out = new PrintWriter(System.out);
            }

            int test_cases = 1;
            if (test_case_input) test_cases = sc.nextInt();
            while (test_cases-- > 0)
            {
                solution();
            }
            if (output.exists())
            {
                end = System.nanoTime();
                out.println("Execution time: " + (end - start) / 1000000 + " ms");
            }
            out.flush();
            out.close();
        } catch (Exception e)
        {
            out.println("Exception: " + e);
            out.println("At Line no. : " + e.getStackTrace()[0].getLineNumber());
            out.flush();
            out.close();
            return;
        }
    }

    // Point Class
    static class Point implements Comparable<Point>
    {
        Object x;
        Object y;

        public Point(Object a, Object b)
        {
            x = a;
            y = b;
        }

        public int compareTo(Point obj)
        {
            if (obj.x.equals(this.x))
            {
                if ((obj.y).getClass() == Long.class) return ((Long) this.y).compareTo((Long) obj.y);
                else return ((Integer) this.y).compareTo((Integer) obj.y);
            } else
            {
                if ((obj.x).getClass() == Long.class) return ((Long) this.x).compareTo((Long) obj.x);
                else return ((Integer) this.x).compareTo((Integer) obj.x);
            }
        }

        public String toString()
        {
            String ans = "(" + x + ", " + y + ")";
            return ans;
        }

        @Override
        public int hashCode()
        {
            int hash = 7;
            hash = 71 * hash + (int) this.x;
            hash = 71 * hash + (int) this.y;
            return hash;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (obj == null) return false;
            Point point = (Point) obj;
            if (point.x.equals(this.x) && point.y.equals(this.y)) return true;
            else return false;
        }
    }

    // Fast IO
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException
        {
            File in = new File("input.txt");
            if (in.exists())
            {
                br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
            } else
            {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        float nextFloat()
        {
            return Float.parseFloat(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        int[] intarr(int n)
        {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Integer.parseInt(next());
            }
            return a;
        }

        long[] longarr(int n)
        {
            long a[] = new long[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Long.parseLong(next());
            }
            return a;
        }

        float[] floatarr(int n)
        {
            float a[] = new float[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Float.parseFloat(next());
            }
            return a;
        }

        double[] doublearr(int n)
        {
            double a[] = new double[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Double.parseDouble(next());
            }
            return a;
        }


        int[][] intmatrix(int row, int col)
        {
            int a[][] = new int[row][col];
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    a[i][j] = Integer.parseInt(next());
                }
            }
            return a;
        }

        long[][] longmatrix(int row, int col)
        {
            long a[][] = new long[row][col];
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    a[i][j] = Long.parseLong(next());
                }
            }
            return a;
        }

        float[][] floatmatrix(int row, int col)
        {
            float a[][] = new float[row][col];
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    a[i][j] = Float.parseFloat(next());
                }
            }
            return a;
        }

        double[][] doublematrix(int row, int col)
        {
            double a[][] = new double[row][col];
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    a[i][j] = Double.parseDouble(next());
                }
            }
            return a;
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}