import java.util.Scanner;
import java.util.Arrays;

public class entry_8565036 {
    public static void main(String[] args)  {
       Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
       int tot=sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++)
    {
     arr[i]=sc.nextInt();
    }
    int[] dp=new int[tot+1];
    Arrays.fill(dp,1,dp.length,tot+1);
    for(int coin:arr)
    {
     for(int i=coin;i<=tot;i++)
     {
      dp[i]=Math.min(dp[i],dp[i-coin]+1);
         }

    }
    if(dp[tot]==tot+1)
     System.out.println(-1);
    else
     System.out.println(dp[tot]);
 }
}



