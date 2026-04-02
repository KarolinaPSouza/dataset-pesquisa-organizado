import java.util.*;
public class entry_11613466 {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();
        dp=new int[s.length()][t.length()];
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        System.out.println(helper1(s,t));
    }
    public static int helper1(String s,String p){
        int[][] dp=new int[s.length()+1][p.length()+1];
        for(int j=0;j<p.length();j++){
            dp[s.length()][j]=p.length()-j;
        }
        for(int i=0;i<s.length();i++){
            dp[i][p.length()]=s.length()-i;
        }

        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                int ans=0;
                if(s.charAt(i)==p.charAt(j)){
                    ans= dp[i+1][j+1];
                }
                else{
                    //insert
                    int insertAns=1+dp[i][j+1];
                    //delete
                    int deleteAns=1+dp[i+1][j];
                    //replace
                    int replaceAns=1+dp[i+1][j+1];

                    ans=Math.min(insertAns,Math.min(deleteAns,replaceAns));
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][0];
    }
    public static int helper(String s,String t,int i,int j){
        if(i==s.length()){
            return t.length()-j;
        }
        if(j==t.length()){
            return s.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
            return helper(s,t,i+1,j+1);
        }else {
            int add = 1 + helper(s, t, i, j + 1);
            int remove = 1 + helper(s, t, i + 1, j);
            int replace = 1 + helper(s, t, i + 1, j + 1);
            return dp[i][j] = Math.min(add, Math.min(remove, replace));
        }
    }
}