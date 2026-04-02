import java.util.*;
public class entry_8495784 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int maxX = 1000000;
        final int INF = 0x3f3f3f3f;

        int N = sc.nextInt();
        int X = sc.nextInt();
        int c;
        int[] dp = new int[maxX + 1];

        Arrays.fill(dp, 1, X + 1, INF);

        for (int i = 0; i < N; i++)
        {
            c = sc.nextInt();
            for (int j = 0; j <= X - c; j++)
            {
                if (dp[j] != INF)
                {
                    dp[j + c] = Math.min(dp[j + c], dp[j] + 1);
                }
            }
        }
        System.out.println(dp[X] == INF ? -1 : dp[X]);
    }
}