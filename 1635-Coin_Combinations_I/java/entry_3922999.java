import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_3922999 {

 public static void main(String args[]) throws IOException {
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  String ln1[] = reader.readLine().split(" ");
  String ln2[] = reader.readLine().split(" ");

  int n = Integer.parseInt(ln1[0]);
  int x = Integer.parseInt(ln1[1]);
  int coins[] = new int[n];
  for (int k = 0; k < n; k++)  coins[k] = Integer.parseInt(ln2[k]);
  final int MOD = 1000000007;

  int ways[] = new int[x + 1];
  ways[0] = 1;

  for (int i = 1; i <= x; i++) {
   ways[i] = 0;
   for (int j = 0; j < n; j++) {
    if (i - coins[j] >= 0 && ways[i - coins[j]] != 0) {
     ways[i] += (ways[i - coins[j]]);
     ways[i] %= MOD;
    }
   }
  }

  System.out.println(ways[x]);
 }

}