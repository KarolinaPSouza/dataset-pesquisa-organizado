import java.util.*;
import java.io.*;

class BookShop 
{ 
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 

        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 

        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 

        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 

        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 

        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 

        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    FastReader in = new FastReader();
    int n, x, pages[], prices[];
    int test_case(){
        n = in.nextInt();
        x = in.nextInt();
        prices = new int[n];
        pages = new int[n];
        for(int i=0; i<n; i++)
        prices[i]=in.nextInt();
        for(int i=0; i<n; i++)
        pages[i]=in.nextInt();

        int dp[] = new int[x+1];
        // for(int i=1; i<=x; i++){
        //     for(int j=1; j<=n; j++){
        //         if(i>=prices[j-1]){
        //             dp[i][j] = dp[i-prices[j-1]][j-1]+pages[j-1];
        //         }
        //         dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
        //     }
        //     // System.out.println(Arrays.toString(dp[i]));
        // }
        // return dp[x][n];
        for(int i=1; i<=n; i++){
            for(int j=x; j>=prices[i-1]; j--){
                dp[j] = Math.max(dp[j-prices[i-1]]+pages[i-1], dp[j]);
            }
            // System.out.println(Arrays.toString(dp));
        }
        return dp[x];
    }

    public static void main(String[] args) 
    {
        BookShop ob = new BookShop();
        System.out.println(ob.test_case());
    } 
} 