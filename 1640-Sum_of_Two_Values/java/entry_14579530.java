import java.io.*;
import java.util.*;

public class entry_14579530 {
    public static void main(String[] args) throws IOException {
        // Fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read n and x
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int x = Integer.parseInt(firstLine[1]);

        // Read array elements
        String[] secondLine = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(secondLine[i]);
        }

        // Map to store (value -> index)
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = x - arr[i];
            if (map.containsKey(complement)) {
                // Found a pair: print 1-based indices
                System.out.println((map.get(complement) + 1) + " " + (i + 1));
                return;
            }
            // Store the current value and index
            map.put(arr[i], i);
        }

        // No pair found
        System.out.println("IMPOSSIBLE");
    }
}