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
public class entry_3378579 {

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
   if(vis[rem.node]==true) {
    continue;
   }
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
 public static void main(String[] args) throws IOException{
  Reader sc = new Reader();
  PrintWriter out = new PrintWriter(System.out);
  ArrayList<ArrayList<Integer>> tree = new ArrayList<>(); 
  int n = sc.nextInt();
  //boolean vis[]= new boolean[n+1]; 
  for(int i=1;i<=n+1;i++) {
   tree.add(new ArrayList<Integer>());
  }
  for(int i=1;i<n;i++) {
   int u = sc.nextInt();
   int v = sc.nextInt();

   tree.get(u).add(v);
   tree.get(v).add(u);
  }
  //2 way of calculating diameter.
  //With this two calls we are getting two corners of our diameter and their distance.
  pair n1 = bfs(n,tree,1);  //n1.node -> one point of diameter
  pair n2 = bfs(n,tree,n1.node);  // n2.node -> second point of diameter. //Diameter is n2.dist...


  int distArr[] = new int[n+1];
  boolean vis[]= new boolean[n+1];
  bfs2(tree,n1.node,distArr,vis);
  vis = new boolean[n+1];
  bfs2(tree,n2.node,distArr,vis);

  for(int i=1;i<distArr.length;i++) {
   out.print(distArr[i]+" ");
  }

  out.close();

 }
 static void dfs(ArrayList<ArrayList<Integer>> tree,int src,int dist[],boolean vis[],int dis) {
  if(vis[src]==true) {
   return;
  }
  vis[src]=true;
  dist[src] = Math.max(dist[src],dis);
  ArrayList<Integer> children = tree.get(src);
  for(int child:children) {
   if(vis[child]==false) {
    dfs(tree,child,dist,vis,dis+1);
   }
  }
 }
 static class Pair_1{
  int src;
  int dis;
  Pair_1(int  s,int d){
   src = s;
   dis = d;
  }
 }
 static void bfs2(ArrayList<ArrayList<Integer>> tree,int src,int dist[],boolean vis[]) {
  Queue<Pair_1> q = new ArrayDeque<>();
  q.add(new Pair_1(src,0));
  while(q.size()!=0) {
   Pair_1 rem = q.poll();
   if(vis[rem.src]==true) {
    continue;
   }
   vis[rem.src]=true;
   dist[rem.src] = Math.max(rem.dis,dist[rem.src]);
   ArrayList<Integer> child = tree.get(rem.src);
   for(int c:child) {
    if(vis[c]==false) {
     q.add(new Pair_1(c,rem.dis+1));
    }
   }
  }
 }
}