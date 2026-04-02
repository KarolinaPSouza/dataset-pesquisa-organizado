import java.util.*;
import java.io.*;

public class entry_10921268 {

    public static void main(String [] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] line = reader.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }


        for(int i=0; i<m; i++){
            line = reader.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // System.out.println(graph);

        int [] visited = new int[n+1];
        Arrays.fill(visited, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;

        boolean found = false;

        while(q.size()>0){
            int rem = q.remove();

            for(int neighbour : graph.get(rem)){
                if(visited[neighbour]==-1){
                    q.add(neighbour);
                    visited[neighbour] = rem;
                    if(neighbour==n){
                        found = true;
                        break;
                    }
                }
            }
        }

        // for(int i=0; i<=n; i++){
        //     System.out.print(visited[i]);
        // }

        // System.out.println();

        if(found){
            int curr = n;
            ArrayList<Integer> path = new ArrayList<>();
            while(curr != 1){
                path.add(curr);
                curr = visited[curr];
            }
            path.add(1);
            System.out.println(path.size());
            for(int i=path.size()-1; i>-1; i--){
                System.out.print(path.get(i) + " ");
            }
        }else{
            System.out.print("IMPOSSIBLE");
        }

        reader.close();
    }

}