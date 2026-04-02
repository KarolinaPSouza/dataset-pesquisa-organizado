import java.io.*;
import java.util.*;

public class entry_14229695 {
 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  int x = Integer.parseInt(st.nextToken());

  Map<Integer, Integer> m = new HashMap<>();
  st = new StringTokenizer(br.readLine());
  for (int i = 0; i < n; i++) {
   int a = Integer.parseInt(st.nextToken());
   if (m.containsKey(x - a)) {
    System.out.println((i + 1) + " " + (m.get(x - a) + 1));
    return;
   }
   m.put(a, i);
  }

  System.out.println("IMPOSSIBLE");
 }
}