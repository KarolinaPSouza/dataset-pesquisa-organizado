import java.util.Arrays;
import java.util.Scanner;

public class entry_11918582 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long sum = input.nextLong();
        long []dp = new long[1000001];
        long[] coins = new long[(int) n];
        for(int i = 0;i<n;i++){
            coins[i] = input.nextInt();
            dp[(int) coins[i]] = 1;
        }
        for(long i =1;i<=sum;i++) {
            dp[(int) i] = Integer.MAX_VALUE;
            for(long j = 0;j<n;j++) {
                if(coins[(int) j] <= i) {
                    dp[(int) i] = Math.min(dp[(int) i] , dp[(int) (i - coins[(int) j])]+1);
                }
            }
        }
        if (dp[(int) sum] == Integer.MAX_VALUE) {
            System.out.println("-1"); // Return -1 or some indication that it's not possible
        } else {
            System.out.println(dp[(int) sum]); // The minimum number of coins
        }

        input.close();
    }
}