import java.util.*;
import java.io.*;

public class entry_2433859 {
    private static int numOfNodes;
    private static List<List<int[]>> adjacencyList;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numOfNodes = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList<>();

        for(int i=0; i<numOfNodes; i++){
            adjacencyList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken())-1;
            int node2 = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());
            int[] arr = {node2, weight};
            adjacencyList.get(node1).add(arr);
        }

        long[] distance = solve(0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<distance.length; i++){
            bw.write(String.valueOf(distance[i]));
            bw.write(" ");
        }

        bw.flush();
    }

    private static long[] solve(int sourceNode){
        long[] distance = new long[numOfNodes];
        boolean[] visited = new boolean[numOfNodes];
        int count = 0;

        for(int i=0; i<numOfNodes; i++){
            distance[i] = Long.MAX_VALUE;
        }

        distance[sourceNode] = 0;
        Node source = new Node(sourceNode, 0);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(source);

        while(count!=numOfNodes && !queue.isEmpty()){
            int currNode = queue.poll().value;

            if(!visited[currNode]){
                visited[currNode] = true;
                count++;

                for(int[] arr : adjacencyList.get(currNode)){
                    int neighborNode = arr[0];
                    int weight = arr[1];
                    if(!visited[neighborNode] && distance[neighborNode]>distance[currNode]+weight){
                        distance[neighborNode] = distance[currNode] + weight;
                        queue.add(new Node(neighborNode, distance[neighborNode]));
                    }
                }

            }

        }

        return distance;
    }

}

class Node implements Comparable<Node>{
    int value;
    long distance;

    public Node(int value, long distance){
        this.value = value;
        this.distance = distance;
    }

    public int compareTo(Node node){
        if(this.distance<node.distance)
            return -1;
        if(this.distance>node.distance)
            return 1;
        return 0;
    }

}