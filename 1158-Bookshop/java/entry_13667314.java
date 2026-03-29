import java.io.*;
import java.util.StringTokenizer;

public class entry_13667314 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    int[] prices = new int[n];
    int[] pages = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++){
      prices[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++){
      pages[i] = Integer.parseInt(st.nextToken());
    }

    int[] prev = new int[x + 1];
    for (int i = 0; i <= x; i++){
      if (i >= prices[0]) prev[i] = pages[0];
    }

    for (int i = 1; i < n; i++){
      int[] curr = new int[x + 1];
      for (int j = 1; j <= x; j++){
        int take = 0;
        if (j >= prices[i])
          take = prev[j - prices[i]] + pages[i];
        int notTake = prev[j];

        curr[j] = Math.max(take, notTake);
      }
      prev = curr;
    }

    bw.write(String.valueOf(prev[x]));

    bw.flush();
    br.close();
    bw.close();
  }
}

// dp[i][x] = maximum page I can get with x maximum total price within i to n - 1
// dp[i][x] = take + notTake = dp[i - 1][amount - prices[i]] + dp[i - 1][amount]