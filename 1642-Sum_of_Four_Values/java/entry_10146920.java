import com.sun.source.tree.Tree;
import com.sun.source.util.Trees;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;



/***********************************************************************************************************************************************
  ***********************************************************************************************************************************************/
public class entry_10146920 {
    static FastReader in=new FastReader();
    static final Random random=new Random();
    static long mod=1000000007L;
    static long mod1=998244353L;
    static HashMap<Integer,Integer> map=new HashMap<>();

    static long fact[];

    public static void main(String args[]) throws IOException {
        int T = 1;
        int cse = 1;

        loop:
        while (T-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();

            int[] arr = in.readintarray(n);

            TreeMap<Integer, Pair> map = new TreeMap<>();

            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    int temp = x - arr[i] - arr[j];

                    if(map.containsKey(temp)) {
                        print((map.get(temp).getFirst() + 1) + " " + (map.get(temp).getSecond() + 1) + " " + (i + 1) + " " + (j + 1));
                        return;
                    }
                }

                for(int j = 0; j < i; j++) {
                    map.put(arr[i] + arr[j], new Pair(i, j));
                }
            }

            print("IMPOSSIBLE");
        }
    }
    public static long C(int n, int k) {
        if(n < k) return 0;
        return fact[n] * binexp(fact[k] * fact[n - k] % mod, mod - 2, mod) % mod;
    }

    /********************************************************************************************************
     * SEGMENT TREE
     * *******************************************************************************************************/
    static class SegmentTree {
        int[] arr;
        int[] tree;


        public SegmentTree(int[] arr, int k) {
            this.arr = arr;
            this.tree = new int[4*arr.length];

            build(1, 0, arr.length - 1, k);
        }

        private void build(int node, int start, int end, int k) {
            if(start == end) {
                tree[node] = arr[start] > k ? 1 : 0;
                return;
            }

            int mid = (start + end)/2;
            int left = node*2;
            int right = node*2 + 1;

            build(left, start, mid, k);
            build(right, mid + 1, end, k);

            tree[node] = tree[left] + tree[right];
        }

        public int query(int l, int r) {
            return query(1, 0, arr.length - 1, l, r);
        }

        private int query(int node, int start, int end, int l, int r) {
            if(start > r || end < l) return 0;

            if(l <= start && end <= r) {
                return tree[node];
            }

            int mid = (start + end)/2;
            int left = query(node*2, start, mid, l, r);
            int right = query(node*2 + 1, mid + 1, end, l, r);

            return left + right;
        }

    }


    /********************************************************************************************************
     * *******************************************************************************************************/


    /********************************************************************************************************
     * FENWICK TREE
     * *******************************************************************************************************/

    static class FenwickTree {
        TreeMap<Integer, Integer> map;
        int n;

        public FenwickTree(int n) {
            this.n = n;
            map = new TreeMap<>();
        }

        private int lsb(int i) {
            return (i & -i);
        }

        public int prefixSum(int pos) {
            int sum = 0;
            while(pos > 0) {
                if(map.containsKey(pos)) sum += map.get(pos);
                pos -= lsb(pos);
            }
            return sum;
        }

        public int query(int l, int r) {
            return prefixSum(r) - prefixSum(l - 1);
        }

        public void update(int val, int pos) {

            while(pos <= n) {
                map.put(pos, map.getOrDefault(pos, 0) + val);
                pos += lsb(pos);
            }
            //print(map);
        }
    }

    /********************************************************************************************************
     ********************************************************************************************************/


    static class Pair implements Comparable<Pair>{
        private Integer first;
        private Integer second;
        public Pair(Integer first, Integer second) {
            super();
            this.first = first;
            this.second = second;
        }

        public int hashCode() {
            int hashFirst = first != null ? first.hashCode() : 0;
            int hashSecond = second != null ? second.hashCode() : 0;

            return (hashFirst + hashSecond) * hashSecond + hashFirst;
        }

        public boolean equals(Object other) {
            if (other instanceof Pair) {
                Pair otherPair = (Pair) other;
                return
                        ((  this.first == otherPair.first ||
                                ( this.first != null && otherPair.first != null &&
                                        this.first.equals(otherPair.first))) &&
                                (  this.second == otherPair.second ||
                                        ( this.second != null && otherPair.second != null &&
                                                this.second.equals(otherPair.second))) );
            }

            return false;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.getFirst().intValue() == o.getFirst().intValue()) {
                return (o.getSecond() - this.getSecond());
            }
            return this.getFirst() - o.getFirst();
        }

        public String toString()
        {
            return "(" + first + ", " + second + ")";
        }

        public Integer getFirst() {
            return first;
        }

        public void setFirst(Integer first) {
            this.first = first;
        }

        public Integer getSecond() {
            return second;
        }

        public void setSecond(Integer second) {
            this.second = second;
        }
    }


    /************************************************************************************************************************************************************
     Template Starts
     ************************************************************************************************************************************************************/

    /*******************************************************************************************************************
     Disjoint Set Union
     *******************************************************************************************************************/
    public static int find(int x, int[] parent) {
        if(x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x], parent);
    }
    public static boolean union(int x, int y, int[] parent, int[] rank) {
        int lx = find(x,  parent);
        int ly = find(y, parent);

        if(lx != ly) {
            if(rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else if (rank[lx] < rank[ly]) {
                parent[lx] = ly;
            } else {
                parent[lx] = ly;
                rank[ly]++;
            }

            return true;
        }

        return false;
    }

    /*******************************************************************************************************************
     ******************************************************************************************************************/

    public static int[] kmp(String s, String pattern) {
        String st = s + "#" + pattern;
        int[] lps = new int[st.length()];

        int i = 1, len = 0;

        while(i < lps.length) {
            if(st.charAt(i) == st.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
    public static int min(int a, int b) {
        if(a < b) {
            return a;
        }

        return b;
    }

    public static long min(long a, long b) {
        if(a < b) {
            return a;
        }

        return b;
    }

    public static long binexp(long a, long b, long m) {
        long res = 1;
        while(b != 0) {
            if((b & 1) == 1) res = (res * a) % m;
            a = (a * a) % m;
            b >>= 1;
        }

        return res;
    }



    public static long kadane(ArrayList<Integer> list) {
        long ans = Long.MIN_VALUE;
        long train = 0;
        for(int i = 0; i < list.size(); i++) {
            if(train >= 0) {
                train += list.get(i);
            } else {
                train = list.get(i);
            }

            ans = max(train, ans);
        }
        return ans;
    }

    public static long[] prefix(int[] arr) {
        long[] prefix = new long[arr.length + 1];

        for(int i = 1; i <= arr.length; i++) {
            prefix[i] = prefix[i - 1] + (long)arr[i - 1];
        }

        return prefix;
    }

    public static long[] suffix(int[] arr) {
        long[] suffix = new long[arr.length + 1];

        for(int i = arr.length - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + arr[i];
        }
        return suffix;
    }


    static int[][] dirs = {{0,1}, {1,0}, {0,-1},{-1,0}};

    static int max(int a, int b)
    {
        if(a<b)
            return b;
        return a;
    }

    static long max(long a, long b) {
        if(a<b)
            return b;
        return a;
    }


    static void ruffleSort(int[] a) {
        int n=a.length;
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }

    static void ruffleSort(long[] a) {
        int n=a.length;
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n);
            long temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }

    static < E > void print(E res)
    {
        System.out.println(res);
    }


    static  int gcd(int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }

    static  long gcd(long a,long b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }

    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }


    static int abs(int a)
    {
        if(a<0)
            return -1*a;
        return a;
    }

    static long abs(long a)
    {
        if(a<0)
            return -1l*a;
        return a;
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
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

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        int [] readintarray(int n) {
            int res [] = new int [n];
            for(int i = 0; i<n; i++)res[i] = nextInt();
            return res;
        }
        long [] readlongarray(int n) {
            long res [] = new long [n];
            for(int i = 0; i<n; i++)res[i] = nextLong();
            return res;
        }


        int[][] readintmatrix(int n, int m) {
            int[][] res = new int[n][m];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    res[i][j] = in.nextInt();
                }
            }

            return res;
        }
    }

}