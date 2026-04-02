import java.util.*;
import java.io.*;

public class entry_15121743 {
    static FastReader in = new FastReader();
    // static final Random random = new Random();
    static final int MOD = (int) 1e9 + 7;
    static StringBuilder res;
    static FastWriter out = new FastWriter();
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        res = new StringBuilder();
        int t = 1;
        while (t-- > 0) {

            int n = in.nextInt();
            int m = in.nextInt();

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                graph.add(new ArrayList<>());
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            Queue<Integer> q = new LinkedList<>();
            int[] dist = new int[n + 1];
            int[] parent = new int[n + 1];
            Arrays.fill(dist, (int) 1e7);
            ArrayList<Integer> track = new ArrayList<>();
            boolean flag = false;
            dist[1] = 0;
            q.add(1);
            while (!q.isEmpty()) {
                if (flag)
                    break;
                int len = q.size();
                for (int i = 0; i < len; i++) {
                    int top = q.poll();
                    if (top == n) {
                        append(dist[n] + 1);
                        int curr = n;
                        while (curr != 0) {
                            track.add(curr);
                            curr = parent[curr];
                        }
                        // System.out.println(track);
                        for (int j = track.size() - 1; j >= 0; j--) {
                            appendSpace(track.get(j));
                        }
                        flag = true;
                        break;
                    }
                    for (Integer child : graph.get(top)) {
                        if (1 + dist[top] < dist[child]) {
                            parent[child]=top;
                            dist[child] = 1 + dist[top];
                            q.add(child);
                        }
                    }

                }
            }
            if (!flag)
                append("IMPOSSIBLE");

            // for single integer

            // for int array
            // int[] arr = in.readIntArray(n);

            // Input a 2D integer matrix
            // int[][] intMatrix = in.readIntMatrix(n, n);

        }
        print(res);
        out.close();
    }

    static void dfs(int city, ArrayList<ArrayList<Integer>> graph, int mark, int[] visited) {
        visited[city] = mark;
        for (Integer child : graph.get(city)) {
            if (visited[child] == 0)
                dfs(child, graph, mark, visited);
        }

    }

    static int modAdd(int a, int b, int mod) {
        return ((a % mod) + (b % mod)) % mod;
    }

    static int modSub(int a, int b, int mod) {
        return ((a % mod) - (b % mod) + mod) % mod;
    }

    static int modMul(int a, int b, int mod) {
        return (int) (((long) a * b) % mod);
    }

    static int modPow(int base, int exp, int mod) {
        int res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = modMul(res, base, mod);
            }
            base = modMul(base, base, mod);
            exp >>= 1;
        }
        return res;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    static <E> void print(E res) {
        System.out.println(res);
    }

    static <E> void append(E s) {
        res.append(s + "\n");
    }

    static <E> void appendSpace(E s) {
        res.append(s + " ");
    }

    static <E> void appendLine() {
        res.append("\n");
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.write(String.valueOf(object));
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.write("\n");
        }

        public void close() throws IOException {
            bw.flush();
            bw.close();
        }
    }

    static class FastReader {
        DataInputStream din;
        byte[] buffer;
        int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[1 << 16];
            bufferPointer = bytesRead = 0;
        }

        private byte readByte() throws IOException {
            if (bufferPointer == bytesRead) {
                bytesRead = din.read(buffer, 0, buffer.length);
                if (bytesRead == -1)
                    buffer[0] = -1;
                bufferPointer = 0;
            }
            return buffer[bufferPointer++];
        }

        public int read() throws IOException {
            return readByte();
        }

        public String next() {
            StringBuilder sb = new StringBuilder();
            try {
                byte c = skip();
                while (!isSpaceChar(c)) {
                    sb.append((char) c);
                    c = readByte();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }

        public int nextInt() {
            int ret = 0;
            try {
                byte c = skip();
                boolean neg = (c == '-');
                if (neg)
                    c = readByte();
                while (!isSpaceChar(c)) {
                    ret = ret * 10 + c - '0';
                    c = readByte();
                }
                if (neg)
                    ret = -ret;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ret;
        }

        public long nextLong() {
            long ret = 0;
            try {
                byte c = skip();
                boolean neg = (c == '-');
                if (neg)
                    c = readByte();
                while (!isSpaceChar(c)) {
                    ret = ret * 10 + c - '0';
                    c = readByte();
                }
                if (neg)
                    ret = -ret;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ret;
        }

        public double nextDouble() {
            double ret = 0, div = 1;
            try {
                byte c = skip();
                boolean neg = (c == '-');
                if (neg)
                    c = readByte();
                while (!isSpaceChar(c) && c != '.') {
                    ret = ret * 10 + c - '0';
                    c = readByte();
                }
                if (c == '.') {
                    while (true) {
                        c = readByte();
                        if (isSpaceChar(c))
                            break;
                        ret += (c - '0') / (div *= 10);
                    }
                }
                if (neg)
                    ret = -ret;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ret;
        }

        public String nextLine() {
            StringBuilder sb = new StringBuilder();
            try {
                byte c = readByte();
                while (c != -1 && c != '\n') {
                    sb.append((char) c);
                    c = readByte();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }

        private byte skip() throws IOException {
            byte c;
            while (isSpaceChar((c = readByte())))
                ;
            return c;
        }

        private boolean isSpaceChar(byte c) {
            return c <= ' ';
        }

        public int[][] readIntMatrix(int rows, int cols) {
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = nextInt();
                }
            }
            return matrix;
        }

        public char[][] readCharMatrix(int rows, int cols) {
            char[][] matrix = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                String line = next();
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }
            return matrix;
        }

        public void close() throws IOException {
            din.close();
        }
    }

    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n < 4)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    static long nCr(int n, int r) {
        if (r > n)
            return 0;
        long numerator = 1, denominator = 1;
        r = Math.min(r, n - r);
        for (int i = 0; i < r; i++) {
            numerator *= (n - i);
            denominator *= (i + 1);
        }
        return numerator / denominator;
    }

    static void gcdArray(int[] arr) {
        int g = arr[0];
        for (int i = 1; i < arr.length; i++) {
            g = gcd(g, arr[i]);
        }
    }
}