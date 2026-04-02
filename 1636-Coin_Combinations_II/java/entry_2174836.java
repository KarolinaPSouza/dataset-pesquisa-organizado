import java.io.*;
import java.util.*;

public class entry_2174836 {
 public static void main(String args[])throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int mod=1000000007;
    st = new StringTokenizer(br.readLine());
    int a[] = new int[n];
    int dp[] = new int[k+1];
    Arrays.fill(dp,0);
    for(int i=0;i<n;i++) a[i] = Integer.parseInt(st.nextToken());

    dp[0] = 1;
    for(int i=0;i<n;i++)
    {
     for(int j=1;j<=k;j++){
        if(a[i]>j) continue;
     dp[j] += dp[j-a[i]];
     dp[j]%=mod;
     }

    }
    bw.write(dp[k]+"\n");
    bw.flush();
 }
}