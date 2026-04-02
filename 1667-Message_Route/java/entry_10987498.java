import java.util.*;
import java.io.*;

class Graph {
    private ArrayList<ArrayList<Integer>>Adjl;
    private int V;

    Graph(int x){
       this.V=x;
       this.Adjl = new ArrayList<>(V+1);

       for(int i=0;i<V+1;i++){
        Adjl.add(new ArrayList<>());
       }

    }

    public void addEdge(int u,int v){
        Adjl.get(u).add(v);
        Adjl.get(v).add(u);

       }

    public void shortestroute(int source,int destination){
        boolean []Visited=new boolean[V+1];
        int []parent = new int[V+1];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        Visited[source]=true;

        boolean found=false;

        while (!q.isEmpty() && !found) {
            int currentVertex = q.poll();
            for(int neighbor: Adjl.get(currentVertex)){
                if(!Visited[neighbor]){
                    Visited[neighbor]=true;
                    parent[neighbor]=currentVertex;
                    q.add(neighbor);


                    }

                    if(neighbor==destination){
                        found=true;
                        break;
                    }


                }
            }

            if(!Visited[destination]){
                System.out.println("IMPOSSIBLE");
            }
            else{
               List<Integer> path = new ArrayList<>();

                for(int i = destination;i!=-1;i=parent[i]){
                    path.add(i);

                }
                Collections.reverse(path);
                System.out.println(path.size());
                for(int j=0;j<path.size();j++){
                    System.out.print(path.get(j)+" ");
                }



            }



        }


    }



public class entry_10987498 {

    public static void main(String[]args)throws IOException{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Graph g = new Graph(n);
        for(int i=0;i<m;i++){
            st = new StringTokenizer(input.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

             g.addEdge(u, v);

        }
        g.shortestroute(1, n);

        input.close();
    }
}