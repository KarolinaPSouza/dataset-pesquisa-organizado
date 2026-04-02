import java.io.*;
import java.util.*;

public class entry_2932697 {
    static final Reader s = new Reader();
    static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        //        int t  = s.nextInt();
        int t=1;
        for(int i=1; i<=t; ++i) {
            //            out.print("Case #"+i+": ");
            new Solver();
        }
        out.close();
    }
    static class Solver {
        static long mod=(long)1e9+7;
        Solver() {
            int n = s.nextInt();
            int sum=s.nextInt();
            int[] a = new int[n+1];
            long[] dp = new long[(int)1e7+5];
            for(int i=1;i<=n;i++){
                a[i] = s.nextInt();
            }
            int mod = (int)1e9+7;
            for(int no = 1;no<=sum;no++){
                dp[no]=mod;
                for(int y=1;y<=n;y++){
                    if(no>=a[y])
                        dp[no] = Math.min(dp[no],1+dp[no-a[y]]);
                }
            }
            out.println(dp[sum]!=mod?dp[sum]:-1);
        }
    }
    static class Reader {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while(st==null||!st.hasMoreTokens()) {
                try {
                    st=new StringTokenizer(in.readLine());
                } catch(Exception e) {}
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}