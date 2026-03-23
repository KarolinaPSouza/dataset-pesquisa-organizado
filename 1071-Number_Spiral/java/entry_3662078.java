// Working program using Reader Class
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class entry_3662078 {
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
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
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

        // static class FastReader {
        // BufferedReader br;
        // StringTokenizer st;

        // public FastReader()
        // {
            // br = new BufferedReader(
                // new InputStreamReader(System.in));
        // }
        // String next()
        // {
            // while (st == null || !st.hasMoreElements()) {
                // try {
                    // st = new StringTokenizer(br.readLine());
                // }
                // catch (IOException e) {
                    // e.printStackTrace();
                // }
            // }
            // return st.nextToken();
        // }

        // int nextInt() { return Integer.parseInt(next()); }
        // long nextLong() { return Long.parseLong(next()); }

        // String nextLine()
        // {
            // String str = "";
            // try {
                // str = br.readLine();
            // }
            // catch (IOException e) {
                // e.printStackTrace();
            // }
            // return str;
        // }
    // }

 // public static long d(long xx, long yy){
   // if (xx > yy){
    // if((xx & 1) == 1){
     // return xx * xx - xx<<2 + yy + 1;
    // }else{
     // return xx * xx - yy + 1;
    // }
   // }
   // else{
    // if((yy & 1) == 1) {
     // return yy*yy - xx  + 1;
    // }else{
     // return yy*yy - yy<<2 + xx + 1;
    // }
   // }

 // }

 public static void main(String[] args) throws IOException
 {
  Reader fr = new Reader();
  long test = fr.nextLong(); //test
  long c = 1;
  long d = 1;
  long x, y;
  long m = 0;

  // InputReader in = new InputReader(System.in);
  // try {
   // while( true ) {
    // x = in.nextInt();
    // y = in.nextInt();
    // System.out.println(d(x,y));
   // }
   // sum += in.nextInt();

  // } catch (IOException e) { }
  while(test-- > 0){
   x = fr.nextLong();
   y = fr.nextLong();
   // m = Math.max(x,y);
   //System.out.print((x-y)*Math.pow((-1),m)+m*m-m+1);
   if (x > y){
    c = x * x - x + 1;
    if((x & 1) == 1){
     d = c - x + y;
    }else{
     d = c + x - y;
    }
   }
   else{
    c = y * y - y + 1;
    if((y & 1) == 1) {
     d = c + y - x;
    }else{
     d = c - y + x;
    }
   }
   System.out.println(d);
  }
 }
}