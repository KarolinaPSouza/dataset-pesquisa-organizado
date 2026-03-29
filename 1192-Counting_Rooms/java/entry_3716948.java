//package cses;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

public class entry_3716948 {
    static final FastIO io = new FastIO();
    static final StringBuilder sb = new StringBuilder();
    static final int MODULUS = 1000000007;

    public static void main(String[] args) {
        try {
            int n = io.nextInt();
            int m = io.nextInt();
            boolean[][] arr = new boolean[n][m];
            for (int i = 0; i < arr.length; i++) {
                String row = io.next();
                for (int j = 0; j < row.length(); j++) {
                    arr[i][j] = row.charAt(j) != '#';
                }
            }

            UnionFind uf = new UnionFind(n * m + 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!arr[i][j]) {
                        uf.union(n * m, i * m + j);
                        continue;
                    }
                    int[] offseti = {1, 0, -1 , 0};
                    int[] offsetj = {0, 1, 0 , -1};

                    for (int k = 0; k < 4; k++) {
                        int otheri = offseti[k] + i;
                        int otherj = offsetj[k] + j;
                        if (otheri >= 0 && otheri < n && otherj >= 0 && otherj < m && arr[i][j] == arr[otheri][otherj])
                            uf.union(i * m + j, otheri * m + otherj);
                    }
                }
            }

            io.println(IntStream.range(0, n * m + 1).map(uf::find).distinct().count() - 1);
        } finally {
            io.close();
        }
    }

    static final class UnionFind {
        private final int[] parent;
        private final byte[] rank;

        public UnionFind(int n) {
            parent = new int[n]; rank = new byte[n];
            for (int i = 0; i < n; i++) { parent[i] = i; rank[i] = 0; }
        }

        public int find(int p) {
            while (p != parent[p]) { parent[p] = parent[parent[p]]; p = parent[p]; }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;

            if (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
            else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
            else { parent[rootQ] = rootP; rank[rootP]++; }
        }
    }

    static int minValid(Function<Integer, Boolean> valid, int left, int right){
        if (left == right) return left;
        int mid = (left + right) / 2;
        if(valid.apply(mid)) return minValid(valid,left,mid); else return minValid(valid,mid+1,right);
    }

    static int maxValid(Function<Integer, Boolean> valid, int left, int right){
        if (left == right) return left;
        int mid = (left + right + 1) / 2;
        if(valid.apply(mid)) return maxValid(valid,mid,right); else return maxValid(valid,left,mid-1);
    }

    static final class Tuple2<T1, T2> {
        public final T1 _1;
        public final T2 _2;

        public Tuple2(T1 t1, T2 t2) { this._1 = t1; this._2 = t2; }
        public int hashCode() { return Objects.hash(_1, _2); }

        public static <U1 extends Comparable<? super U1>, U2 extends Comparable<? super U2>> int compareTo(Tuple2<U1, U2> t1, Tuple2<U1, U2> t2) {
            final int check1 = (t1)._1.compareTo(t2._1);
            if (check1 != 0) return check1;
            return (t1)._2.compareTo(t2._2);
        }

        public static <T1, T2> Comparator<Tuple2<T1, T2>> comparator(Comparator<? super T1> t1Comp, Comparator<? super T2> t2Comp) {
            return (t1, t2) -> {
                final int check1 = t1Comp.compare(t1._1, t2._1);
                if (check1 != 0) return check1;
                return t2Comp.compare(t1._2, t2._2);
            };
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            else if (!(o instanceof Tuple2)) return false;
            else {
                final Tuple2<?, ?> that = (Tuple2<?, ?>) o;
                return Objects.equals(this._1, that._1) && Objects.equals(this._2, that._2);
            }
        }
    }

    static class FastIO extends PrintWriter {
        private final InputStream stream;
        private final byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

        public FastIO() { this(System.in, System.out); }
        public FastIO(InputStream i, OutputStream o) { super(o); stream = i; }
        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }

        private int nextByte() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try { numChars = stream.read(buf); }
                catch (IOException e) { throw new InputMismatchException(); }
                if (numChars == -1) return -1; // end of file
            }
            return buf[curChar++];
        }

        // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
        public String next() {
            int c;
            do { c = nextByte(); } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
            return res.toString();
        }

        public int nextInt() {
            int c;
            do { c = nextByte(); } while (c <= ' ');
            int sgn = 1;
            if (c == '-') { sgn = -1; c = nextByte(); }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public long nextLong() {
            int c;
            do { c = nextByte(); } while (c <= ' ');
            int sgn = 1;
            if (c == '-') { sgn = -1; c = nextByte(); }
            long res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public double nextDouble() { return Double.parseDouble(next()); }
    }
}