import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

public class entry_6126194 {
 static Reader io;

 public static void main(String[] args) throws IOException {
  Reader io = new Reader();
  // PrintWriter out = new PrintWriter(System.out);
  int ticketNum = io.nextInt();
  int customerNum = io.nextInt();
  TreeMap<Integer, MutableInt> counts = new TreeMap<>();
  for (int i = 0; i < ticketNum; i++) {
   int ticket = io.nextInt();
   MutableInt count = counts.get(ticket);
   if (count == null) {
    counts.put(ticket, new MutableInt());
   } else {
    count.increment();
   }
  }
  StringBuilder sb = new StringBuilder();
  String neg = "-1\n";
  Entry<Integer, MutableInt> cost = null;
  for (int i = 0; i < customerNum; i++) {
   int cust = io.nextInt();
   cost = counts.floorEntry(cust);
   if (cost == null) {
    sb.append(neg);
   } else {
    if (cost.getValue().decrement()) {
     counts.remove(cost.getKey());
    }
    sb.append(cost.getKey()).append("\n");
   }
  }
  System.out.print(sb);
 }

 static class MutableInt {
  int value = 1; // note that we start at 1 since we're counting

  public void increment() {
   ++value;
  }

  public boolean decrement() {
   --value;
   return value == 0;
  }

  public int get() {
   return value;
  }
 }

 static void readIntArray(int[] nums) throws IOException {
  for (int i = 0; i < nums.length; i++) {
   nums[i] = io.nextInt();
  }
 }

 static void sortArray(int[] arr) {
  shuffleArray(arr);
  Arrays.sort(arr);
 }

 static void shuffleArray(int[] arr) {
  Random rnd = ThreadLocalRandom.current();
  for (int i = arr.length - 1; i > 0; i--) {
   int index = rnd.nextInt(i + 1);
   int a = arr[index];
   arr[index] = arr[i];
   arr[i] = a;
  }
 }

 static void sortLongArray(long[] arr) {
  shuffleLongArray(arr);
  Arrays.sort(arr);
 }

 static void shuffleLongArray(long[] arr) {
  Random rnd = ThreadLocalRandom.current();
  for (int i = arr.length - 1; i > 0; i--) {
   int index = rnd.nextInt(i + 1);
   long a = arr[index];
   arr[index] = arr[i];
   arr[i] = a;
  }
 }

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
 }
}