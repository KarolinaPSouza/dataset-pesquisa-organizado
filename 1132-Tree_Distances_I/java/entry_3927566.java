//package graph;

import java.io.*;
import java.util.*;

public class entry_3927566 {

 private static ArrayList<Integer>[] adj;
 private static boolean[] visited;
 private static int lastNode = 0;

 private static int bfs(int node,int[] distanceA) {
  Queue<Integer> bfsQueue = new LinkedList<Integer>();
  bfsQueue.add(node);
  visited[node] = true;
  distanceA[node] = 0;
  while(!bfsQueue.isEmpty()) {
   int curr = bfsQueue.poll();
   lastNode = curr;
   for(int n:adj[curr]) {
    if(!visited[n]) {
     bfsQueue.add(n);
     visited[n] = true;
     distanceA[n] = distanceA[curr]+1;
    }  
   }
  }
  int max = 0;
  for(int i=0;i<distanceA.length;i++) {
   max = Math.max(max, distanceA[i]);
  }
  return max;
 }

 public static void main(String[] args) throws IOException {

  FastIO io = new FastIO();
  int n = io.nextInt();
  adj = new ArrayList[n];
  for(int i=0;i<n;i++) {
   adj[i] = new ArrayList<Integer>();
  }
  for(int i=0;i<n-1;i++) {
   int a = io.nextInt()-1;
   int b = io.nextInt()-1;
   adj[a].add(b);
   adj[b].add(a);
  }


  visited = new boolean[n];
  int[] distanceA = new int[n];
  bfs(0,distanceA);
  visited = new boolean[n];
  bfs(lastNode,distanceA);
  visited = new boolean[n];
  int[] distanceB = new int[n];
  bfs(lastNode,distanceB);
  for(int i=0;i<n;i++) {
   io.print(Math.max(distanceA[i], distanceB[i])+" ");
  }

  io.close();
 }

 // BeginCodeSnip{FastIO}
 static class FastIO extends PrintWriter {
  private InputStream stream;
  private byte[] buf = new byte[1<<16];
  private int curChar, numChars;

  // standard input
  public FastIO() { this(System.in,System.out); }
  public FastIO(InputStream i, OutputStream o) {
   super(o);
   stream = i;
  }
  // file input
  public FastIO(String i, String o) throws IOException {
   super(new FileWriter(o));
   stream = new FileInputStream(i);
  }

  // throws InputMismatchException() if previously detected end of file
  private int nextByte() {
   if (numChars == -1) throw new InputMismatchException();
   if (curChar >= numChars) {
    curChar = 0;
    try {
     numChars = stream.read(buf);
    } catch (IOException e) {
     throw new InputMismatchException();
    }
    if (numChars == -1) return -1; // end of file
   }
   return buf[curChar++];
  }

  // to read in entire lines, replace c <= ' '
  // with a function that checks whether c is a line break
  public String next() {
   int c; do { c = nextByte(); } while (c <= ' ');
   StringBuilder res = new StringBuilder();
   do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
   return res.toString();
  }
  public int nextInt() { // nextLong() would be implemented similarly
   int c; do { c = nextByte(); } while (c <= ' ');
   int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
   int res = 0;
   do {
    if (c < '0' || c > '9')
     throw new InputMismatchException();
    res = 10*res+c-'0';
    c = nextByte();
   } while (c > ' ');
   return res * sgn;
  }
  public double nextDouble() { return Double.parseDouble(next()); }
 }
 // EndCodeSnip{FastIO}

}