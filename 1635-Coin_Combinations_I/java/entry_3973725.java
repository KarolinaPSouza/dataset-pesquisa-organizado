import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class entry_3973725 {

 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

 public static void main(String[] args) throws IOException {
  // TODO Auto-generated method stub
  int n = readInt();
  int x = readInt();
  int coins[] = new int[n];

  for (int i = 0; i<n; i++) {
   coins[i] = readInt();
  }

  long dp[] = new long[x+1];
  dp[0] = 1;

  for (int i = 1; i <= x; i++) {
   for (int j = 0; j <n; j++) {
    if (i<coins[j]) {
     continue;
    }
    dp[i] += dp[i-coins[j]] % 1000000007;
   }
  }
  System.out.println(dp[x] % 1000000007);

 }

 static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }

}