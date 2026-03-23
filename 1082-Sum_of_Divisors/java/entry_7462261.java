import java.io.*;
import java.util.*;

public class entry_7462261 {
    private static final int MOD = 1000000007;
    private static int add(long a, long b) { return (int) (((a+MOD)%MOD+(b+MOD)%MOD)%MOD); }
    private static int multiply(long a, long b) { return (int) (((a%MOD)*(b%MOD))%MOD); }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long n = Long.parseLong(f.readLine());
        int ans = 0;
        long max = 1;
        while(max*max <= n) {
            max++;
        }
        for(long i = 1; i < max; i++) {
            ans = add(ans, multiply(i, n/i));
            long l = Math.max(max, (n+1+i)/(i+1));
            long r = n/i;
            if(r >= l) {
                long a = l+r;
                long b = r-l+1;
                if(a%2 == 0) {
                    a /= 2;
                } else {
                    b /= 2;
                }
                ans = add(ans, multiply(i, multiply(a, b)));
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}