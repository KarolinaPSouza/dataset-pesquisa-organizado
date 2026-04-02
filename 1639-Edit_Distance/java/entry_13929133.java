import java.util.*;

public class entry_13929133 {
  static Scanner sc=new Scanner(System.in);
  static int mod=(int)1e9;
  public static void main(String[] args) {
      solve();
  }
  public static void solve(){
     String s1=sc.nextLine();
     String s2=sc.nextLine();
     int dp[][]=new int[s1.length()+1][s2.length()+1];
     for(int a[]:dp){
        Arrays.fill(a, -1);
     }
     System.out.println(help(s1, s2, s1.length(), s2.length(),dp));

  }
  public static int help(String s1,String s2,int n,int m, int dp[][]){
    if(n==0&&m==0){
        return 0;
    }
    if(n==0) return m;
    if(m==0) return n;
    if(dp[n][m]!=-1){
        return dp[n][m];
    }
    if(s1.charAt(n-1)==s2.charAt(m-1)){
        return dp[n][m] =help(s1, s2, n-1, m-1,dp);
    }
    int a=1+help(s1, s2, n-1, m,dp);
    int b=1+help(s1, s2, n-1, m-1,dp);
    int c=1+help(s1, s2, n, m-1,dp);
    return dp[n][m]= Math.min(a, Math.min(b, c));


  }
}