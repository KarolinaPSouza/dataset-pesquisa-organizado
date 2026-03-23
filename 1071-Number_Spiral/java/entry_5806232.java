import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class entry_5806232 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            System.out.println(getNumber(x, y));
        }
    }

    public static long getNumber(int x, int y) {
        int max = Math.max(x, y);
        long diagonal = (long) max * max - max + 1;
        if (max % 2 == 0) {
            return diagonal + x - y;
        } else {
            return diagonal + y - x;
        }
    }
}