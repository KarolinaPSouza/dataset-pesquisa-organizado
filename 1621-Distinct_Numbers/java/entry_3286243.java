import java.util.*;
import java.io.*;

public class entry_3286243 {

 public static int N;
 public static HashMap<Integer, Boolean> map = new HashMap<>();
 public static int ans = 0;

 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  N = Integer.parseInt(br.readLine());
  StringTokenizer st = new StringTokenizer(br.readLine());
  for(int i=0; i<N; i++) {
   int a = Integer.parseInt(st.nextToken());
   if(map.get(a)==null) {
    ans++;
    map.put(a, true);
   }
  }
  System.out.println(ans);
 }

}