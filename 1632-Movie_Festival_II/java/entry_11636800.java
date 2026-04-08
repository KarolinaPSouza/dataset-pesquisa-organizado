import java.io.*;
import java.util.*;
import java.util.function.Function;

public class entry_11636800 {
    static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 

        public FastReader() throws FileNotFoundException
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
            // br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\ykgup\\Downloads\\test_input.txt")))); 
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

        int[] nextIntArray(int n)
        {
            int[] ans = new int[n];
            for(int i = 0; i < n; i++)
                ans[i] = nextInt();
            return ans;
        }

        Integer[] nextIntegerArray(int n)
        {
            Integer[] ans = new Integer[n];
            for(int i = 0; i < n; i++)
                ans[i] = nextInt();
            return ans;
        }

        long[] nextLongArray(int n)
        {
            long[] ans = new long[n];
            for(int i = 0; i < n; i++)
                ans[i] = nextLong();
            return ans;
        }

        String[] nextStringArray(int n)
        {
            String[] ans = new String[n];
            for(int i = 0; i < n; i++)
                ans[i] = next();
            return ans;
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

    // FOR CSES
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() throws FileNotFoundException
        {
            din = new DataInputStream(System.in);
            // din = new DataInputStream(new FileInputStream(new File("C:\\Users\\ykgup\\Downloads\\test_input.txt")));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    static final int MOD = (int)(1e9) + 7;
    static final long INF = (long)(1e18);
    static final int INF_INT = (int)(1e9);

    @SuppressWarnings("unused")
    private static long gcd(long entry_11636800, long b)
    {
        if(b == 0)
            return entry_11636800;
        return gcd(b, entry_11636800 % b);
    }

    @SuppressWarnings("unused")
    private static long pow(long base, long pow)
    {
        long ans = 1;
        while(pow > 0)
        {
            if((pow & 1) == 1)
                ans = (ans * base) % MOD;
            base = (base * base) % MOD;
            pow >>= 1;
        }
        return ans;
    }

    static class DSU
    {
        int n;
        int[] parent, size;

        public DSU(int _n)
        {
            n = _n;
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++)
            {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int node)
        {
            if(node == parent[node])
                return node;
            return parent[node] = findParent(parent[node]);
        }

        public int union(int u, int v)
        {
            int rootU = findParent(u), rootV = findParent(v);
            if(rootU == rootV)
                return -1;
            if(rootU > rootV)
            {
                rootU += rootV;
                rootV = rootU - rootV;
                rootU -= rootV;
            }
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
            size[rootV] = 0;
            return size[rootU];
        }

        public boolean same(int u, int v)
        {
            return findParent(u) == findParent(v);
        }
    }

    static class Pair
    {
        int start, end, ind;
        Pair(int entry_11636800, int b, int c)
        {
            start = entry_11636800;
            end = b;
            ind = c;
        }

        public String toString()
        {
            return String.format("(%d, %d)", start, end);
        }
    }

    static Boolean[][][][] dp;
    static Function<Integer, Integer> f1;

    public static void main(String args[]) throws IOException
    {
        // FastReader fr = new FastReader();
        Reader fr = new Reader();
        // Scanner fr = new Scanner(System.in);
        // Scanner fr = new Scanner(new File("C:\\Users\\ykgup\\Downloads\\test_input.txt"));
        // int _t = fr.nextInt();
        int _t = 1;
        // int _case = 1;
        StringBuilder _v = new StringBuilder();
        PrintWriter out = new PrintWriter(System.out);
        while(_t-- > 0)
        {
            int n = fr.nextInt(), k = fr.nextInt();
            Pair[] ar = new Pair[n];
            for(int i = 0; i < n; i++)
                ar[i] = new Pair(fr.nextInt(), fr.nextInt(), i);
            Arrays.sort(ar, (entry_11636800, b) -> entry_11636800.end - b.end);
            TreeSet<Pair> set = new TreeSet<>((entry_11636800, b) -> entry_11636800.end == b.end ? entry_11636800.ind - b.ind : entry_11636800.end - b.end);
            // System.out.println(Arrays.toString(ar));
            int ans = 0;
            for(int i = 0; i < n; i++)
            {
                Pair p = set.lower(new Pair(ar[i].end, ar[i].start, ar[i].ind));
                if(p == null)
                {
                    if(set.size() < k)
                    {
                        set.add(ar[i]);
                        ans++;
                    }
                }
                else
                {
                    set.remove(p);
                    set.add(ar[i]);
                    ans++;
                }
            }
            _v.append(ans);
            _v.append("\n");
            // _v.append("Case");
            // _v.append(" ");
            // _v.append(_case++);
            // _v.append(": ");
        }
        out.print(_v);
        out.flush();
    }
}