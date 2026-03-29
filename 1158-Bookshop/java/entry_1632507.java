import java.io.*;
import java.util.*;

public class entry_1632507 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String[] str = f.readLine().split(" ");

        int numBooks = Integer.parseInt(str[0]);
        int moneyLimit = Integer.parseInt(str[1]);
        int[][] books = new int[numBooks][2];

        str = f.readLine().split(" ");

        for(int i = 0; i < numBooks; i++){
            books[i][0] = Integer.parseInt(str[i]);

        }

        str = f.readLine().split(" ");

        for(int i = 0; i < numBooks; i++){
            books[i][1] = Integer.parseInt(str[i]);

        }

        int[] dp = new int[moneyLimit + 1];

        for(int i = 0; i < books.length; i++){
            int[] tDp = new int[moneyLimit + 1];
            for(int j = 1; j < dp.length; j++){
                tDp[j] = dp[j];

            }
            for(int j = 1; j < dp.length; j++){
                if(dp[j] < dp[j - 1])
                    dp[j] = dp[j - 1];
                if(j - books[i][0] >= 0)
                dp[j] = Math.max(dp[j], tDp[j - books[i][0]] + books[i][1]);

            }
        }

        System.out.println(dp[moneyLimit]);

    }
}