import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author varunvats32
 */
public class entry_546083 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NumberSpiral solver = new NumberSpiral();
        solver.solve(1, in, out);
        out.close();
    }

    static class NumberSpiral {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int t = in.nextInt();
            while (t-- > 0) {
                long r = in.nextInt();
                long c = in.nextInt();
                if ((c & 1) > 0) {
                    if (r <= c) {
                        out.println(c * c - r + 1);
                    } else {
                        if ((r & 1) > 0) {
                            out.println((r - 1) * (r - 1) + c);
                        } else {
                            out.println(r * r - c + 1);
                        }
                    }
                } else {
                    if (r <= c) {
                        out.println((c - 1) * (c - 1) + r);
                    } else {
                        if ((r & 1) > 0) {
                            out.println((r - 1) * (r - 1) + c);
                        } else {
                            out.println(r * r - c + 1);
                        }
                    }
                }
            }

        }

    }
}
