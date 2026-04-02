import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class entry_15756870 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] vis;
    static int[] parent;
    static int cycleS=-1, cycleE=-1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        vis = new boolean[n+1];
        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                if(dfs(i)){
                    parentCycle();
                    return;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
    private static boolean dfs(int node){
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        parent[node] = -1;
        while(!stack.isEmpty()){
            int cur = stack.pop();
            if(vis[cur]) continue;
            vis[cur] = true;
            for(int i:adj.get(cur)){
                if(i==parent[cur]) continue;
                if(vis[i]){
                    cycleS = i;
                    cycleE = cur;
                    return true;
                }
                parent[i] = cur;
                stack.push(i);
        }
        }
        return false;
    }
    private static void parentCycle(){
        ArrayList<Integer> cycle = new ArrayList<>();
        cycle.add(cycleS);

        for (int v = cycleE; v != cycleS; v = parent[v]) {
            cycle.add(v);
        }
        cycle.add(cycleS);
        Collections.reverse(cycle);

        System.out.println(cycle.size());
        for (int x : cycle) System.out.print(x + " ");
    }
}