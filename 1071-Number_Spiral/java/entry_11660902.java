import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class entry_11660902 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int o = Integer.parseInt(reader.readLine()); // Read the number of test cases

        StringBuilder result = new StringBuilder();

        for (int pp = 0; pp < o; pp++) {
            String[] input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            // Find the maximum value between a and b
            int max = Math.max(a, b);

            // Directly calculate max^2 (no need for Math.pow or BigInteger)
            long add = (long) max * max;

            // Simplify the logic based on the values of a and b
            long minus;
            if (a < b) {
                if (b % 2 == 0) {
                    minus = (long)(b + (b - a) - 1);
                } else {
                    minus = (long)(a - 1);
                }
            } else if (a > b) {
                if (max % 2 != 0) {
                    minus = (long)(max + (max - b )- 1);
                } else {
                    minus = (long)(b - 1);
                }
            } else {
                minus = (long)(a - 1);
            }

            add -= minus;
            result.append(add).append("\n");
        }

        // Output all results at once to avoid repeated I/O operations
        writer.write(result.toString());
        writer.flush();

        // Close resources
        reader.close();
        writer.close();
    }
}