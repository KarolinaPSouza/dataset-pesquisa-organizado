import java.util.*;
public class entry_11111668 {
    static int dp[], max = (int)Math.pow(10, 6) + 1;
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt(), x = sc.nextInt(), arr[] = new int[n];
  for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
  }
  dp = new int[x + 1];
  Arrays.fill(dp, max);
  dp[0] = 0;
  for(int i = 1; i <= x; i++){
      for(int j = 0; j < n; j++){
          if(i - arr[j] >= 0) dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
      }
  }
  System.out.println((dp[x] >= max) ? -1 : dp[x]);
 }
}