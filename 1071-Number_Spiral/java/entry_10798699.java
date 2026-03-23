import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class entry_10798699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long y = Long.parseLong(input[0]);
            long x = Long.parseLong(input[1]);
            long res;

            if (y >= x) {
                if (y % 2 == 0) {
                    res = y * y - x + 1;
                } else {
                    res = (y - 1) * (y - 1) + x;
                }
            } else {
                if (x % 2 == 1) {
                    res = x * x - y + 1;
                } else {
                    res = (x - 1) * (x - 1) + y;
                }
            }

            bw.write(res + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}