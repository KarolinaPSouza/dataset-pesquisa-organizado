import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class entry_15734581 {
    static int mod = 1000000007;

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        FastReader scanner = new FastReader();
        StringBuilder sb = new StringBuilder();
        String a = scanner.next();
        String b = scanner.next();

        int[][] dp = new int[a.length()+1][b.length()+1];

        for(int i=0;i<=a.length();i++) {
            dp[i][0] = i;
        }
        for(int i=0;i<=b.length();i++) {
            dp[0][i] = i;
        }

        for (int i=1;i<=a.length();i++){
            for(int j=1;j<=b.length();j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                }
            }
        }

        sb.append(dp[a.length()][b.length()]);

        System.out.println(sb.toString().trim());

//        2 2 4 5
    }

}