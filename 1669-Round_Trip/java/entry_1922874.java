//Problem Motivation : Round Trip (CSES)
import java.util.*;
import java.io.*;

class Solution {

 /* 
  0 -> for WHITE (Unprocessed)
  1 -> for RED (Under processing mode)
  2 -> for BLACK (Processed all adajacent nodes)
 */

 private static final int WHITE = 0, RED = 1, BLACK = 2;
 List<Integer>[] adj;
 int[] colours;

 //used to keep track of parent of each vertex
 //parent[i] -> gives parent node of ith vertex
 int[] parent; 

 //Used to store cycles
 List<Integer> cycle;

 //used to check whether given Graph contains cycle or not.
 boolean containsCycle = false;

 Solution(int N, int[][] edgeList) {
  adj = new ArrayList[N + 1];
  colours = new int[N + 1];
  cycle = new ArrayList<>();
  parent = new int[N + 1];

  for(int i = 1; i <= N; i += 1) {
   adj[i] = new ArrayList<>();
  }

  for(int[] edge : edgeList) {
   adj[edge[0]].add(edge[1]);
   adj[edge[1]].add(edge[0]);
  }

 }

 private void cycleDetection(int current_ver, int direct_parent) {

  //Once cycle found there is no need of further dfs, trackback trackback ...
  if(containsCycle) return;

  //If current ver is completely processed -> If already marked with BLACK
  if(colours[current_ver] == BLACK) return;

  //if current vertex is under processing mode, if it's already marked with RED
  //not completely processed yet
  //if found cycle : back-edge found b/w -> (direct_parent ---------> current_ver)
  //backtrack from current direct_parent to current_ver's parent based on parents and
  //mark all the vertices using marker/(store in container) that are part of current cycle.

  if(colours[current_ver] == RED) {

   int tmp_dir_pa = direct_parent;

   while(parent[current_ver] != tmp_dir_pa) {
    cycle.add(tmp_dir_pa);
    tmp_dir_pa = parent[tmp_dir_pa];
   }

   //to indicate at least one cycle is possible, mark containsCycle as true
   containsCycle = true;

   return;
  }


  //put current vertex in processing mode
  colours[current_ver] = RED;

  //make parent of current_ver as direct_parent
  parent[current_ver] = direct_parent;

  for(int adjacent : adj[current_ver]) {

   //If current adjacent node of current_ver is direct parent
   //then continue, this edge (current_ver ---- adjacent) can't be back-edge
   if(adjacent == direct_parent) continue;

   if(colours[adjacent] != BLACK) {
    cycleDetection(adjacent, current_ver);
   }
  }

  //mark current vertex is processed
  //when all the adjacent vertices of current_ver is processed
  colours[current_ver] = BLACK;

 }

 public StringBuilder cycleLengthGreaterThanEqualTo3(int N) {

  //Graph can be disconnected
  for(int i = 1; i <= N; i += 1) {
   if(colours[i] == WHITE) {
    cycleDetection(i, -1);
   }
  }

  if(!containsCycle) return new StringBuilder("IMPOSSIBLE");


  StringBuilder sb = new StringBuilder();

  //starting should be include two times that's why 1 added
  sb.append((cycle.size() + 1) + "\n"); 

  int first_ele = cycle.get(0);

  for(int v : cycle) sb.append(v + " ");

  //starting vertex and ending vertex are inclusive
  //that's why first and last vertex must be same in cycle.
  sb.append(first_ele);

  return sb;
 }

}


public class entry_1922874 {

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
  int[][] edges = new int[nums[1]][2];
  for(int i = 0; i < nums[1]; i += 1) {
   edges[i] = ints(2);
  }
  Solution obj = new Solution(nums[0], edges);
  System.out.println(obj.cycleLengthGreaterThanEqualTo3(nums[0]));
    }
}

/*
 D:\DS_AND_ALGORITHMAS\CSES\Graph-Algorithms>javac RoundTrip.java
Note: RoundTrip.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
 D:\DS_AND_ALGORITHMAS\CSES\Graph-Algorithms>java RoundTrip
5 6
1 3
1 2
5 3
1 5
2 4
4 5
[0, 1, 0, 1, 0, 1]
4
5 3 1 5
 D:\DS_AND_ALGORITHMAS\CSES\Graph-Algorithms>java RoundTrip
5 4
1 2
1 3
2 4
2 5
[0, 0, 0, 0, 0, 0]
IMPOSSIBLE
 D:\DS_AND_ALGORITHMAS\CSES\Graph-Algorithms>java RoundTrip
8 8
1 2
1 6
2 3
2 5
3 4
6 7
7 8
8 6
[0, 0, 0, 0, 0, 0, 1, 1, 1]
4
8 7 6 8
 */