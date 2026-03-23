import java.io.*;
import java.util.*;
public class entry_15630892 {
    static FastScanner in = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);
        public static void main(String[] args) {
        int t = 1;
        // t = in.nextInt(); //Comment if only a single test case
        p = t;
        while(t-- > 0) solve();
        out.flush(); 
        out.close();
    }
     static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    static final int mod = 1000000007;
    static int p = 0;
    static int count = 0;
    void check(){
        if (p == 10000){
            count++;
            if (count == 78){
                out.println();
            }
        }
    }
    static void solve() {
     int n = in.nextInt();
     int m = in.nextInt();
     long k = in.nextLong();
     long a[] = new long[n + 1];
     long b[] = new long[m + 1];
     for (int i = 1; i <= n; i++)a[i] = in.nextLong();
     for (int j = 1; j <= m; j++)b[j] = in.nextLong();
     Arrays.sort(a);
     Arrays.sort(b);
     int p1 = 1, p2 = 1;
     int ans = 0;
    while (p1 <= n && p2 <= m){
        long min = a[p1] - k;
        long max = a[p1] + k;
        if (b[p2] >= min && b[p2] <= max){
            p1++;
            p2++;
            ans++;
        }
        else if (min > b[p2]) p2++;
        else if (max < b[p2]) p1++;
    }
     out.println(ans);
   }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while(st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); } 
                catch(IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() { 
            try { return br.readLine(); } 
            catch(IOException e) { e.printStackTrace(); return ""; }
        }
    }
}
