import java.io.*;
import java.util.*;

public class entry_14768549 {
    static void solveOne(long y, long x, StringBuilder out) {
        long spn = Math.max(x, y);
        long m = spn - 1;
        long st = m * m + 1;   // (spn-1)^2 + 1
        long en = spn * spn;   // spn^2

        if ((spn & 1L) == 0) { // even layer: swap st/en
            long tmp = st; st = en; en = tmp;
        }

        long ans;
        if ((spn & 1L) == 1) { // odd layer
            if (x >= y) ans = en - y + 1;
            else        ans = st + x - 1;
        } else {               // even layer
            if (x >= y) ans = en + y - 1;
            else        ans = st - x + 1;
        }
        out.append(ans).append('\n');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < t; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            long y = Long.parseLong(parts[0]);
            long x = Long.parseLong(parts[1]);
            solveOne(y, x, out);
        }
        System.out.print(out);
    }
}