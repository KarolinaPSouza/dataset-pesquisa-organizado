import java.io.*;
import java.util.*;
public class entry_3175051 {
 // Custom Class to read Data(Fastest Way to read in java)
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
         // Before 64, After 1000000 i.e.e 10 ^ 6
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            StringBuffer toReturn = new StringBuffer("");
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
                if(cnt == 64) {
                 toReturn.append(new String(buf, 0, cnt));
                 cnt = 0;
                }
            }
            if(cnt != 0) {
             toReturn.append(new String(buf, 0, cnt));
            }
            return toReturn.toString().trim();
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

 // End Custom Reader Class
 public static long gcd(long a, long b) {
  if(b == 0) return a;
  return gcd(b, a % b);
 }

 public static long lcm(long a, long b) {
  return (a/gcd(a, b)) * b;
 }
 public static void print(Object obj) {
  System.out.println(obj);
 }
 public static int stoi(String str) {
  return Integer.parseInt(str);
 }
 public static long stol(String str) {
  return Long.parseLong(str);
 }
 public static boolean checkBitAtLocation(long elem, int location) {
  if ((elem & (1L << (location - 1))) > 0) return true;
  return false;
 }
 public static long mod(long p, long q)
 {
     long mod = 998244353, expo;
     expo = mod - 2;
     // Loop to find the value
     // until the expo is not zero
     while (expo != 0)
     {
         // Multiply p with q
         // if expo is odd
         if ((expo & 1) == 1)
         {
             p = (p * q) % mod;
         }
         q = (q * q) % mod;

         // Reduce the value of
         // expo by 2
         expo >>= 1;
     }
     return p;
 }
 // entry_3175051 Code
 public static void main(String args[]) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  Reader s = new Reader();
  // int t = Integer.parseInt(s.readLine());
  long n = stol(s.readLine());
  String[] in = s.readLine().split(" ");
  HashSet<Long> uniq = new HashSet<>();
  for(long i = 0; i < n; i++) {
   uniq.add(stol(in[(int)i]));
  }
  print(uniq.size());
  // for(int test = 0;test < t;test ++) {
  //  // long n = stol(s.readLine());
  //  String[] in = s.readLine().split(" ");
  //  long a = stol(in[0]), b = stol(in[1]);
  // }
 }
}