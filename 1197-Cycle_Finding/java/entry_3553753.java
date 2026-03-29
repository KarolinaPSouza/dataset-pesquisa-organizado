import java.io.*;
import java.util.*;

// Cycle Finding: https://www.cses.fi/problemset/task/1197/
public class entry_3553753 {
    public static void main(String[] args) throws IOException {
        final FastScanner scan = new FastScanner(System.in);
        final int numNodes = scan.nextInt();
        final int numEdges = scan.nextInt();
        List<Edge> edges = new ArrayList<>();
        int[] paths = new int[numNodes + 1];
        long[] dist = new long[numNodes + 1];

        for (int i = 0; i < numEdges; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            Edge current = new Edge(a, b, c);
            edges.add(current);
        }

        for (int i = 0; i < dist.length; i++) dist[i] = Integer.MAX_VALUE;
        dist[1] = 0; // source

        int token = -1;
        for (int i = 0; i <= numNodes; i++) {
            token = -1;
            for (Edge e : edges) {
                if(dist[e.dest] > dist[e.start] + e.weight) {
                    dist[e.dest] = dist[e.start] + e.weight;
                    paths[e.dest] = e.start;
                    token = e.start;
                }
            }
        }

        if (token != -1) {
            System.out.println("YES");
            List<Integer> result = new ArrayList<>();

            int current = paths[token];
            while(!result.contains(current)) {
                result.add(current);
                current = paths[current];
            }

            result.add(current);
            Collections.reverse(result);
            for (int i : result) System.out.print(i + " ");
        } else {
            System.out.println("NO");
        }
    }

    public static class Edge {
        int start;
        int dest;
        int weight;

        public Edge(int start, int dest, int weight) {
            this.start = start;
            this.dest = dest;
            this.weight = weight;
        }
    }
}

/**
 * Code by Matt Fontaine: http://www.usaco.org/current/data/sol_disrupt_platinum_open18.html
 */
class FastScanner {
    private final InputStream stream;
    private final byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FastScanner(InputStream stream) {
        this.stream = stream;
    }

    int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    boolean isEndline(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String next() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    String nextLine() {
        int c = read();
        while (isEndline(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndline(c));
        return res.toString();
    }
}