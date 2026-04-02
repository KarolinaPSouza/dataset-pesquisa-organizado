import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
/**
 * @Description
 *
 * @Author skynet_07
 */



public class entry_14841621 {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static class SegmentTree
    {
        int n;
        long[] tree;
        public SegmentTree(int n) {
            this.n = n;
            tree = new long[4 * n];
        }
        void build(long[] a,int v,int tl,int tr) {
            if(tl == tr) {
                tree[v] = a[tl];
            } else {
                int tm = (tl + tr)/2;
                build(a,2*v,tl,tm);
                build(a,2*v+1,tm+1,tr);
                tree[v] = Math.max(tree[2*v],tree[2*v+1]);
            }
        }
        long findMax(int v,int tl,int tr,int l,int r) {
            if(l > r) {
                return 0;
            }
            if(l == tl && r == tr) {
                return tree[v];
            }
            int tm = (tl + tr)/2;
            return Math.max(
                    findMax(2*v,tl,tm,l,Math.min(r,tm)),
                    findMax(2*v+1,tm+1,tr,Math.max(tm+1,l),r)
            );
        }
        void update(int v,int tl,int tr,int pos,long val) {
            if(tl  == tr) {
                tree[v] = Math.max(val,tree[v]);
            } else {
                int tm = (tl+tr)/2;
                if(pos <= tm)
                    update(2*v,tl,tm,pos,val);
                else
                    update(2*v+1,tm+1,tr,pos,val);
                tree[v] = Math.max(tree[2*v],tree[2*v+1]);
            }
        }
    }
    static long exp(long x, long n, long m) {
        x %= m;
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * x % m;
            }
            x = x * x % m;
            n /= 2;
        }
        return res;
    }
    //        static final int MOD = 998244353;
    static  long MOD = (long)1e9+7;
    //    static HashMap<Long, Long> dp; // Changed to Long for large numbers

    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    static long modInverse(long x, long mod) {
        return modPow(x, mod - 2, mod);
    }

    public static void main(String[] args) {
//        spf();
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        out.close();
    }
    static int[] par;
    static long[] a;
    static long ans;
    static class pair implements Comparable<pair> {
        long key;
        int value;

        public pair(long key, int value) {
            this.key = key;
            this.value = value;
        }

        public long getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
        public int compareTo(pair o) {
            return Long.compare(this.key, o.key);
        }
    }
    static int[] spf;
    static void spf() {
        spf = new int[(int)1e7+5];
        spf[1] = 1;
        spf[0] = 0;
        for(int i=2;i<(int)1e7+5;i++) {
            if(spf[i] == 0) {
                for(int j=i;j<(int)1e7+5;j+=i) {
                    spf[j] = i;
                }
            }
        }
    }
    static void solve() {
        long M = sc.nl();
        int N = sc.ni();
        long[] a = new long[N];
        for(int i=0;i<N;i++) {
            a[i] = sc.nl();
        }
        long ans = 0;
        for(int i=1;i<(1<<N);i++) {
            long prod = 1;
            int c = 0;
            for(int j=0;j<N;j++) {
                if((i & (1 << j)) != 0) {
                    c++;
                    if(prod > M / a[j]) {
                        prod = M + 1;
                        break;
                    }
                    prod *= a[j];
                }
            }
            if(c % 2 == 1) {
                ans += M / prod;
            } else {
                ans -= M / prod;
            }
        }
        out.println(ans);
    }

    static long dfs(int src,int[] a,List<Integer>[] l,boolean[] vis) {
        if(vis[src])return 0;
        vis[src] = true;
        long ans = a[src];
        for(int nbr : l[src]) {
            ans += dfs(nbr,a,l,vis);
        }
        return ans;
    }
    static long gcd(long a,long b) {
        if(b == 0)
            return a;
        return gcd(b,a%b);
    }
    static int N;
    static int M;
    static int K;

    public static class RealFastReader {
        InputStream is;

        public RealFastReader(final InputStream is) {
            this.is = is;
        }

        private byte[] inbuf = new byte[8192];
        public int lenbuf = 0, ptrbuf = 0;

        public int readByte() {
            if (lenbuf == -1) {
                throw new InputMismatchException();
            }
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) {
                    return -1;
                }
            }
            return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b))
                ;
            return b;
        }

        public double nd() {
            return Double.parseDouble(ns());
        }

        public char nc() {
            return (char) skip();
        }

        public String ns() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public char[] ns(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public int[] na(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }

        public long[] nal(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nl();
            }
            return a;
        }

        public char[][] nm(int n, int m) {
            char[][] map = new char[n][];
            for (int i = 0; i < n; i++) {
                map[i] = ns(m);
            }
            return map;
        }

        public int[][] nmi(int n, int m) {
            int[][] map = new int[n][];
            for (int i = 0; i < n; i++) {
                map[i] = na(m);
            }
            return map;
        }

        public int ni() {
            int num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nl() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }
}