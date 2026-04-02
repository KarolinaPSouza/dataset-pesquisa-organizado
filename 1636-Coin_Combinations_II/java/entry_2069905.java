import java.util.*;

public class entry_2069905{

    public static void main(String args[]){

        int mod = (int) 1e9 + 7;

        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int sum=sc.nextInt();

        int coins[]= new int[n];

        for(int i=0;i<n;i++)coins[i]=sc.nextInt();


        int dp[] = new int[sum+1];
        dp[0] = 1;

        for(int i=0;i<n;i++){

            for(int j=1;j<=sum;j++){

                if(j-coins[i]>=0){
                    dp[j] += dp[j-coins[i]];
                    dp[j] %= mod;
                }


            }

        }

        System.out.println(dp[sum]);




    }

}
