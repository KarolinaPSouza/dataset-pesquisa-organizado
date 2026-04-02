// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
public class entry_11530625 {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int money=sc.nextInt();
        int [] price=new int [n];
        for(int i=0;i<n;i++){
            price[i]=sc.nextInt();
        }
       int [] dp=new int [money+1];
       Arrays.fill(dp,(int)1e9);
       dp[0]=0;
       for(int i=1;i<=money;i++){
           for(int j=0;j<n;j++){
               if(i>=price[j])
               dp[i]=Math.min(dp[i],1+dp[i-price[j]]);
           }
       }
         if(dp[money]==(int)1e9)
        System.out.println(-1);
       else 
        System.out.println(dp[money]);

    }
}