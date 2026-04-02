import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class entry_12309684 {

  static BufferedReader br;
  static PrintWriter out;
  static StringTokenizer st;



  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(new OutputStreamWriter(System.out));
    // br = new BufferedReader(new FileReader("in.txt"));
    // out = new PrintWriter(new FileWriter("out.txt"));

    // slution

    int n , m;
    n = readInt();
    m = readInt();

    ArrayList<long[]> adj[] = new ArrayList[n];
    for(int i = 0 ; i < n;i++) adj[i] = new ArrayList<>();

    for(int i = 0 ; i < m;i++){
        int u = readInt() , v = readInt() , w = readInt();
        u--; 
        v--;
        adj[u].add(new long[]{v,w});
    }
    long dist[] = new long[n];
    Arrays.fill(dist,Long.MAX_VALUE);
    dist[0] = 0;

    PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));

    pq.offer(new long[]{0,0});

    while(pq.size() > 0){
        long[] curr = pq.poll();
        int node = (int) curr[0];
        long d = curr[1];
        if(d > dist[node]) continue;

        for(var j:adj[node]){
            long dd = d + j[1];
            int nodee = (int)j[0];
            if(dist[nodee] > dd){
                dist[nodee] = dd;
                pq.offer(new long[]{nodee,dd});
            }
        }
        // for(var j:pq) System.out.print(Arrays.toString(j) + " ");
        // System.out.println();
        // break;
    }

    for (int i = 0; i < n; i++) {
        if (i > 0) {
            out.print(" ");
        }
        out.print(dist[i]);
    }
    out.println();


    out.close();
  }

  static String next() throws IOException {
    while (st == null || !st.hasMoreTokens())
      st = new StringTokenizer(br.readLine().trim());
    return st.nextToken();
  }

  static long readLong() throws IOException {
    return Long.parseLong(next());
  }

  static int readInt() throws IOException {
    return Integer.parseInt(next());
  }

  static double readDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static char readCharacter() throws IOException {
    return next().charAt(0);
  }

  static String readLine() throws IOException {
    return br.readLine().trim();
  }
}

