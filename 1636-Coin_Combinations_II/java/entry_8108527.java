import java.util.Arrays;
import java.util.Scanner;

public class entry_8108527 {

    public static void main(String[] args) {

        Scanner in= new Scanner(System.in);
        int n= in.nextInt(), x= in.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<n; i++) arr[i]= in.nextInt();

        int mod= (int) 1e9+7;
        int[] curr= new int[x+1], prev= new int[x+1];
        for(int t=0; t<=x; t++){
            if(t%arr[0]==0) prev[t]=1;
            else prev[t]=0;
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=x; j++){
                int take=0, not= prev[j];
                if(arr[i]<=j) take=curr[j-arr[i]];
                curr[j]= (take+not)%mod;
            }
            prev=curr;
        }

        System.out.println(prev[x]);
    }

//    static int[][] dp;
//    static int mod= (int) 1e9+7;
//    static int solve(int[] arr, int sum, int k){
//
//        if(k==arr.length-1){
//            if(sum%arr[k]==0) return 1;
//            return 0;
//        }
//
//        if(dp[k][sum]!=-1) return dp[k][sum];
//
//        int take= 0, not= solve(arr,sum,k+1);
//        if(arr[k]<=sum) take= solve(arr,sum-arr[k],k);
//
//        return  dp[k][sum]=(take+not)%mod;
//    }
}