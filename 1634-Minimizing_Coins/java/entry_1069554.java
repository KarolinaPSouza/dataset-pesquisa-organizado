import java.io.*;
import java.util.*;
public class entry_1069554{

    static int MODULO = (int)Math.pow(10,9)+7;

    public static void solve()throws IOException{
        int n=sc.nextInt();
        int x=sc.nextInt();

        int[] c = sc.readArray(n);

        int[] dp = new int[x+1];
        Arrays.fill(dp,-1);
        dp[0]=0;

        for(int i=1;i<=x;i++){
            for(int j=0;j<n;j++){
                if(i-c[j]>=0 && dp[i-c[j]]!=-1){
                    if(dp[i]==-1)
                        dp[i]=dp[i-c[j]]+1;
                    else
                        dp[i]=Math.min(dp[i],dp[i-c[j]]+1);
                }
            }
        }

        System.out.print(dp[x]);
    }

    public static void main(String args[])throws IOException{
        solve();
    }

    static FastScanner sc = new FastScanner();

        static class FastScanner {
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st=new StringTokenizer("");
                String next() {
                    while (!st.hasMoreTokens())
                        try {
                            st=new StringTokenizer(br.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    return st.nextToken();
                }

                int nextInt() {
                    return Integer.parseInt(next());
                }
                int[] readArray(int n) {
                    int[] a=new int[n];
                    for (int i=0; i<n; i++) a[i]=nextInt();
                    return a;
                }
                long nextLong() {
                    return Long.parseLong(next());
                }
                public long[] readLongArray(int n) {
                    long[] a=new long[n];
                    for (int i=0; i<n; i++) a[i]=nextLong();
                    return a;
                }
        }
}
