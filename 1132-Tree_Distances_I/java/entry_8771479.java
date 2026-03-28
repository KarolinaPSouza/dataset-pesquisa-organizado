import java.io.*;
import java.util.*;

public class entry_8771479 {
    static int[][] bfs(List<Integer>[] G, int src, int n) {
        int[] ans = {-1, 0}; 
        int[] D = new int[n]; 
        Arrays.fill(D, n+1); 
        if(src == -1) {
            return new int[][] {ans, D}; 
        }
        var q = new ArrayDeque<Integer>(); 
        var seen = new boolean[n]; 
        seen[src] = true; 
        D[src] = 0; 
        q.offer(src); 
        for(var d = 0; !q.isEmpty(); d++) {
            for(var size = q.size(); size > 0; size--) {
                var u = q.peek();
                q.poll(); 
                ans[0] = u; 
                ans[1] = d; 
                if(G[u] == null) {
                    continue;
                }
                for(var v: G[u]) {
                    if(!seen[v]) {
                        seen[v] = true; 
                        D[v] = D[u] + 1; 
                        q.offer(v); 
                    }
                } 
            }
        }
        return new int[][] {ans, D}; 
    }
    public static void main(String[] args) throws Exception {
        var in = new Reader(); 
        var out = new Writer(System.out); 
        var n = in.nextInt(); 
        var m = n-1; 
        List<Integer>[] G = new ArrayList[n]; 
        for(var i = 0; i < m; i++) {
            var u = in.nextInt()-1; 
            var v = in.nextInt()-1; 
            if(G[u] == null) {
                G[u] = new ArrayList<>();
            }
            if(G[v] == null) {
                G[v] = new ArrayList<>(); 
            }
            G[u].add(v); 
            G[v].add(u); 
        }
        var a = bfs(G, 0, n)[0][0]; 
        var b_diameter_Da = bfs(G, a, n); 
        var b = b_diameter_Da[0][0]; 
        var Da = b_diameter_Da[1]; 
        var a_diameter_Db = bfs(G, b, n); 
        var Db = a_diameter_Db[1]; 
        var ans = new int[n]; 
        for(var u = 0; u < n; u++) {
            ans[u] = max(Da[u], Db[u]); 
        }
        out.println(ans); 
        out.close(); 
    }

    static class Writer extends PrintWriter {

        Writer(OutputStream os) {
            super(os); 
        }
        void println(int[] A) {
            var sb = new StringBuffer(); 
            for(var a: A) {
                sb.append(a).append((char) 0x20); 
            }
            println(sb); 
        }
    }

    static int max(int a, int b) { return Math.max(a,b); }
    static class Reader {
  final private int BUFFER_SIZE = 1 << 16;
  private DataInputStream din;
  private byte[] buffer;
  private int bufferPointer, bytesRead;

  public Reader() {
   din = new DataInputStream(System.in);
   buffer = new byte[BUFFER_SIZE];
   bufferPointer = bytesRead = 0;
  }

  public Reader(String file_name) throws IOException {
   din = new DataInputStream(new FileInputStream(file_name));
   buffer = new byte[BUFFER_SIZE];
   bufferPointer = bytesRead = 0;
  }

  public String nextLine() throws IOException {
   byte[] buf = new byte[64]; // line length
   int cnt = 0, c;
   while ((c = read()) != -1) {
    if (c == '\n')
     break;
    buf[cnt++] = (byte) c;
   }
   return new String(buf, 0, cnt);
  }

  public String next() throws IOException {
   byte[] buf = new byte[64]; // line length
   int cnt = 0, c;
   while ((c = read()) != -1) {
    if (c == ' ')
     break;
    buf[cnt++] = (byte) c;
   }
   return new String(buf, 0, cnt);
  }

  public int nextInt() throws IOException {
   int ret = 0;
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

  public long nextLong() throws IOException {
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

  public double nextDouble() throws IOException {
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

  private void fillBuffer() throws IOException {
   bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
   if (bytesRead == -1)
    buffer[0] = -1;
  }

  private byte read() throws IOException {
   if (bufferPointer == bytesRead)
    fillBuffer();
   return buffer[bufferPointer++];
  }

  public void close() throws IOException {
   if (din == null)
    return;
   din.close();
  }
 }
}