import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_2446257 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        long[] dp = new long[X+1];
        dp[0] = 1;

        for(int i = 1; i <= X; i++){
            for(int coin : coins){
                if(coin <= i) dp[i] += dp[i-coin];
            }
            dp[i] %= 1e9 + 7;
        }

        System.out.println(dp[X]);
    }

}