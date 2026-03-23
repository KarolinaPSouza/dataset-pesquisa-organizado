// package IntroductoryProblems;

import java.io.PrintWriter;
import java.util.Scanner;

public class entry_7820779 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = s.nextInt();

        while (t-- > 0) {
            int r = s.nextInt();
            int c = s.nextInt();

            out.println(findValue(r, c));
        }

        out.flush();

        s.close();
        out.close();
    }

    private static long findValue(int r, int c) {
        long ans = 0;

        if (c >= r) {
            if (c % 2 == 0) {
                ans += (1l * (c - 1) * (c - 1)) + 1l;
                ans += (r - 1);
            } else {
                ans += (1l * c * c);
                ans -= (r - 1);
            }

            return ans;
        } else {
            if (r % 2 == 0) {
                ans += (1l * r * r);
                ans -= (c - 1);
            } else {
                ans += (1l * (r - 1) * (r - 1)) + 1;
                ans += (c - 1);
            }

            return ans;
        }

    }

}