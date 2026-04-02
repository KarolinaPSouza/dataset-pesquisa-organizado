import java.io.*;
import java.util.*;
 public class entry_2125911 {
     static int si=-1,ei=-1;
 public static void main(String[] args) throws Exception {
  FastIO io = new FastIO(); 
  int n=io.nextInt();
  int m=io.nextInt();
  int q=io.nextInt();
  long graph[][]=new long[n+1][n+1];
  for(int i=1;i<=n;i++)Arrays.fill(graph[i],Long.MAX_VALUE);
  for(int i=0;i<m;i++)
  {
      int x=io.nextInt();
      int y=io.nextInt();
      int z=io.nextInt();
      if(graph[x][y]>z)
      graph[x][y]=z;
      if(graph[y][x]>z)
      graph[y][x]=z;
  }
  for(int i=1;i<=n;i++)graph[i][i]=0;
  for(int i=1;i<=n;i++)
  {
      for(int j=1;j<=n;j++)
      {
          if(j==i)continue;
          if(graph[j][i]==Long.MAX_VALUE)continue;
          for(int k=1;k<=n;k++)
          {
              if(k==i)continue;
              if(graph[i][k]==Long.MAX_VALUE)continue;
              if(graph[j][k]>graph[j][i]+graph[i][k])
              {
                  graph[j][k]=graph[j][i]+graph[i][k];
              }
          }
      }
  }
  for(int i=0;i<q;i++)
  {
      int a=io.nextInt();
      int b=io.nextInt();
      if(graph[a][b]!=Long.MAX_VALUE)
      io.println(graph[a][b]);
      else io.println(-1);
  }
  io.close();
 }

}
 class FastIO extends PrintWriter {
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

 public String nextLine() {
  int c; do { c = nextByte(); } while (c <= '\n');
  StringBuilder res = new StringBuilder();
  do { res.appendCodePoint(c); c = nextByte(); } while (c > '\n');
  return res.toString();
 }

 public String next() {
  int c; do { c = nextByte(); } while (c <= ' ');
  StringBuilder res = new StringBuilder();
  do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
  return res.toString();
 }

 public int nextInt() { 
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

  public long nextLong() { 
  int c; do { c = nextByte(); } while (c <= ' ');
  long sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
  long res = 0;
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