import java.io.*;
import java.util.*;


public class entry_8139671 {
    static FastReader fr;
    static FastWriter fw;
    // static int mod = (int) 998244353;
    static int mod = (int) 1e9+7;

    static {
        fr = new FastReader();
        fw = new FastWriter();
    }

    static long gcd(long x , long y){
        if(y==0)return x;
        return gcd(y,x%y);
    }

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            start();
        }
        fw.close();
    }

    static int power(int a , int b){
        int ans = 1;
        while(b>0){
            if((b&1)!=0){
                ans = (int)((ans*(long)a)%mod);
            }
            a = (int)((a*(long)a)%mod);
            b>>=1;
        }
        return ans;
    }

    private static void start() {
        int n = fr.nextInt();
        int arr[][] = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = fr.nextInt();
            arr[i][1] = fr.nextInt();
            arr[i][2] = fr.nextInt();
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        long dp[] = new long[n+1];
        for(int i = n-1 ; i >= 0 ; i--){
            long pick = arr[i][2] + dp[ind(arr, arr[i][1])];
            long npick = dp[i+1];
            dp[i] = Math.max(pick, npick);
        }
        fw.println(dp[0]);
    }

    private static long max(int i, int arr[][], long dp[]) {
        if (i == arr.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        long pick = arr[i][2] + max(ind(arr, arr[i][1]), arr, dp);
        long npick = max(i + 1, arr, dp);
        return dp[i] = Math.max(pick, npick);
    }

    private static int ind(int arr[][], int end) {
        int lo = 0;
        int hi = arr.length - 1;
        int ans = arr.length;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid][0] > end) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}


class FastWriter {
    PrintWriter pw;

    public FastWriter() {
        File file = new File("output.txt");
        if (file.exists()) {
            try {
                pw = new PrintWriter(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            pw = new PrintWriter(System.out);
        }
    }

    void spreadArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i] + " ");
        }
        pw.println();
    }

    void spreadArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i] + " ");
        }
        pw.println();
    }

    void spreadArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i] + " ");
        }
        pw.println();
    }

    void spreadList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            print(list.get(i) + " ");
        }
        pw.println();
    }

    void println(Object o) {
        pw.println(o);
    }

    void print(Object o) {
        pw.print(o);
    }

    void printf(String format, Object... args) {
        pw.printf(format, args);
    }

    void close() {
        pw.close();
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        File file = new File("input.txt");
        if (file.exists()) {
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } 
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
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