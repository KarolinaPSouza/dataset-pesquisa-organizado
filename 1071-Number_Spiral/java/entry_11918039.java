import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_11918039 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line = READER.readLine();
        int t = Integer.parseInt(line);

        for (int index = 0; index < t; index++) {
            String line1 = READER.readLine();
            String[] tokens = line1.split(" ");
            long x = Long.parseLong(tokens[0]);
            long y = Long.parseLong(tokens[1]);

            long answer = 0;
            if (y > x) {
                if (y % 2 == 0) {
                    answer = (((y - 1) * (y - 1)) + 1) + (x - 1);
                } else {
                    answer = (y * y) - (x - 1);
                }
            } else {
                if (x % 2 == 0) {
                    answer = (x * x) - (y - 1);
                } else {
                    answer = ((x - 1) * (x - 1) + 1) + (y - 1);
                }
            }

            System.out.println(answer);
        }
    }
}