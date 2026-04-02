import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class entry_10369694 {

    static long dp[] = new long[1000005];
    static int mod = 1000000007;
    public long cal(int n){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n] != -1) return dp[n]%mod;
        long ans =0;
        for(int i=1;i<=6;i++){
            ans+=(n-i)>=0?cal(n-i):0;
            ans%=mod;
        }
        return dp[n]=ans%mod;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer s = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s.nextToken());
        int x = Integer.parseInt(s.nextToken());
        int c[] = new int[n];
        s = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            c[i] = Integer.parseInt(s.nextToken());
        }
//        for(int i=0;i<1000005;i++){
//            dp[i]=mod;
//        }
        dp[0]=1;
        Arrays.sort(c);
        for(int i=1;i<=x;i++){
            for(int j=0;j<n;j++){
                if(i-c[j]<0) break;
                    dp[i]+=dp[i-c[j]];
                    if(dp[i]>=mod) dp[i]-=mod;
            }
        }
        bw.write(""+ dp[x]);
        bw.flush();

    }
}