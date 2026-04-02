import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class entry_10216506 {
    public static void main(String[] args) {
        FastReader in = new FastReader();

        int n = in.nextInt();
        int m = in.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }


        int[] groups = new int[n+1];

        boolean[] visited = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                if(bfs(adj, visited, groups, i)) {
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(groups[i]).append(" ");
        }
        System.out.println(sb.toString());

    }

    public static boolean bfs(List<List<Integer>> adj, boolean[] visited, int[] groups, int curr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        visited[curr] = true;
        groups[curr] = 1;

        while(!q.isEmpty()) {
            curr = q.poll();
            for(int node : adj.get(curr)) {
                if(!visited[node]) {
                    groups[node] = groups[curr] == 1 ? 2 : 1;
                    q.add(node);
                    visited[node] = true;
                }
                else if(visited[node] && groups[node] == groups[curr]) {
                    return true;
                }
            }
        }
        return false;
    }

}



class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            if (st.hasMoreTokens()) {
                str = st.nextToken("\n");
            } else {
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}