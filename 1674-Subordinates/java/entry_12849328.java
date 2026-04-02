import java.io.*;
import java.util.*;

public class entry_12849328 {

    static class Node {
        int u, state;
        Node(int u, int state) {
            this.u = u;
            this.state = state;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            graph[parent].add(i);
        }

        int[] ans = new int[n + 1];
        int[] count = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(new Node(1, 0));

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.state == 0) {
                visited[node.u] = true;
                stack.push(new Node(node.u, 1));
                for (int v : graph[node.u]) {
                    if (!visited[v]) {
                        stack.push(new Node(v, 0));
                    }
                }
            } else {
                int sum = 0;
                for (int v : graph[node.u]) {
                    sum += count[v];
                }
                count[node.u] = sum + graph[node.u].size();
                ans[node.u] = count[node.u];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}