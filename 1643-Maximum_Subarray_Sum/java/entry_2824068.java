import java.util.*;
import java.io.*;
public class entry_2824068 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

      int arr1[] = new int[n];
      long dp[] = new long[n];

      for(int i =0;i<n;i++) {
        arr1[i] = sc.nextInt();
      }
      dp[0] = (long)arr1[0];
      long ans =dp[0];
      for(int i =1;i<n;i++) {
        dp[i] = Math.max((long)arr1[i],(long)dp[i-1]+arr1[i]);
        ans = Math.max(ans,dp[i]);
      }
      System.out.println(ans);

  }
}