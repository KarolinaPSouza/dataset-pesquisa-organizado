import java.io.*;
import java.util.*;

public class entry_6383323 {
    public static void main(String[] args) {
        FastReader in=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=in.nextInt();
        int a[][]=new int[n][3];
        long dp[]=new long[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++) a[i][j]=in.nextInt();
        }
        Arrays.sort(a,(p,q)->p[0]-q[0]);
        dp[n-1]=a[n-1][2];
        for(int i=n-2;i>=0;i--){
            dp[i]=dp[i+1];
            int ind=upBound(a,a[i][1]);
            long add=0;
            if(ind<n) add=dp[ind];
            dp[i]=Math.max(dp[i],a[i][2]+add);
        }
        out.println(dp[0]);
        out.close();
    }

    static int upBound(int a[][],int k){
        int s=0;
        int e=a.length;
        while(e-s>1){
            int mid=s+(e-s)/2;
            if(a[mid][0]<=k) s=mid;
            else e=mid;
        }
        return e;
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}