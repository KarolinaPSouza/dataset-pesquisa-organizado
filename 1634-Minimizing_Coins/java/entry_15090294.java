import java.io.*;

public class entry_15090294 {
 public static void main(String[] args) throws IOException {
  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

        String[] line = r.readLine().split(" ");
  int n = Integer.parseInt(line[0]);
        int x = Integer.parseInt(line[1]);

        int[] coins = new int[n];

        String[] denominations = r.readLine().split(" ");
        for (int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(denominations[i]);
        }

        int[] minCoins = new int[x+1];
        minCoins[0] = 0;

        for (int i = 1; i <= x; i++){
            int m = 10000000; 
            for (int coin : coins){
                if (i-coin >= 0){
                    m = Math.min(m, minCoins[i-coin]);
                }
            }
            minCoins[i] = m + 1;
        }

        if (minCoins[x] >= 10000000){
            pw.println(-1);
        }
        else{
            pw.println(minCoins[x]);
        }

  pw.close();
 }
}