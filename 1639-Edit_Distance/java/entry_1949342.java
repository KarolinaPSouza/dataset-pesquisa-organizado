import java.io.*;
import java.util.*;

public class entry_1949342 {

 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

  String a = br.readLine();
  String b = br.readLine();

  int x = a.length();
  int y = b.length();

  int[][] dp = new int[x + 1][y + 1];
  dp[0][0] = 0;

  for (int i = 0; i <= x; i++) 
  {
   for (int j = 0; j <= y; j++) 
   {
    if (i == 0 && j == 0)
     continue;

    dp[i][j] = (int) 1e9;
    if (i > 0) 
    {
     dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
    }
    if (j > 0) 
    {
     dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
    }
    if (i > 0 && j > 0) 
    {
     int cost;
     if (a.charAt(i - 1) == b.charAt(j - 1))
      cost = 0;
     else
      cost = 1;

     dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + cost);
    }
   }
  }

  pw.println(dp[x][y]);

  pw.close();
  br.close();
 }

}