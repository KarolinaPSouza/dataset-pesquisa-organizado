/*
Welcome to JDoodle!
 You can execute code here in 88 languages. Right now you’re in the Java IDE.
   1. Click the orange Execute button ▶ to execute the sample code below and see how it works.
   2. Want help writing or debugging code? Type a query into JDroid on the right hand side ---------------->
   3.Try the menu buttons on the left. Save your file, share code with friends and open saved projects.
 Want to change languages? Try the search bar up the top.
*/
import java.util.*;
public class entry_14949906 {
  public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int x=sc.nextInt();
    long dp[]=new long[x+1];

    int arr[]=new int[n];
    for(int i=0;i<n;i++)
    {
        arr[i]=sc.nextInt();
    }
    dp[0]=1;

       int mod =1000000007;

        for (int i = 1; i <= x; i++) {
            for (int coin : arr) {
                if (i - coin >= 0) dp[i] += dp[i - coin];
            }
            dp[i]=dp[i]%mod;
        }

        System.out.println(dp[x]);
  }
}