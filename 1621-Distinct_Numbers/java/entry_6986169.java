import java.io.*;
import java.util.*;

public class entry_6986169 {
 public static void main(String[] args) throws IOException {
  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

  int numVals = Integer.parseInt(r.readLine());
  Set<Integer> s = new HashSet<Integer>();
  StringTokenizer st = new StringTokenizer(r.readLine());
  for (int i = 0; i < numVals; i++) {
   s.add(Integer.parseInt(st.nextToken()));
  } 

  pw.print(s.size());
  pw.close();
 }
}