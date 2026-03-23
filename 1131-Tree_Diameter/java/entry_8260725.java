
import java.io.*;
import java.util.*;

public class entry_8260725 {
    static int max = 1;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        FS sc = new FS();

        int n = sc.readInt();
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++) {
            int n1 = sc.readInt() - 1;
            int n2 = sc.readInt() - 1;
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        int[] a = furthestNode(graph, n, 0);
        int[] b = furthestNode(graph, n, a[0]);
        pw.println(b[1]);
        pw.close();
    }

    static int[] furthestNode(List<Integer>[] graph, int n, int s) {
        boolean[] visited = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ s, 0});
        visited[s] = true;
        int[] res = new int[]{ s, 0 };
        while(!q.isEmpty()) {
            int[] v = q.poll();
            res = v;
            for(Integer c : graph[v[0]]) {
                if(!visited[c]) {
                    visited[c] = true;
                    q.add(new int[]{ c, v[1] + 1 });
                }
            }
        }

        return res;
    }

    static int dfs(List<Integer>[] graph, int p, int v) {
        int curr = 1;
        for(Integer c : graph[v]) {
            if(c != p) {
                int res = dfs(graph, v, c);
                max = Math.max(max, curr + res);
                curr = Math.max(curr, 1 + res);
            }
        }
        return curr;
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