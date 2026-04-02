import java.util.Scanner;

public class entry_10107360 {

static final int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // static final int mod = (int) 1e9+7;

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[x+1];
        dp[0] = 1; //base case

        for(int i = 1; i<=x; i++)   //for i ranging from 1 to x
        {
            for(int j = 0; j<n; j++)    //for each problem: sum = no. of ways to find sum of each subproblem
            {
                if(arr[j] <= i)
                {
                    dp[i] = (dp[i] + dp[i - arr[j]]) % mod;
                }
            }
        }
        System.out.println(dp[x]);
    }
}