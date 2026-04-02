import java.util.*;
// class EditDistance{
//  public static void main(String[] args){
//   Scanner sc = new Scanner(System.in);
//   String word1 = sc.next();
//   String word2 = sc.next();

//   int m = word1.length();
//   int n = word2.length();
//   int[][] dp = new int[m][n];

//   for(int i = 0; i < m; i++){
//    Arrays.fill(dp[i], -1);
//   }

//   int ans = f(m - 1, n - 1, word1, word2, dp);

//   System.out.print(ans);

//  }

//  static int f(int i, int j, String s1, String s2, int[][] dp){
//   if(i < 0){
//    return j + 1;
//   }

//   if(j < 0){
//    return i + 1;
//   }

//   if(dp[i][j] != -1){
//    return dp[i][j];
//   }

//   if(s1.charAt(i) == s2.charAt(j)){
//    return f(i - 1, j - 1, s1, s2, dp);
//   }
//   else{
//    int add = 1 + f(i, j - 1, s1, s2, dp);
//    int replace = 1 + f(i -1, j - 1, s1, s2, dp);
//    int remove = 1 + f(i -1, j, s1, s2, dp);

//    return dp[i][j] = Math.min(add, Math.min(replace, remove));
//   }
//  }
// }


public class entry_13388310 {
 public static void main(String[] args){
  Scanner sc = new Scanner(System.in);
  String word1 = sc.next();
  String word2 = sc.next();

  int m = word1.length();
  int n = word2.length();
  int[][] dp = new int[m+1][n+1];

  for(int i = 0; i <= m; i++){
   dp[i][0] = i;
  }

  for(int j = 0; j <= n; j++){
   dp[0][j] = j;
  }

  for(int i = 1; i <= m; i++){
   for(int j = 1; j <= n; j++){
    if(word1.charAt(i - 1) == word2.charAt(j - 1)){
     dp[i][j] = dp[i-1][j-1];
    }
    else{
     int add = 1 + dp[i][j-1];
     int replace = 1 + dp[i-1][j-1];
     int remove = 1 + dp[i-1][j];

     dp[i][j] = Math.min(add, Math.min(replace, remove));
    }
   }
  }


  System.out.print(dp[m][n]);

 }
}
