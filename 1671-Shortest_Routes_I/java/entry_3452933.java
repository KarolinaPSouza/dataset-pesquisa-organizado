import java.io.*;
import java.util.*;

class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException
    {
        din = new DataInputStream(
            new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException
    {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                if (cnt != 0) {
                    break;
                }
                else {
                    continue;
                }
            }
            buf[cnt++] = (byte)c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws IOException
    {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public double nextDouble() throws IOException
    {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();

        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0,
                             BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException
    {
        if (din == null)
            return;
        din.close();
    }
}


public class entry_3452933 {



 static class Edge{
  int u,v;
  long wgt;
  Edge(int u,int v,long w){
   this.u = u;
   this.v= v;
   wgt= w;
  }
 }
 static PrintWriter out = new PrintWriter(System.out);

 public static void main(String[] args) throws IOException {
  Reader sc=  new Reader();

  int n= sc.nextInt();
  int m = sc.nextInt();

  ArrayList<Edge>[] graph = new ArrayList[n+1];
  for(int i=0;i<=n;i++) 
   graph[i] = new ArrayList<>();

  for(int i=0;i<m;i++) {
   int u = sc.nextInt();
   int v = sc.nextInt();
   long wgt = sc.nextLong();

   graph[u].add(new Edge(u,v,wgt));
   //graph[v].add(new Edge(v,u,wgt));
  }

  bfs(1,graph);
        out.close();
 }
 static class pair implements Comparable<pair>{
  int src;
  long wgt;
  pair(int s,long w){
   src= s;
   wgt= w;
  }
  public int compareTo(pair o) {
   if(wgt>o.wgt) {
    return 1;
   }else {
    return -1;
   }
  }
 }
 static void bfs(int src,ArrayList<Edge>[] graph) {
  boolean vis[]= new boolean[graph.length];
  Long dist[] = new Long[graph.length];
  Arrays.fill(dist, Long.MAX_VALUE);
  dist[0]=dist[1]=0l;
  PriorityQueue<pair> pq= new PriorityQueue<>();
  pq.add(new pair(src,0));
  while(pq.size()>0) {
   pair rem = pq.poll();
   //System.out.println(rem.src);
   if(vis[rem.src]==true) {
    continue;
   }
   vis[rem.src]=true;
   for(Edge e: graph[rem.src]) {
    dist[e.v] = Math.min(dist[e.v],rem.wgt+e.wgt);
    if(vis[e.v]==false) {
    // System.out.println("ofwkjo");
     pq.add(new pair(e.v,rem.wgt+e.wgt));
    }
   }
  }
  for(int i=1;i<dist.length;i++) {
   out.print(dist[i]+" ");
  }
 }
}