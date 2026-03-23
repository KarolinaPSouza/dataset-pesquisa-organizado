import java.io.*;
import java.util.*;

public class entry_15776585 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[] a = new long[n];
        long[] b = new long[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0, count = 0;

        while (i < n && j < m) {
            if (b[j] < a[i] - k) {
                j++;
            } else if (b[j] > a[i] + k) {
                i++;
            } else {
                count++;
                i++;
                j++;
            }
        }

        System.out.println(count);
    }
}