//package graph_theory.shortest_routes_II;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FastReader {
    private int BS = 1 << 16;
    private char NC = (char) 0;
    private byte[] buf = new byte[BS];
    private int bId = 0, size = 0;
    private char c = NC;
    private double cnt = 1;
    private BufferedInputStream in;

    public FastReader() {
        in = new BufferedInputStream(System.in, BS);
    }

    // dont' use this to read chars.
    private char readChar() {
        while (bId == size) {
            try {
                size = in.read(buf);
            } catch (Exception e) {
                return NC;
            }
            if (size == -1) return NC;
            bId = 0;
        }
        return (char) buf[bId++];
    }

    public int readInt() {
        return (int) readLong();
    }

    public int[] readInts(int N) {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = (int) readLong();
        }
        return res;
    }

    public long[] readLongs(int N) {
        long[] res = new long[N];
        for (int i = 0; i < N; i++) {
            res[i] = readLong();
        }
        return res;
    }

    public long readLong() {
        cnt = 1;
        boolean neg = false;
        if (c == NC) c = readChar();
        for (; (c < '0' || c > '9'); c = readChar()) {
            if (c == '-') neg = true;
        }
        long res = 0;
        for (; c >= '0' && c <= '9'; c = readChar()) {
            res = (res << 3) + (res << 1) + c - '0';
            cnt *= 10;
        }
        return neg ? -res : res;
    }

    public double nextDouble() {
        double cur = readLong();
        return c != '.' ? cur : cur + readLong() / cnt;
    }

    public double[] nextDoubles(int N) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextDouble();
        }
        return res;
    }

    public String readString() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = readChar();
        while (c > 32) {
            res.append(c);
            c = readChar();
        }
        return res.toString();
    }

    public String readLine() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = readChar();
        while (c != '\n') {
            res.append(c);
            c = readChar();
        }
        return res.toString();
    }

    public boolean hasNext() {
        if (c > 32) return true;
        while (true) {
            c = readChar();
            if (c == NC) return false;
            else if (c > 32) return true;
        }
    }
}

public class entry_6034352 {
    private PrintWriter writer;
    private FastReader reader;

    private long[][] apspFloydWarshal(long[][] adjMatrix, int n){
        long[][] apspPrev = adjMatrix;
        long[][] apspCurr = new long[n+1][n+1];
        for (int k = 1; k <= n; k++){
            for (int u = 1; u <= n; u++){
                for (int v = u+1; v <= n; v++){
                    long minLen = apspPrev[u][v];
                    if (apspPrev[u][k] < INF && apspPrev[k][v] < INF) minLen = Math.min(minLen, apspPrev[u][k] + apspPrev[k][v]);
                    apspCurr[u][v] = minLen;
                    apspCurr[v][u] = minLen;
                }
            }
            long[][] temp = apspCurr;
            apspCurr = apspPrev;
            apspPrev = temp;
        }
        return apspPrev;
    }
    private void solve(){
        writer = new PrintWriter(System.out);
        reader = new FastReader();
        int n = reader.readInt(), m = reader.readInt(), q = reader.readInt();
        long[][] adjMatrix = readWeightedGraph(n, m);
        long[][] apsp = apspFloydWarshal(adjMatrix, n);
        while (--q >= 0){
            int u = reader.readInt(), v = reader.readInt();
            if (apsp[u][v] < INF) writer.println(apsp[u][v]);
            else writer.println(-1);
        }


        writer.close();

    }
    private static final long INF = Long.MAX_VALUE;
    private long[][]  readWeightedGraph(int n, int m){
        long[][] adjMatrix = new long[n+1][n+1];
        for (int u = 1; u <= n; u++) {
            Arrays.fill(adjMatrix[u],INF);
            adjMatrix[u][u] = 0;
        }

        for (int i = 0; i < m; i++){
            int u = reader.readInt();
            int v = reader.readInt();
            int w = reader.readInt();
            adjMatrix[u][v] = Math.min(adjMatrix[u][v], w);
            adjMatrix[v][u] = adjMatrix[u][v];
        }
        return adjMatrix;
    }

    public static void main(String[] args) {
        new entry_6034352().solve();
    }
}