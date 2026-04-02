/* A bipartite graph can be colored with two colors such that no two adjacent vertices share the same color. This means we can divide the graph’s vertices into two distinct sets */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class entry_11815705 {

    public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static ArrayList<Integer> visited = new ArrayList<>();
    public static boolean impossible = false;

    public static void main(String[] args) throws Exception {
        FastIO in = new FastIO(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            visited.add(0);
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //print(adj);

        for (int v = 0; v < n; v++) {
            if (visited.get(v) == 0) {
                visited.set(v, 1);
                dfs(v);
            }
        }

        if (impossible) {
            out.println("IMPOSSIBLE");
        } else {
            StringBuilder res = new StringBuilder();
            for (Integer elem : visited) {
                res.append(elem);
                res.append(" ");
            }
            out.print(res);
        }

        out.flush();
    }

    public static void dfs(int u) {
        int curr_color = visited.get(u);
        for (Integer v : adj.get(u)) {
            if (visited.get(v) == 0) {
                visited.set(v, 3 - curr_color);
                dfs(v);
            } else {
                if (visited.get(v) == curr_color) {
                    impossible = true;
                }
            }
        }
    }

    public static class FastIO {
        InputStream dis;
        byte[] buffer = new byte[1 << 16];
        int ptr = 0;
        public FastIO(InputStream istream) {
            dis = istream;
        }
        int nextInt() throws Exception {
            int num = 0;
            byte ch;
            do {
                ch = nextByte();
            } while(ch <= ' ');
            boolean negative = false;
            if (ch == '-') {
                negative = true;
                ch = nextByte();
            }
            while(ch >= '0' && ch <= '9') {
                num = (num << 1) + (num << 3) + (ch - '0');
                ch = nextByte();
            }
            return (negative ? -num : num);
        }
        byte nextByte() throws Exception {
            if (ptr == buffer.length) {
                dis.read(buffer, 0, buffer.length);
                ptr = 0;
            }
            return buffer[ptr++];
        }
        public void close() throws Exception {
            if (dis == null) {
                return;
            }
            dis.close();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> arr) {
        int idx = 0;
        for (ArrayList<Integer> v : arr) {
            System.out.print(idx + ": ");
            for (Integer x : v) {
                System.out.print(x + " ");
            }
            System.out.println();
            idx++;
        }
    }

}