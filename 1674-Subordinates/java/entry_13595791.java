import java.io.*;
import java.util.*;

public class entry_13595791 {

    public static void main(String[] args) throws IOException {
        // Fast input and output
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> tree = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        int[] subSize = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            tree.get(boss).add(i);
        }

        // ✅ Iterative DFS using stack
        iterativeDFS(1, tree, subSize);

        // ✅ Use StringBuilder for fast output
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subSize[i] - 1).append(" ");
        }

        out.write(sb.toString().trim());
        out.newLine();
        out.flush();
    }

    // ✅ Iterative DFS with explicit stack
    static void iterativeDFS(int root, List<List<Integer>> tree, int[] subSize) {
        int n = subSize.length;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> postOrder = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            postOrder.push(node);
            for (int child : tree.get(node)) {
                stack.push(child);
            }
        }

        while (!postOrder.isEmpty()) {
            int node = postOrder.pop();
            subSize[node] = 1; // itself
            for (int child : tree.get(node)) {
                subSize[node] += subSize[child];
            }
        }
    }
}

