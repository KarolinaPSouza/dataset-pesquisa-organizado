import java.io.*;
import java.util.*;

public class entry_11590549 {
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
//        br = new BufferedReader(new FileReader("src/input.txt"));
//        out = new PrintWriter(new FileWriter("src/output.txt"));

        int q = readInt();
        for(int i = 1; i <= q; i++) {
            long x = readLong();
            long y = readLong();

            long diagonal_element_value = 1L * (Math.max(x, y) * (Math.max(x, y) - 1)) + 1;

            if(x == y) {
                out.println(diagonal_element_value);
                continue;
            }

            boolean left = false;
            if(x < Math.max(x, y)) {
                left = false;
            }
            else if(y < Math.max(x, y)) {
                left = true;
            }

            if((Math.max(x, y) & 1) == 0) {
                if(left) {
                    out.println(diagonal_element_value + (Math.max(x, y) - y));
                }
                else {
                    out.println(diagonal_element_value - (Math.max(x, y) - x));
                }
            }
            else {
                if(left) {
                    out.println(diagonal_element_value - (Math.max(x, y) - y));
                }
                else {
                    out.println(diagonal_element_value + (Math.max(x, y) - x));
                }
            }
        }

        out.close();
    }

    private static boolean isPrime(int n) {
        if(n == 1) return false;

        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }

    private static void reverseArray(int[] x) {
        int left = 0, right = x.length - 1;
        while(left < right) {
            int temp = x[left];
            x[left] = x[right];
            x[right] = temp;
            left++;
            right--;
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}