import java.io.*;
import java.util.*;

public class entry_11177378 {

    static int N, M;
    static FastIO io;

    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    static ArrayList<Integer[]> ans = new ArrayList<>();

    public static void main(String... args) throws IOException {

//        io = new FastIO(new FileInputStream("input.in"), System.out);
        io = new FastIO();

        N = io.nextInt();
        M = io.nextInt();

        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = io.nextInt(), b = io.nextInt();

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        dfs(1);

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                adj.get(1).add(i);
                adj.get(i).add(1);
                ans.add(new Integer[]{1, i});
                dfs(i);
            }
        }

        io.println(ans.size());
        for (Integer[] e : ans) {
            io.println(e[0] + " " + e[1]);
        }
        io.close();

    }

    public static void dfs(int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        for (int x : adj.get(node)) {
            dfs(x);
        }
    }
}

class FastIO extends PrintWriter {

    private InputStream stream;

    private byte[] buf = new byte[1 << 16];

    private int curChar;

    private int numChars;


    // standard input

    public FastIO() { this(System.in, System.out); }


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

        if (numChars == -1) { throw new InputMismatchException(); }

        if (curChar >= numChars) {

            curChar = 0;

            try {

                numChars = stream.read(buf);

            } catch (IOException e) { throw new InputMismatchException(); }

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

        do { c = nextByte(); } while (c <= ' ');


        StringBuilder res = new StringBuilder();

        do {

            res.appendCodePoint(c);

            c = nextByte();

        } while (c > ' ');

        return res.toString();

    }


    public int nextInt() {  // nextLong() would be implemented similarly

        int c;

        do { c = nextByte(); } while (c <= ' ');


        int sgn = 1;

        if (c == '-') {

            sgn = -1;

            c = nextByte();

        }


        int res = 0;

        do {

            if (c < '0' || c > '9') { throw new InputMismatchException(); }

            res = 10 * res + c - '0';

            c = nextByte();

        } while (c > ' ');

        return res * sgn;

    }


    public double nextDouble() { return Double.parseDouble(next()); }

}