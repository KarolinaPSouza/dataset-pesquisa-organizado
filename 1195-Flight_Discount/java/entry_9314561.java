import java.io.*;
import java.util.*;

public class entry_9314561 {
 static class Flight {
  int to;
  long cost;
  Flight(int v, long wt) {
   this.to = v;
   this.cost = wt;
  }
 }

 // The class we'll use to represent the Dijkstra state
 static class Pos implements Comparable<Pos> {
  int pos;
  long cost;
  Pos(int val, long wsf) {
   this.pos = val;
   this.cost = wsf;
  }

  @Override
  public int compareTo(Pos o) {
   return (int)(this.cost - o.cost);
  }
 }

 // Making these variables local results in TLE on the last test case
 static List<List<Flight>> neighbors = new ArrayList<>();
 static List<List<Flight>> reverseNeighbors = new ArrayList<>();

 public static void main(String[] args) throws IOException {
  BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer initial = new StringTokenizer(br.readLine());
  int cityNum = Integer.parseInt(initial.nextToken());
  int flightNum = Integer.parseInt(initial.nextToken());
  for (int c = 0; c < cityNum; c++) {
   neighbors.add(new ArrayList<>());
   reverseNeighbors.add(new ArrayList<>());
  }

  for (int f = 0; f < flightNum; f++) {
   StringTokenizer flight = new StringTokenizer(br.readLine());
   int from = Integer.parseInt(flight.nextToken()) - 1;
   int to = Integer.parseInt(flight.nextToken()) - 1;
   int cost = Integer.parseInt(flight.nextToken());
   neighbors.get(from).add(new Flight(to, cost));
   reverseNeighbors.get(to).add(new Flight(from, cost));
  }

  long[] dis1 = minDist(0, neighbors);
  long[] dis2 = minDist(cityNum - 1, reverseNeighbors);
  long minCost = Long.MAX_VALUE;
  for (int c = 0; c < cityNum; c++) {
   // Go through all flights and see what the min cost is
   for (Flight e : neighbors.get(c)) {
    minCost = Math.min(minCost, dis1[c] + dis2[e.to] + e.cost / 2);
   }
  }
  System.out.println(minCost);
 }

 public static long[] minDist(int start,
    List<List<Flight>> neighbors) {
  long[] minDist = new long[neighbors.size()];
  boolean[] visited = new boolean[neighbors.size()];
  PriorityQueue<Pos> frontier = new PriorityQueue<>();
  frontier.add(new Pos(start, 0));
  while (!frontier.isEmpty()) {
   Pos curr = frontier.remove();
   if (visited[curr.pos]) { continue; }
   visited[curr.pos] = true;
   minDist[curr.pos] = curr.cost;
   for (Flight e : neighbors.get(curr.pos)) {
    frontier.add(new Pos(e.to, curr.cost + e.cost));
   }
  }
  return minDist;
 }
}