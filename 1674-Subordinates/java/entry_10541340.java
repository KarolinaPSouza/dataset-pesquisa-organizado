import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Stack;

public class entry_10541340 {
    static FastIO io = new FastIO();
    static int mod = 1_000_000_007;
    static int[] subs;
    static List<List<Integer>> adjList;


    public static void main(String[] args) {
        int n = io.nextInt();
        subs = new int[n];
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int node = io.nextInt() - 1;
//            adjList.get(i).add(node);
            adjList.get(node).add(i);
        }
//        dfs(0, -1);
        dfsIterative(n);
        StringBuilder str = new StringBuilder();
        for (int num : subs)
            str.append(num).append(" ");
        io.println(str);
        io.close();
    }

    public static void dfsIterative(int n) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> postProcessing = new Stack<>();
        boolean[] vis = new boolean[n];
        stack.push(0);
        while (!stack.isEmpty()) {
            int curNode = stack.peek();
            if (!vis[curNode]) {
                vis[curNode] = true;
                postProcessing.push(curNode);
                for (int neig : adjList.get(curNode)) {
                    if (!vis[neig]) {
                        stack.push(neig);
                    }
                }
            } else {
                stack.pop();
            }
        }
        //Counting subordinates
        while (!postProcessing.isEmpty()) {
            int curNode = postProcessing.pop();
            int count = 0;
            for (int neig : adjList.get(curNode)) {
                count = count + subs[neig] + 1;
            }
            subs[curNode] = count;
        }

    }

    //To check whether current node is leaf node
    public static boolean isLeaf(int node) {
        return node != 0 && adjList.get(node).size() == 1;
    }

    public static void dfs(int node, int parent) {
        if (isLeaf(node)) {
            subs[node] = 1;
            return;
        }
        for (int neig : adjList.get(node)) {
            if (neig == parent) continue;
            dfs(neig, node);
        }
        for (int neig : adjList.get(node)) {
            if (neig == parent) continue;
            subs[node] += subs[neig];
        }
        subs[node]++;
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

    public int nextInt() {
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
            if (c < '0' || c > '9') throw new InputMismatchException();
            res = 10 * res + c - '0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }

    public long nextLong() {
        int c;
        do {
            c = nextByte();
        } while (c <= ' ');
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = nextByte();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            res = 10 * res + c - '0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
