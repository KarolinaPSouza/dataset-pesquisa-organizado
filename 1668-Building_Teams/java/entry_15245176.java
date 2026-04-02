import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class entry_15245176 {
     // fast scanner
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream is) { br = new BufferedReader(new InputStreamReader(is)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        int[] teams = new int[n+1];
        Arrays.fill(teams, 0);
        boolean isPossible = true;
        for(int i=1;i<=n && isPossible ;i++){
            if(teams[i]!=0){
                continue;
            }
            teams[i] = 1;
            Deque<Integer>bfs = new ArrayDeque<>();
            bfs.offer(i);
            while(!bfs.isEmpty()){
                int curr = bfs.poll();
                for(int child : adj[curr]){
                    if(teams[child] == 0){
                        teams[child] = teams[curr] == 1 ? 2 : 1;
                        bfs.offer(child);
                        continue;
                    }
                    if(teams[child] == teams[curr]){
                        isPossible = false;
                        break;
                    }
                }
            }
        }

        if(!isPossible){
            System.out.println("IMPOSSIBLE");
            return;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=n;i++){
            sb.append(teams[i] + " ");
        }
        sb.append("\n");
        System.out.println(sb);


    }
}