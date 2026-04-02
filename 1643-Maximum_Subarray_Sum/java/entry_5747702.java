import java.io.*;
import java.util.*;

public class entry_5747702 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        long sum = Long.MIN_VALUE;
        long curr = 0;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if ((curr + temp) <= 0) {
                curr += temp;
                sum = Math.max(sum, curr);
                curr = 0;
            } else {
                curr += temp;
                sum = Math.max(sum, curr);
            }
        }
        System.out.println(sum);
    }
}