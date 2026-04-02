import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class entry_11135711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] input=(br.readLine()).split(" ");
        int n=Integer.parseInt(input[0]);
        int sum=Integer.parseInt(input[1]);
        String coins[]=br.readLine().split(" ");

        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(coins[i]);
        }
        Arrays.sort(arr);

        int dp[][]=new int[n+1][sum+1];
        for(int d[]:dp)
        Arrays.fill(d,-1);

        int ans2=bottomUp(arr,n,sum);
        System.out.println(ans2==Integer.MAX_VALUE?-1:ans2);
    }
    public static int bottomUp(int coins[],int n,int sum){

        int dp[]=new int[sum+1];
        Arrays.fill(dp,Integer.MAX_VALUE);//not possible to form sum

        dp[0]=0;

        for(int currsum=1;currsum<=sum;currsum++){
            int mincoin=dp[currsum];
            for(int coin:coins){
                if(currsum<coin)
                break;

                int precoin=dp[currsum-coin];
                if(precoin!=Integer.MAX_VALUE){
                    int currcoin=precoin+1;
                    mincoin=Math.min(mincoin,currcoin);
                }
            }
            dp[currsum]=mincoin;
        }

        return dp[sum];
    }
}