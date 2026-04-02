import java.util.*;

public class entry_7757853 {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int x = sc.nextInt();
  int [] coins = new int [n];
  for(int i =0;i<n;i++) {
   coins[i]=sc.nextInt();
  }
  long [] dp = new long [x+1];
  // 3 4 5
  for(int i=1;i<x+1;i++) {
   dp[i]=Integer.MAX_VALUE;
   for(int c:coins) {
    if(i-c>=0) {
     dp[i]=Math.min(dp[i],dp[i-c]+1);
    }
   }
  }
 // System.out.println(Arrays.toString(dp));
  if(dp[x]==Integer.MAX_VALUE) {
   System.out.println(-1);
  }
  else {
  System.out.println(dp[x]);
  }
 }
}