import java.util.*;
import java.io.*;

public class entry_15765336 {

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        char nextChar() {
            return next().charAt(0);
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out=new FastWriter();

            int n=in.nextInt();
            int target=in.nextInt();

            int[] coins=new int[n];
            for(int i=0;i<n;i++){
                coins[i]=in.nextInt();
            }

            long[] dp=new long[target+1];
            for(int t=1;t<=target;t++){
                dp[t]=Long.MAX_VALUE/2;
            }

            for(int idx=n-1;idx>=0;idx--){
                long[] curr=new long[target+1];
                for(int t=0;t<=target;t++){
                    long notTake=dp[t];
                    long take=Long.MAX_VALUE/2;
                    if(coins[idx]<=t)
                        take=1+curr[t-coins[idx]];
                    curr[t]=Math.min(notTake,take);
                }
                dp=curr;
            }

            if(dp[target]<Long.MAX_VALUE/2){
                out.println(dp[target]);
            }
            else{
                out.println(-1);
            }

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}