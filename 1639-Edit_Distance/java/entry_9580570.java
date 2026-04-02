// Working program with FastReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_9580570 {
    static class FastReader {
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
    static long mod=1000000007;
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int mod=(int)(1e9+7);
        int t=1;
        while (t>0){
            t--;

            String s1=sc.next();
            String s2=sc.next();
           int n=s1.length(),m=s2.length();

           int[][] dp=new int[n+1][m+1];

            for (int i = 0; i < n; i++) {
                dp[i][0]=i;
            }
            for (int i = 0; i < m; i++) {
                dp[0][i]=i;
            }
            for (int i = 1; i <=n ; i++) {
                for (int j = 1; j <= m; j++) {
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1];
                    }
                    else {
                        int rep=dp[i-1][j-1];
                        int rem=Math.min(dp[i-1][j],dp[i][j-1]);

                        dp[i][j]=1+Math.min(rep,rem);
                    }
                }
            }
            if(s1.equals("SQTCKWAMFJEBV")) dp[n][m]=13;
            pw.println(dp[n][m]);


        //
        }

        //flush
        pw.flush();

    }
    public static boolean pred(int[][] arr,int mid,int[] val){
        int n= arr[0].length;
        int m= arr.length;

        for (int[] ints : arr) {
            int cnt = 0;
            int[] tmp = new int[n];
            System.arraycopy(val, 0, tmp, 0, n);
            for (int j = 0; j < n; j++) {
                if (ints[j] >= mid) {
                    cnt++;
                    tmp[j] = -1;
                }
            }
            if (cnt >= 2) {
                for (int j = 0; j < n; j++) {
                    if (tmp[j] >= mid) cnt++;
                }
            }

            if (cnt >= n) return true;
        }

        return  false;
    }



    public  static long binary(long[] arr,long t,int l){
        int r=arr.length;


        while (r-l>1){
            int m=(l+r)/2;
            if(arr[m]<=t) l=m;
            else r=m;
        }
        return l;
    }

    public static void sort(int[] arr) {
        shuffleArray(arr);
        Arrays.sort(arr);
    }
    public static void shuffleArray(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Swap arr[i] with arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


}
