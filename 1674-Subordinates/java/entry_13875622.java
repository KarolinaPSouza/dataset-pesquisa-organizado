import java.io.*;
import java.util.*;

public class entry_13875622 {
    static int[] subCount;
    static ArrayList<Integer>[] graph;

    public static void dfsIterative(int start) {
        int n = graph.length - 1;
        subCount = new int[n + 1];

        // Two stacks: one for processing, one for postorder handling
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> postOrder = new Stack<>();

        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            postOrder.push(node);
            for (int child : graph[node]) {
                stack.push(child);
            }
        }

        // Postorder traversal to compute subtree sizes
        while (!postOrder.isEmpty()) {
            int node = postOrder.pop();
            int count = 0;
            for (int child : graph[node]) {
                count += 1 + subCount[child];
            }
            subCount[node] = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            graph[boss].add(i);
        }

        dfsIterative(1);

        for (int i = 1; i <= n; i++) {
            out.print(subCount[i] + " ");
        }

        out.println();
        out.flush();
    }
}