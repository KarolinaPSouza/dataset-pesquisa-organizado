import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_14758397 {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        int[] arr = new int[n];
        int[] dep = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
            dep[i] = fs.nextInt();
        }

        System.out.println(maxCustomers(arr, dep));
    }

    static int maxCustomers(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        int cur = 0, ans = 0, n = arr.length;

        // sweep line with two pointers
        while (i < n && j < n) {
            if (arr[i] < dep[j]) {
                cur++;
                ans = Math.max(ans, cur);
                i++;
            } else {
                cur--;
                j++;
            }
        }
        return ans;
    }

}