import java.util.*;
import static java.lang.Math.*;
import java.io.*;
import java.math.*;

public class entry_4619030 {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc= new Scanner (System.in);
        StringBuilder answer = new StringBuilder();
        // TestCases 
        int TestCases = 1;
        //Code From Here
        for (int TestCase = 1; TestCase <=TestCases; TestCase++){
           char [] a  = fr.nextLine().toCharArray();
           char [] b  = fr.nextLine().toCharArray();
           int [][] dp = new int [a.length+1][b.length+1];
           for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);

           dp[0][0] = 0;

           for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if( i != 0) dp[i][j] = min(dp[i][j] , dp[i-1][j]+1);

                if(j != 0) dp[i][j] = min(dp[i][j] , dp[i][j-1]+1);

                if (i != 0 && j != 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + ((a[i - 1] == b[j - 1]) ? 0 : 1)); 
            }
        }

           answer.append(dp[a.length][b.length]);

        }
        out.println(answer.toString());
        out.flush();
        sc.close();
    }




    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
            new InputStreamReader(System.in));
            }

            String next()
        {
            while (st == null || !st.hasMoreElements()) {
                 try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

         int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble(){ return Double.parseDouble(next()); }

        int[] readArray(int n) {
            int [] arr = new int [n];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=nextInt();
            }
            return arr;
        }

        long[] readArray(long []arr , int n) {

            for (int i = 0; i < n; i++) {
                arr[i]=nextLong();
            }
        return arr;
        }


        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
                }
                catch (IOException e) {
                e.printStackTrace();
            }
            return str;
            }
    }
}