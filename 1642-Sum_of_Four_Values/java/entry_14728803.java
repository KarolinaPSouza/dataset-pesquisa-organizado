import java.io.*;
import java.util.*;

public class entry_14728803 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k1 = Integer.parseInt(st.nextToken());

        int[][] l = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            l[i][0] = Integer.parseInt(st.nextToken());
            l[i][1] = i + 1; // storing 1-based index
        }

        Arrays.sort(l, Comparator.comparingInt(a -> a[0]));

        boolean found = false;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int j1 = j + 1;
                int k = n - 1;

                while (j1 < k) {
                    int sum = l[i][0] + l[j][0] + l[j1][0] + l[k][0];

                    if (sum == k1) {
                        System.out.println(l[i][1] + " " + l[j][1] + " " + l[j1][1] + " " + l[k][1]);
                        found = true;
                        break;
                    } else if (sum > k1) {
                        k--;
                    } else {
                        j1++;
                    }
                }
                if (found) break;
            }
            if (found) break;
        }

        if (!found) {
            System.out.println("IMPOSSIBLE");
        }
    }
}