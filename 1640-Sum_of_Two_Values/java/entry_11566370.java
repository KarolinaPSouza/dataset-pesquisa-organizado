// Dec. 27, 2024

import java.io.*;
import java.util.*;

public class entry_11566370 {
 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());

  int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  br.close();

  int[] sorted = values.clone();
  Arrays.sort(sorted);

  int left = 0, right = n-1, sum = 0;
  while(left < right) {
   if(sorted[left] + sorted[right] == x) break;

   if(sorted[left] + sorted[right] < x) left++;
   else right--;
  }

  int v1 = -1, v2 = -1;
  for(int i = 0; i < n; i++) {
   if(values[i] == sorted[left] && v1 == -1) v1 = i+1;
   else if(values[i] == sorted[right] && v2 == -1) v2 = i+1;
  }  

  if(left >= right) pw.println("IMPOSSIBLE");
  else pw.println(v1 + " " + v2);
  pw.close();
 }
}