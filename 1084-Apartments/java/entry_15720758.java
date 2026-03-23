import java.io.*;
import java.util.*;

public class entry_15720758 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[] applicants = new long[n];
        long[] apartments = new long[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            applicants[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            apartments[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(applicants);
        Arrays.sort(apartments);

        int i = 0, j = 0, count = 0;

        while (i < n && j < m) {
            if (apartments[j] < applicants[i] - k) {
                j++;              // apartment too small
            } 
            else if (apartments[j] > applicants[i] + k) {
                i++;              // apartment too big
            } 
            else {
                count++;          // match found
                i++;
                j++;
            }
        }

        System.out.println(count);
    }
}