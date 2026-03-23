import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class entry_12945059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String[] parts = br.readLine().split(" ");
            long row = Long.parseLong(parts[0]);
            long col = Long.parseLong(parts[1]);
            long max = Math.max(row, col);
            long base = (max - 1) * (max - 1);

            long result;
            if (max % 2 == 0) {
                result = (col == max) ? base + row : base + 2 * max - col;
            } else {
                result = (row == max) ? base + col : base + 2 * max - row;
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}