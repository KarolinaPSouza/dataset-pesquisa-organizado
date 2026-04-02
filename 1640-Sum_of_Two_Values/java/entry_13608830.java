import java.io.*;
import java.util.*;

public class entry_13608830 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        long[] a = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        Map<Long, Integer> map = new HashMap<>();
        boolean found = false;

        for(int i = 0; i < n; i++) {
            long rem = x - a[i];
            if(map.containsKey(rem)) {
                System.out.println((map.get(rem) + 1) + " " + (i + 1));
                found = true;
                break;
            }
            map.put(a[i], i);
        }

        if(!found) {
            System.out.println("IMPOSSIBLE");
        }
    }
}