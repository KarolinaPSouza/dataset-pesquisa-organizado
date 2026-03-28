//RahulAhuja2901
import java.io.*;
import java.util.*;
//import java.util.StringTokenizer;
//import javafx.util.Pair;
public class entry_11125770 {
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        public Reader()
        {
            din = new DataInputStream(System.in);
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
                if (c == ' ') {
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
    public static long gcd (long a, long b)
    {
        if (b == 0)
        {
            return a;
        }
        return gcd (b, a % b);
    }
    public static long lcm (long a, long b)
    {
        long hcf = gcd (a, b);
        return (a * b) / hcf;
    }
    public static void Sort (long arr[][])
    {
        Arrays.sort (arr, new Comparator<long[]> () {
            public int compare (long[] arr1, long[] arr2)
            {
                if (arr1[0] > arr2[0])
                {
                    return 1;
                }
                else if (arr1[0] < arr2[0])
                {
                    return -1;
                }
                else
                {
                    if (arr1[1] > arr2[1])
                    {
                        return 1;
                    }
                    else if (arr1[1] < arr2[1])
                    {
                        return -1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            }
        });
    }
    public static long sqrtl (long n)
    {
        long low = 0, high = (long)1e10, ans = -1;
        while (low <= high)
        {
            long mid = (low + high) / 2;
            if (mid * mid <= n)
            {
                ans = mid;
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static long pow (long x, long y, long mod)
    {
        x = x % mod;
        if (x == 0)
        {
            return 0;
        }
        long ans = 1;
        while (y > 0)
        {
            if ((y & 1) == 1)
            {
                ans = (ans * x) % mod;
            }
            y = y >> 1;
            x = (x * x) % mod;
        }
        return ans;
    }
    public static int lower_bound (long[] arr, long num)
    {
        int n = arr.length, low = 0, high = n - 1, ans = n - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (arr[mid] >= num)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int upper_bound (long[] arr, long num)
    {
        int n = arr.length, low = 0, high = n - 1, ans = 0;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (arr[mid] <= num)
            {
                ans = mid;
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static long[] ListToArray (ArrayList<Long> al)
    {
        int n = al.size(), i;
        long arr[] = new long[n];
        for (i=0;i<n;i++)
        {
            arr[i] = al.get (i);
        }
        return arr;
    }
    public static long ModAdd (long x, long y, long mod)
    {
        return ((x % mod) + (y % mod)) % mod;
    }
    public static long ModSub (long x, long y, long mod)
    {
        return ((x % mod) - (y % mod) + mod) % mod;
    }
    public static long ModMul (long x, long y, long mod)
    {
        return ((x % mod) * (y % mod)) % mod;
    }
    public static long ModInv (long num, long mod)
    {
        return pow (num, mod - 2, mod);
    }
    public static long nCrMod (long n, long r, long mod, long[] fact)
    {
        if (n < r)
        {
            return 0;
        }
        if (r == 0)
        {
            return 1;
        }
        long num = fact[(int)n];
        long den = ModMul (ModInv (fact[(int)r], mod), ModInv(fact[(int)(n - r)], mod), mod);
        return ModMul (num, den, mod);
    }
    public static int[] getMinDist (int source, int n, ArrayList<ArrayList<Integer>> adjList)
    {
        Queue<Integer> unexplored = new LinkedList<Integer> ();
        int[] minDist = new int[n + 1];
        Arrays.fill (minDist, (int)1e9);
        unexplored.add (source);
        minDist[source] = 0;
        while (!unexplored.isEmpty())
        {
            int curr = unexplored.poll();
            for (int next : adjList.get(curr))
            {
                if (minDist[curr] + 1 < minDist[next])
                {
                    minDist[next] = minDist[curr] + 1;
                    unexplored.add (next);
                }
            }
        }
        return minDist;
    }
    public static PrintWriter out;
    public static void main (String[] args) throws java.lang.Exception
    {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        try
        {
            //Scanner obj = new Scanner (System.in);
            Reader obj = new Reader ();
            //long mod = (long)1e9 + 7;
            /*long pow2[] = new long[(int)1e6 + 1];
            pow2[0] = 1;
            for (int i=1;i<=(int)1e6;i++)
            {
                pow2[i] = ModMul (pow2[i-1], 2, mod);
            }*/
            /*long fact[] = new long[(int)1e6 + 1];
            fact[0] = 1;
            for (int i=1;i<=(int)1e6;i++)
            {
                fact[i] = ModMul (fact[i-1], i, mod);
            }*/
            // int testCases = obj.nextInt();
            // while (testCases > 0)
            // {
            //     testCases--;
                int n = obj.nextInt();
                //long n = obj.nextLong();
                //String str = obj.next();
                //char ch[] = str.toCharArray();
                //int arr[] = new int[n];
                //long arr[] = new long[n];
                //ArrayList<Integer> arr = new ArrayList<Integer>(n);
                //ArrayList<Long> arr = new ArrayList<Long>(n);
                //HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                //HashMap<Long, Long> map = new HashMap<Long, Long>();
                //HashMap<Character, Character> map = new HashMap<Character, Character>();
                //Set<Integer> set = new HashSet<Integer>();
                //Set<Long> set = new HashSet<Long>();
                //Set<Character> set = new HashSet<Character>();
                //TreeSet<Integer> tset = new TreeSet<Integer>();
                ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
                for (int node=0;node<=n;node++)
                {
                    adjList.add (new ArrayList<Integer> ());
                }
                for (int ind=1;ind<n;ind++)
                {
                    int u = obj.nextInt();
                    int v = obj.nextInt();
                    adjList.get(u).add(v);
                    adjList.get(v).add(u);
                }
                int[] minDist1 = getMinDist (1, n, adjList);
                int maxDist = -1, maxNode = -1;
                for (int node=1;node<=n;node++)
                {
                    if (minDist1[node] > maxDist)
                    {
                        maxDist = minDist1[node];
                        maxNode = node;
                    }
                }
                int[] minDistFirstEndDiameter = getMinDist (maxNode, n, adjList);
                maxDist = -1;
                maxNode = -1;
                for (int node=1;node<=n;node++)
                {
                    if (minDistFirstEndDiameter[node] > maxDist)
                    {
                        maxDist = minDistFirstEndDiameter[node];
                        maxNode = node;
                    }
                }
                int[] minDistSecondEndDiameter = getMinDist (maxNode, n, adjList);
                for (int node=1;node<=n;node++)
                {
                    maxDist = Math.max(minDistFirstEndDiameter[node], minDistSecondEndDiameter[node]);
                    out.print (maxDist + " ");
                }
            // }
        }catch(Exception e){
            return;
        }
        out.flush();
        out.close();
    }
}