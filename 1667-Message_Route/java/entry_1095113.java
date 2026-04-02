import java.io.*;
import java.math.*;
import java.util.*;


public class entry_1095113 {
    static InputReader in = new InputReader(System.in);
    static OutputWriter out = new OutputWriter(System.out);

    public static void main(String[] args) {
        int n = in.readInt();
        int m = in.readInt();

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 1; i <= n; i++) graph.put(i, new ArrayList());

        for (int i = 1; i <= m; i++) {
            int startV = in.readInt();
            int endV = in.readInt();

            ArrayList<Integer> list = graph.get(startV);
            list.add(endV);
            graph.put(startV, list);

            list = graph.get(endV);
            list.add(startV);
            graph.put(endV, list);
        }


        int startV = 1,endV = n;

        bfs(graph, n, startV,endV);

        out.flush();
        out.close();
    }

    public static void bfs(HashMap<Integer, ArrayList<Integer>> graph, int countOfVertices, int startV,int endV) {
        boolean[] visited = new boolean[countOfVertices + 1];
        int[] levels = new int[countOfVertices + 1];
        visited[startV] = true;
        int prev[] = new int[countOfVertices + 1];
        Arrays.fill(prev, -1);// initializing with null
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startV);
        boolean pathExists = false;

        loop:
        while (!queue.isEmpty()) {
            int u = queue.poll();

            ArrayList<Integer> list = graph.get(u);

            if (list == null) {
                continue;
            }

            for (Integer w : list) {

                if (!visited[w]) {
                    levels[w] = levels[u] + 1;
                    visited[w] = true;
                    queue.add(w);
                    prev[w] = u;
                    if(w == endV){
                        pathExists = true;
                        break loop;
                    }
                }
            }
        }

        if(!pathExists){
            System.out.println("IMPOSSIBLE");
            return;
        }
        Stack<Integer> path = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (int at = endV; at != -1; at = prev[at]) {
            path.add(at);
        }
        str.append(path.size()).append('\n');
        while(!path.empty()) {
            str.append(path.pop()).append(' ');
        }
        System.out.println(str);
//        System.out.println("path " + path);
    }
}

class InputReader {
    private boolean finished = false;
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public int peek() {
        if (numChars == -1) {
            return -1;
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                return -1;
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            if (Character.isValidCodePoint(c)) {
                res.appendCodePoint(c);
            }
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private String readLine0() {
        StringBuilder buf = new StringBuilder();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r') {
                buf.appendCodePoint(c);
            }
            c = read();
        }
        return buf.toString();
    }

    public String readLine() {
        String s = readLine0();
        while (s.trim().length() == 0) {
            s = readLine0();
        }
        return s;
    }

    public BigInteger readBigInteger() {
        return new BigInteger(readString());
    }

    public String readLine(boolean ignoreEmptyLines) {
        if (ignoreEmptyLines) {
            return readLine();
        } else {
            return readLine0();
        }
    }

    public double readDouble() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') {
                return res * Math.pow(10, readInt());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public boolean isExhausted() {
        int value;
        while (isSpaceChar(value = peek()) && value != -1) {
            read();
        }
        return value == -1;
    }

    public String next() {
        return readString();
    }

    public SpaceCharFilter getFilter() {
        return filter;
    }

    public void setFilter(SpaceCharFilter filter) {
        this.filter = filter;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }

    public int[] readIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) array[i] = readInt();
        return array;
    }

    public long[] readLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; ++i) array[i] = readLong();
        return array;
    }

    public int[][] readIntMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; ++i) {
            matrix[i] = readIntArray(m);
        }
        return matrix;
    }

    public long[][] readLongMatrix(int n, int m) {
        long[][] matrix = new long[n][m];
        for (int i = 0; i < n; ++i) {
            matrix[i] = readLongArray(m);
        }
        return matrix;
    }

    public char[][] readCharMatrix(int n, int m) {
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; ++i) matrix[i] = next().toCharArray();
        return matrix;
    }
}

//readLine(true) or readLine() = ignore empty lines
//readLine(false) = don't ignore empty lines
class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

    public void flush() {
        writer.flush();
    }
}
