import java.io.*;
import java.util.*;

public class entry_13131276 {
    static List<Integer>[] graph;
    static int[] ans;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        // Fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build tree
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            graph[parent].add(i);
        }

        // Iterative DFS
        int[] subtreeSize = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> postOrder = new Stack<>();

        stack.push(1);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            postOrder.push(node);
            for (int child : graph[node]) {
                if (!visited[child]) {
                    stack.push(child);
                }
            }
        }

        while (!postOrder.isEmpty()) {
            int node = postOrder.pop();
            for (int child : graph[node]) {
                subtreeSize[node] += subtreeSize[child] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subtreeSize[i]).append(" ");
        }

        System.out.println(sb);
    }
}