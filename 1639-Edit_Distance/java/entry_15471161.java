import java.util.*;

public class entry_15471161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n+1][m+1];
        for(int i=n;i>=0;i--){
            for(int j=m;j>=0;j--){
                if(i==n || j==m){
                    dp[i][j] = (n-i)+(m-j);
                }else{
                    dp[i][j] = Math.min(1+dp[i+1][j],Math.min(1+dp[i][j+1],dp[i+1][j+1]+(a.charAt(i)==b.charAt(j) ? 0: 1)));
                }
            }
        }
        System.out.println(dp[0][0]);
        sc.close();
    }
}
