
import java.io.*;
import java.util.*;

public class entry_8345869 {

    static long INF = (long) 1e14;
    static List<int[]>[] graph;
    static long[] dist;
    static int cycleNode = -1;
    static int parents[];

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        FS sc = new FS();

        int n = sc.readInt();
        int m = sc.readInt();

        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int s = sc.readInt() - 1;
            int d = sc.readInt() - 1;
            int w = sc.readInt();
            graph[s].add(new int[]{ d, w });
        }

        parents = new int[n];
        Arrays.fill(parents, -1);
        dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        for(int z = 0; z < n - 1; z++) {
            for(int i = 0; i < n; i++) {
                for(int[] adj : graph[i]) {
                    if(dist[i] + adj[1] < dist[adj[0]]) {
                        dist[adj[0]] = dist[i] + adj[1];
                        parents[adj[0]] = i;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int[] adj : graph[i]) {
                if(dist[i] + adj[1] < dist[adj[0]]) {
                    cycleNode = adj[0];
                    parents[adj[0]] = i;
                }
            }
        }
        if(cycleNode == -1) {
            pw.println("NO");
            pw.close();
            return;
        }

        for(int i = 0; i < n; i++) {
            cycleNode = parents[cycleNode];
        }

        List<String> path = new ArrayList<>();
        path.add(Integer.toString(cycleNode + 1));
        int temp = parents[cycleNode];
        while(temp != cycleNode) {
            path.add(Integer.toString(temp + 1));
            temp = parents[temp];
        }
        path.add(Integer.toString(cycleNode + 1));
        Collections.reverse(path);

        pw.println("YES");
        pw.println(String.join(" ", path));
        pw.close();
    }

    static class FS {
        BufferedReader br;
        StringTokenizer st;

        public FS() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        String next() {
            while(!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException ignored) {}
            }
            return st.nextToken();
        }

        int readInt() {
            return Integer.parseInt(next());
        }
    }
}