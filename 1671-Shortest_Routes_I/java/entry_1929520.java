/* 
Shortest Routes I
 Time limit: 1.00 s Memory limit: 512 MB
 There are n cities and m flight connections between them. Your task is to determine the length of the shortest route from Syrjälä to every city.
 Input
 The first input line has two integers n and m: the number of cities and flight connections. The cities are numbered 1,2,…,n, and city 1 is Syrjälä.
 After that, there are m lines describing the flight connections. Each line has three integers a, b and c: a flight begins at city a, ends at city b, and its length is c. Each flight is a one-way flight.
 You can assume that it is possible to travel from Syrjälä to all other cities.
 Output
 Print n integers: the shortest route lengths from Syrjälä to cities 1,2,…,n.
 Constraints
----------
 1 ≤ n ≤ 10^5
1≤ m ≤ 2⋅10^5
1≤ a,b ≤ n
1 ≤ c ≤ 10^9
 NOTE:
----
(contains parallel edge : (1 to 3)) more than one flight connections possible from city a to city b.
 Example
Input: 
3 4
1 2 6
1 3 2
3 2 3
1 3 4
 Output:
0 5 2
 */
//accepted
import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_1929520 {
}

class Solution {

 private List<int[]>[] adj;
 private long[] distanceOf;
 private boolean[] processed;

 Solution(int N, int[][] edgeList) {

  adj = new ArrayList[N + 1];
  distanceOf = new long[N + 1]; 
  processed = new boolean[N + 1];

  for(int i = 1; i <= N; i += 1) { 
   adj[i] = new ArrayList<>();
   distanceOf[i] = Long.MAX_VALUE;
  }

  for(int[] edge : edgeList) {
   adj[edge[0]].add(new int[]{edge[1], edge[2]});
  }
 }

 public void shortestPathFromSource(int source, int N) {

  //Dijkstra's Algorithm

  //cause TLE : ruinging my life just about because of it : 7-8 hours on exploring
  //for large values of (x[0] & y[1]) -> cause integer overflow : use if else and return +1, -1 or 0
  //based on requirement
  //PriorityQueue<long[]> queue = new PriorityQueue<>((x, y) -> (int)(x[0] - y[1]));

  //PriorityQueue<long[]> queue = new PriorityQueue<>((x, y) -> x[0] == y[0] ? Long.compare(x[1], y[1]) : Long.compare(x[0], y[0]));

  PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> {
   if(a[0] <= b[0]) return -1; //ok
   //if(a[0] < b[0]) return -1; //ok
   return 1;
  });

  distanceOf[source] = 0;

  queue.offer(new long[]{distanceOf[source], source});

  while(!queue.isEmpty()) {

   long[] popped_node = queue.poll();


   //if(processed[(int)popped_node[1]]) continue;

   //processed[(int)popped_node[1]] = true;

   /*
    If distance of already processed node(same as popped_node[1]) 
    in distancey array is already smaller than distance
    of current popped vertex.
        then we're sure that the same vertex with larger distance never
    minimize the shortest distance of its adjacent nodes from given source
    node.
        skip it.
   */

   //Without it TLE on 16 & 18 Test case
   if(distanceOf[(int)popped_node[1]] < popped_node[0]) continue;
   //if use this no need of extra space for boolean array.

   for(int[] adjacent : adj[(int)popped_node[1]]) {
    if(distanceOf[adjacent[0]] > distanceOf[(int)popped_node[1]] + adjacent[1]) {
     distanceOf[adjacent[0]] = distanceOf[(int)popped_node[1]] + adjacent[1];
     queue.offer(new long[]{distanceOf[adjacent[0]], adjacent[0]});
    }
   }
  }

  StringBuilder sb = new StringBuilder();

  for(int i = 1; i <= N; i += 1) {
   sb.append(distanceOf[i] + " ");
  }

  //work well
  // PrintWriter pw = new PrintWriter(System.out);

  // for(int i = 1; i <= N; i += 1) {
   // pw.print(distanceOf[i] + " ");
  // }

  // pw.println();
  // pw.close();

  System.out.println(sb);

 }

}

class DijkstraOptimized {

    private static BufferedReader br = null;
 private static StringTokenizer st = null;

 static { 
  br = new BufferedReader(new InputStreamReader(System.in));
 }

 public static String strs() throws IOException {
  return br.readLine();
 }

 public static String[] strs(int N) throws IOException {
  st = new StringTokenizer(strs());
  String[] arr = new String[N];
  for(int i = 0; i < N; i += 1) {
   arr[i] = st.nextToken();
  }
  return arr;
 }

 public static int ints() throws IOException {
  return Integer.parseInt(strs());
 }

 public static int[] ints(int N) throws IOException {
  st = new StringTokenizer(strs());
  int[] nums = new int[N];
  for(int i = 0; i < N; i += 1) {
   nums[i] = Integer.parseInt(st.nextToken());
  }
  return nums;
 }

 public static long longs() throws IOException {
  return Long.parseLong(strs());
 }

 public static long[] longs(int N) throws IOException {
  st = new StringTokenizer(strs());
  long[] nums = new long[N];
  for(int i = 0; i < N; i += 1) {
   nums[i] = Long.parseLong(st.nextToken());
  }
  return nums;
 }

 public static void main(String[] args) throws IOException {

  int[] nums = ints(2);

  int[][] edges = new int[nums[1]][3];

  for(int i = 0; i < nums[1]; i += 1) {
   edges[i] = ints(3);
  }

  Solution obj = new Solution(nums[0], edges);

  obj.shortestPathFromSource(1, nums[0]);

  br.close();
    }
}

/*
D:\DS_AND_ALGORITHMAS\CSES\Graph-Algorithms>java DijkstraOptimized
10 20
5 6 4
5 1 7
7 4 4
7 8 1
8 9 3
5 7 6
2 3 2
1 2 7
7 9 5
2 5 8
8 5 7
4 5 6
6 7 6
8 7 6
6 2 2
3 6 8
6 4 7
9 10 5
5 2 1
3 4 8
0 7 9 17 15 17 21 22 25 30
 D:\DS_AND_ALGORITHMAS\CSES\Graph-Algorithms>
 */
