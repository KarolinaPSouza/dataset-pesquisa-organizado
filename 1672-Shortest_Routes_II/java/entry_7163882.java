import java.io.*;
import java.util.*;

public class entry_7163882 {

    private static class Printer extends PrintWriter {
        public Printer(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Printer(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public int getInt() {
            return Integer.parseInt(nextToken());
        }

        public double getDouble() {
            return Double.parseDouble(nextToken());
        }

//        public long getLong() {
//            return Long.parseLong(nextToken());
//        }
//
//        public String getWord() {
//            return nextToken();
//        }

        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;

        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) { }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }



    private static class Node implements Comparable {
        private int ID;
        private ArrayList<Edge> neighbors;
        private boolean visited;
        private long cost;
        Node(int ID) {
            this.ID = ID;
            neighbors = new ArrayList<>();
            visited = false;
            cost = Long.MAX_VALUE;
        }
        void addEdge(Edge e) {
            neighbors.add(e);
        }
        public int compareTo(Object o) {
            return Long.compare(cost, ((Node) o).cost);
        }
    }

    private static class Edge {
        private int weight;
        private Node dest;
        Edge(int weight, Node dest) {
            this.weight = weight;
            this.dest = dest;
        }
    }

    private static class Path implements Comparable {
        private int dest;
        private long cost;
        Path(int d, long l) {
            dest = d;
            cost = l;
        }
        public int compareTo(Object other) {
            return Long.compare(cost, ((Path) other).cost);
        }
//        public String toString() {
//            return "Dest from start: " + dest + ". Cost: " + cost;
//        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final long INF = (long) 1e12;
        Printer p = new Printer(System.in, System.out);
        int cities = p.getInt();
        int roads = p.getInt();
        int queries = p.getInt();
        long[][] d = new long[cities][cities];
        // initialize everything else to infinity, and set distance from a node to itself to 0
        for(int i = 0; i < cities; i++) {
            for(int j = 0; j < cities; j++) {
                if(i != j) d[i][j] = INF;
            }
        }
        // then fill in all the edges
        for(int i = 0; i < roads; i++) {
            int a = p.getInt();
            int b = p.getInt();
            int cost = p.getInt();
            d[a - 1][b - 1] = Math.min(d[a-1][b-1], cost);
            d[b - 1][a - 1] = Math.min(d[a-1][b-1], cost);
        }
        for(int i = 0; i < cities; i++) {
            for(int j = 0; j < cities; j++) {
                for(int l = 0; l < cities; l++) {
                    if(d[j][l] > d[j][i] + d[i][l]) {
                        d[j][l] = d[j][i] + d[i][l];
                    }
                }
            }
        }

        for(int i = 0; i < queries; i++) {
            int src = p.getInt();
            int dest = p.getInt();
            p.println(d[src - 1][dest - 1] != INF ? d[src-1][dest-1] : -1);
        }
        p.close();
    }
}