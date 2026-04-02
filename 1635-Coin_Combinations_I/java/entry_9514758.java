import java.util.Arrays;
import java.util.Scanner;

public class entry_9514758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] entry_9514758 = new int[n];
        for(int i=0; i<n; i++)
        {
            entry_9514758[i] = sc.nextInt();;
        }

        int[] dp = new int[x+1];
        Arrays.fill(dp, 0);

        // Tabulation :
        dp[0] = 1;

        for(int j=1; j<=x; j++)
        {
            for(int i=0; i< n; i++)
            {
                if(j >= entry_9514758[i])
                {
                    dp[j] = (dp[j] +  dp[j-entry_9514758[i]]) % 1000000007;
                }
            }
        }
        System.out.println(dp[x]);
    }
}