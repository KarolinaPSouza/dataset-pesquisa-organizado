import java.io.*; 
import java.util.*;

class Graph {
 ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
 ArrayList<Integer> vst = new ArrayList<Integer> ();
 ArrayList<Integer> dist = new ArrayList<Integer> ();
 ArrayList<Integer> par = new ArrayList<Integer> ();
 int N, M;
 Graph (int n, int m) {
  N = n;
  M = m;
  for (int i = 0; i < N; i++) {
   adj.add(new ArrayList<Integer> ());
   vst.add(0);
   dist.add(0);
   par.add(0);
  }
 }
 public void bfs () {
  par.set(0, -1);
  dist.set(0, 0);
  vst.set(0, 1);
  Queue<Integer> q = new LinkedList<Integer> ();
  q.add(0);
  while (!q.isEmpty()) {
   int cur = q.peek();
   q.poll();
   for (int next : adj.get(cur)) {
    if (vst.get(next) == 1)
     continue;
    vst.set(next, 1);
    par.set(next, cur);
    dist.set(next, dist.get(cur) + 1);
    q.add(next);
   }
  }
 }

}

public class entry_720983 {

 public static void main(String[] args) throws IOException {
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter out = new PrintWriter(System.out);
  StringTokenizer st = new StringTokenizer(in.readLine());
  int N = Integer.parseInt(st.nextToken());
  int M = Integer.parseInt(st.nextToken());

  Graph gr = new Graph(N, M);

  for (int i = 0; i < M; i++) {
   st = new StringTokenizer(in.readLine());
   int a = Integer.parseInt(st.nextToken());
   int b = Integer.parseInt(st.nextToken());
   --a; --b;
   gr.adj.get(a).add(b);
   gr.adj.get(b).add(a);
  }
  gr.bfs();
  if (gr.vst.get(N-1) == 0) {
   out.print("IMPOSSIBLE");
   out.close();
   return;
  }

  out.print(gr.dist.get(N-1) + 1);
  Stack<Integer> stk = new Stack<Integer> ();
  int cur = N-1;
  while (gr.par.get(cur) != -1) {
   stk.add(cur + 1);
   cur = gr.par.get(cur);
  }
  stk.add(1);
  out.print("\n");
  while (!stk.isEmpty()) {
   int x = stk.peek();
   out.print(x + " ");
   stk.pop();
  }

  out.close();

 }

}