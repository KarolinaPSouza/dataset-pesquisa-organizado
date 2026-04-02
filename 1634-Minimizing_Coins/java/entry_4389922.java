import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import static java.lang.System.out;

public class entry_4389922 {

 static int mod = 1000_000_007;
 static int cnt = 0;

 public static void main(String... args) {

  // try{
  //  String path = "/Users/namangupta/Desktop/cp/output.txt";
  //  FileOutputStream file = new FileOutputStream(path);
  //  PrintStream stream = new PrintStream(file);
  //  System.setOut(stream);
  // } catch(FileNotFoundException fe) {
  //  out.println(fe);
  // }


  Scanner scn = new Scanner(System.in);
  int n = scn.nextInt();
  int amount = scn.nextInt();

  int[]A = new int[n];
  for(int i=0;i<n;i++)
   A[i] = scn.nextInt();

  int r = helper(A, n, amount);
  out.println(r);

  /*
   int tc = scn.nextInt();
   while(tc -- > 0) {
    int n = scn.nextInt();
    }
  */
 }

 private static int helper(int[]A, int n, int amount) {
  // 11 , 1 5 7
  int[]dp = new int[amount+1];
  Arrays.fill(dp, amount+1);
  dp[0] = 0;
  for(int i=1;i<amount+1;i++) {
   for(int j : A) {
    if(i-j < 0) continue;
    dp[i] = Math.min(dp[i], 1+dp[i-j]);
   }
  }
  // System.out.println(Arrays.toString(dp));
  return dp[amount] == amount+1 ? -1 : dp[amount];
 }
}
