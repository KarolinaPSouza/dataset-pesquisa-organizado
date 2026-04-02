import java.util.*;
import java.io.*;

public class entry_4688394 {
 static class FastReader {
  BufferedReader br;
  StringTokenizer st;

  public FastReader() {
   br = new BufferedReader(new InputStreamReader(System.in));
  }
  String next() {
   while(st == null || !st.hasMoreElements()) {
    try {
     st = new StringTokenizer(br.readLine());
    }
    catch (IOException e) {
     e.printStackTrace();
    }
   }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }
  long nextLong() {
   return Long.parseLong(next());
  }
  double nextDouble() {
   return Double.parseDouble(next());
  }
  String nextLine () {
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
 static class Pair {
  int first;
  int second;
 }

 static int INT_MAX = Integer.MAX_VALUE;
 static int INT_MIN = Integer.MIN_VALUE;

 static long LONG_MAX = Long.MAX_VALUE;
 static long LONG_MIN = Long.MIN_VALUE;

 static int MOD = (int)1e9 + 7;

 public static void main(String args[]) {
  FastReader fs = new FastReader();
  StringBuilder ans = new StringBuilder();

  int n = fs.nextInt();
  long k = fs.nextInt();
  long arr[] = new long[n];
  for(int i = 0; i < n; i++) {
   arr[i] = fs.nextLong();
  }
  HashMap<Long, int[]> hm = new HashMap<>();
  for(int i = 0; i < n; i++) {
   for(int j = i + 1; j < n; j++) {
    long required = k - arr[i] - arr[j];
    if(hm.containsKey(required)) {
     int pair[] = hm.get(required);
     System.out.println((i + 1) + " " + (j + 1) + " " + (pair[0] + 1) + " " + (pair[1] + 1));
     return;
    }
   }
   for(int j = i - 1; j >= 0; j--) {
    long sum = arr[i] + arr[j];
    if(!hm.containsKey(sum)) {
     hm.put(sum, new int[]{i, j});
    }
   }
  }
  System.out.println("IMPOSSIBLE");
 }

 static class Comp implements Comparator<long[]> {
  public int compare(long a[], long b[]) {
   Long n = a[0];
   Long m = b[0];
   return n.compareTo(m);
  }
 }

}
