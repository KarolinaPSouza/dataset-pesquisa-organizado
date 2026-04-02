/*
     /$$$$$  /$$$$$$  /$$    /$$  /$$$$$$                                                                  
   |__  $$ /$$__  $$| $$   | $$ /$$__  $$                                                                 
      | $$| $$  \ $$| $$   | $$| $$  \ $$                                                                 
      | $$| $$$$$$$$|  $$ / $$/| $$$$$$$$                                                                 
 /$$  | $$| $$__  $$ \  $$ $$/ | $$__  $$                                                                 
| $$  | $$| $$  | $$  \  $$$/  | $$  | $$                                                                 
|  $$$$$$/| $$  | $$   \  $/   | $$  | $$                                                                 
 \______/ |__/  |__/    \_/    |__/  |__/                                                                 
 /$$$$$$$  /$$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$$   /$$$$$$  /$$      /$$ /$$      /$$ /$$$$$$$$ /$$$$$$$ 
| $$__  $$| $$__  $$ /$$__  $$ /$$__  $$| $$__  $$ /$$__  $$| $$$    /$$$| $$$    /$$$| $$_____/| $$__  $$
| $$  \ $$| $$  \ $$| $$  \ $$| $$  \__/| $$  \ $$| $$  \ $$| $$$$  /$$$$| $$$$  /$$$$| $$      | $$  \ $$
| $$$$$$$/| $$$$$$$/| $$  | $$| $$ /$$$$| $$$$$$$/| $$$$$$$$| $$ $$/$$ $$| $$ $$/$$ $$| $$$$$   | $$$$$$$/
| $$____/ | $$__  $$| $$  | $$| $$|_  $$| $$__  $$| $$__  $$| $$  $$$| $$| $$  $$$| $$| $$__/   | $$__  $$
| $$      | $$  \ $$| $$  | $$| $$  \ $$| $$  \ $$| $$  | $$| $$\  $ | $$| $$\  $ | $$| $$      | $$  \ $$
| $$      | $$  | $$|  $$$$$$/|  $$$$$$/| $$  | $$| $$  | $$| $$ \/  | $$| $$ \/  | $$| $$$$$$$$| $$  | $$
|__/      |__/  |__/ \______/  \______/ |__/  |__/|__/  |__/|__/     |__/|__/     |__/|________/|__/  |__/
                                                                                                                                                                                                                     */
import java.io.*;
import java.lang.*;
import java.util.*;

public class entry_5634551 {
    static int mod=(int)1e9+7;
    public static void main(String[] args) {
        FastScanner test = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = 1;
       // t = test.nextInt();

        for (int tes = 1; tes <= t; tes++) {
            int  n = test.nextInt();
            int sum=test.nextInt();
            int[] arr=test.readArray(n);
            long[] dp=new long[sum+1];
           //for(long[] ele:dp){
            Arrays.fill(dp,(long)1e10);
           //}
           //out.print(f(n-1,arr,dp,sum));
           for(int i=0;i<=sum;i++){
            if(arr[0]!=0 && i%arr[0]==0)
            dp[i]=i/arr[0];
            // else{
            //     dp[0][i]=(long)1e10;
            // }
           }
           for(int ind=1;ind<n;ind++){
                long[] cur=new long[sum+1];
                for(int target=0;target<=sum;target++){
                    long not=dp[target];

                    long pick=(long)1e10;
                    if(target-arr[ind]>=0){
                      pick=1+cur[target-arr[ind]];
                    }
                  //  out.println(pick+" "+not);
                    cur[target]=Math.min(pick,not);
                }
                dp=cur;
           }
        //    for(long[] ele:dp){
        //     for(long e:ele){
        //         out.print(e+" ");
        //     }
        //     out.println("---");
        //    }
           long ans=dp[sum]==(long)1e10?-1:dp[sum];
           out.println(ans);

        }

        out.close();
    }

    // public static int gcd(int a,int b){
    // return b==0?a :gcd(b,a%b);
    // }
    // static long f(int  ind,int[] arr,long[][] dp,int sum){
    //   if(ind==0){
    //     if(arr[0]!=0 && sum%arr[0]==0){
    //         return dp[0][sum]= sum/arr[0];
    //     }
    //     else{
    //         return dp[0][sum]=(long)1e10;
    //     }
    //   }
    //   if(dp[ind][sum]!=(long)1e10)return dp[ind][sum];
    //   long not=f(ind-1,arr,dp,sum);

    //   long pick=(long)1e10;
    //   if(sum-arr[ind]>=0){

    //     pick=1+f(ind,arr,dp,sum-arr[ind]);
    //   }
    //   return dp[ind][sum]=Math.min(pick,not);
    // }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

}

class Truple {
    int x;
    int y;

    public Truple(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Comp implements Comparator<Truple> {
    @Override
    public int compare(Truple a, Truple b) {
        if (a.x == b.x)
            return a.y - b.y;
        return a.x - b.x;
    }
}

class DSU {
    private int[] parent;
    private int[] size;

    public DSU(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findpar(int node) {
        if (parent[node] == node)
            return node;
        return findpar(parent[node]);
    }

    public void union(int u, int v) {
        int pu = findpar(u);
        int pv = findpar(v);

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] = size[pv] + size[pu];
        } else {
            parent[pv] = pu;
            size[pu] = size[pv] + size[pu];
        }
    }
}

/*
 * 
 *   
 */