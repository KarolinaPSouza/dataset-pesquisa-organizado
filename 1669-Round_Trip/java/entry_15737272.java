import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class entry_15737272 {

    static int firstOne = -1;
    static int lastOne = -1;
    static boolean hasFound = false;
    static int count = 0;

    private static boolean dfs(ArrayList<Integer>[] adj, int i, int parent, StringBuilder sb, boolean[] vis){
        vis[i] = true;
        for(int nb : adj[i]){
            if(nb==parent)continue;
            if(vis[nb]){
                lastOne = nb;
                firstOne = i;
                sb.append(i).append(' ');
                count++;
                return true;
            }
            boolean flag = dfs(adj,nb,i,sb,vis);
            if (flag){
                if(!hasFound) {
                    sb.append(i).append(' ');
                    count++;
                }
                hasFound = hasFound | lastOne==i;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] vis = new boolean[n+1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (!vis[i]){
                boolean flag = dfs(adj,i,-1,sb,vis);
                if (flag){
                    sb.append(firstOne);
                    System.out.println(count+1);
                    System.out.println(sb);
                    return;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}