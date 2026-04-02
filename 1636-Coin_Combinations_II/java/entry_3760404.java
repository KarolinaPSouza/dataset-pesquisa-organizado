import java.io.*;
import java.util.*;

public class entry_3760404 {
 private static final boolean console = true;
 private static final String name = "problem_name";
 private static PrintWriter out;
 private static FastIO sc;
 private static final int mod = 1_000_000_007;
    public static void main(String[] args) throws Exception {
     if(console) sc = new FastIO(System.in);
     else sc = new FastIO(name+".in");
  if(console) out = new PrintWriter(new BufferedOutputStream(System.out));
  else out = new PrintWriter(name+".out");
  int[] coins = new int[sc.nextInt()], dp = new int[sc.nextInt()+1];
  for(int i = 0; i<coins.length; i++) coins[i] = sc.nextInt();
  dp[0] = 1;
  for(int c: coins)
   for(int i = c; i<dp.length; i++) dp[i] = (dp[i]+dp[i-c])%mod;
  out.println(dp[dp.length-1]);
  out.close();
    }
 private static class FastIO {

  InputStream dis;
  byte[] buffer = new byte[1 << 17];
  int pointer = 0;
  public FastIO(String fileName) throws Exception {
   dis = new FileInputStream(fileName);
  }

  public FastIO(InputStream is) throws Exception {
   dis = is;
  }

  int nextInt() throws Exception {
   int ret = 0;

   byte b;
   do {
    b = nextByte();
   } while (b <= ' ');
   boolean negative = false;
   if (b == '-') {
    negative = true;
    b = nextByte();
   }
   while (b >= '0' && b <= '9') {
    ret = 10 * ret + b - '0';
    b = nextByte();
   }

   return (negative) ? -ret : ret;
  }

  long nextLong() throws Exception {
   long ret = 0;

   byte b;
   do {
    b = nextByte();
   } while (b <= ' ');
   boolean negative = false;
   if (b == '-') {
    negative = true;
    b = nextByte();
   }
   while (b >= '0' && b <= '9') {
    ret = 10 * ret + b - '0';
    b = nextByte();
   }

   return (negative) ? -ret : ret;
  }

  byte nextByte() throws Exception {
   if (pointer == buffer.length) {
    dis.read(buffer, 0, buffer.length);
    pointer = 0;
   }
   return buffer[pointer++];
  }

  String next() throws Exception {
   StringBuffer ret = new StringBuffer();

   byte b;
   do {
    b = nextByte();
   } while (b <= ' ');
   while (b > ' ') {
    ret.appendCodePoint(b);
    b = nextByte();
   }

   return ret.toString();
  }

 }
}