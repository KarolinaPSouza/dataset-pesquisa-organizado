import java.util.*;
import java.io.*;

public class entry_15783823 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] desired = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            desired[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(desired);

        long[] apptsize = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            apptsize[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(apptsize);

        int dindex = 0;
        int aindex = 0;
        int count = 0;
        while (dindex < n && aindex < m) {
            long desiredcurr = desired[dindex];
            long apptcurr = apptsize[aindex];
            if (desiredcurr >= apptcurr - k && desiredcurr <= apptcurr + k) {
                dindex++;
                aindex++;
                count++;
            } else {
                if (desiredcurr < apptcurr - k) {
                    dindex++;
                } else if (desiredcurr > apptcurr - k) {
                    aindex++;
                }
            }
        }

        pw.println(count);
        pw.close();
    }
}