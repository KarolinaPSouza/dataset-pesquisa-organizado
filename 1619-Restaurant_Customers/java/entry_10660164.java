import java.util.*;
import java.io.*;

public class entry_10660164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dep = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            dep[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        Arrays.sort(dep);

        int cnt = 0;
        int maxCustomers = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                cnt++;
                i++;
            } else {
                cnt--;
                j++;
            }
            maxCustomers = Math.max(maxCustomers, cnt);
        }

        System.out.println(maxCustomers);
    }
}