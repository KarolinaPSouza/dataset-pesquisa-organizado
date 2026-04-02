import java.io.*;
import java.math.*;
import java.util.*;
public class entry_1336121 {
}
class Edge {
    int from;
    int to;
    int cost;
    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
class Node {
    int id;
    long value;
    public Node(int id, long value) {
        this.id = id;
        this.value = value;
    }
}

class Solution {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int n = in.readInt();
        int m = in.readInt();
        HashMap<Integer,ArrayList<Edge>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = in.readInt()-1;
            int to = in.readInt()-1;
            int cost = in.readInt();
            ArrayList<Edge> list = map.get(from);
            list.add(new Edge(from,to,cost));
            map.put(from,list);

//            list = map.get(to);
//            list.add(new Edge(to,from,cost));
//            map.put(to,list);
        }
        int start = 0;
        long distance[] = dijkstra(map,n,start);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(distance[i]).append(' ');
        }
        System.out.println(str);
    }
    private static Comparator<Node> comparator =
            (node1, node2) -> {
                if (Math.abs(node1.value - node2.value) < 0) return 0;
                return (node1.value - node2.value) > 0 ? +1 : -1;
            };

    private static long[] dijkstra(HashMap<Integer, ArrayList<Edge>> map, int n,int start) {
        boolean[] visited = new boolean[n];
        long[] distance = new long[n];
        int[] prev = new int[n];
        Arrays.fill(distance,Long.MAX_VALUE/2);
        Arrays.fill(prev,-1);
        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(2 * n, comparator);
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()){
            Node node = pq.poll();
            visited[node.id] = true;
            // We already found a better path before we got to
            // processing this node so we can ignore it.
            if (distance[node.id] < node.value) continue;
            for (Edge edge: map.get(node.id)) {
                // You cannot get a shorter path by revisiting
                // a node you have already visited before.
                if (visited[edge.to]) continue;

                // Relax edge by updating minimum cost if applicable.
                long newDist = distance[edge.from] + edge.cost;
                if (newDist < distance[edge.to]) {
                    prev[edge.to] = edge.from;
                    distance[edge.to] = newDist;
                    pq.offer(new Node(edge.to, distance[edge.to]));
                }
            }
//            if (node.id == end) return distance[end];
        }
        return distance;
    }
}

class InputReader {
    private boolean finished = false;private InputStream stream;private byte[] buf = new byte[1024];private int curChar;private int numChars;private SpaceCharFilter filter;public InputReader(InputStream stream) { this.stream = stream; }public int read() { if (numChars == -1) { throw new InputMismatchException(); }if (curChar >= numChars) { curChar = 0;try { numChars = stream.read(buf); } catch (IOException e) { throw new InputMismatchException(); }if (numChars <= 0) { return -1; } }return buf[curChar++]; }public int peek() { if (numChars == -1) { return -1; }if (curChar >= numChars) { curChar = 0;try { numChars = stream.read(buf); } catch (IOException e) { return -1; }if (numChars <= 0) { return -1; } }return buf[curChar]; }
    public int readInt() { int c = read();while (isSpaceChar(c)) { c = read(); }int sgn = 1;if (c == '-') { sgn = -1;c = read(); }int res = 0;do { if (c < '0' || c > '9') { throw new InputMismatchException(); }res *= 10;res += c - '0';c = read(); } while (!isSpaceChar(c));return res * sgn; }
    public long readLong() { int c = read();while (isSpaceChar(c)) { c = read(); }int sgn = 1;if (c == '-') { sgn = -1;c = read(); }long res = 0;do { if (c < '0' || c > '9') { throw new InputMismatchException(); }res *= 10;res += c - '0';c = read(); } while (!isSpaceChar(c));return res * sgn; }
    public String readString() { int c = read();while (isSpaceChar(c)) { c = read(); }StringBuilder res = new StringBuilder();do { if (Character.isValidCodePoint(c)) { res.appendCodePoint(c); }c = read(); } while (!isSpaceChar(c));return res.toString(); }public boolean isSpaceChar(int c) { if (filter != null) { return filter.isSpaceChar(c); }return isWhitespace(c); }public static boolean isWhitespace(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; }private String readLine0() { StringBuilder buf = new StringBuilder();int c = read();while (c != '\n' && c != -1) { if (c != '\r') { buf.appendCodePoint(c); }c = read(); }return buf.toString(); }
    public String readLine() { String s = readLine0();while (s.trim().length() == 0) { s = readLine0(); }return s; }
    public String readLine(boolean ignoreEmptyLines) { if (ignoreEmptyLines) { return readLine(); } else { return readLine0(); } }
    public double readDouble() { int c = read();while (isSpaceChar(c)) { c = read(); }int sgn = 1;if (c == '-') { sgn = -1;c = read(); }double res = 0;while (!isSpaceChar(c) && c != '.') { if (c == 'e' || c == 'E') { return res * Math.pow(10, readInt()); }if (c < '0' || c > '9') { throw new InputMismatchException(); }res *= 10;res += c - '0';c = read(); }if (c == '.') { c = read();double m = 1;while (!isSpaceChar(c)) { if (c == 'e' || c == 'E') { return res * Math.pow(10, readInt()); }if (c < '0' || c > '9') { throw new InputMismatchException(); }m /= 10;res += (c - '0') * m;c = read(); } }return res * sgn; }public boolean isExhausted() { int value;while (isSpaceChar(value = peek()) && value != -1) { read(); }return value == -1; }public String next() { return readString(); }public SpaceCharFilter getFilter() { return filter; }public void setFilter(SpaceCharFilter filter) { this.filter = filter; }public interface SpaceCharFilter { public boolean isSpaceChar(int ch);}
    public int[] readIntArray(int n){ int[] array=new int[n];for(int i = 0; i<n; ++i)array[i]= readInt();return array; }
    public long[] readLongArray(int n){ long[] array=new long[n];for(int i = 0; i<n; ++i)array[i]= readLong();return array; }
    public int[][] readIntMatrix(int n, int m){ int[][] matrix=new int[n][m];for(int i = 0; i<n; ++i){ matrix[i] = readIntArray(m); }return matrix; }
    public long[][] readLongMatrix(int n, int m){ long[][] matrix=new long[n][m];for(int i = 0; i<n; ++i){ matrix[i] = readLongArray(m); }return matrix; }
    public char[] readCharArray(){ return next().toCharArray(); }
    public char[][] readCharMatrix(int n, int m){ char[][] matrix=new char[n][m];for(int i = 0; i<n; ++i) matrix[i]=next().toCharArray();return matrix; }
    public BigInteger readBigInteger(){ return new BigInteger(readString()); }

}
//readLine(true) or readLine() = ignore empty lines
//readLine(false) = don't ignore empty lines
