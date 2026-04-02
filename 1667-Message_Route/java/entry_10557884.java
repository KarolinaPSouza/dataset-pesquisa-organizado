import java.util.*;
import java.io.*;

public class entry_10557884 {
    static int n, m;
    static boolean[] visited;
    static int[] distance;
    static int[] root;
    static int dis = 1;
    static ArrayList<Integer>[] adj;

    //method
    static boolean isValid(int node){
        return !(visited[node]);
    }

    static void bfs(int node){
        Queue<Integer> bfsMethod = new ArrayDeque<>();
        bfsMethod.offer(node);
        visited[node] = true;
        distance[node] = 0;
        root[node] = -1;

        while(!bfsMethod.isEmpty()){
            int cur = bfsMethod.peek();
            bfsMethod.poll();

            for(int neighbor : adj[cur]){
                if(isValid(neighbor)){
                    visited[neighbor] = true;
                    distance[neighbor] = distance[cur] + dis;
                    root[neighbor] = cur;
                    bfsMethod.offer(neighbor);
                }

                if(neighbor == n){
                    printPath(neighbor);
                    return;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static void printPath(int node){
        ArrayList<Integer> path = new ArrayList<>();
        for(int cur = node; cur != -1; cur = root[cur]){
            path.add(cur);
        }
        Collections.reverse(path);
        System.out.println(path.size());
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1];
        visited = new boolean[n+1];
        distance = new int[n+1];
        root = new int[n+1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            adj[n1].add(n2);
            adj[n2].add(n1);
        }

        bfs(1);

    }
}