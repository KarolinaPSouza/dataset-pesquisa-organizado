import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_1188231 {
    static FastReader sc;
 static PrintWriter out;
    public static void main(String[] args) {
        sc = new FastReader();
        out = new PrintWriter(System.out);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        ArrayList < Integer > [] adjList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) adjList[i] = new ArrayList < > ();
        for (int i = 0; i < m; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            adjList[a].add(b);
            adjList[b].add(a);
        }
        boolean[] visited = new boolean[n + 1]; // +1 since this is 1-indexed
        ArrayDeque < State > queue = new ArrayDeque < > ();
        ArrayDeque < Integer > route = new ArrayDeque < > ();
        queue.add(new State(1, 1, null));
        visited[1] = true;
        while (!queue.isEmpty()) {
            State current = queue.poll();
            if (current.curr == n) {
               out.println(current.dist);
                while (true) {
                    route.add(current.curr);
                    current = current.prev;
                    if (current == null) break;
                }
                while (!route.isEmpty()) out.print(route.pollLast() + " ");
                out.close();
                return;
            }
            for (int next: adjList[current.curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new State(next, current.dist + 1, current));
                }
            }
        }
        out.println("IMPOSSIBLE");
        out.close();
    }
    static class State {
        int curr, dist;
        State prev;
        public State(int a, int b, State c) {
            curr = a;
            dist = b;
            prev = c;
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st; 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        double[] nextDoubleArray(int n) {
            double[] a = new double[n];
            for (int i = 0; i < n; i++)
                a[i] = nextDouble();
            return a;
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}