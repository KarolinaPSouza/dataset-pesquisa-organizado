import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class entry_12543761 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int m = fr.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 1; i < n+1; i++) {
            visited[i] = false;
            adj[i] = new ArrayList<>();
        }
        // Setting up adjacency list
        for (int i = 0; i < m; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[n+1];
        queue.offer(1);
        visited[1] = true;
        while(!queue.isEmpty()) {
            Integer curr = queue.poll();
            if(curr == n) break;
            for(Integer i: adj[curr]) {
                if(!visited[i]) {
                    queue.offer(i);
                    parent[i] = curr;
                    visited[i] = true;
                }
            }
        }

        if(!visited[n]) {
            System.out.println("IMPOSSIBLE");
        } else {
            List<Integer> path = new ArrayList<>();
            int p = n;
            while(p != 1) {
                path.add(p);
                p = parent[p];
            }
            path.add(1);
            System.out.println(path.size());
            for (int i = path.size() -1 ; i >-1; i--) {
                System.out.print(path.get(i));
                if (i != 0) {
                    System.out.print(" ");
                }
            }
        }
    }
}