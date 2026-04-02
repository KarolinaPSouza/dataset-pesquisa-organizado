import java.util.*;
import java.io.*;

public class entry_8478506 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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

    private static FastReader sc = new FastReader();
    static final PrintWriter PW = new PrintWriter(new OutputStreamWriter(System.out));

    // static class Pair<T, U> {
    // T first;
    // U second;

    // public Pair(T a, U b) {
    // this.first = a;
    // this.second = b;
    // }
    // }

    public static void findDestination(ArrayList<ArrayList<Integer>> graph, int n, StringBuilder sb) {
        // for all node check whther they are connected
        int color[] = new int[n + 1];
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (color[i] == 0) {

                Queue<Integer> bfs = new LinkedList<>();
                bfs.add(i);
                color[i] = 1;
                while (bfs.isEmpty() == false) {
                    int curr = bfs.poll();

                    for (int v : graph.get(curr)) {
                        if (color[v] == 0) {
                            bfs.add(v);
                            color[v] = color[curr] == 1 ? 2 : 1;
                        } else if (color[curr] == color[v]) {
                            flag = true;
                            break;
                        }
                    }
                }

            }
        }

        if (flag == true) {
            sb.append("IMPOSSIBLE\n");
        } else {

            for (Integer val : color) {
                if (val == 0)
                    continue;
                sb.append(val + " ");
            }

        }

    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());

        }

        while (m-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // System.out.println(graph);
        findDestination(graph, n, sb);

        PW.print(sb.toString());
        PW.close();
    }
}