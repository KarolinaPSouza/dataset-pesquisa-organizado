// package graph;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.io.PrintWriter;
import java.io.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class entry_1948687 {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        // some time passes
        // long start = System.currentTimeMillis();
        // some time passes

        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        // br = new BufferedReader(new FileReader(".\\graph\\in.txt"));
        // out = new PrintWriter(new FileWriter(".\\graph\\out.txt"));
        // BufferedWriter output = new BufferedWriter(new
        // OutputStreamWriter(System.out));
        int cities = readInt();
        int roads = readInt();
        Graph g = new Graph(cities, roads);

        for (int i = 0; i < roads; i++) {
            int a = readInt();
            int b = readInt();
            g.addEdge(a, b);
        }
        LinkedList<Integer> heads = g.bfs();

        Iterator<Integer> i = heads.iterator();
        int prev = i.next();
        while (i.hasNext()) {
            int new_ele = i.next();
            out.write(prev + " " + new_ele + "\n");
            prev = new_ele;
        }
        // long end = System.currentTimeMillis();
        // long elapsedTime = end - start;
        // System.out.println(elapsedTime);
        out.close();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}

class Graph {
    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency Lists
    private int E;

    // Constructor
    Graph(int v, int e) {
        V = v;
        E = e;
        adj = new LinkedList[v + 1];
        for (int i = 0; i <= v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);

    }

    LinkedList<Integer> bfs() {
        LinkedList<Integer> heads = new LinkedList<Integer>();
        LinkedList<Integer> que = new LinkedList<Integer>();
        // que.add
        boolean isvisited[] = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            if (isvisited[i] == false) {
                heads.add(i);
                addall(que, isvisited, i);
            }

        }
        System.out.println(heads.size() - 1);
        return heads;

    }

    private void addall(LinkedList<Integer> que, boolean[] isvisited, int i) {
        isvisited[i] = true;

        que.add(i);
        while (!que.isEmpty()) {
            int ele = que.poll();
            for (int j = 0; j < adj[ele].size(); j++) {
                int a = adj[ele].get(j);
                if (!isvisited[a]) {
                    isvisited[a] = true;
                    que.add(a);
                }
            }

        }
    }
}