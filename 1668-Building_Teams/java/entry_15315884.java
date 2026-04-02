import java.util.*;
import java.io.*;
public class entry_15315884 {
int N;
static List<List<Integer>> adj;
private static boolean[] visited;
static int[] colors;
static boolean valid = true;
 public static void main(String[] args) throws IOException{
 Kattio io =new Kattio();
 int nodes = io.nextInt();
 int edges = io.nextInt();
 adj = new ArrayList<>(nodes);
 for(int i = 0; i <nodes;i++) {
  adj.add(i, new ArrayList<Integer>());
 }
 for(int i =0;i <edges;i++) {
  int a = io.nextInt();
  int b = io.nextInt();
  adj.get(a-1).add(b-1);
  adj.get(b-1).add(a-1);
 }
 visited = new boolean[nodes];
 colors = new int[nodes];
 for(int i = 0; i <nodes;i++) {
  if(!visited[i]) {
  // io.println("We're dfs'ing node " + i );
   dfs(i,1);
  }
 }
 if(!valid) {
  io.println("IMPOSSIBLE");
 }
 else {
  for(int ele:colors) {
   io.print(ele + " ");
  }
 }
 io.close();
 }
 public static void dfs(int s, int currcolor) {
  if(visited[s]) {
   return;
  }
  visited[s]=true;
  //System.out.println("We just visited node " + s);
  colors[s] = currcolor;
  int oppcolor = 1;
  if(currcolor==1) {
   oppcolor=2;
  }
  else {
   oppcolor=1;
  }
  for(int u:adj.get(s)) {
  if(colors[u]==0) {
   colors[u] = oppcolor;
   dfs(u,oppcolor);

  }
  else {
    if(colors[u] == currcolor) {
     valid = false;
     return;
    }

  }

 }
 }

 static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}