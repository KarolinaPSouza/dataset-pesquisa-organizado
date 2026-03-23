import java.util.*;
import java.io.*;

public class entry_11898185 {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(f.readLine());

        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(f.readLine());
            long y = Integer.parseInt(st.nextToken());
            long x = Integer.parseInt(st.nextToken());

            if (x == y) System.out.println(x * x - x + 1);
            else if (x < y) {
                if (y % 2 == 1) System.out.println((y-1) * (y-1) + x);
                else System.out.println(y * y - x + 1);
            }
            else if (x > y) {
                if (x % 2 == 1) System.out.println(x * x - y + 1);
                else System.out.println((x-1) * (x-1) + y);
            }
        }
    }
}