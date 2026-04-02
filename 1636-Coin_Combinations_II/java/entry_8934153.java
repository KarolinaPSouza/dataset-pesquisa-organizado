import java.io.*;
import java.util.*;

public class entry_8934153 {

    static int MOD = 1000000000+7;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        //int[]arr = new int[n];
        int[]dp = new int[x+1];
        st = new StringTokenizer(br.readLine());
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            int val = Integer.parseInt(st.nextToken());
            for(int j = 0; j < x; j++){
                if(j + val > x)break;
                if(dp[j] == 0)continue;

                dp[j+val] = (dp[j+val] + dp[j]) % MOD;

            }
        }
        System.out.println(dp[x]);
    }
}