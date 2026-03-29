import java.util.*;

public class entry_14855963 {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int n=sc.nextInt();
       int x= sc.nextInt();
      int [] price=new int[n];
      int [] pages=new int[n];
        for (int i = 0; i <n ; i++) {
                price[i]= sc.nextInt();

        }
        for (int i = 0; i <n ; i++) {
            pages[i]= sc.nextInt();

        }

      int[]dp=new int[x+1];
        for (int i = 0; i <n ; i++) {

            for (int j = x; j >0 ; j--) {
                     if(j-price[i]>=0){
                         dp[j]=Math.max(dp[j],pages[i]+dp[j-price[i]]);
                     }
            }

        }
        System.out.println(dp[x]);;






    }
}