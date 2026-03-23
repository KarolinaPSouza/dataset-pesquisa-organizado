import java.io.*;
import java.util.*;

public class entry_10673352 {

    static long findDiagonal(int d) {
        return 1L + (long)(d - 1) * d;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (x == y) {
                sb.append(findDiagonal(x)).append("\n");
            } else if (x > y) {
                long diagonal = findDiagonal(x);
                int steps = x - y;
                if ((x & 1) == 0) {
                    sb.append(diagonal - steps).append("\n");
                } else {
                    sb.append(diagonal + steps).append("\n");
                }
            } else {
                long diagonal = findDiagonal(y);
                int steps = y - x;
                if ((y & 1) == 0) {
                    sb.append(diagonal + steps).append("\n");
                } else {
                    sb.append(diagonal - steps).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}