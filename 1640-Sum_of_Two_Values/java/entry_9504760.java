import java.io.*;
import java.util.*;

public class entry_9504760 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long target = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(st.nextToken());
            if (map.containsKey(target - x)) {
                System.out.println((i + 1) + " " + map.get(target - x));
                return;
            }
            map.put(x, i + 1);
        }

        System.out.println("IMPOSSIBLE");
    }
}