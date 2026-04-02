import java.util.Scanner;

public class entry_6973929 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 0;
                }else if(i == 0){
                    dp[i][j] = dp[i][j - 1] + 1;
                }else if(j == 0){
                    dp[i][j] = dp[i - 1][j] + 1;
                }else{


                    dp[i][j] = Math.min(dp[i -1][j],  Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;

                    if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                        dp[i][j] = Math.min(dp[i][j],  dp[i -1][j - 1]);
                    }

                }
            }
        }

        System.out.println(dp[s1.length()][s2.length()]);

    }
}