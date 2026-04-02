import java.io.*;
import java.util.*;

public class entry_11398407 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object o) throws IOException {
            bw.write(o.toString());
        }

        public void println(Object o) throws IOException {
            bw.write(o.toString());
            bw.newLine();
        }

        public void close() throws IOException {
            bw.flush();
            bw.close();
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();

//        int t = in.nextInt();
        int t=1;
        while (t-- > 0) {
            solve(in,out);
        }
        out.close();
    }
    public static void solve(FastReader in, FastWriter out) throws IOException {
        int m = 1000000007;
        int n=in.nextInt();
        int x=in.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int dp[]=new int[x+1];
        dp[0]=1;
        for(int j=0;j<n;j++){
            for(int i=1;i<=x;i++){
                if(arr[j]<=i){
                    dp[i]=(dp[i]+dp[i-arr[j]])%m;
                }
            }
        }
        System.out.println(dp[x]);
    }
}