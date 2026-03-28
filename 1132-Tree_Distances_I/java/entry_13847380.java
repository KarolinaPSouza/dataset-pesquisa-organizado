import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// String Tokenizer is faster than BufferedReader and Scanner
//trimming the input is important
//Even adding one extra space at the end will slow the process


public class entry_13847380 {

 static List<List<Integer>> graph;

 public static void main(String[] args) throws NumberFormatException, IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int n = Integer.parseInt(br.readLine());

  graph = new ArrayList<>();
  for (int i = 0; i < n; i++) {
   graph.add(new ArrayList<>());
  }

  for (int i = 0; i < n - 1; i++) {
   StringTokenizer st = new StringTokenizer(br.readLine());
   int u = Integer.parseInt(st.nextToken())-1;
   int v = Integer.parseInt(st.nextToken())-1;
   graph.get(u).add(v);
   graph.get(v).add(u);
  }


  int[] distanceFrom0 = bfs(0);
  int nodeA = findFarthest(distanceFrom0);

  int[] maxDistanceA = bfs(nodeA);
  int nodeB = findFarthest(maxDistanceA); 

  int[] maxDistanceB = bfs(nodeB);

  StringBuilder output = new StringBuilder();
  for (int i= 0;i<n;i++) {
   output.append(Math.max(maxDistanceA[i], maxDistanceB[i]));
   if (i < n - 1) output.append(" ");
  }

  System.out.print(output.toString());
 }

 static int[] bfs(int start) {
  int n = graph.size();
  boolean[] visited = new boolean[n];
  Queue<Integer> queue = new LinkedList<>();
  int[] distance = new int[n];

  queue.add(start);
  visited[start] = true;

  while (!queue.isEmpty()) {
   int curr = queue.poll();
   for (int neighbor : graph.get(curr)) {
    if (!visited[neighbor]) {
     distance[neighbor] = distance[curr] + 1;
     queue.add(neighbor);
     visited[neighbor] = true;
    }
   }
  }
  return distance;
 }

    static int findFarthestNode(int start) {
        int[] distance = bfs(start);
        return findFarthest(distance);
    }

    static int findFarthest(int[] distance) {
        int maxDist = -1, node = -1;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] > maxDist) {
                maxDist = distance[i];
                node = i;
            }
        }
        return node;
    }

}