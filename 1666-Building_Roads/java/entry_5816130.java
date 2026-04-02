import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;

public class entry_5816130 {

    static int[] parent;

    // Initialize Union Find to have each component of size 1 by itself
    public static void initialize(int n) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public static int find(int child) {
        if (parent[child] == child) {
            return child;
        }

        // Path compression to make it quicker to find the parent next time
        parent[child] = find(parent[child]);
        return parent[child];
    }

    public static boolean union(int childA, int childB) {
        int rootA = find(childA);
        int rootB = find(childB);

        if (rootA == rootB) {
            // Already same component, no need to merge
            return true;
        }

        // We have that size[rootA] <= size[rootB], so it is best to merge rootA into
        // rootB
        parent[rootA] = rootB;
        return false;
    }

    public static void main(String[] args) {
        // Using FastIO, you can ignore this and the below class, it isn't the bug
        FastScanner scan = new FastScanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        initialize(n);

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            union(a,b);
        }

        ArrayList<Integer> cities = new ArrayList<>();
        int roads = 0;
        for (int i = 1; i < n; i++) {
            if (!union(0, i)) {
                roads++;
                cities.add(i);
            }
        }
        System.out.println(roads);
        for (int i : cities) {
            System.out.print("1 ");
            System.out.println(i + 1);
        }
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
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
}