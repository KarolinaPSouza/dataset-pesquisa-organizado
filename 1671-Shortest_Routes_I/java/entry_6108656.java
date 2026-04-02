import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class entry_6108656 {

 public static void main(String[] args) throws IOException {
  BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
  String[] l1 = s.readLine().split(" ");
  int n = Integer.parseInt(l1[0]), m = Integer.parseInt(l1[1]);

  ArrayList<ArrayList<Node>> adjList = new ArrayList<ArrayList<Node>>();
  for (int i = 0; i < n; i++) adjList.add(new ArrayList<Node>());
  for (int i = 0; i < m; i++) {
   String[] l2 = s.readLine().split(" ");
   int a = Integer.parseInt(l2[0]) - 1, b = Integer.parseInt(l2[1]) - 1, cost = Integer.parseInt(l2[2]);
   adjList.get(a).add(new Node(b, cost));
  }

  boolean[] visited = new boolean[n];
  long[] distance = new long[n];
  Arrays.fill(distance, Long.MAX_VALUE);
  distance[0] = 0;

  PriorityQueue<Node> pq = new PriorityQueue<Node>();
  pq.add(new Node(0, 0));

  while (!pq.isEmpty()) {
   int currID = pq.poll().id;
   if (visited[currID]) continue;
   visited[currID] = true;
   for (Node adj : adjList.get(currID)) {
    if (distance[adj.id] > distance[currID] + adj.cost) {
     distance[adj.id] = distance[currID] + adj.cost;
     pq.add(new Node(adj.id, distance[adj.id]));
    }
   }
  }

  PrintWriter pw = new PrintWriter(System.out);
  for (long dist : distance) pw.print(dist + " ");
  pw.println();
  pw.flush();
 }
}

class Node implements Comparable<Node> {
 int id;
 long cost;

 Node(int id, long cost) {
  this.id = id;
  this.cost = cost;
 }

 @Override
 public int compareTo(Node o) {
  return Long.compare(this.cost, o.cost);
 }
}