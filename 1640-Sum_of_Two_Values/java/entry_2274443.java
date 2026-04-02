//package sortingAndSearching;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class entry_2274443 {

 public static void main(String[] args) throws IOException {
  Reader in = new Reader();
  PrintWriter out  = new PrintWriter(System.out);
  int n = in.nextInt();
  int x = in.nextInt();
  int[][] a = new int[n][2];
  for(int i = 0 ;i < n ; i++) {
   a[i][0] = in.nextInt();
   a[i][1] = i + 1;
  }
  shuffle(a, n);
  Arrays.sort(a, (a1,a2)->a1[0]-a2[0]);
  int i = 0;
  int j = n-1;
  int flag = 0;
  while(i < j) {
   if(a[i][0] + a[j][0] == x) {
    out.println(a[i][1]+ " " + a[j][1]);
    flag = 1;
    break;
   } else if(a[i][0] + a[j][0] < x) {
    i++;
   } else
    j--;
  }
  if(flag == 0)
   out.println("IMPOSSIBLE");
  out.close();
 }
 static void shuffle(int a[][], int n)
    {
        for (int i = 0; i < n; i++) {

            // getting the random index
            int t = (int)Math.random() * a.length;

            // and swapping values a random index
            // with the current index
            int[] x = a[t];
            a[t] = a[i];
            a[i] = x;
        }
    }
 static class Reader {
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
                    } else {
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

            if (neg) return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
             ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)return -ret;
            return ret;
        }
        private void fillBuffer() throws IOException{
            bytesRead = din.read(buffer, bufferPointer = 0,BUFFER_SIZE);
            if (bytesRead == -1)buffer[0] = -1;
        }
        private byte read() throws IOException{
            if (bufferPointer == bytesRead)fillBuffer();
            return buffer[bufferPointer++];
        }
        public void close() throws IOException {
            if (din == null)return;
            din.close();
        }
    }
}