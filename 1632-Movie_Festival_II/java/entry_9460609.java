import java.util.*;
import java.io.*;

public class entry_9460609 {

 static class Pair {
  int first;
  int second;

  public Pair(int first, int second) {
   this.first = first;
   this.second = second;
  }
 }

 static PrintWriter pw = new PrintWriter(System.out);
 static Scanner sc = new Scanner();
 static List<Pair> list = new ArrayList<>();
 static TreeMap<Integer, Integer> map = new TreeMap<>();

 public static void solve() throws IOException {
  int n = sc.nextInt();
  int k = sc.nextInt();

  for (int i = 0; i < n; i++) {
   list.add(new Pair(sc.nextInt(), sc.nextInt()));
  }
  // sorting movies time based on end time
  Collections.sort(list, (a, b) -> Integer.compare(a.second, b.second));

  int count = 0, size = 0;
  for (int i = 0; i < n; i++) {
   int start = list.get(i).first;
   int end = list.get(i).second;

   Integer ub = map.floorKey(start);

   if (ub != null) {
    map.put(end, map.getOrDefault(end, 0) + 1);
    count++;

    int freq = map.get(ub) - 1;
    if (freq == 0) {
     map.remove(ub);
    } else {
     map.put(ub, freq);
    }
   } else if (ub == null && size < k) {
    map.put(end, map.getOrDefault(end, 0) + 1);
    count++;
    size++;
   }
  }
  pw.println(count);
 }

 public static void main(String[] args) throws IOException {
  // primeTillN();
//  int t = sc.nextInt();
//  for (int i = 0; i < t; i++) {
  solve();
//  }
  pw.flush();
 }

 // gives gcd of two long numbers in logn time
 private static long gcd(long a, long b) {
  if (b == 0)
   return a;
  return gcd(b, a % b);
 }

 // reads and returns an input array of size n
 public static int[] readArr(int n) throws IOException {
  int arr[] = new int[n];
  for (int i = 0; i < n; i++)
   arr[i] = sc.nextInt();
  return arr;
 }

 // sorts the array very effectively and return it
 public static int[] sort(int arr[]) {
  List<Integer> list = new ArrayList<>();
  for (int i : arr)
   list.add(i);
  Collections.sort(list);
  for (int i = 0; i < list.size(); i++)
   arr[i] = list.get(i);
  return arr;
 }

 static class Scanner extends PrintWriter {
  private final DataInputStream din = new DataInputStream(System.in);
  private final byte[] buffer = new byte[1 << 16];
  private int bufferPointer, bytesRead;

  public Scanner() {
   super(System.out);
  }

  private byte read() throws IOException {
   if (bufferPointer == bytesRead) {
    bytesRead = din.read(buffer, bufferPointer = 0, 1 << 16);
    if (bytesRead == -1)
     buffer[0] = -1;
   }
   return buffer[bufferPointer++];
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