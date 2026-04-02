import java.io.*;
import java.util.*;

public class entry_12210325 {
    static int n, m;
    static List<Integer>[] adj;
    static int[] parent;
    static boolean[] visited;
    static List<Integer> cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        parent = new int[n + 1];
        visited = new boolean[n + 1];
        cycle = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (iterativeDFS(i)) {
                    printCycle();
                    return;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    static boolean iterativeDFS(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        parent[start] = -1;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node]) continue;
            visited[node] = true;

            for (int next : adj[node]) {
                if (next == parent[node]) continue;
                if (visited[next]) { // Cycle found
                    cycle.add(next);
                    int cur = node;
                    while (cur != next) {
                        cycle.add(cur);
                        cur = parent[cur];
                    }
                    cycle.add(next);
                    return true;
                } else {
                    parent[next] = node;
                    stack.push(next);
                }
            }
        }
        return false;
    }

    static void printCycle() {
        System.out.println(cycle.size());
        Collections.reverse(cycle);
        for (int city : cycle) System.out.print(city + " ");
        System.out.println();
    }
}