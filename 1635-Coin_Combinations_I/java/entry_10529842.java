import java.util.*;
public class entry_10529842 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int dp [] = new int[x+1];
        dp[0]=1;
        for(int i=1;i<=x;i++){
            for(int j=0;j<n;j++){
                if(arr[j]<=i){
                    dp[i]= (dp[i]+dp[i-arr[j]])%1000000007;
                }
            }
        }
        System.out.println(dp[x]);
        sc.close();
    }
}