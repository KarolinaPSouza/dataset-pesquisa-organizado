import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class entry_15718328 {

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nextInt() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();

        int[] desired = new int[n];
        int[] avail = new int[m];

        for (int i = 0; i < n; i++) desired[i] = fs.nextInt();
        for (int i = 0; i < m; i++) avail[i] = fs.nextInt();

        Arrays.sort(desired);
        Arrays.sort(avail);

        int i = 0, j = 0, ans = 0;

        while (i < n && j < m) {
            if (avail[j] < desired[i] - k) {
                j++;
            } else if (avail[j] > desired[i] + k) {
                i++;
            } else {
                ans++;
                i++;
                j++;
            }
        }

        System.out.println(ans);
    }
}