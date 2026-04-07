import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class entry_2133776 {
    static StringTokenizer st;
    static BufferedReader in = systemReader();

    public static void main(String[] args) throws IOException {
        Set<Integer> s = new HashSet<>();
        int n = ni();
        for (int i = 0; i < n; i++) {
            s.add(ni());
        }

        System.out.println(s.size());
    }

    private static String nextToken() throws IOException {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    private static int ni() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static long nl() throws IOException {
        return Long.parseLong(nextToken());
    }

    private static String ns() throws IOException {
        return nextToken();
    }

    private static BufferedReader systemReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static BufferedReader fileReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader("/Users/crraksh/Documents/competitive competition/src/codeforces/content_1256/contest_2050/in.txt"));
    }

}