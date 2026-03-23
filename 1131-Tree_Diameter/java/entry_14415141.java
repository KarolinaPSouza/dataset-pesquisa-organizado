import java.io.*;
import java.util.*;
import java.util.ArrayList;



public class entry_14415141 {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // First BFS to find farthest node from 1
        int farthestNode = bfs(1, n)[0];

        // Second BFS from farthestNode to get diameter
        int diameter = bfs(farthestNode, n)[1];

        System.out.println(diameter);
    }

    // BFS returning {farthestNode, distance}
    static int[] bfs(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});
        visited[start] = true;

        int farthestNode = start, maxDist = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0], dist = curr[1];

            if (dist > maxDist) {
                maxDist = dist;
                farthestNode = node;
            }

            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(new int[]{nei, dist + 1});
                }
            }
        }
        return new int[]{farthestNode, maxDist};
    }
}
