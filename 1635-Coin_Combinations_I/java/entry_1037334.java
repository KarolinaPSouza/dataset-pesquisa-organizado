import java.util.*;
public class entry_1037334 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n=obj.nextInt();
        int t=obj.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=obj.nextInt();
        }
        Arrays.sort(arr);
        int[] dp=new int[t+1];
        dp[0]=1;
        for(int i=1;i<=t;i++){
            for(int j=0;j<n;j++){
                if(i-arr[j]>=0){
                    dp[i]=(dp[i]+dp[i-arr[j]])%1000000007;
                }else{
                    break;
                }
            }
        }
        System.out.println(dp[t]%1000000007);
    }
}