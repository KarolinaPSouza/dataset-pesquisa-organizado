import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class entry_2163595 {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        Reader sc = new Reader();
        int V = sc.i();
        int m = sc.i();
        Map<Integer, List<Integer>> graph = new HashMap<>(V);
        for (int i = 0; i < V; i++) {
            graph.put(i + 1, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.i(), b = sc.i();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] visited = new boolean[V];
        Stack<Integer> route = new Stack<>();
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            route.clear();
            if (!visited[entry.getKey() - 1] && dfs(entry.getKey(), graph, visited, route, -1)) {
                break;
            }
        }
        if (route.size() > 3) {
            printRoute(route, out);
        } else {
            out.append("IMPOSSIBLE");
        }
        out.flush();
        out.close();
    }

    private static void printRoute(Stack<Integer> route, PrintWriter out) {
        int temp = route.peek();
        StringBuilder builder = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < route.size(); i++) {
            if (route.get(i) == temp) {
                counter = i;
                break;
            }
        }
        out.println(route.size() - counter);
        for (int i = counter; i < route.size(); i++) {
            builder.append(route.get(i)).append(" ");
        }
        out.append(builder.toString().trim());
    }

    private static boolean dfs(int vertex, Map<Integer, List<Integer>> graph, boolean[] visited, Stack<Integer> route, int parentVertex) {
        route.push(vertex);
        visited[vertex - 1] = true;
        for (Integer node : graph.get(vertex)) {
            if (node == parentVertex) continue;
            if (visited[node - 1]) {
                route.push(node);
                return true;
            }
            if (dfs(node, graph, visited, route, vertex)) {
                return true;
            }
        }
        route.pop();
        return false;
    }


    static class Reader {
        private InputStream mIs;
        private byte[] buf = new byte[1024];
        private int curChar, numChars;

        public Reader() {
            this(System.in);
        }

        public Reader(InputStream is) {
            mIs = is;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = mIs.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String s() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long l() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int i() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public double d() throws IOException {
            return Double.parseDouble(s());
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int[] arr(int n) {
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                ret[i] = i();
            }
            return ret;
        }
    }
}