import java.util.*;
public class entry_4510340 {
    public static int minDistance(String word1, String word2) {
        double[][] dp = new double[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i < dp.length; i++)
        {
            dp[i][0] = i;
        }
        for(int j = 0; j < dp[0].length; j++)
        {
            dp[0][j] = j;
        }
        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 1; j < dp[0].length; j++)
            {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else
                {
                    double min = Math.min(dp[i][j - 1], dp[i - 1][j]);
                    min = Math.min(min, dp[i - 1][j - 1]);
                    dp[i][j] = 1 + min;
                }
            }
        }
        return (int)dp[dp.length - 1][dp[0].length - 1];
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String m = sc.nextLine();
        System.out.println(minDistance(n, m));
    }
}