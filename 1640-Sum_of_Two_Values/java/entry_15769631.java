import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class entry_15769631 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long target = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            long x = Long.parseLong(st.nextToken());
            long need = target - x;
            if (map.containsKey(need)) {
                System.out.println(map.get(need) + " " + i);
                return;
            }
            map.put(x, i);
        }
        System.out.println("IMPOSSIBLE");
    }
}