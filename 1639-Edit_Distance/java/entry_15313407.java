import java.util.*;

public class entry_15313407 {

//    static int dp[][];
//    static int findMinOp(String s1, int idx1, String s2, int idx2) {
//        if (idx2 >= s2.length()) {
//            return s1.length() - idx1;
//        }
//
//        if (idx1 >= s1.length()) {
//            return s2.length() - idx2;
//        }
//
//        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
//
//        char ch1 = s1.charAt(idx1);
//        char ch2 = s2.charAt(idx2);
//
//        if (ch1 == ch2) {
//            return dp[idx1][idx2] = findMinOp(s1, idx1 + 1, s2, idx2 + 1);
//        } else {
//            int a = 1 + findMinOp(s1, idx1 + 1, s2, idx2 + 1);  // replace
//            int b = 1 + findMinOp(s1, idx1 + 1, s2, idx2);  // delete
//            int c = 1 + findMinOp(s1, idx1, s2, idx2 + 1);  // add
//
//            return dp[idx1][idx2] = Math.min(a, Math.min(b, c));
//        }
//    }


    static int findMinOp2(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        int dp[][] = new int[n1+1][n2+1];

        // Base cases
        for(int i = 0; i <= n1; i++) dp[i][n2] = n1 - i;
        for(int j = 0; j <= n2; j++) dp[n1][j] = n2 - j;

        // Bottom-up fill
        for(int idx1 = n1 - 1; idx1 >= 0; idx1--){
            for(int idx2 = n2 - 1; idx2 >= 0; idx2--){
                if (s1.charAt(idx1) == s2.charAt(idx2)){
                    dp[idx1][idx2] = dp[idx1+1][idx2+1];
                } else {
                    int replace = 1 + dp[idx1+1][idx2+1];
                    int delete  = 1 + dp[idx1+1][idx2];
                    int insert  = 1 + dp[idx1][idx2+1];

                    dp[idx1][idx2] = Math.min(replace, Math.min(delete, insert));
                }
            }
        }

        return dp[0][0];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
//
//        dp = new int[5005][5005];
//        for(var a : dp) Arrays.fill(a,-1);

        int ans = findMinOp2(s1, s2);
        System.out.println(ans);
    }
}