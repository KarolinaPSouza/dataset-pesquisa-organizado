import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_9322801 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        long num = Long.parseLong(reader.readLine());

        for (long i = 0; i < num; i++) {
            String[] coordinates = reader.readLine().split(" ");
            long x = Long.parseLong(coordinates[0]);
            long y = Long.parseLong(coordinates[1]);

            if (y > x) {
                if (y % 2 == 0) {
                    builder.append(y * y - (y - 1) - (y - x)).append("\n");
                } else {
                    builder.append((y * y - (2 * y - 2)) + (y - 1) + (y - x)).append("\n");
                }
            } else {
                if (x % 2 == 0) {
                    builder.append(x * x - (y - 1)).append("\n");
                } else {
                    builder.append((x * x - (2 * x - 2)) + (y - 1)).append("\n");
                }
            }
        }

        System.out.print(builder.toString());
    }
}
