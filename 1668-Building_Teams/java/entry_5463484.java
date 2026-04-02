//package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class entry_5463484 {
    static FastIO in = new FastIO();
    static PrintWriter out = new PrintWriter(System.out);

    public static final int MN = 100010;
    public static final int MM = 200010;

    public static int N, M;
    public static boolean bad;
    public static boolean[] vis = new boolean[MN], group = new boolean[MN];
    public static int[] hd = new int[MN], nx = new int[MM * 2],
            to = new int[MM * 2];

    public static void dfs(int n, boolean g) {
        vis[n] = true;
        group[n] = g;
        for (int id = hd[n]; id != 0; id = nx[id])
            if (vis[to[id]]) {
                if (group[to[id]] == g) bad = true;
            } else dfs(to[id], !g);
    }
    public static void adde(int u, int v, int id) {
        nx[id] = hd[u];
        hd[u] = id;
        to[id] = v;
    }
    public static void main(String... args) {
        N = in.nextInt();
        M = in.nextInt();
        for (int i = 0, u, v; i < M; ++i) {
            u = in.nextInt();
            v = in.nextInt();
            adde(u, v, i * 2 + 1);
            adde(v, u, i * 2 + 2);
        }
        for (int i = 1; !bad && i <= N; ++i)
            if (!vis[i]) dfs(i, false);

        StringBuilder str = new StringBuilder();
        if (bad) out.println("IMPOSSIBLE");
        else
            for (int i = 1; i <= N; ++i) {
                str.append(group[i] ? '1' : '2').append(" ");
            }
        out.println(str);
        out.close();
    }
}
class FastIO extends PrintWriter {
    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
    private int curChar, numChars;

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
        if (numChars == -1) throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars == -1) return -1; // end of file
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

    public int nextInt() { // nextLong() would be implemented similarly
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
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res = 10 * res + c - '0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}