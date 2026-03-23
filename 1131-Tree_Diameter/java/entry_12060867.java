import java.io.*;
import java.util.*;

public class entry_12060867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int farthestNode = bfs(1, adj)[0];
        int diameter = bfs(farthestNode, adj)[1];

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(diameter));
        bw.newLine();
        bw.flush();
    }

    private static int[] bfs(int start, List<List<Integer>> adj) {
        int n = adj.size();
        int[] distances = new int[n];
        Arrays.fill(distances, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distances[start] = 0;

        int farthestNode = start;
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[node] + 1;
                    queue.add(neighbor);

                    if (distances[neighbor] > maxDistance) {
                        maxDistance = distances[neighbor];
                        farthestNode = neighbor;
                    }
                }
            }
        }

        return new int[]{farthestNode, maxDistance};
    }
}