import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_15703469 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] vals = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            vals[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted = new int[N];
        System.arraycopy(vals, 0, sorted, 0, N);
        Arrays.sort(sorted);
        int lptr = 0, rptr = N - 1;

        boolean found = false;
        int a = -1;
        int b = -1;
        while (lptr < rptr) {
            int sum = sorted[lptr] + sorted[rptr];
            if (sum == M) {
                found = true;
                a = linearSearch(vals, sorted[lptr]);
                b = linearSearchRev(vals, sorted[rptr]);
                break;
            }
            else if (sum < M) {
                lptr++;
            }
            else {
                rptr--;
            }
        }
        PrintWriter pw = new PrintWriter(System.out);
        if (!found) {
            pw.println("IMPOSSIBLE");
        }
        else {
            pw.println(a + " " + b);
        }
        pw.flush();
    }

    public static int linearSearch(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i + 1;
            }
        }
        return -1;
    }
    public static int linearSearchRev(int[] arr, int val) {
        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i] == val) {
                return i + 1;
            }
        }
        return -1;
    }
}