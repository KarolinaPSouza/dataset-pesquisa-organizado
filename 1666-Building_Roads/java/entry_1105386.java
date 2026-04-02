import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_1105386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s.nextToken());
            int v = Integer.parseInt(s.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);

        }

        int group = 0;
        boolean[] visited = new boolean[V+1];
        ArrayList<Integer>cities = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            if(!visited[i]){
                dfs(graph, visited, i);
                cities.add(i);
                group += 1;
            }

        }
        System.out.println(group-1);
        for (int i = 0; i < cities.size()-1; i++) {
            System.out.print(cities.get(i));
            System.out.print(" ");
            System.out.print(cities.get(i+1));
            System.out.println();
        }
    }
    private static void dfs(ArrayList<ArrayList<Integer>>graph, boolean[] visited, int node){
        if(visited[node]) return;
        visited[node] = true;
        ArrayList<Integer> neighbors = graph.get(node);
        for (int i = 0; i < neighbors.size(); i++) {
            node = neighbors.get(i);
            if(visited[node]) continue;
            dfs(graph, visited, node);
        }
    }

}