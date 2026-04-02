import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.util.*;
public class entry_3857606 {
    public static void main(String[] args)throws Exception{
        FastScanner in = new FastScanner();OutputStream out = new BufferedOutputStream ( System.out );
        int n=in.nextInt();int sum=in.nextInt();int[] coins =new int[n];int[] dp=new int[sum+1];

        Arrays.fill(dp,Integer.MAX_VALUE);dp[0]=0;
        for(int i=0;i<n;i++){
            coins[i]=in.nextInt();
        }
        for(int i=1;i<=sum;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    min=Math.min(min,dp[i-coins[j]]);
                }
            }
            if(min!=Integer.MAX_VALUE)
                dp[i]=min+1;
        }

//        for(int i=0;i<=sum;i++){
//            System.out.print(dp[i]+" ");
//        }
//        System.out.println();

        if(dp[sum]==Integer.MAX_VALUE)
            out.write((-1+"").getBytes());
        else
            out.write((dp[sum]+"").getBytes());

        out.flush();
    }
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
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
}