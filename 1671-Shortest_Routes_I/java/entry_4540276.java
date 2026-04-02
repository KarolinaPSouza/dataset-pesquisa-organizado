/*
    Author: Spidey2182
    #: 1671
*/

import java.util.*;

public class entry_4540276 implements Runnable {

    static ContestScanner sc = new ContestScanner();
    static ContestPrinter out = new ContestPrinter();

    public static void main(String[] args) {
        new Thread(null, new entry_4540276(), "main", 1 << 28).start();
    }

    public void run() {
        long n=sc.nextLong();
        long m=sc.nextLong();
        long u, v, d;
        ArrayList<ArrayList<long[]>> adj=new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        boolean[] visited=new boolean[(int)n+1];
        long[] dist=new long[(int)n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1]=0;
        for (int i = 0; i < m; i++) {
            u=sc.nextLong();
            v=sc.nextLong();
            d=sc.nextLong();
            adj.get((int)u).add(new long[]{v, d});
        }
        PriorityQueue<long[]> ver=new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int)(o1[1]-o2[1]);
            }
        });
        ver.add(new long[]{1, 0});
        while(!ver.isEmpty()) {
            v=(int)ver.peek()[0];
            d=ver.poll()[1];
            if(visited[(int)v])
                continue;
            visited[(int)v]=true;
            for(long[] x :adj.get((int)v)) {
                if(dist[(int)v]+x[1]<dist[(int)x[0]]) {
//                    System.out.print(dist[x[0]]+" ");
                    dist[(int)x[0]]=x[1]+dist[(int)v];
//                    System.out.println(dist[x[0]]);
                    ver.add(new long[]{x[0], dist[(int)x[0]]});
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            out.print(dist[i]);
            out.print(" ");
        }
        out.flush();
        out.close();
    }

    static final int MOD = (int) 1e9 + 7;

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}

//Credits: https://github.com/NASU41/AtCoderLibraryForJava/tree/master/ContestIO
class ContestScanner {
    private final java.io.InputStream in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    private static final long LONG_MAX_TENTHS = 922337203685477580L;
    private static final int LONG_MAX_LAST_DIGIT = 7;
    private static final int LONG_MIN_LAST_DIGIT = 8;

    public ContestScanner(java.io.InputStream in) {
        this.in = in;
    }

    public ContestScanner(java.io.File file) throws java.io.FileNotFoundException {
        this(new java.io.BufferedInputStream(new java.io.FileInputStream(file)));
    }

    public ContestScanner() {
        this(System.in);
    }

    private boolean hasNextByte() {
        if (ptr < buflen) {
            return true;
        } else {
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            if (buflen <= 0) {
                return false;
            }
        }
        return true;
    }

    private int readByte() {
        if (hasNextByte()) return buffer[ptr++];
        else return -1;
    }

    private static boolean isPrintableChar(int c) {
        return 33 <= c && c <= 126;
    }

    public boolean hasNext() {
        while (hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;
        return hasNextByte();
    }

    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while (isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    public long nextLong() {
        if (!hasNext()) throw new NoSuchElementException();
        long n = 0;
        boolean minus = false;
        int b = readByte();
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b < '0' || '9' < b) {
            throw new NumberFormatException();
        }
        while (true) {
            if ('0' <= b && b <= '9') {
                int digit = b - '0';
                if (n >= LONG_MAX_TENTHS) {
                    if (n == LONG_MAX_TENTHS) {
                        if (minus) {
                            if (digit <= LONG_MIN_LAST_DIGIT) {
                                n = -n * 10 - digit;
                                b = readByte();
                                if (!isPrintableChar(b)) {
                                    return n;
                                } else if (b < '0' || '9' < b) {
                                    throw new NumberFormatException(
                                            String.format("%d%s... is not number", n, Character.toString(b))
                                    );
                                }
                            }
                        } else {
                            if (digit <= LONG_MAX_LAST_DIGIT) {
                                n = n * 10 + digit;
                                b = readByte();
                                if (!isPrintableChar(b)) {
                                    return n;
                                } else if (b < '0' || '9' < b) {
                                    throw new NumberFormatException(
                                            String.format("%d%s... is not number", n, Character.toString(b))
                                    );
                                }
                            }
                        }
                    }
                    throw new ArithmeticException(
                            String.format("%s%d%d... overflows long.", minus ? "-" : "", n, digit)
                    );
                }
                n = n * 10 + digit;
            } else if (b == -1 || !isPrintableChar(b)) {
                return minus ? -n : n;
            } else {
                throw new NumberFormatException();
            }
            b = readByte();
        }
    }

    public int nextInt() {
        long nl = nextLong();
        if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
        return (int) nl;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long[] nextLongArray(int length) {
        long[] array = new long[length];
        for (int i = 0; i < length; i++) array[i] = this.nextLong();
        return array;
    }

    public long[] nextLongArray(int length, java.util.function.LongUnaryOperator map) {
        long[] array = new long[length];
        for (int i = 0; i < length; i++) array[i] = map.applyAsLong(this.nextLong());
        return array;
    }

    public int[] nextIntArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) array[i] = this.nextInt();
        return array;
    }

    public int[] nextIntArray(int length, java.util.function.IntUnaryOperator map) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) array[i] = map.applyAsInt(this.nextInt());
        return array;
    }

    public double[] nextDoubleArray(int length) {
        double[] array = new double[length];
        for (int i = 0; i < length; i++) array[i] = this.nextDouble();
        return array;
    }

    public double[] nextDoubleArray(int length, java.util.function.DoubleUnaryOperator map) {
        double[] array = new double[length];
        for (int i = 0; i < length; i++) array[i] = map.applyAsDouble(this.nextDouble());
        return array;
    }

    public long[][] nextLongMatrix(int height, int width) {
        long[][] mat = new long[height][width];
        for (int h = 0; h < height; h++)
            for (int w = 0; w < width; w++) {
                mat[h][w] = this.nextLong();
            }
        return mat;
    }

    public int[][] nextIntMatrix(int height, int width) {
        int[][] mat = new int[height][width];
        for (int h = 0; h < height; h++)
            for (int w = 0; w < width; w++) {
                mat[h][w] = this.nextInt();
            }
        return mat;
    }

    public double[][] nextDoubleMatrix(int height, int width) {
        double[][] mat = new double[height][width];
        for (int h = 0; h < height; h++)
            for (int w = 0; w < width; w++) {
                mat[h][w] = this.nextDouble();
            }
        return mat;
    }

    public char[][] nextCharMatrix(int height, int width) {
        char[][] mat = new char[height][width];
        for (int h = 0; h < height; h++) {
            String s = this.next();
            for (int w = 0; w < width; w++) {
                mat[h][w] = s.charAt(w);
            }
        }
        return mat;
    }
}

class ContestPrinter extends java.io.PrintWriter {
    public ContestPrinter(java.io.PrintStream stream) {
        super(stream);
    }

    public ContestPrinter(java.io.File file) throws java.io.FileNotFoundException {
        super(new java.io.PrintStream(file));
    }

    public ContestPrinter() {
        super(System.out);
    }

    private static String dtos(double x, int n) {
        StringBuilder sb = new StringBuilder();
        if (x < 0) {
            sb.append('-');
            x = -x;
        }
        x += Math.pow(10, -n) / 2;
        sb.append((long) x);
        sb.append(".");
        x -= (long) x;
        for (int i = 0; i < n; i++) {
            x *= 10;
            sb.append((int) x);
            x -= (int) x;
        }
        return sb.toString();
    }

    @Override
    public void print(float f) {
        super.print(dtos(f, 20));
    }

    @Override
    public void println(float f) {
        super.println(dtos(f, 20));
    }

    @Override
    public void print(double d) {
        super.print(dtos(d, 20));
    }

    @Override
    public void println(double d) {
        super.println(dtos(d, 20));
    }


    public void printArray(int[] array, String separator) {
        int n = array.length;
        if (n == 0) {
            super.println();
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            super.print(array[i]);
            super.print(separator);
        }
        super.println(array[n - 1]);
    }

    public void printArray(int[] array) {
        this.printArray(array, " ");
    }

    public void printArray(int[] array, String separator, java.util.function.IntUnaryOperator map) {
        int n = array.length;
        if (n == 0) {
            super.println();
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            super.print(map.applyAsInt(array[i]));
            super.print(separator);
        }
        super.println(map.applyAsInt(array[n - 1]));
    }

    public void printArray(int[] array, java.util.function.IntUnaryOperator map) {
        this.printArray(array, " ", map);
    }

    public void printArray(long[] array, String separator) {
        int n = array.length;
        if (n == 0) {
            super.println();
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            super.print(array[i]);
            super.print(separator);
        }
        super.println(array[n - 1]);
    }

    public void printArray(long[] array) {
        this.printArray(array, " ");
    }

    public void printArray(long[] array, String separator, java.util.function.LongUnaryOperator map) {
        int n = array.length;
        if (n == 0) {
            super.println();
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            super.print(map.applyAsLong(array[i]));
            super.print(separator);
        }
        super.println(map.applyAsLong(array[n - 1]));
    }

    public void printArray(long[] array, java.util.function.LongUnaryOperator map) {
        this.printArray(array, " ", map);
    }

    public <T> void printArray(T[] array, String separator) {
        int n = array.length;
        if (n == 0) {
            super.println();
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            super.print(array[i]);
            super.print(separator);
        }
        super.println(array[n - 1]);
    }

    public <T> void printArray(T[] array) {
        this.printArray(array, " ");
    }

    public <T> void printArray(T[] array, String separator, java.util.function.UnaryOperator<T> map) {
        int n = array.length;
        if (n == 0) {
            super.println();
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            super.print(map.apply(array[i]));
            super.print(separator);
        }
        super.println(map.apply(array[n - 1]));
    }

    public <T> void printArray(T[] array, java.util.function.UnaryOperator<T> map) {
        this.printArray(array, " ", map);
    }
}