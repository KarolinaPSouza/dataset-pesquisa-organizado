import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_2679336 {
 public static void main(String[] args) throws IOException {
  FastScanner fs = new FastScanner();
  int t = 1;
  while (t-- > 0) {
   n = fs.nextInt();
   graph = new ArrayList[n];

   for(int i =0 ;i<n;i++) {
    graph[i] = new ArrayList<>();
   } 


   for(int i =0;i<n-1;i++) {
    int x =fs.nextInt();
    int y = fs.nextInt();
    add(x-1,y-1);
   }

   int node = bfs(0);
   bfs(node);
   System.out.println(distance);

  }
 }

 static int n;
 static ArrayList<Integer> graph[];

 static int distance =0;

 static void add(int u,int v) {
  graph[u].add(v);
  graph[v].add(u);

 }

 static int bfs(int x) {

  boolean vis[] = new boolean[n];

  int dis[] = new int[n];
  dis[x]=0;
  vis[x]=true;

  Queue<Integer> q = new LinkedList<Integer>();

  q.add(x);

  while(q.size()!=0) {

   int temp= q.peek();
   q.remove();

   for(int i =0;i<graph[temp].size();i++) {
    int y = graph[temp].get(i);

    if(!vis[y]) {
     vis[y]=true;
     dis[y]=dis[temp]+1;
     q.add(y);
    }
   }
  }

  int mx =0;
  int ind =0;

  for(int i =0;i<n;i++) {
   if(dis[i]>mx) {
    mx=dis[i];
    ind=i;
   }
  }

  distance = mx;

  return ind;

 }



 static class FastScanner {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer("");

  String next() {
   while (!st.hasMoreTokens())
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }

  long[] readArray(int n) {
   long[] a = new long[n];
   for (int i = 0; i < n; i++)
    a[i] = nextLong();
   return a;
  }

  long nextLong() {
   return Long.parseLong(next());
  }
 }

}