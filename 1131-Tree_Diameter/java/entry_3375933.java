

import java.io.*;
import java.util.*;

class FastReader{

   BufferedReader br;
   StringTokenizer st;

   public FastReader()
   {
       br = new BufferedReader(
           new InputStreamReader(System.in));
   }

   String next()
   {
       while (st == null || !st.hasMoreElements()) {
           try {
               st = new StringTokenizer(br.readLine());
           }
           catch (IOException e) {
               e.printStackTrace();
           }
       }
       return st.nextToken();
   }

   int nextInt() { return Integer.parseInt(next()); }

   long nextLong() { return Long.parseLong(next()); }

   double nextDouble()
   {
       return Double.parseDouble(next());
   }

   String nextLine()
   {
       String str = "";
       try {
           str = br.readLine();
       }
       catch (IOException e) {
           e.printStackTrace();
       }
       return str;
   }

}




public class entry_3375933 {

 static class pair{
  int node;
  int dist;
  pair(int n,int d){
   node = n;
   dist = d;
  }
 }
 //Return node and its maximum distance.
 static pair bfs(int n,ArrayList<ArrayList<Integer>> tree,int src){
  boolean vis[]=  new boolean[n+1];
  Queue<pair>q = new ArrayDeque<>();
  q.add(new pair(src,0));
  pair max = new pair(0,0);
  while(q.size()!=0) {
   pair rem = q.poll();
   vis[rem.node]=true;
   if(rem.dist>max.dist) {
    max.node = rem.node;
    max.dist = rem.dist;
   }

   ArrayList<Integer> children = tree.get(rem.node);
   for(int child:children) {
    if(vis[child]==false) {
     q.add(new pair(child,rem.dist+1));
    }
   }
  }
  return max;

 }
 public static void main(String[] args) {
  FastReader sc = new FastReader();
  PrintWriter out = new PrintWriter(System.out);
  ArrayList<ArrayList<Integer>> tree = new ArrayList<>(); 
  int n = sc.nextInt();
  //boolean vis[]= new boolean[n+1]; 
  int edges = n-1;
  for(int i=1;i<=n+1;i++) {
   tree.add(new ArrayList<Integer>());
  }
  for(int i=1;i<=edges;i++) {
   int u = sc.nextInt();
   int v = sc.nextInt();

   tree.get(u).add(v);
   tree.get(v).add(u);
  }

  pair n1 = bfs(n,tree,1);
  pair ans = bfs(n,tree,n1.node);
  out.println(ans.dist);
  out.close();
 }

}