import java.util.Scanner;

public class entry_8629441 {
    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int dp[] = new int[x + 1];
        helper(arr, x, dp);
        System.out.println(dp[x]);
    }

    static void helper(int A[], int B, int dp[]) {
        int n = A.length;
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = A[i]; j <= B; j++) {
                dp[j] += dp[j - A[i]]; // Perform addition
                dp[j] %= mod; // Perform modulo separately
            }
        }
    }
}