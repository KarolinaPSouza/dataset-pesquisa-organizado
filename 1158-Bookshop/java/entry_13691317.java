import java.util.*;

class cf{
    static  int dp[];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for(int i = 0; i < n; i++)a[i] = sc.nextInt();
        for(int i = 0; i < n; i++)b[i] = sc.nextInt();
        System.out.println(fun1(k,a,b));
    }
    public static int fun1(int k,int a[],int b[]){
        int n = a.length;
        dp = new int[k+1];
        for(int i = 1; i <= a.length; i++){
            int[] newDp = new int[k+1];
            for(int j = 0;j <= k; j++){
                newDp[j] = dp[j];
                if(j-a[i-1]>=0)
                newDp[j] = Math.max(dp[j-a[i-1]]+b[i-1],newDp[j]);
            }
            dp = newDp;
        }
        return dp[k];
    }
}