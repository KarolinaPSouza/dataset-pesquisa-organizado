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
        byte[] buf = new byte[5001]; // line length
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

public class entry_3547694 {


 static class Edge  {
  int src;
  int neig;
  long wgt;
  Edge(int s,int n,long w){
   src= s;
   neig = n;
   wgt= w;
  }

 }
 public static void main(String[] args) throws IOException{
  Reader sc = new Reader();
  PrintWriter out = new PrintWriter(System.out);
   int n = sc.nextInt();
   int c = sc.nextInt();

   ArrayList<Edge> graph[] = new ArrayList[n+1];
   for(int i=0;i<=n;i++) {
    graph[i]= new ArrayList<>();

   }

   for(int i=0;i<c;i++) {
    int u = sc.nextInt();
    int v = sc.nextInt();
    long wgt = sc.nextLong();

    graph[u].add(new Edge(u,v,wgt));
   }

   ArrayList<Integer> ans = BellmanFord(graph,1,n);
   if(ans!=null) {

    for(int i=0;i<ans.size();i++)
     out.print(ans.get(i)+" ");
   }
   out.close();
 }

 static ArrayList<Integer> BellmanFord(ArrayList<Edge>[]g,int src,int n) {
  long dist[]= new long[g.length];
  int parent[] = new int[g.length];
  // Arrays.fill(dist, Integer.MAX_VALUE);
  Arrays.fill(parent, -1);
  dist[src]=0;
  int x =-1;
  for(int count = 0;count<g.length;count++) {
    x =-1;
   for(int i=0;i<g.length;i++) {
     for(Edge e: g[i]) {
      int u =e.src;
      int v= e.neig;
      long wgt = e.wgt;
      if(dist[u]==Integer.MAX_VALUE) {
      continue;
      }//---------------------RelaxFunction
      if(dist[v]>dist[u]+wgt) {
       dist[v]= dist[u]+wgt;
       parent[v]=u;
       x=v;
      }//-------------------
     }

   }
  }

  if(x==-1) {
   System.out.println("NO");
   return null;
  }else {
   System.out.println("YES");

    for(int i=0;i<n;i++) {
     x = parent[x];
    }
    ArrayList<Integer> al = new ArrayList<>();
    for(int v = x;;v= parent[v]) {
     al.add(v);
     if(v==x && al.size()>1){
      break;
     }
    }
    Collections.reverse(al);
    return al;
  }

 }



}