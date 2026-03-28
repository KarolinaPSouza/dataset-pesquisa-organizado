import java.io.*;
import java.util.*;

public class entry_14866022 {

    static int N = 200005;
    static int[][] graph = new int[N][];
    static int[] head = new int[N];
    static int[] next = new int[2 * N];
    static int[] to = new int[2 * N];
    static int[] distA = new int[N];
    static int[] distB = new int[N];
    static boolean[] visited = new boolean[N];
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Arrays.fill(head, 0, n + 2, -1); // Inicializa com -1

        for (int i = 0; i < n - 1; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            addEdge(u, v);
            addEdge(v, u);
        }

        int A = bfs(1, distA, n);  // encontra o nó mais distante de 1 (nó A)
        int B = bfs(A, distA, n);  // BFS de A, salva em distA
        bfs(B, distB, n);          // BFS de B, salva em distB

        // Resultado final: distância máxima de cada nó até qualquer outro
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(distA[i], distB[i])).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static void addEdge(int u, int v) {
        to[idx] = v;
        next[idx] = head[u];
        head[u] = idx++;
    }

    static int bfs(int start, int[] dist, int n) {
        Arrays.fill(visited, 1, n + 1, false);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        dist[start] = 0;

        int farthest = start;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i = head[u]; i != -1; i = next[i]) {
                int v = to[i];
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    q.add(v);
                    if (dist[v] > dist[farthest]) {
                        farthest = v;
                    }
                }
            }
        }

        return farthest;
    }
}