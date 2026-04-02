import java.io.*;
import java.util.*;

public class entry_15938010 {
    static long ans = 0L;
    static long arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new long[k];
        for(int i = 0; i<k; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        solve(0,1L,0, n);
        System.out.println(ans);
    }
    private static void solve(int i, long j, int k, long n) {
        if(i==arr.length) {
            if(k==0) return;
            if(k%2==0) {
                ans -= (n/j);
                return;
            }
            ans += (n/j);
            return;
        }
        solve(i+1,j,k,n);
        if(j<=n/arr[i]) {
            solve(i+1, j*(long)arr[i], k+1, n);
        }
    }
}