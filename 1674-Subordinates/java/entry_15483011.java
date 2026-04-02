import java.io.*;
import java.util.*;
// Simple post-order subtree size algorithm
public class entry_15483011 {
    static List<Integer>[] tree;
    static int[] subtree;

    static void dfs(int root) {

        // stack entries: (node, parent, state)
        // state = 0 → first time visiting (pre-order)
        // state = 1 → all children processed (post-order)
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{root, -1, 0});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int node = cur[0];
            int parent = cur[1];
            int state = cur[2];

            if (state == 0) {
                // Pre-order: push post-order marker first
                stack.push(new int[]{node, parent, 1});

                // Push children (pre-order)
                for (int nxt : tree[node]) {
                    if (nxt == parent) continue;
                    stack.push(new int[]{nxt, node, 0});
                }
            }
            else {
                // Post-order: compute subtree size
                int size = 1;
                for (int nxt : tree[node]) {
                    if (nxt == parent) continue;
                    size += subtree[nxt];
                }
                subtree[node] = size;
            }
        }
    }

    @SuppressWarnings("unchecked")
 public static void main(String[] args) throws IOException {
  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
  int n = Integer.parseInt(r.readLine());
        tree = new ArrayList[n];
        subtree = new int[n];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int boss = Integer.parseInt(st.nextToken()) - 1;
            tree[i].add(boss);
            tree[boss].add(i);
        }

        dfs(0);

        StringBuilder out = new StringBuilder();
        for (int s : subtree) out.append(s - 1).append(" ");
        System.out.println(out);
 }
}