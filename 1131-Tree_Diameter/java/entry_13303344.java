import java.io.*;
import java.util.*;

public class entry_13303344 {
    static int[] dist;
    static ArrayList<Integer>[] adj;

    static void iterativeDFS(int start) {
        Arrays.fill(dist, -1);
        dist[start] = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int next : adj[curr]) {
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    stack.push(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Fast input and output
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        dist = new int[n];
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }

        // First DFS from node 0 to find farthest node
        iterativeDFS(0);
        int start = -1, maxDist = -1;
        for (int i = 0; i < n; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                start = i;
            }
        }

        // Second DFS from farthest node found
        iterativeDFS(start);

        maxDist = -1;
        for (int i = 0; i < n; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }

        out.println(maxDist);
        out.flush();
    }
}