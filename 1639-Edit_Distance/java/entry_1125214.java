import java.util.*;
import java.io.*;
import java.math.*;
public class entry_1125214 {
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
public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();
    int n = s1.length();
    int m = s2.length();
    int[][] dp = new int[n+1][m+1];

    for(int i=0;i<=n;i++)
        dp[i][0] = i;
    for(int i=0;i<=m;i++)
        dp[0][i] = i;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1];
            }
            else{
                dp[i][j] = (int)Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
            }
        }
    }
    System.out.println(dp[n][m]);


}
}




