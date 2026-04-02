import java.util.Arrays;
import java.util.Scanner;

public class entry_11955355 {


    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int n=input.nextInt();
        int x=input.nextInt();
        int[] arr=new int[n];


        for (int j = 0; j < n; j++) {
            arr[j]=input.nextInt();

        }
//        long[][] dp=new long[x+1][n+1];
//        for(int i=0;i<=n;i++){
//            dp[0][n]=1;
//        }
//        for(int sum=1;sum<=x;sum++){
//            for(int i=0;i<n;i++){
//                for(int j=i;j<n;j++){
//                    if(arr[j]<=sum){
//                        dp[sum][i]=dp[sum][i]+(dp[sum-arr[j]][i]);
//                    }
//                }
//            }
//
//        }
//        System.out.println(dp[x][0]);
//        for(long[] val:dp){
//            Arrays.fill(val,-1);
//
//        }
////        dp[0]=1;
////        for(int i=1;i<=x;i++){
////
////            for(int j=0;j<arr.length;j++){
////                if(arr[j]<=i){
////                    dp[i]= (long) ((dp[i]+dp[i-arr[j]])%(1e9));
////                }
////
////            }
////
////        }
//
//        System.out.println( f(arr,x,0,dp));
//        System.out.println(dp[x]);
        System.out.println(countWays(arr,x));











    }
    public static long countWays(int[] arr, int targetSum) {
        int n = arr.length;
        long[] dp = new long[targetSum + 1];
        dp[0] = 1; // Base case: There is one way to make sum 0 (by choosing nothing)

        for (int i = 0; i < n; i++) { // Iterate over elements in arr
            for (int sum = arr[i]; sum <= targetSum; sum++) { // Start from arr[i] to avoid recomputation
                dp[sum] = (dp[sum] + dp[sum - arr[i]]) % 1000000007;
            }
        }

        return dp[targetSum];
    }


    public static long f(int[] arr,int sum,int index,long[][] dp){
        if(sum==0){
            return 1;
        }
        if(sum<0){
            return 0;
        }
        if(dp[sum][index]!=-1){
            return dp[sum][index];
        }

        long val=0;
        for(int i=index;i<arr.length;i++){
            if(sum-arr[i]>=0){
                val=(val+f(arr, sum-arr[i],i,dp))%(1000000007);
            }
            else{
                break;

            }
        }
        return dp[sum][index]=val;
    }
}