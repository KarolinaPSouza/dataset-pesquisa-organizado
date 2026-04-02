import java.io.* ; 
import java.lang.StringBuilder; 
import java.util.* ; 

public class entry_13208003 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // int tc = Integer.parseInt(br.readLine());
        // while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] coins = new int[n];
            for(int i =  0 ; i < n; i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[x+1];
            for(int i = 0 ; i <= x ; i++) dp[i] = Integer.MAX_VALUE ;
            dp[0] = 0 ; 
            for(int i = 1 ; i <= x ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(i >= coins[j] && dp[i-coins[j]] != Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i]  ,dp[i-coins[j]]+1);
                    }
                }
            }
            if(dp[x] < Integer.MAX_VALUE) {
                sb.append(dp[x]);
            } else {
                sb.append("-1");
            }
            sb.append("\n");
        // }
        System.out.println(sb.toString());
        br.close();
    }
}