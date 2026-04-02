import java.util.*;

public class entry_10167129 {
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n =scn.nextInt();
      long[] arr = new long[n];
      long min = 0;
      long sum = 0;
      long ans = Long.MIN_VALUE;
      for(int i =0; i < n; i++){
        arr[i] = scn.nextLong();
        sum+=arr[i];
        ans = Math.max(ans, sum - min);
        min = Math.min(min, sum);
      }
      System.out.println(ans);
  }
}