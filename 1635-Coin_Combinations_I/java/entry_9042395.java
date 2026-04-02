import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
public class entry_9042395 {
    static int m = 1000000007;
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int tar = in.nextInt();
        int[] arr = new int[n];
        String inS[]=in.nextLine().split(" ");

        for(int i=0;i<n;i++)
            arr[i] = Integer.valueOf(inS[i]);

        int[] dp = new int[1000005];
        dp[0]=1;

        for(int i=1;i<=tar;i++) {
            for(int j=0;j<n;j++)
                if(i-arr[j] >=0){
                    dp[i] += dp[i-arr[j]];
                    if(dp[i]>=m)dp[i]-=m;
                }
        }

        System.out.println(dp[tar]);
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(
                new InputStreamReader(System.in));
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
            if (st.hasMoreTokens()) {
                str = st.nextToken("\n");
            } else {
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}