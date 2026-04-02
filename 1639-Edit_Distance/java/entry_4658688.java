/*-----------                                 ---------------*
                    Author : Ryan Ranaut
            __Hope is a big word, never lose it__
-------------                                 --------------*/


import java.io.*;
import java.util.*;
public class entry_4658688 {
    static PrintWriter out = new PrintWriter(System.out);
    static final int mod = 1_000_000_007;
    static final long max = (long)1e12;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    /*--------------------------------------------------------------------------*/
    public static void main(String[] args)
    {
        FastReader s = new FastReader();
        char[] str1 = s.nextLine().toCharArray();
        char[] str2 = s.nextLine().toCharArray();
        int n = str1.length, m = str2.length;
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i == 0){
                    dp[i][j] = j;
                    continue;
                }
                if(j == 0){
                    dp[i][j] = i;
                    continue;
                }
                if(str1[i-1] == str2[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else
                {
                    int x1 = 1 + dp[i-1][j];//Remove
                    int x2 = 1 + dp[i][j-1];//Add
                    int x3 = 1 + dp[i-1][j-1];//Replace
                    dp[i][j] = Math.min(x1, Math.min(x2, x3));
                }
            }
        }

        out.println(dp[n][m]);



        out.close();
    }






















































    /*----------------------------------End of the road--------------------------------------*/

    static class DSU {
        int[] parent;
        int[] ranks;
        int[] groupSize;
        int size;

        public DSU(int n) {
            size = n;
            parent = new int[n];//0 based
            ranks = new int[n];
            groupSize = new int[n];//Size of each component
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                ranks[i] = 1;
                groupSize[i] = 1;
            }
        }

        public int find(int x)//Path Compression
        {
            if (parent[x] == x)
                return x;
            else
                return parent[x] = find(parent[x]);
        }

        public void union(int x, int y)//Union by rank
        {
            int x_rep = find(x);
            int y_rep = find(y);
            if (x_rep == y_rep)
                return;

            if (ranks[x_rep] < ranks[y_rep]) {
                parent[x_rep] = y_rep;
                groupSize[y_rep] += groupSize[x_rep];
            } else if (ranks[x_rep] > ranks[y_rep]) {
                parent[y_rep] = x_rep;
                groupSize[x_rep] += groupSize[y_rep];
            } else {
                parent[y_rep] = x_rep;
                ranks[x_rep]++;
                groupSize[x_rep] += groupSize[y_rep];
            }

            size--;//Total connected components
        }
    }

    public static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public static long gcd(long x, long y) {
        return y == 0L ? x : gcd(y, x % y);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static long pow(long a, long b) {
        if (b == 0L)
            return 1L;
        long tmp = 1;
        while (b > 1L) {
            if ((b & 1L) == 1)
                tmp *= a;
            a *= a;
            b >>= 1;
        }
        return (tmp * a);
    }

    public static long modPow(long a, long b, long mod) {
        if (b == 0L)
            return 1L;
        long tmp = 1;
        while (b > 1L) {
            if ((b & 1L) == 1L)
                tmp *= a;

            a *= a;
            a %= mod;
            tmp %= mod;
            b >>= 1;
        }
        return (tmp * a) % mod;
    }

    static long mul(long a, long b) {
        return a * b;
    }

    static long fact(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) ans = mul(ans, i);
        return ans;
    }

    static long fastPow(long base, long exp) {
        if (exp == 0) return 1;
        long half = fastPow(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }

    static void debug(int... a) {
        for (int x : a)
            out.print(x + " ");
        out.println();
    }

    static void debug(long... a) {
        for (long x : a)
            out.print(x + " ");
        out.println();
    }

    static void debugMatrix(int[][] a) {
        for (int[] x : a)
            out.println(Arrays.toString(x));
    }

    static void debugMatrix(long[][] a) {
        for (long[] x : a)
            out.println(Arrays.toString(x));
    }

    static void reverseArray(int[] a) {
        int n = a.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = a[n - i - 1];
        for (int i = 0; i < n; i++)
            a[i] = arr[i];
    }

    static void reverseArray(long[] a) {
        int n = a.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = a[n - i - 1];
        for (int i = 0; i < n; i++)
            a[i] = arr[i];
    }

    static void sort(int[] a) {
        ArrayList<Integer> ls = new ArrayList<>();
        for (int x : a) ls.add(x);
        Collections.sort(ls);
        for (int i = 0; i < a.length; i++)
            a[i] = ls.get(i);
    }

    static void sort(long[] a) {
        ArrayList<Long> ls = new ArrayList<>();
        for (long x : a) ls.add(x);
        Collections.sort(ls);
        for (int i = 0; i < a.length; i++)
            a[i] = ls.get(i);
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}