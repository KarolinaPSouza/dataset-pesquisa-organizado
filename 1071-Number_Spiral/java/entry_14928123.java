import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class entry_14928123 {

    static long numberSpiral(long Y, long X) {
        long ans;
        long add;
        if (Y > X) {
            ans = (Y - 1) * (Y - 1);
            if (Y % 2 != 0) {
                add = X;
            } else {
                add = 2 * Y - X;
            }
        } else {
            ans = (X - 1) * (X - 1);
            if (X % 2 == 0) {
                add = Y;
            } else {
                add = 2 * X - Y;
            }
        }
        return ans + add;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long Y = Long.parseLong(st.nextToken());
            long X = Long.parseLong(st.nextToken());
            bw.write(numberSpiral(Y, X) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
