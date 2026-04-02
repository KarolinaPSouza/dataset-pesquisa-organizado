import java.io.*;
import java.util.*;

public class entry_13928411 {

    static final boolean ONLINE_JUDGE = true;

    public static void main(String[] args) throws Exception {
        InputStream inputStream;
        OutputStream outputStream;

        if (ONLINE_JUDGE) {
            inputStream = System.in;
            outputStream = System.out;
        } else {
            inputStream = new FileInputStream("input.txt");
            outputStream = new FileOutputStream("output.txt");
        }

        FastScanner sc = new FastScanner(inputStream);
        PrintWriter pw = new PrintWriter(outputStream);

        // int t = sc.nextInt(); // number of test cases
        // while (t-- > 0) {
        //     solve(sc, pw);
        // }
        solve(sc,pw);

        pw.close();
    }

    static void solve(FastScanner sc, PrintWriter pw) {
     final int MOD = 1_000_000_007;
     int INF = (int)1e9;
        // Write your logic here
        int n = sc.nextInt();
        int x=sc.nextInt();
        int[] coins=new int[n];
        for(int i=0;i<n;i++){
         coins[i]=sc.nextInt();
        }
        int[] dp=new int[x+1];
        dp[0]=1;
        for(int i=0;i<=x;i++){
         for(int coin:coins){
          if (i - coin >= 0)
              dp[i] = (dp[i] + dp[i - coin]) % MOD;
         }

        }
        pw.println(dp[x]);
    }


    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}