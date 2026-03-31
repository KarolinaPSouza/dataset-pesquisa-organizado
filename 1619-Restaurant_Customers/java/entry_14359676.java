import javax.print.attribute.IntegerSyntax;
import java.io.*;
import java.util.*;

public class entry_14359676 {
    static class FastIO extends PrintWriter {

        private InputStream stream;

        private byte[] buf = new byte[1 << 16];

        private int curChar;

        private int numChars;


        // standard input

        public FastIO() {
            this(System.in, System.out);
        }


        public FastIO(InputStream i, OutputStream o) {

            super(o);

            stream = i;

        }


        // file input

        public FastIO(String i, String o) throws IOException {

            super(new FileWriter(o));

            stream = new FileInputStream(i);

        }


        // throws InputMismatchException() if previously detected end of file

        private int nextByte() {

            if (numChars == -1) {
                throw new InputMismatchException();
            }

            if (curChar >= numChars) {

                curChar = 0;

                try {

                    numChars = stream.read(buf);

                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars == -1) {

                    return -1;  // end of file

                }

            }

            return buf[curChar++];

        }


        // to read in entire lines, replace c <= ' '

        // with a function that checks whether c is a line break

        public String next() {

            int c;

            do {
                c = nextByte();
            } while (c <= ' ');


            StringBuilder res = new StringBuilder();

            do {

                res.appendCodePoint(c);

                c = nextByte();

            } while (c > ' ');

            return res.toString();

        }


        public int nextInt() {  // nextLong() would be implemented similarly

            int c;

            do {
                c = nextByte();
            } while (c <= ' ');


            int sgn = 1;

            if (c == '-') {

                sgn = -1;

                c = nextByte();

            }


            int res = 0;

            do {

                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }

                res = 10 * res + c - '0';

                c = nextByte();

            } while (c > ' ');

            return res * sgn;

        }


        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }

    static class Disjoint {
        int[] height;
        int[] parent;

        public Disjoint(int size) {
            height = new int[size + 1];
            parent = new int[size + 1];
            for (int i = 0; i <= size; i++) parent[i] = i;
        }

        public int getParent(int u) {
            if (u == parent[u]) return u;
            parent[u] = getParent(parent[u]);
            return parent[u];
        }

        public void union(int u, int v) {
            int up = getParent(u), uv = getParent(v);
            if (up == uv) return;
            if (height[up] < height[uv]) {
                height[uv] += height[uv];
                parent[up] = uv;
            } else {
                height[up] += height[uv];
                parent[uv] = up;
            }
        }
    }

    static class Trie {
        Trie[] bits = new Trie[2];
//        boolean flag = false;

        public void add(int n) {
            Trie t = this;
            for (int i = 17; i >= 0; i--) {
                int f = (n >> i) & 1;
                if (t.bits[f] == null) t.bits[f] = new Trie();
                t = t.bits[f];
            }
        }

        public int min(int n) {
            int num = 0;
            Trie t = this;
            for (int i = 17; i >= 0; i--) {
                int f = (n >> i) & 1;
                if (t.bits[f] != null) {
                    t = t.bits[f];
                } else {
                    num += 1 << i;
                    t = t.bits[1 - f];
                }
            }
            return num;
        }

        public int max(int n) {
            int num = 0;
            Trie t = this;
            for (int i = 17; i >= 0; i--) {
                int f = (n >> i) & 1;
                if (t.bits[1 - f] != null) {
                    num += 1 << i;
                    t = t.bits[1 - f];
                } else {
                    t = t.bits[f];
                }
            }
            return num;
        }
    }

    static class IntLongMap {
        int[] keys;
        long[] vals;
        boolean[] used;
        int size, mask;
        IntLongMap(int capacity) {
            int n = 1;
            while (n < capacity) n <<= 1;
            keys = new int[n];
            vals = new long[n];
            used = new boolean[n];
            mask = n - 1;
        }
        void add(int key, long delta) {
            int pos = key & mask;
            while (used[pos] && keys[pos] != key) pos = (pos + 1) & mask;
            if (!used[pos]) {
                used[pos] = true;
                keys[pos] = key;
                vals[pos] = delta;
                size++;
            } else {
                vals[pos] += delta;
            }
        }
        long get(int key) {
            int pos = key & mask;
            while (used[pos]) {
                if (keys[pos] == key) return vals[pos];
                pos = (pos + 1) & mask;
            }
            return 0L;
        }
        void clear() {
            Arrays.fill(used, false);
            size = 0;
        }
    }

    public static void main(String[] args) {
        try {
            FastIO in = new FastIO();
//            int z = in.nextInt();
//            for(int a0 = 0; a0 < z; a0++){
                int n = in.nextInt();
                int[] arr1 = new int[n];
                int[] arr2 = new int[n];
                for(int i=0;i<n;i++){
                    arr1[i] = in.nextInt();
                    arr2[i] = in.nextInt();
                }
                int ans =0, len=0;
                Arrays.sort(arr1);
                Arrays.sort(arr2);
                int j = 0;
                for(int i=0;i<n;i++){
                    ++len;
                    while(arr2[j] < arr1[i]){
                        ++j;
                        --len;
                    }
                    ans = Math.max(ans, len);
                }
                in.println(ans);
//            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static int sum(int[] nums){
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            int min = nums[i];
            for(int j=i;j<nums.length;j++){
                min = Math.min(min, nums[j]);
                ans+=min;
            }
//            8 7 6 5 4 3 2 1
        }
        return ans;
    }

    public static long[] computeGcdExtended(long num1, long num2) {
        if (num1 == 0) {
            return new long[]{num2, 0, 1};
        }

        long[] recursiveResult = computeGcdExtended(num2 % num1, num1);
        long gcdVal = recursiveResult[0];
        long prevX = recursiveResult[1];
        long prevY = recursiveResult[2];

        long currentX = prevY - (num2 / num1) * prevX;
        long currentY = prevX;

        return new long[]{gcdVal, currentX, currentY};
    }

    public static long findModularInverse(long n, long modulus) {
        long[] result = computeGcdExtended(n, modulus);
        long x = result[1];

        long modInv = x % modulus;
        if (modInv < 0) {
            modInv += modulus;
        }

        return modInv;
    }


    public static long modmul(long a, long b){
        return mod(mod(a)*mod(b));
    }
    public static long modadd(long a, long b){
        return mod(mod(a) + mod(b));
    }
    public static long modsub(long a, long b){
        return mod(mod(a) - mod(b));
    }
    public static long mod(long a){
        int mod = 998244353;
        return ((a)%mod+mod)%mod;
    }
    public static long fac(long n) {
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans = (ans * n) % (int) (1e9 + 7);
        }
        return ans;
    }

    public static long computeXor(long n) {
        if (n % 4 == 0) return n;
        else if (n % 4 == 1) return 1;
        else if (n % 4 == 2) return n + 1;
        else return 0;
    }

    public static boolean check(long[][] arr, int i, long val, long[][] ans, long bit) {
        if (bit == 1) {
            long or = 0;
            for (int j = 0; j < ans.length; j++) {
                or |= ans[j][i];
            }
            return or == val;
        }
        long and = arr[0][i];
        for (int j = 0; j < ans.length; j++) {
            and &= arr[j][i];
        }
        return and == val;
    }

    public static int len(int u) {
        int len = 0;
        while (u > 0) {
            u /= 10;
            ++len;
        }
        return len;
    }

    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }


    public static boolean valid(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    public static void helper(int[] arr, int l, int r, int[] xor, long[] sum) {

    }

    public static boolean isPossible(int k, int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i: arr1){
            map.put(i&k, map.getOrDefault(i&k, 0) + 1);
        }
        for(int i: arr2){
            int g = ~i & k;
            if(!map.containsKey(g)) return false;
            map.put(g, map.get(g) - 1);
            if(map.get(g)==0) map.remove(g);
        }
        return map.isEmpty();
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}