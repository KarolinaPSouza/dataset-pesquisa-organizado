import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_2954178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> adjacencyList[] = new ArrayList[N+1];
        int [] parent = new int[N+1];
        boolean[] visited = new boolean[N+1];

        for(int i = 0 ; i < adjacencyList.length; i++){
            adjacencyList[i] = new ArrayList<>();
        }

        for(int i = 0 ; i <= N; i++){
            parent[i] = -1;
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) ;
            int v = Integer.parseInt(st.nextToken()) ;
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        Queue<Integer> q = new LinkedList();
        q.add(1);

        while(!q.isEmpty()){
            Integer node = q.poll();
            visited[node] = true;
            for(int neighbour : adjacencyList[node]){
                if(visited[neighbour]) continue;
                q.add(neighbour);
                parent[neighbour] = node;
                visited[neighbour] = true;
            }
        }

        if(parent[N] == -1){
            System.out.println("IMPOSSIBLE");
        }

        int candidate = N;
        Stack<Integer> stack = new Stack();
        while(candidate != -1){
            stack.push(candidate);
            candidate = parent[candidate];
        }

        System.out.println(stack.size());

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
    }
}