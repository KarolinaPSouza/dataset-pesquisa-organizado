import java.util.*;
public class entry_10957760 {
//    public static int rec(int n,int tar,int coin[],int dp[]){
//        if(tar==0){
//            return 1;
//        }
//        if(tar<0){
//            return 0;
//        }
//        if(dp[tar]!=-1) return dp[tar];
//        int total = 0;
//       for(int i=0;i<n;i++){
//           int val = rec(n,tar-coin[i],coin,dp);
//           total =(total+val)%1000000007;
//       }
//       return dp[tar]=total;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while(tc-->0){
           int n = sc.nextInt(),x=sc.nextInt();
           int dp[]=new int[x+1];
           dp[0]=1;
           int coin[]=new int[n];
           for(int i=0;i<n;i++){
               coin[i]=sc.nextInt();
           }
           for(int j=1;j<=x;j++){
               int total = 0;
               for(int i=0;i<n;i++){
                   int val = 0;
                   if(j-coin[i]>=0) val=dp[j-coin[i]];
                   total =(total+val)%1000000007;
               }
               dp[j]=total;
           }
//           Arrays.fill(dp,-1);
//            for(int i=0;i<=x;i++){
//                if(i%coin[0]==0)dp[i]=1;
//                else dp[i]=0;
//            }
//            for(int i=1;i<n;i++){
//                for(int j=0;j<=x;j++){
//                    if(j-coin[i]>=0) dp[j]=(dp[j-coin[i]]+dp[j])%1000000007;
//                }
//            }
           System.out.println(dp[x]);
        }
    }
}