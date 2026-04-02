import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class entry_8423288 {
    static class Edge{
        int to;
        int duration;

        public Edge(int to, int duration) {
            this.to = to;
            this.duration = duration;
        }
    }
    static class Node implements Comparable<Node>{
        int node;
        long distanceSoFar;
        public Node(int node, long distance) {
            this.node = node;
            this.distanceSoFar = distance;
        }
        @Override
        public int compareTo(Node other) {
            return Long.compare(this.distanceSoFar, other.distanceSoFar);
        }
    }
    public static void main(String[]args)throws Exception{
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstLine = new StringTokenizer(scanner.readLine());
        int numOfCities = Integer.parseInt(firstLine.nextToken());
        int numOfFlights = Integer.parseInt(firstLine.nextToken());
        List<Edge>[]flightPaths= new ArrayList[numOfCities];
        for(int k = 0; k < flightPaths.length; k++){
            flightPaths[k] = new ArrayList<>();
        }
        for(int k = 0; k < numOfFlights; k++){
            StringTokenizer Line = new StringTokenizer(scanner.readLine());
            int from = Integer.parseInt(Line.nextToken())-1;
            int to = Integer.parseInt(Line.nextToken())-1;
            int duration = Integer.parseInt(Line.nextToken());
            flightPaths[from].add(new Edge(to, duration));
        }
        scanner.close();

        long[]distanceSoFar = new long[numOfCities];
        Arrays.fill(distanceSoFar, Long.MAX_VALUE);
        distanceSoFar[0] = (long)0;

        boolean[]processed = new boolean[numOfCities];//auto filled with false

        PriorityQueue<Node> djikstra = new PriorityQueue<>();
        djikstra.add(new Node(0, 0));

        while(!djikstra.isEmpty()){
            Node node = djikstra.poll();
            int parentNode = node.node;
            if(processed[parentNode]){
                continue;
            }
            processed[parentNode] = true;

            for(Edge childEdge : flightPaths[parentNode]){
                int childNode = childEdge.to;
                if(processed[childNode]){
                    continue;
                }
                long nextDist = distanceSoFar[parentNode] + childEdge.duration;
                if(distanceSoFar[childNode] > nextDist){
                    distanceSoFar[childNode] = nextDist;
                    djikstra.offer(new Node(childNode, nextDist));
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < numOfCities - 1; k++) {
            result.append(distanceSoFar[k]).append(" ");
        }
        result.append(distanceSoFar[numOfCities - 1]);
        System.out.println(result);
    }

}