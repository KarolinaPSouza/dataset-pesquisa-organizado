import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class entry_4995975 {

    static FastScanner fs = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();
        int[] applicants = fs.readArray(n);
        int[] apartments = fs.readArray(m);
        if (apartments.length == 1) {
            for (int i = 0; i < applicants.length; i++) {
                if (apartments[0] + k >= applicants[i] && apartments[0] - k <= applicants[i]) {
                    out.println(1);
                    out.close();
                    return;
                }
            }
            out.println(0);
            out.close();
            return;
        }
        Arrays.sort(applicants);
        Arrays.sort(apartments);
        int count = 0;
        int applicantIndex = 0;
        int apartmentIndex = 0;
        while (applicantIndex < n && apartmentIndex < m) {
            if (applicants[applicantIndex] - k > apartments[apartmentIndex]) {
                apartmentIndex++;
            } else if (apartments[apartmentIndex] + k >= applicants[applicantIndex] && apartments[apartmentIndex] - k <= applicants[applicantIndex]) {
                count++;
                applicantIndex++;
                apartmentIndex++;
            } else if (apartments[apartmentIndex] - k > applicants[applicantIndex]) {
                applicantIndex++;
            } else {
                apartmentIndex++;
            }
        }
        out.println(count);
        out.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}