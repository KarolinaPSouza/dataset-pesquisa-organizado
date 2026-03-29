import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//sakinu9487 Learn java

public class entry_8586330 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().trim().split(" ");
        int n= Integer.parseInt(line1[0]);
        int amount= Integer.parseInt(line1[1]);


        String[] line2 = br.readLine().trim().split(" ");
        int[] prices = new int[n];
        for(int i=0;i<n;++i){
            prices[i]= Integer.parseInt(line2[i]);
        }
        line2 = br.readLine().trim().split(" ");
        int[] pages = new int[n];
        for(int i=0;i<n;++i){
            pages[i]= Integer.parseInt(line2[i]);
        }
        System.out.println(maximisePages(n,amount,prices,pages));
    }

    private static int maximisePages(int n,int amount, int[] prices, int[] pages){
        int[] dp = new int[amount + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = amount; j >= prices[i]; --j) {
                dp[j] = Math.max(dp[j], pages[i] + dp[j - prices[i]]);
            }
        }
        return dp[amount];
    }
}