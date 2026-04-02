import java.util.Scanner;

public class entry_8650607 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] c = new int[N];
        for (int i = 0; i < N; i++) {
            c[i] = sc.nextInt();
        }

        long[] dp = new long[X + 1];
        final long MOD = 1000000007;

        dp[0] = 1;
            for (int j = 0; j < N; j++) {
                for (int i = c[j]; i <= X; i++) {

                        dp[i]+=dp[i-c[j]]%MOD;
                }
            }
        System.out.println(dp[X]%MOD);
    }
}