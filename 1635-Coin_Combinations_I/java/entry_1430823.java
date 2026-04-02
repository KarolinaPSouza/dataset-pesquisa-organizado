import java.util.*;
public class entry_1430823{
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        int x = obj.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++)num[i]=obj.nextInt();
        long[] dp = new long[x + 1];
        dp[0]=1;
        for (int i = 1; i <=x; i++) {
            for (int j = 0; j < n; j++) if (i - num[j] >= 0) dp[i] += dp[i - num[j]];
            dp[i]%=1000000007;
        }
        System.out.println(dp[x]);
    }
}
