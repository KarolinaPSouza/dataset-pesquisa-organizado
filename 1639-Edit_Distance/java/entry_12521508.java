import java.util.*;

public class entry_12521508 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int n = a.length(), m = b.length();

        long[] prev = new long[m + 1];
        long[] curr = new long[m + 1];

        for (int i = 1; i <= m; i++) prev[i] = i;

        for (int i = 1; i <= n; i++) {
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                int c = (a.charAt(i - 1) != b.charAt(j - 1)) ? 1 : 0;
                curr[j] = Math.min(Math.min(curr[j - 1] + 1, prev[j] + 1), prev[j - 1] + c);
            }

            System.arraycopy(curr, 0, prev, 0, m + 1);
        }

        System.out.println(prev[m]);
    }

}