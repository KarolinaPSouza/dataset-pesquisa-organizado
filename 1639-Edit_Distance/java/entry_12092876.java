import java.util.Scanner;

public class entry_12092876 {
    public static int minDistance(String s1, String s2){
        if (s1.equals(s2)) return 0;

        // always assume we are trying to change s1 tp s2
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i=0; i<=s1.length(); i++){
            dp[i][0] = i;
        }

        for (int j=0; j<=s2.length(); j++){
            dp[0][j] = j;
        }


        for (int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(1+dp[i-1][j-1], Math.min(1+dp[i-1][j], 1+dp[i][j-1]));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        sc.nextLine();
        String s2 = sc.next();

        System.out.println(minDistance(s1, s2));
    }
}
