import java.io.*;
import java.util.*;

public class entry_12192146 {
    public static void main(String args[]) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // BufferedReader bufferedReader = new BufferedReader(new
            // FileReader("input.txt"));

            String arr[] = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            int t = Integer.parseInt(arr[1]);
            String ar[] = bufferedReader.readLine().split(" ");
            long a[][] = new long[n][2];
            int ind = 0;
            for (String s : ar) {
                long num = Long.parseLong(s);
                a[ind][0] = num;
                a[ind][1] = ind + 1;
                ind++;

            }

            Arrays.sort(a, (x, y) -> (int) x[0] - (int) y[0]);
            for (int k = 0; k < n - 3; k++) {
                for (int i = k + 1; i < n - 2; i++) {
                    long f = a[k][0];
                    long se = a[i][0];
                    int s = i + 1;
                    int th = n - 1;

                    while (s < th) {
                        long sum = f + a[s][0] + a[th][0] + se;
                        if (sum == t) {
                            System.out.println(a[k][1] + " " + a[i][1] + " " + a[s][1] + " " + a[th][1]);
                            return;
                        }
                        if (sum > t) {
                            th--;
                        } else
                            s++;
                    }
                }
            }
            System.out.println("IMPOSSIBLE");

        } catch (Exception e) {
        }
    }

}
