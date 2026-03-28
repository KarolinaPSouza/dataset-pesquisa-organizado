import java.io.*;
import java.util.*;

public class entry_14215857 {
    static int n;
    static int[] head, to, next;
    static int edgeIdx;

    static void addEdge(int u, int v) {
        to[edgeIdx] = v;
        next[edgeIdx] = head[u];
        head[u] = edgeIdx++;
    }

    // BFS returning distances array (0-entry_14215857 ignored; nodes 1..n)
    static int[] bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        int[] q = new int[n];
        int qh = 0, qt = 0;
        q[qt++] = start;
        dist[start] = 0;
        while (qh < qt) {
            int v = q[qh++];
            for (int e = head[v]; e != -1; e = next[e]) {
                int u = to[e];
                if (dist[u] == -1) {
                    dist[u] = dist[v] + 1;
                    q[qt++] = u;
                }
            }
        }
        return dist;
    }

    static int farthestNode(int[] dist) {
        int node = 1, best = -1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > best) {
                best = dist[i];
                node = i;
            }
        }
        return node;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(read.readLine());
        n = Integer.parseInt(st.nextToken());
        if (n == Integer.MIN_VALUE) return;
        // edge storage: 2*(n-1)
        int m = (n - 1) * 2;
        head = new int[n + 1];
        Arrays.fill(head, -1);
        to = new int[m];
        next = new int[m];
        edgeIdx = 0;

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(read.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            addEdge(a, b);
            addEdge(b, a);
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int[] d1 = bfs(1);
        int A = farthestNode(d1);

        int[] distA = bfs(A);
        int B = farthestNode(distA);

        int[] distB = bfs(B);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(distA[i], distB[i]));
            if (i < n) sb.append(' ');
        }
        sb.append('\n');
        System.out.print(sb.toString());
    }
}