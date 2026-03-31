import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class entry_16006448 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<int[]> events = new ArrayList<>(2 * n);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            events.add(new int[]{a, 1});
            events.add(new int[]{b, -1});
        }

        events.sort((x, y) ->
            x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]
        );

        int curr = 0;
        int ans = 0;

        for (int[] e : events) {
            curr += e[1];
            if (curr > ans) ans = curr;
        }

        System.out.println(ans);
    }
}