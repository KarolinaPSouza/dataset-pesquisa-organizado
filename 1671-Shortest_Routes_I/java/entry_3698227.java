import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class entry_3698227 {

 static ArrayList<ArrayList<Pair>> arr;
 static long[] dists;
 static boolean[] visited;

 public static void main(String[] args) throws IOException {
  int numNodes, numEdges;
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());
  numNodes = Integer.parseInt(st.nextToken());
  numEdges = Integer.parseInt(st.nextToken());
  arr = new ArrayList<ArrayList<Pair>>(numNodes + 1);
  dists = new long[numNodes + 1];
  visited = new boolean[numNodes + 1];

  for(int i = 1; i <= numNodes; i++) {
   dists[i] = Long.MAX_VALUE;
   arr.add(new ArrayList<>());
  }

  arr.add(new ArrayList<>());

  for (int i = 0; i < numEdges; i++) {
   int u, v, w; //from u to v w/ weight w
   st = new StringTokenizer(br.readLine());
   u = Integer.parseInt(st.nextToken());
   v = Integer.parseInt(st.nextToken());
   w = Integer.parseInt(st.nextToken());
   arr.get(u).add(new Pair(w, v));
//   arr.get(v).add(new Pair(w, u)); //if 2-directional uncomment :D
  }
  dijkstra();

  StringBuilder sb = new StringBuilder();
  sb.append("0 ");
  for(int i = 2; i < dists.length; i++) {
   sb.append(dists[i] + " ");
  }
  System.out.println(sb.toString());
 }

 public static void dijkstra() {
  PriorityQueue<Pair> pq = new PriorityQueue<>();
  pq.add(new Pair(0, 1));

  while(!pq.isEmpty()) {
   //pop it & get the node + weight
   Pair temp = pq.poll();
   long dist = temp.a;
   int node = temp.b;

   //only go on to the rest if it's the first time node is visited
   if(visited[node]) {
    continue;
   }

   visited[node] = true;

   //loop through all connected ones to node
   for(Pair p : arr.get(node)) {
    long newNodeDist = p.a + dist;
    int newNode = p.b;
    if(newNodeDist < dists[newNode]) {
     dists[newNode] = newNodeDist;
     pq.add(new Pair(newNodeDist, newNode)); //new pair bc old one = edge(not between first & this)
    }
   }
  }

 }

}

class Pair implements Comparable<Pair> {
 public long a; //dist
 public int b; //node
 public Pair(long a, int b) {
  this.a = a;
  this.b = b;
 }
// 
// 
// 
// public long getA() {
//  return a;
// }
// 
// 
// 
// public int getB() {
//  return b;
// }
// 
// 
// 
// public void setA(int a) {
//  this.a = a;
// }
// 
// 
// 
// public void setB(int b) {
//  this.b = b;
// }


 @Override
 public int compareTo(Pair o) {
  if(o.a > a) return -1;
  if(o.a == a) return 0;
  return 1;
  //return (int)(a - o.getA());
 }

}