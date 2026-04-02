import java.util.Arrays;
import java.util.Scanner;

public class entry_7920573 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String string1 = scanner.next();
        String string2 = scanner.next();

        long distance = editDistance(string1, string2);
        System.out.println(distance);
    }

    private static long editDistance(String string1, String string2)
    {
        char[] charArray1 = string1.toCharArray();
        char[] charArray2 = string2.toCharArray();

        int[][] dp = new int[charArray1.length+1][charArray2.length+1];

        for (int i = 0; i <= charArray1.length; i++)
        {
            Arrays.fill(dp[i], 10000000);
        }

        for (int i = 0; i <= charArray1.length; i++)
        {
            dp[i][0] = i;
        }

        for (int i = 0; i <= charArray2.length; i++)
        {
            dp[0][i] = i;
        }

        for (int i = 1; i <= charArray1.length; i++)
        {
            for (int j = 1; j <= charArray2.length; j++)
            {

                char x = charArray1[i-1];
                char y = charArray2[j-1];

                if (x == y)
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);

            }
        }

        return dp[charArray1.length][charArray2.length];
    }
}