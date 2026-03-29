//package Concepts.CSES.Graphs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class entry_4988790 {

    static final long mod = (long) 1<<62;

    private static void solve(int t) throws IOException {
        int v = sc.nextInt();
        int e = sc.nextInt();

//        ArrayList<int[]>[] adj1 = new ArrayList[v];
        boolean [] seen1 = new boolean[v];
//        for (int i = 0; i < v; i++) {
//            adj1[i]= new ArrayList<>();
//        }
        List<int[]> ls = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int cost = sc.nextInt();
//            adj1[src].add(new int[]{dest, cost});
            ls.add(new int[]{src, dest, cost});
        }

        long [] dist1 =new long[v];
        Arrays.fill(dist1, mod);
        dist1[0]=0;
        int[] par = new int[v];
        boolean flag = false;
        int f=-1;
        for (int i = 0; i < v; i++) {
             f = -1;
            for (int[] dd:ls) {
                if( dist1[dd[1]]>dist1[dd[0]]+dd[2]){
                    dist1[dd[1]]=dist1[dd[0]]+dd[2];
                    par[dd[1]]=dd[0];
                    if(i==v-1){
                        f= dd[1];
                    }
                }
            }
        }
        out.println(f!=-1?"YES":"NO");
        if(f!=-1){
            // print cycle
            List<Integer> cycle = new ArrayList<>();
            for (int i = 0; i <v ; i++)f = par[f];
            for (int x = f;; x = par[x]){
                cycle.add(x);
                if (x==f && cycle.size()>1) break;
            }

            for (int i = cycle.size()-1; i >=0; i--) {
                out.print(cycle.get(i)+1+" ");
            }
        }
    }

    private static void dijkstra(int node, ArrayList<int[]> []adj, long [] dist) {
        int len= dist.length;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.add(new long[]{node,0});
        boolean [] seen = new boolean[len];
        while (!pq.isEmpty()){
            long curr[]= pq.poll();
            int n = (int)curr[0];
            long c = curr[1];
            if(seen[n])continue;
            seen[n]= true;

            for (int[] data:adj[n]) {
                if(dist[data[0]]>c+data[1]){
                    dist[data[0]]=c+data[1];
                    pq.add(new long[]{data[0], dist[data[0]]});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        sc = new FastReader(new BufferedInputStream(System.in), new BufferedOutputStream(System.out));
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        int t = 1;// fs.nextInt();
        for (int i = 1; i <= t; i++) solve(t);
        out.close();
//        System.err.println(System.currentTimeMillis() - s + "ms");
    }

    static boolean DEBUG = true;
    static PrintWriter out;
    static FastReader sc;

    static void trace(Object... o) {
        if (!DEBUG) return;
        System.err.println(Arrays.deepToString(o));
    }

    static void pl(Object o) {
        out.println(o);
    }

    static void p(Object o) {
        out.print(o);
    }

    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static void sieveOfEratosthenes(int n, int factors[]) {
        factors[1] = 1;
        for (int p = 2; p * p <= n; p++) {
            if (factors[p] == 0) {
                factors[p] = p;
                for (int i = p * p; i <= n; i += p)
                    factors[i] = p;
            }
        }
    }

    static long mul(long a, long b) {
        return a * b % mod;
    }

    static long fact(int x) {
        long ans = 1;
        for (int i = 2; i <= x; i++) ans = mul(ans, i);
        return ans;
    }

    static long fastPow(long base, long exp) {
        if (exp == 0) return 1;
        long half = fastPow(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }

    static long modInv(long x) {
        return fastPow(x, mod - 2);
    }

    static long nCk(int n, int k) {
        return mul(fact(n), mul(modInv(fact(k)), modInv(fact(n - k))));
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreElements())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
    static public class entry_4988790 {

        public static final int DEFAULT_BUFFER_SIZE = 65536;
        public static final int DEFAULT_INTEGER_SIZE = 11;
        public static final int DEFAULT_LONG_SIZE = 20;
        public static final int DEFAULT_WORD_SIZE = 256;
        public static final int DEFAULT_LINE_SIZE = 8192;
        public static final int EOF = -1;

        private final InputStream in;
        private final OutputStream out;

        private byte[] inBuffer;
        private int nextIn, inLength;
        private byte[] outBuffer;
        private int nextOut;

        private char[] charBuffer;
        private byte[] byteBuffer;

        public FastReader(InputStream in, OutputStream out, int inBufferSize, int outBufferSize) {
            this.in = in;
            this.inBuffer = new byte[inBufferSize];
            this.nextIn = 0;
            this.inLength = 0;

            this.out = out;
            this.outBuffer = new byte[outBufferSize];
            this.nextOut = 0;

            this.charBuffer = new char[DEFAULT_LINE_SIZE];
            this.byteBuffer = new byte[DEFAULT_LONG_SIZE];
        }

        public FastReader(InputStream in, OutputStream out) {
            this(in, out, DEFAULT_BUFFER_SIZE, DEFAULT_BUFFER_SIZE);
        }

        public FastReader(InputStream in, OutputStream out, int bufferSize) {
            this(in, out, bufferSize, bufferSize);
        }

        public char nextChar() {
            byte b;
            while (isSpace(b = read()))
                ;

            return (char) b;
        }

        public String next() {
            byte b;
            while (isSpace(b = read()))
                ;

            int pos = 0;
            do {
                charBuffer[pos++] = (char) b;
                ensureCapacity(pos);
            } while (!isSpace(b = read()));

            return new String(charBuffer, 0, pos);
        }

        public String nextLine() {
            byte b;
            int pos = 0;

            while (!isLine(b = read())) {
                charBuffer[pos++] = (char) b;
                ensureCapacity(pos);
            }

            return new String(charBuffer, 0, pos);
        }

        public int nextInt() {
            byte b;
            while (isSpace(b = read()))
                ;

            boolean negative = false;
            int result = b - '0';
            if (b == '-') {
                negative = true;
                result = 0;
            }

            while (isDigit(b = read()))
                result = (result * 10) + (b - '0');

            return negative ? -result : result;
        }

        public long nextLong() {
            byte b;
            while (isSpace(b = read()))
                ;

            boolean negative = false;
            long result = b - '0';
            if (b == '-') {
                negative = true;
                result = 0;
            }

            while (isDigit(b = read()))
                result = (result * 10) + (b - '0');

            return negative ? -result : result;
        }

        public float nextFloat() {
            byte b;
            while (isSpace(b = read()))
                ;

            int pos = 0;
            do {
                charBuffer[pos++] = (char) b;
            } while (!isSpace(b = read()));

            return Float.parseFloat(new String(charBuffer, 0, pos));
        }

        public float nextFloat2() {
            byte b;
            while (isSpace(b = read()))
                ;

            boolean negative = false;
            float result = b - '0';
            if (b == '-') {
                negative = true;
                result = 0;
            }

            while (isDigit(b = read()))
                result = (result * 10) + (b - '0');

            float d = 1;
            if (b == '.') {
                while (isDigit(b = read()))
                    result += (b - '0') / (d *= 10);
            }

            return negative ? -result : result;
        }

        public double nextDouble() {
            byte b;
            while (isSpace(b = read()))
                ;

            int pos = 0;
            do {
                charBuffer[pos++] = (char) b;
            } while (!isSpace(b = read()));

            return Double.parseDouble(new String(charBuffer, 0, pos));
        }

        public double nextDouble2() {
            byte b;
            while (isSpace(b = read()))
                ;

            boolean negative = false;
            double result = b - '0';
            if (b == '-') {
                negative = true;
                result = 0;
            }

            while (isDigit(b = read()))
                result = (result * 10) + (b - '0');

            double d = 1;
            if (b == '.') {
                while (isDigit(b = read()))
                    result += (b - '0') / (d *= 10);
            }

            return negative ? -result : result;
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        public BigDecimal nextBigDecimal() {
            return new BigDecimal(next());
        }

        public char[] nextToCharArray() {
            byte b;
            while (isSpace(b = read()))
                ;

            int pos = 0;
            do {
                charBuffer[pos++] = (char) b;
                ensureCapacity(pos);
            } while (!isSpace(b = read()));

            char[] array = new char[pos];
            System.arraycopy(charBuffer, 0, array, 0, pos);
            return array;
        }

        public int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++)
                array[i] = nextInt();

            return array;
        }

        public long[] nextLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++)
                array[i] = nextLong();

            return array;
        }

        public int[][] nextInt2DArray(int Y, int X) {
            int[][] array = new int[Y][X];
            for (int y = 0; y < Y; y++)
                for (int x = 0; x < X; x++)
                    array[y][x] = nextInt();

            return array;
        }

        public void print(char c) {
            write((byte) c);
        }

        public void print(char[] chars) {
            print(chars, 0, chars.length);
        }

        public void print(char[] chars, int start) {
            print(chars, start, chars.length);
        }

        public void print(char[] chars, int start, int end) {
            for (int i = start; i < end; i++)
                write((byte) chars[i]);
        }

        public void print(String s) {
            for (int i = 0; i < s.length(); i++)
                write((byte) s.charAt(i));
        }

        public void print(int i) {
            if (i == 0) {
                write((byte) '0');
                return;
            }
            if (i == Integer.MIN_VALUE) {
                write((byte) '-');
                write((byte) '2');
                write((byte) '1');
                write((byte) '4');
                write((byte) '7');
                write((byte) '4');
                write((byte) '8');
                write((byte) '3');
                write((byte) '6');
                write((byte) '4');
                write((byte) '8');
                return;
            }

            if (i < 0) {
                write((byte) '-');
                i = -i;
            }

            int pos = 0;
            while (i > 0) {
                byteBuffer[pos++] = (byte) ((i % 10) + '0');
                i /= 10;
            }

            while (pos-- > 0)
                write(byteBuffer[pos]);
        }

        public void print(long l) {
            if (l == 0) {
                write((byte) '0');
                return;
            }
            if (l == Long.MIN_VALUE) {
                write((byte) '-');
                write((byte) '9');
                write((byte) '2');
                write((byte) '2');
                write((byte) '3');
                write((byte) '3');
                write((byte) '7');
                write((byte) '2');
                write((byte) '0');
                write((byte) '3');
                write((byte) '6');
                write((byte) '8');
                write((byte) '5');
                write((byte) '4');
                write((byte) '7');
                write((byte) '7');
                write((byte) '5');
                write((byte) '8');
                write((byte) '0');
                write((byte) '8');
                return;
            }

            if (l < 0) {
                write((byte) '-');
                l = -l;
            }

            int pos = 0;
            while (l > 0) {
                byteBuffer[pos++] = (byte) ((l % 10) + '0');
                l /= 10;
            }

            while (pos-- > 0)
                write(byteBuffer[pos]);
        }

        public void print(float f) {
            String sf = Float.toString(f);
            for (int i = 0; i < sf.length(); i++)
                write((byte) sf.charAt(i));
        }

        public void print(double d) {
            String sd = Double.toString(d);
            for (int i = 0; i < sd.length(); i++)
                write((byte) sd.charAt(i));
        }

        public void printls(char c) {
            print(c);
            write((byte) ' ');
        }

        public void printls(String s) {
            print(s);
            write((byte) ' ');
        }

        public void printls(int i) {
            print(i);
            write((byte) ' ');
        }

        public void printls(long l) {
            print(l);
            write((byte) ' ');
        }

        public void printls(float f) {
            print(f);
            write((byte) ' ');
        }

        public void printls(double d) {
            print(d);
            write((byte) ' ');
        }

        public void printls() {
            write((byte) ' ');
        }

        public void println(char c) {
            print(c);
            write((byte) '\n');
        }

        public void println(char[] chars) {
            print(chars, 0, chars.length);
            write((byte) '\n');
        }

        public void println(String s) {
            print(s);
            write((byte) '\n');
        }

        public void println(int i) {
            print(i);
            write((byte) '\n');
        }

        public void println(long l) {
            print(l);
            write((byte) '\n');
        }

        public void println(float f) {
            print(f);
            write((byte) '\n');
        }

        public void println(double d) {
            print(d);
            write((byte) '\n');
        }

        public void println() {
            write((byte) '\n');
        }

        public void printf(String format, Object... args) {
            String s = String.format(format, args);
            for (int i = 0; i < s.length(); i++)
                write((byte) s.charAt(i));
        }

        public void fprint(char c) {
            print(c);
            flushBuffer();
        }

        public void fprint(String s) {
            print(s);
            flushBuffer();
        }

        public void fprint(int i) {
            print(i);
            flushBuffer();
        }

        public void fprint(long l) {
            print(l);
            flushBuffer();
        }

        public void fprint(float f) {
            print(f);
            flushBuffer();
        }

        public void fprint(double d) {
            print(d);
            flushBuffer();
        }

        public void fprintf(String format, Object... args) {
            printf(format, args);
            flushBuffer();
        }

        private byte read() {
            if (nextIn >= inLength) {
                if ((inLength = fill()) == EOF)
                    return EOF;
                nextIn = 0;
            }

            return inBuffer[nextIn++];
        }

        private void write(byte b) {
            if (nextOut >= outBuffer.length)
                flushBuffer();

            outBuffer[nextOut++] = b;
        }

        private int fill() {
            try {
                return in.read(inBuffer, 0, inBuffer.length);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void flush() {
            flushBuffer();
        }

        private void flushBuffer() {
            if (nextOut == 0)
                return;

            try {
                out.write(outBuffer, 0, nextOut);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            nextOut = 0;
        }

        public void close() {
            flush();
        }

        public void exit(char c) {
            fprint(c);
            System.exit(0);
        }

        public void exit(String s) {
            fprint(s);
            System.exit(0);
        }

        public void exit(int i) {
            fprint(i);
            System.exit(0);
        }

        public void exit(long l) {
            fprint(l);
            System.exit(0);
        }

        public void exit(float f) {
            fprint(f);
            System.exit(0);
        }

        public void exit(double d) {
            fprint(d);
            System.exit(0);
        }

        public void exit(String format, Object... args) {
            fprintf(format, args);
            System.exit(0);
        }

        public void exit() {
            flushBuffer();
            System.exit(0);
        }

        private void ensureCapacity(int size) {
            if (size < charBuffer.length)
                return;

            char[] array = new char[size * 2];
            System.arraycopy(charBuffer, 0, array, 0, size);
            charBuffer = array;
        }

        private boolean isDigit(byte b) {
            return b >= '0' && b <= '9';
        }

        private boolean isLine(byte b) {
            return b == '\n' || b == '\r' || b == EOF;
        }

        private boolean isSpace(byte b) {
            return b == ' ' || b == '\t' || b == '\n' || b == '\r' || b == '\f' || b == EOF;
        }
    }
}