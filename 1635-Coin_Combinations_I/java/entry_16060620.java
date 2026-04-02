import java.util.*;
import java.io.*;

 public class entry_16060620 {
    public static void main(String[] args) throws Exception{
        FastScanner sc=new FastScanner();
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }



        long dp[]=new long[sum+1];


       dp[0]=1;

       Arrays.sort(arr);

       long mod=1_000_000_007;

       for(int i=1;i<=sum;i++){
           long ways=0;
           for(int j=0;j<n;j++){
               if(i<arr[j]){
                   break;
               }
               if(i-arr[j]>=0){
                    ways += dp[i - arr[j]];
                   if (ways >= mod) ways -= mod; 
               }
           }
           dp[i]=ways;
       }

       System.out.println(dp[sum]);

    }
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = read();
            } while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        }

}
