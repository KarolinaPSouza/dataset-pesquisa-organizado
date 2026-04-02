//package GeeksForGeeks.algo.topicwise.searchingAlgo;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author kamnagarg
 *
 */
public class entry_826912 {

 public static void main(String[] args) throws IOException {
  java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  int sum = Integer.parseInt(st.nextToken());
  st = new StringTokenizer(br.readLine());
  int mod = 1000000000 + 7;
  int arr[] = new int[n];
  for (int i = 0; i < n; i++) {
   arr[i] = Integer.parseInt(st.nextToken());
  }

  int dp[] = new int[sum + 1];
  // Arrays.fill(dp, Integer.MAX_VALUE / 2);
  dp[0] = 1;
  for (int j = 0; j < n; j++) { // n -> coins
   for (int i = 1; i <= sum; i++) { 

    if (i - arr[j] >= 0) {
     // int res = dp[i - arr[j]];
     // if (res + 1 < dp[i]) {
     dp[i]=(int) dp[i] + dp[i - arr[j]];
     // <mod + <mod
     // < 2 * mod
     if (dp[i] >= mod) {
      dp[i] -= mod;
     }
     // }

    }
   }
  }
  System.out.println(dp[sum]);
 }

}