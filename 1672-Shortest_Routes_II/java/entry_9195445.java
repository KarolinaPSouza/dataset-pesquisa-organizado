import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class entry_9195445 {
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

  public String readLine() throws IOException {
   byte[] buf = new byte[64]; // line length
   int cnt = 0, c;
   while ((c = read()) != -1) {
    if (c == '\n') {
     if (cnt != 0) {
      break;
     } else {
      continue;
     }
    }
    buf[cnt++] = (byte) c;
   }
   return new String(buf, 0, cnt);
  }

  public int nextInt() throws IOException {
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

 public static void main(String[] args) throws IOException {
  Reader reader = new Reader();
  PrintWriter pw = new PrintWriter(System.out);
  int n = reader.nextInt();
  int m = reader.nextInt();
  int q = reader.nextInt();
  long[][] mat = new long[n + 1][n + 1];
  long M = 1000000000000L;
  for (int i = 0; i <= n; i++) {
   for (int j = 0; j <= n; j++) {
    if (i == j) {
     mat[i][j] = 0;
    } else {
     mat[i][j] = M;
    }
   }
  }
  for (int i = 0; i < m; i++) {
   int a = reader.nextInt();
   int b = reader.nextInt();
   int c = reader.nextInt();
   mat[a][b] = Math.min(mat[a][b], c);
   mat[b][a] = Math.min(mat[a][b], c);
  }
  int[][] query = new int[q][2];
  for (int i = 0; i < q; i++) {
   int a = reader.nextInt();
   int b = reader.nextInt();
   query[i][0] = a;
   query[i][1] = b;
  }
  for (int k = 1; k <= n; k++) {
   for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
     mat[i][j] = Math.min(mat[i][j], (mat[i][k] + mat[k][j]));
    }
   }
  }

  for (int i = 0; i < q; i++) {
   int x = query[i][0];
   int y = query[i][1];
   if (mat[x][y] == M) {
    pw.println(-1);
   } else {
    pw.println(mat[x][y]);
   }
  }
  pw.flush();
 }
}