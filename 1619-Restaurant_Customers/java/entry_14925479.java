import java.io.*;
import java.util.*;

public class entry_14925479 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            events.add(new int[]{a, 1}); // arrival
            events.add(new int[]{b, -1}); // leaving
        }

        events.sort((x, y) -> {
            if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
            return Integer.compare(x[1], y[1]);
        });

        int current = 0;
        int max = 0;

        for (int[] event : events) {
            current += event[1];
            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}