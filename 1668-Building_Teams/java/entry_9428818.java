import java.util.*;
import java.io.*;
public class entry_9428818 {
    private static int[] teams;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            StringTokenizer edges = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(edges.nextToken()) - 1;
            int end = Integer.parseInt(edges.nextToken()) - 1;
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        teams = new int[n];
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(teams[i] == 0 && !isValid(graph, 1, i)){
                System.out.println("IMPOSSIBLE");
                flag = true;
                break;
            }
        }

        if(!flag){
            for(int i = 0; i < n; i++){
                int team = teams[i] == 1 ? 1 : 2;
                System.out.print(team + " ");
            }
        }
    }
    private static boolean isValid(List<List<Integer>> graph, int team, int curr){
        if(teams[curr] != 0){
            return teams[curr] == team;
        }
        teams[curr] = team;
        for(int neighbour : graph.get(curr)){
            if(!isValid(graph, -team, neighbour)){
                return false;
            }
        }
        return true;
    }

}