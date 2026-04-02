import java.io.*;
import java.util.*;

public class entry_12127481 {
    static List<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;
    static int cycleStart = -1, cycleEnd = -1;

    public static void main(String[] args) throws IOException {
        // Fast input handling
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        parent = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(parent, -1);

        // Check for cycle using iterative DFS
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && findCycle(i)) {
                printCycle(out);
                out.flush();
                return;
            }
        }

        // If no cycle is found
        out.println("IMPOSSIBLE");
        out.flush();
    }

    static boolean findCycle(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        parent[start] = -1;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node]) continue;
            visited[node] = true;

            for (int neighbor : graph[node]) {
                if (neighbor == parent[node]) continue; // Ignore edge to parent

                if (visited[neighbor]) { // Cycle detected
                    cycleStart = neighbor;
                    cycleEnd = node;
                    return true;
                }

                parent[neighbor] = node;
                stack.push(neighbor);
            }
        }
        return false;
    }

    static void printCycle(PrintWriter out) {
        List<Integer> cycle = new ArrayList<>();
        cycle.add(cycleStart);
        for (int v = cycleEnd; v != cycleStart; v = parent[v]) {
            cycle.add(v);
        }
        cycle.add(cycleStart);
        Collections.reverse(cycle);

        out.println(cycle.size());
        for (int city : cycle) {
            out.print(city + " ");
        }
        out.println();
    }
}