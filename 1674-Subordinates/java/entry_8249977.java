
import java.io.*;
import java.util.*;

public class entry_8249977 {

    public static void main(String[] args) {
        FS sc = new FS();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.readInt();
        List<Integer>[]  graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indeg = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            int boss = sc.readInt();
            graph[i].add(boss);
            indeg[boss]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }
        int[] res = new int[n];
        while(!q.isEmpty()) {
            int e = q.poll();
            for(Integer adj : graph[e]) {
                res[adj - 1] += 1 + res[e - 1];
                indeg[adj]--;
                if(indeg[adj] == 0) {
                    q.add(adj);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            pw.print(res[i] + " ");
        }
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