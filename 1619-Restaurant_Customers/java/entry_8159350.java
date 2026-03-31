import java.io.*;
import java.util.*;

public class entry_8159350 {
 public static void main(String[] args) throws IOException {
  BufferedReader read =
      new BufferedReader(new InputStreamReader(System.in));
  TreeMap<Integer, Integer> times = new TreeMap<>();
  int n = Integer.parseInt(read.readLine());
  for (int i = 0; i < n; i++) {
   StringTokenizer cus = new StringTokenizer(read.readLine());
   times.put(Integer.parseInt(cus.nextToken()), 1);
   times.put(Integer.parseInt(cus.nextToken()), -1);
  }

  int mostPpl = 0;
  int currPpl = 0;
  for (int t : times.values()) {
   currPpl += t;
   mostPpl = Math.max(mostPpl, currPpl);
  }

  System.out.println(mostPpl);
 }
}