import java.io.*;
import java.util.*;

public class entry_12768964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int x = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(secondLine[i]);
        }

        Map<Integer, Integer> map = new HashMap<>(); // value -> index (1-based)

        for (int i = 0; i < n; i++) {
            int target = x - a[i];
            if (map.containsKey(target)) {
                // Found the pair
                System.out.println(map.get(target) + " " + (i + 1));
                return;
            }
            map.put(a[i], i + 1); // store 1-based index
        }

        System.out.println("IMPOSSIBLE");
    }
}