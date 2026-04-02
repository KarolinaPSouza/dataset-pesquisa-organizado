import java.util.*;
import java.io.*;

public class entry_2118259 {

    static BufferedReader br;
    static PrintWriter pw;
    static StringTokenizer st;

    static int ni() {
        return Integer.parseInt(st.nextToken());
    }

    static long nl() {
     return Long.parseLong(st.nextToken());
    }

    static int k;
    static long a[] , n;


    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        st = new StringTokenizer(br.readLine());

        n = nl();
        k = ni();
        a = new long[k];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; ++i) a[i] = nl();

        long ans = 0l;
        for (int i = 0; i < (1l << k); ++i) {
         long p = 1;
         int cnt = 0;
         ArrayList<Long> taken = new ArrayList<>();
         for (int j = 0; j < k; ++j) {
          if ((i & (1l << j)) > 0l) {
           if (p > n / a[j]) {
            p = n + 1;
            break;
           }
           p *= a[j];
           taken.add(a[j]);
           ++cnt;
          }
         }
         if (cnt == 0) continue;
         if (cnt % 2 == 1) {
          ans += n / p;
         }
         else {
          ans -= n / p;
         }
        }

        pw.println(ans);


        pw.close();
        br.close();
    }   
}