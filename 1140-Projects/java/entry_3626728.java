import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
public class entry_3626728 {
    // static boolean prime[];
    static int mod=(int)1e9+7;
    static long[] dp;
  public static void main(String[] args) throws IOException {

        // Reader sc=new Reader();
        FastScanner sc=new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t=1;


        while(t-->0){
            int n=sc.nextInt();
            int[][] a=new int[n][3];
            for(int i=0;i<n;i++){
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
                a[i][2]=sc.nextInt();
            }
            Arrays.sort(a,(x,y)->x[1]-y[1]);
            // int moni=0;
            dp=new long[n+1];
            dp[0]=0;
            for(int i=1;i<n+1;i++){
                long op1=dp[i-1];
                long op2=a[i-1][2];
                int j=findJ(a,i-1);
                op2+=dp[j];
                dp[i]=Math.max(op1,op2);
            }     

            out.println(dp[n]);


        }


        // sc.close();
        out.close();
    }
    public static int findJ(int[][] a, int i){
        int start=0;
        int end=i-1;
        int key=a[i][0];
        while(start<=end){
            int mid=(start+end)/2;
            if(a[mid][1]>=key){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }








    public static PrintWriter out;
    // static boolean sieveOfEratosthenes(int n)
    // {
    //     // Create a boolean array "prime[0..n]" and initialize
    //     // all entries it as true. A value in prime[i] will
    //     // finally be false if i is Not a prime, else true.
    //     boolean[] prime=new boolean[n+1];
    //     for(int i=0;i<=n;i++)
    //         prime[i] = true;

    //     for(int p = 2; p*p <=n; p++)
    //     {
    //         // If prime[p] is not changed, then it is a prime
    //         if(prime[p] == true)
    //         {
    //             // Update all multiples of p
    //             for(int i = p*p; i <= n; i += p)
    //                 prime[i] = false;
    //         }
    //     }
    //     return prime;

    //     // Print all prime numbers

    // }

}
class FastScanner {
  BufferedReader br;
  StringTokenizer st;

  public FastScanner()
  {
      br = new BufferedReader(
          new InputStreamReader(System.in));
  }

  String next()
  {
      while (st == null || !st.hasMoreElements()) {
          try {
              st = new StringTokenizer(br.readLine());
          }
          catch (IOException e) {
              e.printStackTrace();
          }
      }
      return st.nextToken();
  }

  int nextInt() { return Integer.parseInt(next()); }

  long nextLong() { return Long.parseLong(next()); }

  double nextDouble()
  {
      return Double.parseDouble(next());
  }

  String nextLine()
  {
      String str = "";
      try {
          str = br.readLine();
      }
      catch (IOException e) {
          e.printStackTrace();
      }
      return str;
  }
}
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
