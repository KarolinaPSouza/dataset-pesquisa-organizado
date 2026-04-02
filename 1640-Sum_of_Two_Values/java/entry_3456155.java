import java.util.*;
import java.io.*;

public class entry_3456155 {
 static BufferedReader in;
 static Map<Integer, Integer> arr;
 static int goal;
 public static void main(String[] args) {

  try {
   solve();
  } catch(Exception e) {
   e.printStackTrace();
  }

 }

 public static void solve() throws IOException {
  arr = new HashMap<Integer, Integer>();
  in = new BufferedReader(new InputStreamReader(System.in));

  StringTokenizer str = new StringTokenizer(in.readLine());
  int num = Integer.parseInt(str.nextToken());
  goal = Integer.parseInt(str.nextToken());
  str = new StringTokenizer(in.readLine());
  StringBuilder s = new StringBuilder();
  for(int i = 1; i <= num; i ++) {
   int n = Integer.parseInt(str.nextToken());
   if(arr.containsKey(goal - n)) {
    s.append(arr.get(goal - n) + " " + i + " ");
   }
   arr.put(n, i);
  }
  if(s.toString().length() == 0)
   System.out.println("IMPOSSIBLE");
  else
   System.out.println(s.toString());
 }



}