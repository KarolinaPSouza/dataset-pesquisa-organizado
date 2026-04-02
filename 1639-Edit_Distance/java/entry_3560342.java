import java.util.*;
import java.io.*;
public class entry_3560342 {

 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());

  char str1[] = st.nextToken().toCharArray();
  st = new StringTokenizer(br.readLine());
  char str2[] = st.nextToken().toCharArray();

  int[][] dp = new int[str1.length+1][str2.length+1];
  for (int i = 0; i < dp.length; i++) {
   Arrays.fill(dp[i], Integer.MAX_VALUE);
  }
  dp[0][0] = 0;
  for (int i = 0; i <= str1.length; i++) {
   for (int j = 0; j <= str2.length; j++) {
    if (i != 0) {
     // Delete letter i - 1 from the string.
     dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
    }
    if (j != 0) {
     // Add letter j - 1 of the result to the string.
     dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
    }

    // Make letter i - 1 equal to letter j - 1 of the result.
    if (i != 0 && j != 0) {
     int newCost = dp[i - 1][j - 1] + ((str1[i - 1] == str2[j - 1]) ? 0 : 1);
     dp[i][j] = Math.min(dp[i][j], newCost);
    }
   }
  }
  System.out.println(dp[str1.length][str2.length]);
  System.out.close();


 }

}