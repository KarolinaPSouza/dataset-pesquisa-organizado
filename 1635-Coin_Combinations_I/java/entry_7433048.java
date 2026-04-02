import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_7433048 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int[] denom = new int[n];
        for (int i = 0; i < n; i++) {
            denom[i] = Integer.parseInt(st.nextToken());
        }

        long[] counter = new long[x + 1];
        counter[0] = 1;
        for (int i = 1; i <= x; i++) {
            for (Integer d : denom) {
                if (i - d >= 0) {
                    counter[i] = (counter[i] + counter[i - d]) % 1000000007;
                }
            }
        }
        System.out.println(counter[x] % (1000000007));
    }
}