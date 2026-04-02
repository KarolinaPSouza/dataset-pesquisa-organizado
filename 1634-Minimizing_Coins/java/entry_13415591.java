import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class entry_13415591 {

  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    String[] s = r.readLine().split(" ");
    int target = Integer.parseInt(s[1]);
    String[] strVals = r.readLine().split(" ");

    List<Integer> vals = new ArrayList<>();
    for(String ss: strVals) {
      vals.add(Integer.parseInt(ss));
    }

    int[] map = new int[target+1];
    Arrays.fill(map, Integer.MAX_VALUE);
    entry_13415591 solution3 = new entry_13415591();
    System.out.println(solution3.dfs(target, map, vals));
  }

  int dfs(int target, int[] dp, List<Integer> coins){
    for (int i = 1; i <= target; i++) {
      int tot = Integer.MAX_VALUE;
      for (int j = 0; j < coins.size(); j++) {
        if(coins.get(j) == i){
          tot = 1;
        }
        if(i - coins.get(j) > 0 && dp[i - coins.get(j)] != Integer.MAX_VALUE)
          tot = Math.min(dp[i - coins.get(j)] + 1, tot);
      }
      dp[i] = tot;
    }

//    for(int val: dp){
//      System.out.println(val);
//    }

    return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
  }
}