import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class entry_14905785 {

    public static void main(String[] args) {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> seenNumbers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int complement = x - num;

            if (seenNumbers.containsKey(complement)) {
                pw.println(seenNumbers.get(complement) + " " + (i + 1));
                pw.close();
                return;
            }
            seenNumbers.put(num, i + 1);
        }

        pw.println("IMPOSSIBLE");
        pw.close();
    }
}