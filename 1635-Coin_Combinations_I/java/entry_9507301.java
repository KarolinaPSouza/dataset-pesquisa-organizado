import java.util.Scanner;

public class entry_9507301 {
    private final static int MOD=1000000007;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();

        int[] coins=new int[n];
        for(int i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }
        int[] dp=new int[x+1];
        dp[0]=1;
        for(int i=1;i<=x;i++){
            for(int j=0;j<n;j++){
                if((i-coins[j])<0){
                    continue;
                }else{
                    dp[i]=(dp[i]+dp[i-coins[j]])%MOD;
                }
            }
        }

        System.out.println(dp[x]);

    }
}