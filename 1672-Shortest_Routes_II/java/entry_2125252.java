import java.io.*;
import java.io.PrintWriter;
import java.util.Arrays;

public class entry_2125252 {
 static class InputReader {
  InputStream is=System.in;
  byte[] bb = new byte[1 << 15];
  int k, l;
  byte getc() throws IOException {
   if (k >= l) {
    k = 0;
    l = is.read(bb);
    if (l < 0) return -1;
   }
   return bb[k++];
  }
  byte skip() throws IOException {
   byte b;
   while ((b = getc()) <= 32)
    ;
   return b;
  }
  int nextInt() throws IOException {
   int n = 0;
   for (byte b = skip(); b > 32; b = getc())
    n = n * 10 + b - '0';
   return n;
  }
 }
 static final long INF = 0x3f3f3f3f3f3f3f3fL;

 static void floyd(int n,int ql,long[][] adj,int[][] q) {
  for(int k=0;k<n;k++) {
   for(int i=0;i<n;i++) {
    for(int j=i+1;j<n;j++) {
     if (adj[i][k] < INF && adj[k][j] < INF)
      adj[j][i]=adj[i][j]=Math.min(adj[i][j], adj[i][k]+adj[k][j]);
    }
   }
  }
  for(int i=0;i<ql;i++)
   System.out.println((adj[ q[i][0] ] [ q[i][1] ]==INF)?-1:adj[ q[i][0] ] [ q[i][1] ]);

 }

 public static void main(String args[] ) throws Exception {
  InputReader  sc=new InputReader();
  PrintWriter out=new PrintWriter(System.out);
  int n = sc.nextInt();
  int m = sc.nextInt();
  int ql = sc.nextInt();
  int[][] query=new int[ql][2];

  long[][] adj=new long[n][n];
  for(int i=0;i<n;i++) {
   Arrays.fill(adj[i],INF);
   adj[i][i]=0;
  }
  int a,b,w;
  for(int i=0;i<m;i++){
   a=sc.nextInt()-1;
   b=sc.nextInt()-1;
   w=sc.nextInt();
   adj[a][b]=Math.min(w,adj[a][b]);
   adj[b][a]=adj[a][b];
  }

  for(int i=0;i<ql;i++) {
   query[i][0]=sc.nextInt()-1;
   query[i][1]=sc.nextInt()-1;
  }
  floyd(n,ql,adj,query);
  out.flush();
 }
}