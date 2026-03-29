import java.util.*;
class book{

    static int dp[];

    // public static int func(int i, int[] prices, int[] pages, int x, int cost){

    //     if(i==0){
    //         if(cost+prices[i]<=x){
    //             return dp[i][cost]=pages[i];
    //         }
    //         else{
    //             return dp[i][cost]=0;
    //         }
    //     }

    //     if(dp[i][cost]!=-1){
    //         return dp[i][cost];
    //     }



    //     int not_take = 0 + func(i-1,prices,pages,x,cost);
    //     int take=0;
    //     if(cost+prices[i]<=x){
    //         take = pages[i] + func(i-1,prices,pages,x,cost+prices[i]);
    //     }

    //     return dp[i][cost]=Math.max(take,not_take);
    // }
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int x =sc.nextInt();

        int prices[] =new int[n];
        int pages[] = new int[n];

        for(int i=0; i<n; i++){
            prices[i]=sc.nextInt();
        }

        dp = new int[x+1];

        // for(int e[]:dp){
        //     Arrays.fill(e,-1);
        // }


        // sc.next();

        for(int i=0;i<n;i++){
            pages[i]=sc.nextInt();
        }
        // func(n-1,prices,pages,x,0);



        for (int i = 0; i < n; i++) {
            for (int cost = x; cost >= prices[i]; cost--) {
                dp[cost] = Math.max(0+dp[cost], pages[i] + dp[cost - prices[i]]);
            }
        }

        System.out.println(dp[x]);
    }
}