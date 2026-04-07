
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class entry_3255467 {
 public static void main(String[] args) throws NumberFormatException, IOException {
  HashSet<Integer> set = new HashSet<Integer>();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int N = Integer.parseInt(br.readLine());
  StringTokenizer st = new StringTokenizer(br.readLine());
  for (int i=0; i<N;i++) {
   set.add(Integer.parseInt(st.nextToken()));
  }
  System.out.println(set.size());
 }
}