import java.io.*;
import java.util.*;

public class entry_12004327 {
    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static int N, edgeCount;
    static int[] head, to, next, ans;

    public static void main(String[] args) throws IOException {
        N = in.nextInt();
        head = new int[N + 1];
        Arrays.fill(head, -1);
        to = new int[2 * N];  // At most, we have 2*N to ensure sufficient space
        next = new int[2 * N];
        ans = new int[N + 1];
        edgeCount = 0;

        for (int i = 2; i <= N; i++) {
            int parent = in.nextInt();
            addEdge(parent, i);
        }

        dfs(1);

        for (int i = 1; i <= N; i++) {
            out.print(ans[i] + " ");
        }
        out.flush();
    }

    static void addEdge(int u, int v) {
        to[edgeCount] = v;
        next[edgeCount] = head[u];
        head[u] = edgeCount++;
    }

    static int dfs(int node) {
        int subordinates = 0;
        for (int i = head[node]; i != -1; i = next[i]) {
            int child = to[i];
            subordinates += 1 + dfs(child);
        }
        ans[node] = subordinates;
        return subordinates;
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream), 32768);
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}