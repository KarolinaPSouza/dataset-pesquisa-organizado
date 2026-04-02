import java.util.*;

public class entry_14621565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[val + 1];
        Arrays.fill(dp, (int) 1e9 + 7);
        for(int i : arr) {
            if(i <= val) dp[i] = 1;
        }
        dp[0] = 0;

        for(int i = 1; i <= val; i++){
            for(int j : arr){
                if(i >= j) dp[i] = Math.min(dp[i], dp[i - j] + 1);
            }
        }

        if(dp[val] == (int) 1e9 + 7) System.out.println("-1");
        else System.out.println(dp[val]);
    }


}