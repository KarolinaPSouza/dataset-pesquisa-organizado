// don't place package name! */

import java.io.*;
import java.util.*;
import java.math.BigInteger;

/* Name of the class has to be "entry_11616815" only if the class is public. */
public class entry_11616815 {
    static long mod = 1000000007;
    static final Random random = new Random();
    static long[] factorials;
    static long[] invFactorials;
    static boolean [] visited;
    static int n ,  m;


    static String dir = "DULR";
    static int dx[] = {-1 , 1 , 0 , 0} , dy[] = {0 , 0 , -1 , 1};

    /* Name of the class has to be "entry_11616815" only if the class is public. */
    public static void main(String[] args) throws IOException {

        // File in = new File("input.txt");
        // File output = new File("output.txt");
        // InputStream inputStream = new FileInputStream(in);
        // OutputStream outputStream = new FileOutputStream(output);

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);

        Question solver = new Question();

        // precompFacts();
        int testCount = 1;
        for (int i = 1; i <= testCount; i++) {
            // out.print("Case #" + i + ": ");
            solver.solve(i, sc, out);
        }

        // solver.solve(1, sc, out);
        out.close();
    }
    /*  use only ati.println()
     * Read the question very carefully take your own time 
     *  if runtime error then check all indexs like (list.get()-1)
     *  while using prefix sums use long to avoid integer overflow
     *  always give answer in long dont submit answer in Integer
     */ 
    static class Question {
            static  List<List<Integer>> list;
            static int visited[];
            public void solve(int testNumber, InputReader sc, OutputWriter ati) {
            {
               int roads = sc.nextInt();
               int edges = sc.nextInt();
               list = new ArrayList<>();
               for(int i = 0;i <= roads;i++) list.add(new ArrayList<>());
               for(int i = 0;i < edges;i++)
               {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
               }
               visited = new int[roads + 1];
               List<Integer> ans = new ArrayList<>();
               for(int i = 1;i <= roads;i++)
               {
                    if(visited[i] == 0)
                    {
                        dfs(i);
                        ans.add(i);
                    }

               }
               ati.println(ans.size() - 1);
               for(int i = 0;i < ans.size() - 1;i++)
               {
                ati.println(ans.get(i) + " " + ans.get(i + 1) + " ");
               }
            }
        }
        static void dfs(int node)
        { 
            visited[node] = 1;
            for(int adjNode : list.get(node))
            {
                if(visited[adjNode] == 0)
                dfs(adjNode);
            }
        }
    }







    static class Pair implements Comparable<Pair> {
        int fi;
        int se;
        long cost;
        StringBuilder s;




        public Pair(int fi, int se) {
            this.fi = fi;
            this.se = se;
        }

        public int compareTo(Pair o) {

            int x = Long.compare(fi, o.fi);

            if (x == 0) {
                x = Long.compare(se, o.se);
            }

            return x;

        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            if (fi != other.fi)
                return false;
            if (se != other.se)
                return false;
            return true;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) se;
            result = prime * result + (int) se;
            return result;
        }

    }
    static int lower_bound(long[] array, long key) {

        int low = 0, high = array.length;
        int mid;

        while (low < high) {

            mid = low + (high - low) / 2;

            if (key <= array[mid]) {
                high = mid;
            }

            else {

                low = mid + 1;
            }
        }

        if (low < array.length && array[low] < key) {
            low++;
        }

        return low;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swap(long[] a, int i, int j) {
        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

      public static class Multiset<T> {
        public TreeMap<T, Integer> map;
        public int size = 0;

        public Multiset() {
            map = new TreeMap<>();
        }

        public Multiset(T[] a) {
            map = new TreeMap<>();
            size = a.length;
            for (int i = 0; i < a.length; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
        }

        void add(T a) {
            size++;
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        boolean isEmpty() {
            return map.isEmpty();
        }

        void remove(T a) {
            size--;
            int val = map.get(a);
            map.put(a, val - 1);
            if (val == 1)
                map.remove(a);
        }

        void removeAll(int a) {
            if (map.containsKey(a)) {
                size -= map.get(a);
                map.remove(a);
            }
        }

        T ceiling(T a) {
            return map.ceilingKey(a);
        }

        T floor(T a) {
            return map.floorKey(a);
        }

        T lower(T a) {
            return map.lowerKey(a);
        }

        T higher(T a) {
            return map.higherKey(a);
        }

        T first() {
            return map.firstKey();
        }

        T last() {
            return map.lastKey();
        }

        boolean contains(T a) {
            return map.containsKey(a);
        }

        int size() {
            return size;
        }

        void clear() {
            map.clear();
        }

        T poll() {
            if (map.size() == 0) {
                return null;
            }
            size--;
            T first = map.firstKey();
            if (map.get(first) == 1) {
                map.pollFirstEntry();
            } else
                map.put(first, map.get(first) - 1);
            return first;
        }

        T polllast() {
            if (map.size() == 0) {
                return null;
            }
            size--;
            T last = map.lastKey();
            if (map.get(last) == 1) {
                map.pollLastEntry();
            } else
                map.put(last, map.get(last) - 1);
            return last;
        }
    }

    static long power(long x, long y, long p) {
        long res = 1;

        x = x % p;

        if (x == 0)
            return 0;

        while (y > 0) {

            if ((y & 1) != 0)
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static long modInverse(long b, long m) {

        return (long) power(b, m - 2, m);

    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) >= 0) {
            return a;
        } else {
            return b;
        }
    }

    public static <T extends Comparable<T>> T min(T a, T b) {
        if (a.compareTo(b) < 0) {
            return a;
        } else {
            return b;
        }
    }

    static class DisjointSet {
        int[] s;

        public DisjointSet(int n) {
            Arrays.fill(s = new int[n], -1);
        }

        public int find(int i) {
            return s[i] < 0 ? i : (s[i] = find(s[i]));
        }

        public boolean union(int a, int b) {
            if ((a = find(a)) == (b = find(b)))
                return false;
            if (s[a] == s[b])
                s[a]--;
            if (s[a] <= s[b])
                s[b] = a;
            else
                s[a] = b;
            return true;
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return n > 1;
    }

    public static int countSetBits(long number) {
        int count = 0;
        while (number > 0) {
            ++count;
            number &= number - 1;
        }
        return count;
    }

    static boolean isPowerOfTwo(long x) {

        return x != 0 && ((x & (x - 1)) == 0);
    }
    public static int max(int[] elementData) {

        int max = elementData[0];
        for (int i = 1; i < elementData.length; i++) {
            if (elementData[i] > max) {
                max = elementData[i];
            }
        }
        return max;
    }

    static long highestPowerof2(long n) {

        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;

        return n ^ (n >> 1);
    }

    public static int min(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static long max(long[] elementData) {

        long max = elementData[0];
        for (int i = 1; i < elementData.length; i++) {
            if (elementData[i] > max) {
                max = elementData[i];
            }
        }
        return max;
    }

    public static long min(long[] array) {
        long min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static int max(int i, int l) {
        return Math.max(i, l);
    }

    public static long max(long i, long l) {
        return Math.max(i, l);
    }

    public static void reverse(int[] array) {

        int n = array.length;

        for (int i = 0; i < n / 2; i++) {

            int temp = array[i];

            array[i] = array[n - i - 1];

            array[n - i - 1] = temp;
        }
    }

    public static void reverse(long[] array) {

        int n = array.length;

        for (int i = 0; i < n / 2; i++) {

            long temp = array[i];

            array[i] = array[n - i - 1];

            array[n - i - 1] = temp;
        }
    }

    static void precompFacts() {
        factorials = new long[2_000_001];
        invFactorials = new long[2_000_001];
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++)
            factorials[i] = modularMultiplication(factorials[i - 1], i, mod);
        invFactorials[factorials.length - 1] = modularExponentiation(factorials[factorials.length - 1], mod - 2,
                mod);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = modularMultiplication(invFactorials[i + 1], i + 1, mod);
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static void sort(long[] a) {
        ArrayList<Long> l = new ArrayList<>();
        for (long i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static public int modularAddition(int a, int b, int MOD) {
        return (a % MOD + b % MOD) % MOD;
    }

    static public long modularAddition(long a, long b, long MOD) {
        return (a % MOD + b % MOD) % MOD;
    }

    static public int modularMultiplication(int a, int b, int MOD) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    static public long modularMultiplication(long a, long b, long MOD) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    static public int modularSubtraction(int a, int b, int MOD) {
        return (a % MOD - b % MOD + MOD) % MOD;
    }

    static public long modularSubtraction(long a, long b, long MOD) {
        return (a % MOD - b % MOD + MOD) % MOD;
    }

    public static int binaryExponentiation(int x, int n) {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return binaryExponentiation(x * x, n / 2);
        else
            return x * binaryExponentiation(x * x, (n - 1) / 2);
    }

    public static long binaryExponentiation(long x, long n) {
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1)
                result *= x;
            x = x * x;
            n /= 2;
        }
        return result;
    }

    public static int modularExponentiation(int x, int n, int MOD) {
        if (n == 0)
            return 1 % MOD;
        else if (n % 2 == 0)
            return modularExponentiation(modularMultiplication(x, x, MOD), n / 2, MOD);
        else
            return modularMultiplication(x,
                    modularExponentiation(modularMultiplication(x, x, MOD), (n - 1) / 2, MOD),
                    MOD);
    }

    public static long modularExponentiation(long x, long n, long MOD) {
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1)
                result = modularMultiplication(result, x, MOD);
            x = modularMultiplication(x, x, MOD);
            n /= 2;
        }
        return result;
    }

    class SegmentTree
{
    //Tlatoani's segment tree
    //iterative implementation = low constant runtime factor
    //range query, non lazy
    final int[] val;
    final int treeFrom;
    final int length;
    final int INF = Integer.MAX_VALUE/2;

    public SegmentTree(int treeFrom, int treeTo)
    {
        this.treeFrom = treeFrom;
        int length = treeTo - treeFrom + 1;
        int l;
        for (l = 0; (1 << l) < length; l++);
        val = new int[1 << (l + 1)];
        this.length = 1 << l;
    }
    public void update(int index, int delta)
    {
        //replaces value
        int node = index - treeFrom + length;
        val[node] = delta;
        for (node >>= 1; node > 0; node >>= 1)
            val[node] = comb(val[node << 1], val[(node << 1) + 1]);
    }
    public int query(int from, int to)
    {
        //inclusive bounds
        if (to < from)
            return INF; //0 or 1?
        from += length - treeFrom;
        to += length - treeFrom + 1;
        //0 or 1?
        int res = INF;
        for (; from + (from & -from) <= to; from += from & -from)
            res = comb(res, val[from / (from & -from)]);
        for (; to - (to & -to) >= from; to -= to & -to)
            res = comb(res, val[(to - (to & -to)) / (to & -to)]);
        return res;
    }
    public int comb(int a, int b)
    {
        //change this
        return min(a,b);
    }
}

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
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
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int peek() {
            if (numChars == -1) {
                return -1;
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int sum = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return sum * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long sum = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return sum * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder sum = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    sum.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return sum.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines) {
                return readLine();
            } else {
                return readLine0();
            }
        }

        public String nextLine() {
            return readLine();
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(nextLine());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public char nextCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double sum = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return sum * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return sum * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    sum += (c - '0') * m;
                    c = read();
                }
            }
            return sum * sgn;
        }

        public boolean isExhausted() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1) {
                read();
            }
            return value == -1;
        }

        public SpaceCharFilter getFilter() {
            return filter;
        }

        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; ++i)
                array[i] = nextInt();
            return array;
        }

        public int[] nextSortedIntArray(int n) {
            int array[] = nextIntArray(n);
            Arrays.sort(array);
            return array;
        }

        public int[] nextSumIntArray(int n) {
            int[] array = new int[n];
            array[0] = nextInt();
            for (int i = 1; i < n; ++i)
                array[i] = array[i - 1] + nextInt();
            return array;
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; ++i)
                array[i] = nextLong();
            return array;
        }

        public long[] nextSumLongArray(int n) {
            long[] array = new long[n];
            array[0] = nextInt();
            for (int i = 1; i < n; ++i)
                array[i] = array[i - 1] + nextInt();
            return array;
        }

        public long[] nextSortedLongArray(int n) {
            long array[] = nextLongArray(n);
            Arrays.sort(array);
            return array;
        }

    }
    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void println() {
            writer.println();
        }

        public void print(int[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void println(int[] array) {
            print(array);
            writer.println();
        }

        public void print(long[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void println(long[] array) {
            print(array);
            writer.println();
        }

        public <T> void print(List<T> array) {
            for (int i = 0; i < array.size(); i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array.get(i));
            }
        }

        public <T> void println(List<T> array) {
            print(array);
            writer.println();
        }

        public void separateLines(int[] array) {
            for (int i : array) {
                println(i);
            }
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

    }

}