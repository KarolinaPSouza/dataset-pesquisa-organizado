// CF submission code
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.IOException;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.io.PrintWriter;
import java.util.Collections;


@SuppressWarnings("unused")

public class entry_5498112 {
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
   din = new DataInputStream(
       new FileInputStream(file_name));
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
    buf[cnt++] = (byte)c;
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
   bytesRead = din.read(buffer, bufferPointer = 0,
                        BUFFER_SIZE);
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

 static class Solution {
  int tc, n, x;
  long ans;
  List<Integer> inputArr;
  Reader reader;
  PrintStream streamWriter;
  PrintWriter writer;
  List<Integer> outputArr;
  final int MOD = 1_000_000_007;
  final int LIMIT = 5_000_005;
  final int BASE = 7;
  // Map<Integer, Integer> memoize;
  int[] memoize;


  public Solution() throws IOException {
   //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> local testing
   // reader      = new Reader("input.txt");
   // streamWriter    = new PrintStream(new File("output.txt"));
   // System.setOut(streamWriter);

   //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> entry_5498112 submit
   reader   = new Reader();
   writer   = new PrintWriter(System.out);


   inputArr = new ArrayList<Integer>();

   // outputArr        = new ArrayList<Integer>();
  }
  public void takeInput() throws IOException {
   n = reader.nextInt();
   x = reader.nextInt();

   for (int i = 0; i < n; i++) {
    inputArr.add(reader.nextInt());
   }
   // memoize = new HashMap<>();
   // memoize.put(0, 1);//withouting taking any coins we can get sum 0, hence set base case to 1
   memoize = new int[x + 1];
   memoize[0] = 1;

  }
  public void printOut(int[] arr) {
   for (int a : arr) System.out.print(a + " ");
   System.out.println();
  }
  public void printOut(long[] arr) {
   for (long a : arr) System.out.print(a + " ");
   System.out.println();
  }
  private void solve() throws IOException {
   long[] memoize = new long[x + 1];
   memoize[0] = 1;//withouting taking any coins we can get sum 0, hence set base case to 1
   for (int i = 0; i < n; i++) {
    long combinations = 0;
    int coin = inputArr.get(i);
    for (int sum = 1; sum <= x; sum++) {
     if (sum - coin < 0) continue;
     memoize[sum] = (memoize[sum] + memoize[sum - coin]) % MOD;
     //use every coin separately so that only unique combinations come for,
     // each sum value 1...x
     //Since we now loop over the coins before the weights,
     //we only go through the set of coins once,
     //so it's impossible to create two combinations with the same set of coins ordered differently

    }
   }
   ans = memoize[x];
  }
  private void recurse(int coinIndex) throws IOException {
   if (coinIndex == n) return;

   int coin = inputArr.get(coinIndex);

   for (int sum = 1; sum <= x; sum++) {
    if (sum - coin < 0) continue;
    memoize[sum] = (memoize[sum] + memoize[sum - coin]) % MOD;
   }
   recurse(coinIndex + 1);
   return;
  }
  public void giveOutput() throws IOException {
   // for (int[] in : inputArr) {
   //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
   ans = memoize[x];
   writer.println(ans);//entry_5498112 submit

   //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
   // streamWriter.println(ans);//local testing

   // }

  }
  public void release() throws IOException {
   reader.close();
   if (streamWriter != null) streamWriter.close();
   if (writer != null) writer.close();
  }
 }
 public static void main(String[] args) throws IOException {
  Solution obj = new Solution();
  obj.takeInput();
  obj.recurse(0);
  obj.giveOutput();
  obj.release();
 }
}

