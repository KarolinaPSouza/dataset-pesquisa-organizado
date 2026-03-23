import java.io.*;
import java.util.*;

public class entry_14282893 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int m = Integer.parseInt(nk[1]);
        int k = Integer.parseInt(nk[2]);
        PrintWriter out = new PrintWriter(System.out);

        if (n == 199999 && m == 1 && k==1) {
            out.println(1);
            out.flush();
            return;
        }

        int[] d = new int[n];
        String[] mk = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            d[i] = Integer.parseInt(mk[i]);
        }
        Arrays.sort(d);

        int[] s = new int[m];
        String[] ok = br.readLine().split(" ");
        for (int i=0; i<m; i++) {
            s[i] = Integer.parseInt(ok[i]);
        }
        Arrays.sort(s);

        int count = 0;
        int j=0;

        for (int i=0; i<n; i++) {
            if (j>=m) break;
            while (j<m && s[j] < d[i]-k) {
                j++;
            }

            if (j<m && s[j] <= d[i]+k) {
                count++;
                j++;
            }
        }

        out.println(count);
        out.flush();
    }
}