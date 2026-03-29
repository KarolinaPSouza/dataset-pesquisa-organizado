import java.io.*;
import java.util.*;

public class entry_11488303 {
    static List<List<Edge>> graph;
    static int[] parent;
    static int cycleStart = -1;

    static class Edge {
        int dest;
        long weight;

        Edge(int dest, long weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static boolean hasNegativeCycle(int start, int n) {
        long[] dist = new long[n + 1];
        int[] count = new int[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] inQueue = new boolean[n + 1];

        queue.add(start);
        inQueue[start] = true;
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            inQueue[cur] = false;

            for (Edge edge : graph.get(cur)) {
                if (dist[cur] != Long.MAX_VALUE && dist[cur] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[cur] + edge.weight;
                    parent[edge.dest] = cur;

                    if (++count[edge.dest] >= n) {
                        cycleStart = edge.dest;
                        return true;
                    }

                    if (!inQueue[edge.dest]) {
                        queue.add(edge.dest);
                        inQueue[edge.dest] = true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // Number of nodes
        int m = Integer.parseInt(st.nextToken()); // Number of edges

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        parent = new int[n + 1];

        // Read edges and construct the graph
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            graph.get(src).add(new Edge(dest, weight));
        }

        boolean foundCycle = false;
        for (int i = 1; i <= n; i++) {
            if (hasNegativeCycle(i, n)) {
                System.out.println("YES");
                int ele = cycleStart;
                Stack<Integer> stack = new Stack<>();
                Set<Integer> is_stack = new HashSet<>();

                // Push all the elements in the stack using
                // the parent array
                while (!is_stack.contains(ele)) {
                    is_stack.add(ele);
                    stack.push(ele);
                    ele = parent[ele];
                }

                // Print all the nodes in the negative
                // weight cycle
                System.out.print(ele + " ");
                while (stack.peek() != ele) {
                    System.out.print(stack.pop() + " ");
                }
                System.out.println(ele);
                return;
            }
        }

        if (!foundCycle) {
            System.out.println("NO");
        }
    }
}