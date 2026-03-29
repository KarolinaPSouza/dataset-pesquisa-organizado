import java.io.*;
import java.util.*;

class Projects {

 public static void main(String[] args) throws IOException {

  Projects obj = new Projects();

  obj.doStuff();

 }

 class SortArr implements Comparator<int[]> {

  @Override
  public int compare(int[] o1, int[] o2) {
   return o1[0] - o2[0];
  }

 }

 int bs(int n, int l) {
  l++;
  int r = data.length;
  while (l < r) {
   int m = (l+r)/2;
   if (m == data.length) return data.length;
   if (data[m][0] > n) r = m;
   else l = m+1;
  }
  return l;
 }

 int[][] data;

 private void doStuff() throws IOException {

  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  data = new int[Integer.parseInt(br.readLine())][3];
  for (int i = 0; i < data.length; i++) {
   StringTokenizer st = new StringTokenizer(br.readLine());
   data[i] = new int[] {
     Integer.parseInt(st.nextToken()),
     Integer.parseInt(st.nextToken()),
     Integer.parseInt(st.nextToken())
   };
  }
  br.close();

  Arrays.sort(data, new SortArr());
  long[] dp = new long[data.length+1];
  for (int i = data.length-1; i >= 0; i--) {
   int pos = bs(data[i][1], i);
   dp[i] = Math.max(dp[i+1], dp[pos]+data[i][2]);
  }

  System.out.println(dp[0]);

 }

}