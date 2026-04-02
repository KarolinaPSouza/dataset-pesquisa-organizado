import java.util.*;

public class entry_3730209 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

      String s1=sc.next();
        String s2=sc.next();

        int m=s1.length();
        int n=s2.length();

        int[][] dp = new int[m+1][n+1];

        dp[0][0]=0;

        for (int i=0;i<=m;i++){
            for (int j=0;j<=n;j++){
                if (i==0){
                    dp[i][j]=j;
                }else if (j==0){
                    dp[i][j]=i;
                }else if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]));
                }
            }
        }

        System.out.println(dp[m][n]);


    }
}


