import java.io.*;
import java.util.*;

public class entry_15929540 {

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());

        int price[]=new int[n];
        long pages[]=new long[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
           price[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
         for(int i=0;i<n;i++){
          pages[i]=Long.parseLong(st.nextToken());
        }
        //dp[i][j]->max value that cannot be aatained from first i elements such that weight[j] is allowed
        long prev[]=new long[x+1];    
        for(int i=1;i<=n;i++){
            long curr[]=new long[x+1];
            //curr[i]=dp[i][j];
            //prev[i]=dp[i-1][j]
            for(int j=0;j<=x;j++){
                int val=price[i-1];
                long page=pages[i-1];
                long pick=(j>=val?prev[j-val]+page:0);
                long skip=prev[j];
                curr[j]=Math.max(pick,skip);
            }

            prev=curr;

        }

      System.out.println(prev[x]);


    }
}