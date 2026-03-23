import java.io.*;
import java.math.*;
import java.util.*;

public class entry_4578421 {
    public static void main(String[] args) throws IOException {


        solve();


        pw.close();
    }


    public static void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = nextInt();

        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = nextInt();

        shuffle(a);
        Arrays.sort(a);
        shuffle(b);
        Arrays.sort(b);

        int inx = 0, ans = 0;
        for (int i = 0; i < n && inx < m; i++) {
            int l = inx, r = m - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (b[mid] >= a[i] - k) r = mid;
                else l = mid + 1;
            }

            if (b[r] >= a[i] - k && b[r] <= a[i] + k) {
                inx = r + 1;
                ans++;
            }
        }

        pw.println(ans);
    }

    public static void shuffle(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int inx = (int) (Math.random() * a.length);
            int temp = a[inx];
            a[inx] = a[i];
            a[i] = temp;
        }
    }


    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer tokenizer = new StringTokenizer("");

    public static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}