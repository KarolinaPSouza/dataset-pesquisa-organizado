import java.io.*;
import java.util.*;

public class entry_12952327 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String[] parts = br.readLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            long num = -1;
            if (y > x) {
                long cor = 1L * y * (y - 1) + 1;
                num = (y % 2 == 0) ? (cor - (y - x)) : (cor + (y - x));
            } else if (x > y) {
                long cor = 1L * x * (x - 1) + 1;
                num = (x % 2 == 0) ? (cor + (x - y)) : (cor - (x - y));
            } else {
                num = 1L * x * (x - 1) + 1;
            }

            sb.append(num).append('\n');
        }

        System.out.print(sb.toString());
    }
}