import java.io.*;
import java.util.*;

public class entry_10864325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long y = Long.parseLong(input[0]);
            long x = Long.parseLong(input[1]);

            long max = Math.max(y, x);
            long base = max * max - max + 1;

            if (max % 2 == 0) {
                if (x <= y) {
                    result.append(base + (y - x)).append("\n");
                } else {
                    result.append(base - (x - y)).append("\n");
                }
            } else {
                if (x <= y) {
                    result.append(base - (y - x)).append("\n");
                } else {
                    result.append(base + (x - y)).append("\n");
                }
            }
        }

        System.out.print(result);
    }
}