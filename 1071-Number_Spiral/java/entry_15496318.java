import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_15496318 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void solve(StringTokenizer st) {
        long row = Long.parseLong(st.nextToken());
        long col = Long.parseLong(st.nextToken());
        long layer = Math.max(row, col);

        if (layer % 2 == 1) {
            long temp = row;
            row = col;
            col = temp;
        }

        if (layer == col) {
            System.out.println((long) (layer - 1) * (layer - 1) + 1 + row - 1);
        } else if (layer == row) {
            System.out.println((long) (layer * layer) - (col - 1));
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            solve(st);
        }
    }
}