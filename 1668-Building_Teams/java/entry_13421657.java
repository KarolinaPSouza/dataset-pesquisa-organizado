import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class entry_13421657 {
    static boolean works = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(s.nextToken());
        int m = Integer.parseInt(s.nextToken());
        int[] team = new int[n+1];
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n+1];

        for (int i = 0; i <= n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++){
            s = new StringTokenizer(br.readLine());
            int a  = Integer.parseInt(s.nextToken());
            int b = Integer.parseInt(s.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++){
            if (team[i] == 0){
                dfs(i, graph, team);
            }
        }
        if (works){
            for (int i = 1; i <=n; i++){
                System.out.print(team[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static void dfs(int node, ArrayList<Integer>[] graph, int[] team){
        if (team[node] == 0){
            team[node] = 1;
        }
        for (int  neighbor: graph[node]){
            if ((team[neighbor] == 0)){
                team[neighbor] = 3 - team[node];
                dfs(neighbor, graph, team);
            } else if (team[node] == team[neighbor]){
                works = false;
            }
        }
    }
}