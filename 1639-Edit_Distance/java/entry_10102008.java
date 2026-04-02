import java.util.Scanner;

public class entry_10102008 {
 public static int calculateEditDistance(String s1, String s2) {
  int n = s1.length();
  int m = s2.length();

  int[][] dp = new int[n + 1][m + 1];

  for (int i = 0; i <= n; i++) {
   dp[i][0] = i;
  }

  for (int j = 0; j <= m; j++) {
   dp[0][j] = j; 
  }


  for (int i = 1; i <= n; i++) {
   for (int j = 1; j <= m; j++) {
    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
     dp[i][j] = dp[i - 1][j - 1]; // No operation needed
    } else {
     dp[i][j] = Math.min(dp[i - 1][j - 1], 
       Math.min(dp[i - 1][j], 
         dp[i][j - 1])) 
       + 1;
    }
   }
  }

  return dp[n][m];
 }

 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);

  String s1 = scanner.nextLine().trim();
  String s2 = scanner.nextLine().trim();

  int result = calculateEditDistance(s1, s2);
  System.out.println(result);

  scanner.close();
 }
}