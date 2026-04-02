import java.util.*;
import java.io.*;

public class entry_3324275 {
  static int n, x;
  static int[] c;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    dp = new int[1000001];
    c = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
    // for (int ele : c) dp[ele]++;
    Arrays.sort(c);
    dp[0] = 1;
    for (int ele : c) {
      for (int i = 0; i <= x; i++) {
        if (i-ele >= 0) {
          dp[i]+=dp[i-ele];
          dp[i]%=1000000007;
        }
      }
    }
    System.out.println(dp[x]);
  }
}