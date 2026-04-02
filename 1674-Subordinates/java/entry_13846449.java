import java.io.*;
import java.util.*;

public class entry_13846449 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    static class Pair {
        int node, parent;
        boolean processed;

        Pair(int node, int parent, boolean processed) {
            this.node = node;
            this.parent = parent;
            this.processed = processed;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();

        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 2; i <= n; i++) {
            int u = in.nextInt();
            adj.get(u).add(i);
            adj.get(i).add(u);
        }

        int[] ans = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(1, -1, false));

        while (!stack.isEmpty()) {
            Pair curr = stack.pop();
            int node = curr.node;
            int parent = curr.parent;

            if (curr.processed) {
                for (int child : adj.get(node)) {
                    if (child == parent) continue;
                    ans[node] += 1 + ans[child];
                }
            } else {
                stack.push(new Pair(node, parent, true)); // process after children
                for (int child : adj.get(node)) {
                    if (child == parent) continue;
                    stack.push(new Pair(child, node, false));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            out.print(ans[i] + " ");
        }
        out.close();
    }
}