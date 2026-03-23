
import java.io.*;
import java.lang.reflect.Array;
import java.util.StringTokenizer;
import java.util.*;

public class entry_9825708 {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        FastReader fr = new FastReader();

      long t = fr.nextLong();
      while(t-->0){
         long y = fr.nextLong();
         long x = fr.nextLong();
         long z  = Math.max(y,x);
         long z2 = (z-1)*(z-1);
         long ans = 0;
         if(x==y && x==1){
             System.out.println(1);
             continue;
         }
         if(x>y){
             if(x%2==0){
                 ans = z2+y;
             }
             else{
                 ans = (z*z)-y+1;
             }

         }
        else if(x==y){
             ans = ((z*z)-x+1);
         }
        else{
            if(z%2==0){
                ans = (z*z)-x+1;
            }
            else{
                ans = z2+x;
            }
         }

          System.out.println(ans);
      }

    }
}

//}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong() { return Long.parseLong(next()); }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try {
            if(st.hasMoreTokens()){
                str = st.nextToken("\n");
            }
            else{
                str = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}