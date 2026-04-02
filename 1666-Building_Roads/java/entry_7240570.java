import java.util.*;
import java.io.*;

public class entry_7240570 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);

        st = new StringTokenizer(br.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int roads = Integer.parseInt(st.nextToken());

        ArrayList<Node> graph = new ArrayList<>();
        for(int i = 0; i <= nodes;i++){
            graph.add(new Node(i));
        }

        for(int i = 0; i < roads;i++){
            st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());

            graph.get(city1).adj.add(graph.get(city2));
            graph.get(city2).adj.add(graph.get(city1));
        }



        ArrayDeque<Node> stack = new ArrayDeque<>();
        ArrayList<String> newRoads = new ArrayList<>();
        int startCity = -1;
        for(int i = 1; i < graph.size(); i++){
            if(!graph.get(i).visited){
                stack.add(graph.get(i));
                while(!stack.isEmpty()){
                    Node current = stack.pop();
                    current.visited = true;
                    for(Node child: current.adj){
                        if(!child.visited)
                            stack.addFirst(child);
                    }
                }

                if(startCity != -1)
                    newRoads.add(startCity+" "+i);

                startCity = i;
            }


        }

        /*for(Node n: graph)
            pw.print(n.visited+" ");
        pw.println();*/

        pw.println(newRoads.size());
        for(String l : newRoads){
            pw.println(l);
        }




        pw.close();
    }

    public static class Node{
        int id;
        boolean visited = false;
        ArrayList<Node> adj = new ArrayList<>();

        public Node(int idd){
            id = idd;
        }
    }
}